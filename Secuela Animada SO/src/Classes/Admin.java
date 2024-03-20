/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Dashboard.Dashboard;
import java.awt.Graphics;
import java.awt.Image;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author José
 */
public class Admin extends Thread{
//Se encarga de actualizar las colas
//del sistema y de dictarle a la Inteligencia Artificial cuál de los siguientes
//personajes se deben enfrentar.
    
    private Queues p1Avatar;
    private Queues p2Avatar;
    private Queues p3Avatar;
    private Queues refuerzoAvatar;
    private Queues p1USM;
    private Queues p2USM;
    private Queues p3USM;
    private Queues refuerzoUSM;
    private int cycles;
    private Characters Avatar;
    private Characters USM;
    private int avatarCounter;
    private int usmCounter;
    private Queues winners;
    private int avatarWinners;
    private int usmWinners;
    public Semaphore sem;
    private int idAvatar;
    private int idUSM;
//    private AI ai;
    public AI ai;
    private int time;
    private Dashboard db;
    String[] usmCharacters = new String[] {"Mordecai", "Rigby", "Benson", "Skips", "Musculoso"};
    String[] avatarCharacters = new String[] {"Aang", "Katara", "Sokka", "Zuko", "Iroh"};
    String[] usmImgCharacters = new String[] {"/Images/Mordecai.png", "/Images/Rigby.png", "/Images/Benson.png", "/Images/Skips.png", "/Images/Musculoso.png"};
    String[] avatarImgCharacters = new String[] {"/Images/Aang.png", "/Images/Katara.png", "/Images/Sokka.png", "/Images/Zuko.png", "/Images/Iroh.png"};
    
    public Semaphore mutex;
    public Semaphore s;
    private int counterAdmin = 0;
//    AI ai = new AI(sem, db.getSldDuracion().getValue(), db, db.admin);
    
    public Admin(Semaphore sem, int nCharacters, AI ai, int time, Dashboard db, Semaphore s, Semaphore mutex){
        this.sem = sem;
        this.p1Avatar = new Queues();
        this.p2Avatar = new Queues();
        this.p3Avatar = new Queues();
        this.refuerzoAvatar = new Queues();
        this.p1USM = new Queues();
        this.p2USM = new Queues();
        this.p3USM = new Queues();
        this.refuerzoUSM = new Queues();
        this.winners = new Queues();
        this.cycles = 1;
        this.avatarWinners = 0;
        this.usmWinners = 0;
        this.avatarCounter = 0;
        this.usmCounter = 0;
        this.idAvatar = 1;
        this.idUSM = 1;
        this.db = db;
        this.s = s;
        this.mutex = mutex;
        this.ai = new AI(this.s, db.getSldDuracion().getValue(), this.db, this, this.sem, this.mutex);
        this.time = time;
        
        
        int counter = nCharacters;
        while (counter != 0){
            this.createCharacters("A");
            this.createCharacters("U");
            mostrarColas();
            counter--;
        }
    }

    public void createCharacters(String character){
        
        Random random = new Random();
        int auxPriority;
        float auxSkill, auxLife, auxStrength, auxAgility;

        // Asignar prioridad
        auxPriority = random.nextInt(3) + 1; // Valores entre 1 y 3

        // Asignar habilidades según la prioridad
        switch (auxPriority) {
            case 1:
                auxSkill = random.nextInt(51) + 50;    // Entre 50 y 100
                auxLife = random.nextInt(301) + 300;   // Entre 300 y 600
                auxStrength = random.nextInt(501) + 500;  // Entre 500 y 1000
                auxAgility = random.nextInt(251) + 250;   // Entre 250 y 500
                break;

            case 2:
                auxSkill = random.nextInt(41) + 10;    // Entre 10 y 50
                auxLife = random.nextInt(201) + 100;  // Entre 100 y 300
                auxStrength = random.nextInt(401) + 100;  // Entre 100 y 500
                auxAgility = random.nextInt(151) + 50;   // Entre 50 y 200
                break;

            default: // Prioridad 3
                auxSkill = random.nextInt(26);  // Entre 0 y 25
                auxLife = random.nextInt(101);  // Entre 0 y 100
                auxStrength = random.nextInt(201);  // Entre 0 y 200
                auxAgility = random.nextInt(101);   // Entre 0 y 100
                break;
        }

        // Crear personaje
        Characters newCharacter;
        int contadorPersonajes = 0;//Este contador es para que cuando llegue a cierta cantidad, poner el thread a dormir
        if ("A".equals(character)) {
            int auxPosition = random.nextInt(5);
            String imagePath = this.avatarImgCharacters[auxPosition];
            newCharacter = new Characters("A" + getIdAvatar(), this.avatarCharacters[auxPosition], auxPriority, (int) auxSkill, (int) auxLife, (int) auxStrength, (int) auxAgility, imagePath);
            System.out.println(newCharacter.getInfo());//esto es para probar que se estan creando los personajes
            setIdAvatar(getIdAvatar() + 1);
            switch (auxPriority) {
                case 1:
                    getP1Avatar().queue(newCharacter);
                    contadorPersonajes ++;
                    break;
                case 2:
                    getP2Avatar().queue(newCharacter);
                    contadorPersonajes ++;
                    break;
                default:
                    getP3Avatar().queue(newCharacter);
                    contadorPersonajes ++;
                    break;
            }
        } else {
            int auxPosition = random.nextInt(5);
            String imagePath = this.usmImgCharacters[auxPosition];
            newCharacter = new Characters("U" + getIdUSM(), this.usmCharacters[auxPosition], auxPriority, (int) auxSkill, (int) auxLife, (int) auxStrength, (int) auxAgility, imagePath);
            System.out.println(newCharacter.getInfo());//esto es para probar que se estan creando los personajes
            setIdUSM(getIdUSM() + 1);
            switch (auxPriority) {
                case 1:
                    getP1USM().queue(newCharacter);
                    contadorPersonajes ++;
                    break;
                case 2:
                    getP2USM().queue(newCharacter);
                    contadorPersonajes ++;
                    break;
                default:
                    getP3USM().queue(newCharacter);
                    contadorPersonajes ++;
                    break;
            }
        }
    }
    
    public void createRandomCharacters(){
        float probability = (float) Math.random();
        if(probability >= 0.2){
            createCharacters("A");
            createCharacters("U");
        }
    }
    //Tiene un error que cuando una cola se queda vacia, manda los siguientes de las otras colas
    public void sendCharacters(){
        // Intentar enviar personajes de la cola de prioridad 1
//        p1Avatar no vacía y p1USM no vacía
        if (!p1Avatar.isEmpty() && !p1USM.isEmpty()) {
            Characters avatarP1 = p1Avatar.dequeue();
            Characters usmP1 = p1USM.dequeue();
            ai.receiveCharacters(avatarP1, usmP1);// Enviar los personajes a la IA
            System.out.println("Se recibieron los personajes de la cola de prioridad 1");
            this.ai.showCharactersInfo();
        }
        
        
        
        
        
        
//        p1Avatar no vacía y p1USM vacía
        else if (!p1Avatar.isEmpty() && p1USM.isEmpty()) {
            Characters avatarP1 = p1Avatar.dequeue();
            Characters usmP2 = p2USM.dequeue();
            ai.receiveCharacters(avatarP1, usmP2);// Enviar los personajes a la IA
            System.out.println("Se recibieron los personajes de la cola de prioridad 1");
            this.ai.showCharactersInfo();
        }
//        p1Avatar vacía y p1USM no vacía 
        else if (p1Avatar.isEmpty() && !p1USM.isEmpty()) {
            Characters avatarP2 = p2Avatar.dequeue();
            Characters usmP1 = p1USM.dequeue();
            ai.receiveCharacters(avatarP2, usmP1);// Enviar los personajes a la IA
            System.out.println("Se recibieron los personajes de la cola de prioridad 1");
            this.ai.showCharactersInfo();
        }
        
        else if (!p1Avatar.isEmpty() && p1USM.isEmpty() && p2USM.isEmpty()) {
            Characters avatarP1 = p1Avatar.dequeue();
            Characters usmP3 = p3USM.dequeue();
            ai.receiveCharacters(avatarP1, usmP3);// Enviar los personajes a la IA
            System.out.println("Se recibieron los personajes de la cola de prioridad 1");
            this.ai.showCharactersInfo();
        }
        
        else if (p1Avatar.isEmpty() && !p1USM.isEmpty() && p2Avatar.isEmpty()) {
            Characters avatarP3 = p3Avatar.dequeue();
            Characters usmP1 = p1USM.dequeue();
            ai.receiveCharacters(avatarP3, usmP1);// Enviar los personajes a la IA
            System.out.println("Se recibieron los personajes de la cola de prioridad 1");
            this.ai.showCharactersInfo();
        }
//        Añadir hasta la de refuerzos
//        else if (!p1Avatar.isEmpty() && p1USM.isEmpty() && p2USM.isEmpty() && p2USM.isEmpty()) {
//            Characters avatarP1 = p1Avatar.dequeue();
//            Characters usmRefuerzos = refuerzoUSM.dequeue();
//            ai.receiveCharacters(avatarP1, usmRefuerzos);// Enviar los personajes a la IA
//            System.out.println("Se recibieron los personajes de la cola de prioridad 1");
//            this.ai.showCharactersInfo();
//        }
//        
//        else if (p1Avatar.isEmpty() && !p1USM.isEmpty() && p2Avatar.isEmpty() && p3Avatar.isEmpty()) {
//            Characters avatarRefuerzos = refuerzoAvatar.dequeue();
//            Characters usmP1 = p1USM.dequeue();
//            ai.receiveCharacters(avatarRefuerzos, usmP1);// Enviar los personajes a la IA
//            System.out.println("Se recibieron los personajes de la cola de prioridad 1");
//            this.ai.showCharactersInfo();
//        }
        
        //Validar que si todas las colas estan vacías, el programa debe esperar a que un personaje de la colas de refuerzos pase a P1
//        else if (!p1Avatar.isEmpty() && p1USM.isEmpty() && p2USM.isEmpty() && p2USM.isEmpty()) {
//            Characters avatarP1 = p1Avatar.dequeue();
//            Characters usmRefuerzos = refuerzoUSM.dequeue();
//            this.getP1USM().queue(usmRefuerzos);
//            Characters usmP1 = p1USM.dequeue();
//            ai.receiveCharacters(avatarP1, usmP1);// Enviar los personajes a la IA
//            System.out.println("Se recibieron los personajes de la cola de prioridad 1");
//            this.ai.showCharactersInfo();
//        }
//        
//        else if (p1Avatar.isEmpty() && !p1USM.isEmpty() && p2Avatar.isEmpty() && p3Avatar.isEmpty()) {
//            Characters avatarRefuerzos = refuerzoAvatar.dequeue();
//            Characters usmP1 = p1USM.dequeue();
//            this.getP1Avatar().queue(avatarRefuerzos);
//            Characters avatarP1 = p1Avatar.dequeue();
//            ai.receiveCharacters(avatarP1, usmP1);// Enviar los personajes a la IA
//            System.out.println("Se recibieron los personajes de la cola de prioridad 1");
//            this.ai.showCharactersInfo();
//        }
        
        
        
        
    // Si la cola de prioridad 1 está vacía, intentar enviar personajes de la cola de prioridad 2
        else if (!p2Avatar.isEmpty() && !p2USM.isEmpty()) {
            Characters avatarP2 = p2Avatar.dequeue();
            Characters usmP2 = p2USM.dequeue();
            ai.receiveCharacters(avatarP2, usmP2); // Enviar los personajes a la IA
            System.out.println("Se recibieron los personajes de la cola de prioridad 2");
            this.ai.showCharactersInfo();
        }
        
        
        
        else if (!p2Avatar.isEmpty() && p2USM.isEmpty()) {
            Characters avatarP2 = p2Avatar.dequeue();
            Characters usmP3 = p3USM.dequeue();
            ai.receiveCharacters(avatarP2, usmP3); // Enviar los personajes a la IA
            System.out.println("Se recibieron los personajes de la cola de prioridad 2");
            this.ai.showCharactersInfo();
        }
        
        else if (p2Avatar.isEmpty() && !p2USM.isEmpty()) {
            Characters avatarP3 = p3Avatar.dequeue();
            Characters usmP2 = p2USM.dequeue();
            ai.receiveCharacters(avatarP3, usmP2); // Enviar los personajes a la IA
            System.out.println("Se recibieron los personajes de la cola de prioridad 2");
            this.ai.showCharactersInfo();
        }
        
//        Añadir hasta la de refuerzos
//        else if (!p2Avatar.isEmpty() && p2USM.isEmpty() && p3USM.isEmpty()) {
//            Characters avatarP2 = p2Avatar.dequeue();
//            Characters usmRefuerzos = refuerzoUSM.dequeue();
//            this.getP1USM().queue(usmRefuerzos);
//            Characters usmP1 = p1USM.dequeue();
//            ai.receiveCharacters(avatarP2, usmP1);// Enviar los personajes a la IA
//            System.out.println("Se recibieron los personajes de la cola de prioridad 1");
//            this.ai.showCharactersInfo();
//        }
//        
//        else if (p2Avatar.isEmpty() && !p2USM.isEmpty() && p3Avatar.isEmpty()) {
//            Characters avatarRefuerzos = refuerzoAvatar.dequeue();
//            Characters usmP2 = p2USM.dequeue();
//            this.getP1Avatar().queue(avatarRefuerzos);
//            Characters avatarP1 = p1Avatar.dequeue();
//            ai.receiveCharacters(avatarP1, usmP2);// Enviar los personajes a la IA
//            System.out.println("Se recibieron los personajes de la cola de prioridad 1");
//            this.ai.showCharactersInfo();
//        }
        
        
        
        
        
    // Si la cola de prioridad 2 está vacía, intentar enviar personajes de la cola de prioridad 3
        else if (!p3Avatar.isEmpty() && !p3USM.isEmpty()) {
            Characters avatarP3 = p3Avatar.dequeue();
            Characters usmP3 = p3USM.dequeue();
            ai.receiveCharacters(avatarP3, usmP3); // Enviar los personajes a la IA
            System.out.println("Se recibieron los personajes de la cola de prioridad 3");
            this.ai.showCharactersInfo();
        }
        
        
        
        
        else if (!p3Avatar.isEmpty() && p3USM.isEmpty()) {
            Characters avatarP3 = p3Avatar.dequeue();
            Characters usmRefuerzos = refuerzoUSM.dequeue();
            ai.receiveCharacters(avatarP3, usmRefuerzos); // Enviar los personajes a la IA
            System.out.println("Se recibieron los personajes de la cola de prioridad 3");
            this.ai.showCharactersInfo();
        }
        
        else if (p3Avatar.isEmpty() && !p3USM.isEmpty()) {
            Characters avatarRefuerzos = refuerzoAvatar.dequeue();
            Characters usmP3 = p3USM.dequeue();
            ai.receiveCharacters(avatarRefuerzos, usmP3); // Enviar los personajes a la IA
            System.out.println("Se recibieron los personajes de la cola de prioridad 3");
            this.ai.showCharactersInfo();
        }
        
        
        
        
        
    // Si todas las colas de prioridad están vacías, intentar enviar personajes de las colas de refuerzo
        else if (!refuerzoAvatar.isEmpty() && !refuerzoUSM.isEmpty()) {
            Characters refuerzoAvatarChar = refuerzoAvatar.dequeue();
            Characters refuerzoUSMChar = refuerzoUSM.dequeue();
            ai.receiveCharacters(refuerzoAvatarChar, refuerzoUSMChar); // Enviar los personajes a la IA
            System.out.println("Se recibieron los personajes de las colas de refuerzo");
            this.ai.showCharactersInfo();
        }
    // Si todas las colas están vacías, mostrar un mensaje indicando que no hay personajes disponibles
        else {
            System.out.println("No hay personajes disponibles para enviar a la IA en ninguna cola.");
        }
    }
    
    //Esta funcion debe mostrar las colas en la interfaz y no hacer la logica desde la interfaz
    public void mostrarColas(){
        db.getTxtP1Avatar().setText(this.p1Avatar.print());
        db.getTxtP1USM().setText(this.p1USM.print());
        db.getTxtP2Avatar().setText(this.p2Avatar.print());
        db.getTxtP2USM().setText(this.p2USM.print());
        db.getTxtP3Avatar().setText(this.p3Avatar.print());
        db.getTxtP3USM().setText(this.p3USM.print());
        db.getTxtRefuerzosAvatar().setText(this.refuerzoAvatar.print());
        db.getTxtRefuerzosUSM().setText(this.refuerzoUSM.print());
        db.getTxtGanadores().setText(this.winners.print()); 
    }
    
//    public void moveP2toP1(){
//        this.p2Avatar.extractP2toP1(8, p1Avatar);
//    }
        
    @Override
    public void run(){
        while(true){
            try{
                mutex.acquire();
                        
//                sem.acquire(); //Nuevo
//                s.acquire(); //nuevo
                
//                sem.acquire();
//                s.release();
//                JOptionPane.showMessageDialog(null, db.getCounter() + "," + getCounterAdmin());
//                if (db.getCounter() == 0 && getCounterAdmin() == 0){
//                    moveP2toP1();
                    mostrarColas();
                    sendCharacters();
//                    sleep((db.getSldDuracion().getValue() * 1000));
                    if(cycles == 1){
                        createRandomCharacters();
                        cycles--;
                    }else{
                        cycles++;
                    }
                    db.setSldDuracion(db.getSldDuracion());
//                }
//                setCounterAdmin(1);
//                db.setCounter(1);
//                s.acquire();
//                sem.release();

//                sem.release(); //Nuevo
                
                s.release();
//                sem.acquire();
            }catch (InterruptedException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @return the p1Avatar
     */
    public Queues getP1Avatar() {
        return p1Avatar;
    }

    /**
     * @param p1Avatar the p1Avatar to set
     */
    public void setP1Avatar(Queues p1Avatar) {
        this.p1Avatar = p1Avatar;
    }

    /**
     * @return the p2Avatar
     */
    public Queues getP2Avatar() {
        return p2Avatar;
    }

    /**
     * @param p2Avatar the p2Avatar to set
     */
    public void setP2Avatar(Queues p2Avatar) {
        this.p2Avatar = p2Avatar;
    }

    /**
     * @return the p3Avatar
     */
    public Queues getP3Avatar() {
        return p3Avatar;
    }

    /**
     * @param p3Avatar the p3Avatar to set
     */
    public void setP3Avatar(Queues p3Avatar) {
        this.p3Avatar = p3Avatar;
    }

    /**
     * @return the refuerzoAvatar
     */
    public Queues getRefuerzoAvatar() {
        return refuerzoAvatar;
    }

    /**
     * @param refuerzoAvatar the refuerzoAvatar to set
     */
    public void setRefuerzoAvatar(Queues refuerzoAvatar) {
        this.refuerzoAvatar = refuerzoAvatar;
    }

    /**
     * @return the p1USM
     */
    public Queues getP1USM() {
        return p1USM;
    }

    /**
     * @param p1USM the p1USM to set
     */
    public void setP1USM(Queues p1USM) {
        this.p1USM = p1USM;
    }

    /**
     * @return the p2USM
     */
    public Queues getP2USM() {
        return p2USM;
    }

    /**
     * @param p2USM the p2USM to set
     */
    public void setP2USM(Queues p2USM) {
        this.p2USM = p2USM;
    }

    /**
     * @return the p3USM
     */
    public Queues getP3USM() {
        return p3USM;
    }

    /**
     * @param p3USM the p3USM to set
     */
    public void setP3USM(Queues p3USM) {
        this.p3USM = p3USM;
    }

    /**
     * @return the refuerzoUSM
     */
    public Queues getRefuerzoUSM() {
        return refuerzoUSM;
    }

    /**
     * @param refuerzoUSM the refuerzoUSM to set
     */
    public void setRefuerzoUSM(Queues refuerzoUSM) {
        this.refuerzoUSM = refuerzoUSM;
    }

    /**
     * @return the cycles
     */
    public int getCycles() {
        return cycles;
    }

    /**
     * @param cycles the cycles to set
     */
    public void setCycles(int cycles) {
        this.cycles = cycles;
    }

    /**
     * @return the Avatar
     */
    public Characters getAvatar() {
        return Avatar;
    }

    /**
     * @param Avatar the Avatar to set
     */
    public void setAvatar(Characters Avatar) {
        this.Avatar = Avatar;
    }

    /**
     * @return the USM
     */
    public Characters getUSM() {
        return USM;
    }

    /**
     * @param USM the USM to set
     */
    public void setUSM(Characters USM) {
        this.USM = USM;
    }

    /**
     * @return the avatarCounter
     */
    public int getAvatarCounter() {
        return avatarCounter;
    }

    /**
     * @param avatarCounter the avatarCounter to set
     */
    public void setAvatarCounter(int avatarCounter) {
        this.avatarCounter = avatarCounter;
    }

    /**
     * @return the usmCounter
     */
    public int getUsmCounter() {
        return usmCounter;
    }

    /**
     * @param usmCounter the usmCounter to set
     */
    public void setUsmCounter(int usmCounter) {
        this.usmCounter = usmCounter;
    }

    /**
     * @return the winners
     */
    public Queues getWinners() {
        return winners;
    }

    /**
     * @param winners the winners to set
     */
    public void setWinners(Queues winners) {
        this.winners = winners;
    }

    /**
     * @return the avatarWinners
     */
    public int getAvatarWinners() {
        return avatarWinners;
    }

    /**
     * @param avatarWinners the avatarWinners to set
     */
    public void setAvatarWinners(int avatarWinners) {
        this.avatarWinners = avatarWinners;
    }

    /**
     * @return the usmWinners
     */
    public int getUsmWinners() {
        return usmWinners;
    }

    /**
     * @param usmWinners the usmWinners to set
     */
    public void setUsmWinners(int usmWinners) {
        this.usmWinners = usmWinners;
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

    /**
     * @return the idAvatar
     */
    public int getIdAvatar() {
        return idAvatar;
    }

    /**
     * @param idAvatar the idAvatar to set
     */
    public void setIdAvatar(int idAvatar) {
        this.idAvatar = idAvatar;
    }

    /**
     * @return the idUSM
     */
    public int getIdUSM() {
        return idUSM;
    }

    /**
     * @param idUSM the idUSM to set
     */
    public void setIdUSM(int idUSM) {
        this.idUSM = idUSM;
    }

    /**
     * @return the counterAdmin
     */
    public int getCounterAdmin() {
        return counterAdmin;
    }

    /**
     * @param counterAdmin the counterAdmin to set
     */
    public void setCounterAdmin(int counterAdmin) {
        this.counterAdmin = counterAdmin;
    }
    
    
}
