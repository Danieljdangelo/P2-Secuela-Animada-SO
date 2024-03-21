/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Dashboard.Dashboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import javax.swing.Timer;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 *
 * @author José
 */
public class AI  extends Thread{
//Su función es recibir dos personajes
//por ronda, uno de Avatar y otro de Un Show Más, procesar sus
//características y determinar el resultado de la batalla entre ambos.
    
    private int time;
    private String status;
    public Characters avatar;
    public Characters usm;
    private int result;
    private Semaphore sem;
    private Semaphore s;
    private Semaphore mutex;
    private Dashboard db;
    private Admin admin;
    
    private BufferedImage image;
    
    
    public AI(Semaphore s, int time, Dashboard db, Admin admin, Semaphore sem, Semaphore mutex){
        this.sem = sem;
        this.time = time;
        this.status = "Esperando";
        this.db = db;
        this.admin = admin;
        this.s = s;
        this.mutex = mutex;
    }
    
    public void caseCombat(Characters avatar, Characters usm){//despues de que sale un ganador, se para el programa.
        
        if(this.avatar != null && this.usm != null){
            float probability = (float) Math.random();
            
            if(probability <= 0.4){
                result = 1; //Ganó avatar
                combat(avatar, usm);        
            }else if(probability > 0.4 && probability <= 0.67){
                result = 3; //Hay empate
                combat(avatar, usm);
            }else{
                result = 4; //No hay combate
                combat(avatar, usm);
            }
        }else{
            System.out.println("Los personajes son nulos en el case combat");
        }
    }
    
    public Characters combat(Characters avatar, Characters usm){
        int pointsAvatar = calculatePointsAvatar(avatar);
        int pointsUSM = calculatePointsUsm(usm);
        Characters veredict = null;


        if(result == 1){
            if(pointsAvatar > pointsUSM){
                db.getTxtVictoriasAvatar().setText(Integer.toString(Integer.parseInt(db.getTxtVictoriasAvatar().getText()) + 1));
                moveWinnerToWinnersQueue(this.avatar);
                db.getResultsPane().setText("Veredicto: El ganador de esta batalla es... \n" + avatar.getInfo());
                veredict =  avatar;
            }else if(pointsUSM > pointsAvatar){
                db.getTxtVictoriasUSM().setText(Integer.toString(Integer.parseInt(db.getTxtVictoriasUSM().getText()) + 1));
                moveWinnerToWinnersQueue(this.usm);
                db.getResultsPane().setText("Veredicto: El ganador de esta batalla es... \n" + usm.getInfo());
                veredict = usm; 
            }else{
                float probability = (float) Math.random();
                if (probability < 0.5){
                    db.getTxtVictoriasAvatar().setText(Integer.toString(Integer.parseInt(db.getTxtVictoriasAvatar().getText()) + 1));
                    moveWinnerToWinnersQueue(this.avatar);
                    db.getResultsPane().setText("Veredicto: El ganador de esta batalla es... \n" + avatar.getInfo());
                    veredict =  avatar;
                }else{
                    db.getTxtVictoriasUSM().setText(Integer.toString(Integer.parseInt(db.getTxtVictoriasUSM().getText()) + 1));
                    moveWinnerToWinnersQueue(this.usm);
                    db.getResultsPane().setText("Veredicto: El ganador de esta batalla es... \n" + usm.getInfo());
                    veredict = usm; 
                }
            }
        }else if(result == 3){
            returnCharactersToPriority1Queues();
            db.getResultsPane().setText("Veredicto: Hubo un empate");
            veredict =  null;
        }else{
            moveCharactersToRefuerzoQueues();
            db.getResultsPane().setText("Veredicto: No se puedo llevar a cabo el combate");
            veredict =  null;
        }

        return veredict;
   }
    
    private int calculatePointsAvatar(Characters character){
        // Calcula los puntos del personaje basados en sus atributos
        int points = 0;
        points += (character.getSkill() > this.usm.getSkill()) ? 1 : 0;
        points += (character.getLife() > this.usm.getLife()) ? 1 : 0;
        points += (character.getStrength() > this.usm.getStrength()) ? 1 : 0;
        points += (character.getAgility() > this.usm.getAgility()) ? 1 : 0;
        return points;
    }
    
    private int calculatePointsUsm(Characters character){
        // Calcula los puntos del personaje basados en sus atributos
        int points = 0;
        points += (character.getSkill() > this.avatar.getSkill()) ? 1 : 0;
        points += (character.getLife() > this.avatar.getLife()) ? 1 : 0;
        points += (character.getStrength() > this.avatar.getStrength()) ? 1 : 0;
        points += (character.getAgility() > this.avatar.getAgility()) ? 1 : 0;
        return points;
    }
    
    @Override
    public void run(){
        while(true){
            try{
                
                s.acquire();
      
                    exitRefuerzoQueues();
                    db.setSldDuracion(db.getSldDuracion());
                    db.getTxtDecisionIA().setText("Esperando");
                    sleep((db.getSldDuracion().getValue()/3) * 1000);
                    db.setSldDuracion(db.getSldDuracion());
                    db.getTxtDecisionIA().setText("Decidiendo");
                    sleep((db.getSldDuracion().getValue()/3) * 1000);
                    db.setSldDuracion(db.getSldDuracion());
                    db.getTxtDecisionIA().setText("Decidiendo");
                    sleep((db.getSldDuracion().getValue()/3) * 1000);
                    db.getTxtDecisionIA().setText("Anunciando");
                    sleep(((db.getSldDuracion().getValue()/3) * 1000)/2);
                    caseCombat(this.avatar, this.usm);
                    db.setSldDuracion(db.getSldDuracion());
                    sleep(((db.getSldDuracion().getValue()/3) * 1000)/2);
                    db.getResultsPane().setText("");
                    cleanText();
//                    exitRefuerzoQueues(); 
                    moveP2toP1();
                    moveP3toP2();

                mutex.release();
            }catch (InterruptedException ex) {
                Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
//Este método es llamado por el admin para asignarle los primeros de cada cola de prioridad a la ia
    public void receiveCharacters(Characters avatar, Characters usm){
        this.setAvatar(avatar);
        this.setUsm(usm);
    }
//Este metodo muestra en los paneles, la informacion de los personajes que están en la arena    
    public void showCharactersInfo(){
        Images ImageAvatar = new Images(db.getImgAvatar(), this.avatar.getPath());
        Images ImageUSM = new Images(db.getImgUSM(), this.usm.getPath());
        if (avatar != null && usm != null) {
            db.getPanelAvatar().setText(this.avatar.getInfo());
            ImageIcon avatarImage = new ImageIcon(this.avatar.getImagePath());
            JLabel avatarLabel = new JLabel(avatarImage);
            db.getImgAvatar().removeAll(); // Limpiar cualquier componente previo
            db.getImgAvatar().add(avatarLabel);
            
            db.getPanelUsm().setText(this.usm.getInfo()); 
            ImageIcon usmImage = new ImageIcon(this.usm.getImagePath());
            JLabel usmLabel = new JLabel(usmImage);
            db.getImgUSM().removeAll(); // Limpiar cualquier componente previo
            db.getImgUSM().add(usmLabel);
            db.getImgAvatar().add(ImageAvatar).repaint();
            db.getImgUSM().add(ImageUSM).repaint();
        } else {
            System.out.println("Al menos uno de los personajes es null");
            }
    }
    
    public void cleanText(){
        System.out.println("Se estan limpiando los paneles");
        db.getPanelAvatar().setText("");
        db.getPanelUsm().setText("");
        db.getImgUSM().removeAll();
        db.getImgAvatar().removeAll();
        
    }
    
    private void incrementarContadorPersonajes() {
        // Incrementar el contador en la P2 de Avatar
        Queues cola1 = admin.getP2Avatar();
        incrementarContadorCola(cola1);

        // Incrementar el contador en la P2 de Usm
        Queues cola2 = admin.getP2USM();
        incrementarContadorCola(cola2);

        // Incrementar el contador en la P3 de Avatar
        Queues cola3 = admin.getP3Avatar();
        incrementarContadorCola(cola3);

        // Incrementar el contador en la P3 de Usm
        Queues cola4 = admin.getP3USM();
        incrementarContadorCola(cola4);
    }

    private void incrementarContadorCola(Queues cola) {
        Characters current = cola.getpHead();
        while (current != null) {
            current.incrementarContador();
            current = current.getpNext();
        }
    }
    
    private void moveWinnerToWinnersQueue(Characters winner) {//Ahora desencola a los de cualquier cola, solo solo era P1
        if (this.admin.getP1Avatar().contains(winner)) { // Si el ganador proviene de la cola P1Avatar
            this.admin.getP1Avatar().dequeue(); // Quitarlo de la cola P1Avatar
        } else if (this.admin.getP2Avatar().contains(winner)) { // Si el ganador proviene de la cola P2Avatar
            this.admin.getP2Avatar().dequeue(); // Quitarlo de la cola P2Avatar
        } else if (this.admin.getP3Avatar().contains(winner)) { // Si el ganador proviene de la cola P3Avatar
            this.admin.getP3Avatar().dequeue(); // Quitarlo de la cola P3Avatar
        } else if (this.admin.getRefuerzoAvatar().contains(winner)) { // Si el ganador proviene de la cola de refuerzos de Avatar
            this.admin.getRefuerzoAvatar().dequeue(); // Quitarlo de la cola de refuerzos de Avatar
        } else if (this.admin.getP1USM().contains(winner)) { // Si el ganador proviene de la cola P1USM
            this.admin.getP1USM().dequeue(); // Quitarlo de la cola P1USM
        } else if (this.admin.getP2USM().contains(winner)) { // Si el ganador proviene de la cola P2USM
            this.admin.getP2USM().dequeue(); // Quitarlo de la cola P2USM
        } else if (this.admin.getP3USM().contains(winner)) { // Si el ganador proviene de la cola P3USM
            this.admin.getP3USM().dequeue(); // Quitarlo de la cola P3USM
        } else if (this.admin.getRefuerzoUSM().contains(winner)) { // Si el ganador proviene de la cola de refuerzos de USM
            this.admin.getRefuerzoUSM().dequeue(); // Quitarlo de la cola de refuerzos de USM
        }
        this.admin.getWinners().queue(winner); // Encolar al ganador en la cola de ganadores
    }
    
    private void moveCharactersToPriorityQueues() {//Hay que cambiarlo para que mueva los personajes a sus colas respectivas
    this.admin.getP1Avatar().dequeue();
    this.admin.getP1USM().dequeue();
    this.admin.getP1Avatar().queue(this.avatar);
    this.admin.getP1USM().queue(this.usm);
    }
    
    private void returnCharactersToPriority1Queues() {//Hay que cambiarlo para que mueva los personajes a sus colas respectivas
    this.admin.getP1Avatar().dequeue();
    this.admin.getP1USM().dequeue();
    this.admin.getP1Avatar().queue(this.avatar);
    this.admin.getP1USM().queue(this.usm);
    }
    
    private void moveCharactersToRefuerzoQueues() {//Hay que cambiarlo para que mueva los personajes a sus colas respectivas
    this.admin.getP1Avatar().dequeue();
    this.admin.getRefuerzoAvatar().queue(this.avatar);
    this.admin.getP1USM().dequeue();
    this.admin.getRefuerzoUSM().queue(this.usm);
    }
    
    public void exitRefuerzoQueues(){
        float probability = (float) Math.random();
//        JOptionPane.showMessageDialog(null, probability);
        if(this.admin.getRefuerzoAvatar() != null && this.admin.getRefuerzoUSM() != null){
            if (probability <= 0.4){
                this.admin.getP1Avatar().queue(this.admin.getRefuerzoAvatar().getpHead());
                this.admin.getRefuerzoAvatar().dequeue();
                this.admin.getP1USM().queue(this.admin.getRefuerzoUSM().getpHead());
                this.admin.getRefuerzoUSM().dequeue();
            }else{
                this.admin.getRefuerzoAvatar().queue(this.admin.getRefuerzoAvatar().getpHead());
                this.admin.getRefuerzoAvatar().dequeue();
                this.admin.getRefuerzoUSM().queue(this.admin.getRefuerzoUSM().getpHead());
                this.admin.getRefuerzoUSM().dequeue();
            }
        }
        
    }
    
    public void moveP2toP1(){
        this.admin.getP2Avatar().extractP2toP1(8, this.admin.getP1Avatar());
        this.admin.getP2USM().extractP2toP1(8, this.admin.getP1USM());
    }
    
    public void moveP3toP2(){
        this.admin.getP3Avatar().extractP3toP2(8, this.admin.getP2Avatar());
        this.admin.getP3USM().extractP3toP2(8, this.admin.getP2USM());
    }
    
    //Esta funcion debería mostrar el estatus de la ia
    public void mostrarEstatus(String estatus){
        this.db.getTxtDecisionIA().setText(estatus);
    }
    /**
     * @return the time
     */
    public int getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the avatar
     */
    public Characters getAvatar() {
        return avatar;
    }

    /**
     * @param avatar the avatar to set
     */
    public void setAvatar(Characters avatar) {
        this.avatar = avatar;
    }

    /**
     * @return the usm
     */
    public Characters getUsm() {
        return usm;
    }

    /**
     * @param usm the usm to set
     */
    public void setUsm(Characters usm) {
        this.usm = usm;
    }

    /**
     * @return the result
     */
    public int getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(int result) {
        this.result = result;
    }

    /**
     * @return the sem
     */
    public Semaphore getSem() {
        return sem;
    }

    /**
     * @param sem the sem to set
     */
    public void setSem(Semaphore sem) {
        this.sem = sem;
    }
    
    
    
}
