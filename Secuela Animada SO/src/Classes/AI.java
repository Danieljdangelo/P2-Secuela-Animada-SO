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
    private Dashboard db;
    private Admin admin;
    
    private BufferedImage image;
    
    
    public AI(Semaphore sem, int time, Dashboard db, Admin admin){
        this.sem = sem;
        this.time = time;
        this.status = "Esperando";
        this.db = db;
        this.admin = admin;
    }
    
    public void caseCombat(Characters avatar, Characters usm){//despues de que sale un ganador, se para el programa.
        
        if(this.avatar != null && this.usm != null){
            float probability = (float) Math.random();
//            JOptionPane.showMessageDialog(null, probability);
//            Characters winners = combat(avatar, usm);
            
            if(/*probability >= 0.0 && */probability <= 0.4){
//                JOptionPane.showMessageDialog(null, "ENTRÓ");
//                if(winners != null){
////                    JOptionPane.showMessageDialog(null, "ENTRÓ");
////                    if(winners.equals(this.avatar)){
////                        JOptionPane.showMessageDialog(null, "ENTRÓ");
                        result = 1; //Ganó avatar
                        combat(avatar, usm);
////                        moveWinnerToWinnersQueue(this.avatar);
////                        this.admin.setAvatarWinners(this.admin.getAvatarWinners()+1);
//
//                        //Cuando gana avatar, hay que sacar al ganador de la cola de prioridad 1 y meterlo en la cola de ganadores
////                    }else{
////                        JOptionPane.showMessageDialog(null, "ENTRÓ");
////                        result = 2; //Ganó usm
////                        moveWinnerToWinnersQueue(this.usm);
////                        this.admin.setUsmWinners(this.admin.getUsmWinners()+1);
//
//                        //Cuando gana usm, hay que sacar al ganador de la cola de prioridad 1 y meterlo en la cola de ganadores junto a los ganadores de avatar
////                        }
//                    }else{
//                    System.out.println("Error en el combate, no se pudo determinar un ganador");
//                }
            }else if(probability > 0.4 && probability <= 0.67){
//                JOptionPane.showMessageDialog(null, "ENTRÓ");
                result = 3; //Hay empate
                combat(avatar, usm);
//                moveCharactersToPriorityQueues();
//                JOptionPane.showMessageDialog(null, "ENTRÓ");
            }else{
//                JOptionPane.showMessageDialog(null, "ENTRÓ");
                result = 4; //No hay combate
                combat(avatar, usm);
//                moveCharactersToRefuerzoQueues();
//                JOptionPane.showMessageDialog(null, "ENTRÓ");
            }
        }else{
            System.out.println("Los personajes son nulos en el case combat");
        }
    }
    
    public Characters combat(Characters avatar, Characters usm){
        int pointsAvatar = calculatePointsAvatar(avatar);
        int pointsUSM = calculatePointsUsm(usm);
        Characters veredict = null;


        
//        if(this.avatar.getSkill() > this.usm.getSkill()){
//            pointsAvatar++;
//        }else if(this.avatar.getSkill() < this.usm.getSkill()){
//            pointsUSM++;
//        }else{
//            pointsAvatar++;
//            pointsUSM++;
//        }
//        
//        if(this.avatar.getLife() > this.usm.getLife()){
//            pointsAvatar++;
//        }else if(this.avatar.getLife() < this.usm.getLife()){
//            pointsUSM++;
//        }else{
//            pointsAvatar++;
//            pointsUSM++;
//        }
//        
//        if(this.avatar.getStrength() > this.usm.getStrength()){
//            pointsAvatar++;
//        }else if(this.avatar.getStrength() < this.usm.getStrength()){
//            pointsUSM++;
//        }else{
//            pointsAvatar++;
//            pointsUSM++;
//        }
//        
//        if(this.avatar.getAgility() > this.usm.getAgility()){
//            pointsAvatar++;
//        }else if(this.avatar.getAgility() < this.usm.getAgility()){
//            pointsUSM++;
//        }else{
//            pointsAvatar++;
//            pointsUSM++;
//        }
//        .

        if(result == 1){
            if(pointsAvatar > pointsUSM){
                db.getTxtVictoriasAvatar().setText(Integer.toString(Integer.parseInt(db.getTxtVictoriasAvatar().getText()) + 1));
                moveWinnerToWinnersQueue(this.avatar);
//                JOptionPane.showMessageDialog(null, "El ganador de esta batalla es: \n" + avatar.getInfo());
                db.getResultsPane().setText("Veredicto: El ganador de esta batalla es... \n" + avatar.getInfo());
//                db.getTxtVictoriasAvatar().setText(Integer.toString(Integer.parseInt(db.getTxtVictoriasAvatar().getText()) + 1));
                veredict =  avatar;
            }else if(pointsUSM > pointsAvatar){
                db.getTxtVictoriasUSM().setText(Integer.toString(Integer.parseInt(db.getTxtVictoriasUSM().getText()) + 1));
                moveWinnerToWinnersQueue(this.usm);
//                JOptionPane.showMessageDialog(null, "El ganador de esta batalla es: \n" + usm.getInfo());
                db.getResultsPane().setText("Veredicto: El ganador de esta batalla es... \n" + usm.getInfo());
//                db.getTxtVictoriasUSM().setText(Integer.toString(Integer.parseInt(db.getTxtVictoriasUSM().getText()) + 1));
                veredict = usm; 
            }else{
//                JOptionPane.showMessageDialog(null, "Hubo un empate real"); //Solo es para validar
                float probability = (float) Math.random();
                if (probability < 0.5){
                    db.getTxtVictoriasAvatar().setText(Integer.toString(Integer.parseInt(db.getTxtVictoriasAvatar().getText()) + 1));
                    moveWinnerToWinnersQueue(this.avatar);
//                    JOptionPane.showMessageDialog(null, "El ganador de esta batalla es: \n" + avatar.getInfo());
                    db.getResultsPane().setText("Veredicto: El ganador de esta batalla es... \n" + avatar.getInfo());
                    veredict =  avatar;
                }else{
                    db.getTxtVictoriasUSM().setText(Integer.toString(Integer.parseInt(db.getTxtVictoriasUSM().getText()) + 1));
                    moveWinnerToWinnersQueue(this.usm);
//                    JOptionPane.showMessageDialog(null, "El ganador de esta batalla es: \n" + usm.getInfo());
                    db.getResultsPane().setText("Veredicto: El ganador de esta batalla es... \n" + usm.getInfo());
                    veredict = usm; 
                }
            }
        }else if(result == 3){
            returnCharactersToPriority1Queues();
//            JOptionPane.showMessageDialog(null, "Hubo un empate");
            db.getResultsPane().setText("Veredicto: Hubo un empate");
//            this.admin.getP1Avatar().queue(this.avatar);
//            this.admin.getP1USM().queue(this.usm);
            veredict =  null;
        }else{
            moveCharactersToRefuerzoQueues();
//            JOptionPane.showMessageDialog(null, "No se puedo llevar a cabo el combate");
            db.getResultsPane().setText("Veredicto: No se puedo llevar a cabo el combate");
            veredict =  null;
        }
        
        
        
//        if(pointsAvatar > pointsUSM){
//            JOptionPane.showMessageDialog(null, "El ganador de esta batalla es: \n" + avatar.getInfo());
//            db.getTxtVictoriasAvatar().setText(Integer.toString(Integer.parseInt(db.getTxtVictoriasAvatar().getText()) + 1));
////            moveWinnerToWinnersQueue(avatar);
//            return avatar; //Ganó avatar
//        }else if(pointsAvatar < pointsUSM){
//            JOptionPane.showMessageDialog(null, "El ganador de esta batalla es: \n" + usm.getInfo());
//            db.getTxtVictoriasUSM().setText(Integer.toString(Integer.parseInt(db.getTxtVictoriasUSM().getText()) + 1));
////            moveWinnerToWinnersQueue(usm);
//            return usm; //Ganó usm
//        }else{
//            JOptionPane.showMessageDialog(null, "Hubo un empate");
//            return null;
//        }
//.
//            int random = (int) (Math.random() * 2); // random entre 0 y 1
//            if (random == 0){
//                return avatar;
//            }else{
//                return usm;
//            }
//        
//            int random = (int) (Math.floor(Math.random() * (2 - 1 + 1) + 1));
//            if(random == 1){
//                return avatar;
//            }else{
//                return usm;
//            }
//        }else{
//            return usm;
//        }
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
//                mostrarEstatus("Decidiendo.");
                
                sem.acquire();
                db.setSldDuracion(db.getSldDuracion());
//                showCharactersInfo();
//                this.admin.sendCharacters();
                db.getTxtDecisionIA().setText("Esperando");
                sleep((db.getSldDuracion().getValue()/3) * 1000);
//                mostrarEstatus("Anunciando.");
                db.setSldDuracion(db.getSldDuracion());
                db.getTxtDecisionIA().setText("Decidiendo");
                sleep((db.getSldDuracion().getValue()/3) * 1000);
//                showCharactersInfo();
//                mostrarEstatus("Duermiendo.");
                db.setSldDuracion(db.getSldDuracion());
                db.getTxtDecisionIA().setText("Anunciando");
                sleep(((db.getSldDuracion().getValue()/3) * 1000)/2);
                caseCombat(this.avatar, this.usm);
                db.setSldDuracion(db.getSldDuracion());
                sleep(((db.getSldDuracion().getValue()/3) * 1000)/2);
                db.getResultsPane().setText("");
                sem.release();
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
            db.getPanelUsm().setText(this.usm.getInfo()); 
//            JOptionPane.showMessageDialog(null, this.avatar.getInfo() + "\n" + this.avatar.getPath());
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
    }
    
    private void moveWinnerToWinnersQueue(Characters winner) {//Hay que cambiarlo para que mueva los personajes a sus colas respectivas
    this.admin.getP1Avatar().dequeue();
    this.admin.getP1USM().dequeue();
    this.admin.getWinners().queue(winner);
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
