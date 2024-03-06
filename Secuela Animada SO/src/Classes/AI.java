/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Dashboard.Dashboard;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public AI(Semaphore sem, int time, Dashboard db, Admin admin){
        this.sem = sem;
        this.time = time;
        this.status = "Esperando";
        this.db = db;
        this.admin = admin;
    }
    
    public void caseCombat(/*Characters avatar, Characters usm*/){
        if(this.avatar != null && this.usm != null){
            float probability = (float) Math.random();
            if(probability >= 0.0 && probability < 0.4){
                showCharactersInfo();
                Characters combat = combat();
                if(combat.equals(this.avatar)){
                    result = 1; //Ganó avatar
                    admin.getP1Avatar().dequeue();//Cuando gana avatar, hay que sacar al ganador de la cola de prioridad 1 y meterlo en la cola de ganadores
                    admin.getWinners().queue(combat);
                    admin.setAvatarWinners(+1);
                }else{
                    result = 2; //Ganó usm
                    admin.getP1USM().dequeue();//Cuando gana usm, hay que sacar al ganador de la cola de prioridad 1 y meterlo en la cola de ganadores junto a los ganadores de avatar
                    admin.getWinners().queue(combat);
                    admin.setUsmWinners(+1);
                }
            }else if(probability >= 0.4 && probability < 0.67){
                result = 3; //Hay empate
                
            }else{
                result = 4; //No hay combate
            }
//            cleanText();
        }else{
            System.out.println("Los personajes son nulos en el case combat");
        }
    }
    
    public Characters combat(){
        int pointsAvatar = 0;
        int pointsUSM = 0;
        
        if(this.avatar.getSkill() > this.usm.getSkill()){
            pointsAvatar++;
        }else if(this.avatar.getSkill() < this.usm.getSkill()){
            pointsUSM++;
        }else{
            pointsAvatar++;
            pointsUSM++;
        }
        
        if(this.avatar.getLife() > this.usm.getLife()){
            pointsAvatar++;
        }else if(this.avatar.getLife() < this.usm.getLife()){
            pointsUSM++;
        }else{
            pointsAvatar++;
            pointsUSM++;
        }
        
        if(this.avatar.getStrength() > this.usm.getStrength()){
            pointsAvatar++;
        }else if(this.avatar.getStrength() < this.usm.getStrength()){
            pointsUSM++;
        }else{
            pointsAvatar++;
            pointsUSM++;
        }
        
        if(this.avatar.getAgility() > this.usm.getAgility()){
            pointsAvatar++;
        }else if(this.avatar.getAgility() < this.usm.getAgility()){
            pointsUSM++;
        }else{
            pointsAvatar++;
            pointsUSM++;
        }
        
        if(pointsAvatar > pointsUSM){
            return avatar; //Ganó avatar
        }else if(pointsAvatar < pointsUSM){
            return usm;
        }else{
            int random = (int) (Math.random() * 2); // random entre 0 y 1
            if (random == 0){
                return avatar;
            }else{
                return usm;
            }
        }
//            int random = (int) (Math.floor(Math.random() * (2 - 1 + 1) + 1));
//            if(random == 1){
//                return avatar;
//            }else{
//                return usm;
//            }
//        }else{
//            return usm;
//        }
//        
   }
    
    @Override
    public void run(){
        while(true){
            try{
//                sem.acquire();
                showCharactersInfo();
                caseCombat(/*avatar, usm*/);
                sleep(time * 1000);
//                sem.release();
            }catch (InterruptedException ex) {
                Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
//Hay error porque no está recibiendo los characters, puede que no se estén creando los nodos
    public void reciveCharacters(Characters avatar, Characters usm){
        this.setAvatar(avatar);
        this.setUsm(usm);
    }
    
    public void showCharactersInfo(){
        if (avatar != null && usm != null) {
            db.getPanelAvatar().setText(this.avatar.getInfo());
            db.getPanelUsm().setText(this.usm.getInfo());
        } else {
            System.out.println("Al menos uno de los personajes es null");
            }
    }
    
    public void cleanText(){
        System.out.println("Se estan limpiando los paneles");
        db.getPanelAvatar().setText("");
        db.getPanelUsm().setText("");
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
