/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

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
    private Characters avatar;
    private Characters usm;
    private int result;
    private Semaphore sem;
    
    public AI(Semaphore sem, int time){
        this.sem = sem;
        this.time = time;
        this.status = "Esperando";
    }
    
    public void caseCombat(Characters avatar, Characters usm){
        float probability = (float) Math.random();
        if(probability >= 0.0 && probability < 0.4){
            Characters combat = combat(avatar, usm);
            if(combat == avatar){
                result = 1; //Ganó avatar
            }else{
                result = 2; //Ganó usm
            }
        }else if(probability >= 0.4 && probability < 0.67){
            result = 3; //Hay empate
        }else{
            result = 4; //No hay combate
        }
    }
    
    public Characters combat(Characters avatar, Characters usm){
        int pointsAvatar = 0;
        int pointsUSM = 0;
        
        if(avatar.getSkill() > usm.getSkill()){
            pointsAvatar++;
        }else if(avatar.getSkill() == usm.getSkill()){
            pointsAvatar++;
            pointsUSM++;
        }else{
            pointsUSM++;
        }
        
        if(avatar.getLife() > usm.getLife()){
            pointsAvatar++;
        }else if(avatar.getLife() == usm.getLife()){
            pointsAvatar++;
            pointsUSM++;
        }else{
            pointsUSM++;
        }
        
        if(avatar.getStrength() > usm.getStrength()){
            pointsAvatar++;
        }else if(avatar.getStrength() == usm.getStrength()){
            pointsAvatar++;
            pointsUSM++;
        }else{
            pointsUSM++;
        }
        
        if(avatar.getAgility() > usm.getAgility()){
            pointsAvatar++;
        }else if(avatar.getAgility() == usm.getAgility()){
            pointsAvatar++;
            pointsUSM++;
        }else{
            pointsUSM++;
        }
        
        if(pointsAvatar > pointsUSM){
            return avatar; //Ganó avatar
        }else if(pointsAvatar == pointsUSM){
            int random = (int) (Math.floor(Math.random() * (2 - 1 + 1) + 1));
            if(random == 1){
                return avatar;
            }else{
                return usm;
            }
        }else{
            return usm;
        }
        
    }
    
    @Override
    public void run(){
        while(true){
            try{
//                sem.acquire();
                caseCombat(avatar, usm);
                sleep(time * 1000);
//                sem.release();
            }catch (InterruptedException ex) {
                Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
