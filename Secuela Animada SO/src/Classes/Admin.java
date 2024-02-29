/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Dashboard.Dashboard;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private Semaphore sem;
    private int idAvatar;
    private int idUSM;
    String[] usmCharacters = new String[5];
    String[] avatarCharacters = new String[5];
    String[] usmImgCharacters = new String[5];
    String[] avatarImgCharacters = new String[5];
    
    public Admin(Semaphore sem, int nCharacters){
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
        this.cycles = 0;
        this.avatarWinners = 0;
        this.usmWinners = 0;
        this.avatarCounter = 0;
        this.usmCounter = 0;
        this.idAvatar = 1;
        this.idUSM = 1;
        this.usmCharacters[0] = "Mordecai";
        this.usmCharacters[1] = "Rigby";
        this.usmCharacters[2] = "Benson";
        this.usmCharacters[3] = "Skips";
        this.usmCharacters[4] = "Musculoso";
        this.usmImgCharacters[0] = "/Images/Mordecai.png";
        this.usmImgCharacters[1] = "/Images/Rigby.png";
        this.usmImgCharacters[2] = "/Images/Benson.png";
        this.usmImgCharacters[3] = "/Images/Skips.png";
        this.usmImgCharacters[4] = "/Images/Musculoso.png";
        this.avatarCharacters[0] = "Aang";
        this.avatarCharacters[1] = "Katara";
        this.avatarCharacters[2] = "Sokka";
        this.avatarCharacters[3] = "Zuko";
        this.avatarCharacters[4] = "Iroh";
        this.avatarImgCharacters[0] = "/Images/Aang.png";
        this.avatarImgCharacters[1] = "/Images/Katara.png";
        this.avatarImgCharacters[2] = "/Images/Sokka.png";
        this.avatarImgCharacters[3] = "/Images/Zuko.png";
        this.avatarImgCharacters[4] = "/Images/Iroh.png";
        
        
        int counter = nCharacters;
        while (counter != 0){
            this.createCharacters("A");
            this.createCharacters("U");
            counter--;
        }
    }

    public void createCharacters(String character){
        float auxSkill = (float) Math.random();
        float auxLife = (float) Math.random();
        float auxStrength = (float) Math.random();
        float auxAgility = (float) Math.random();
        
        int auxPriority = 0;
        
        int numSkill = 0;
        int numLife = 0;
        int numStrength = 0;
        int numAgility = 0;
        
        if(auxSkill >= 0.4){
            auxPriority++;
            numSkill++;
        }
        
        if(auxLife >= 0.3){
            auxPriority++;
            numLife++;
        }
        
        if(auxStrength >= 0.5){
            auxPriority++;
            numStrength++;
        }
        
        if(auxAgility >= 0.6){
            auxPriority++;
            numAgility++;
        }
        
        switch(auxPriority){
            case 0:
                auxSkill = (int) Math.random() * 25;
                auxLife = (int) Math.random() * 300;
                auxStrength = (int) Math.random() * 500;
                auxAgility = (int) Math.random() * 250;
                auxPriority = 3;
                break;
            
            case 1:
            case 2:
                if(numSkill == 1){
                    auxSkill = (int) Math.random() * 50;
                }else{
                    auxSkill = (int) Math.random() * 40;
                }
                
                if(numLife ==  1){
                    auxLife = (int) Math.random() * 600;
                }else{
                    auxLife = (int) Math.random() * 500;
                }
                
                if(numStrength == 1){
                    auxStrength = (int) Math.random() * 1000;
                }else{
                    auxStrength = (int) Math.random() * 900;
                }
                
                if(numAgility == 1){
                    auxAgility = (int) Math.random() * 500;
                }else{
                    auxAgility = (int) Math.random() * 400;
                }
                
                auxPriority = 2;
                break;
                
            default:
                if(numSkill == 1){
                    auxSkill = (int) Math.random() * 75;
                }else{
                    auxSkill = (int) Math.random() * 65;
                }
                
                if(numLife ==  1){
                    auxLife = (int) Math.random() * 900;
                }else{
                    auxLife = (int) Math.random() * 800;
                }
                
                if(numStrength == 1){
                    auxStrength = (int) Math.random() * 1500;
                }else{
                    auxStrength = (int) Math.random() * 1300;
                }
                
                if(numAgility == 1){
                    auxAgility = (int) Math.random() * 750;
                }else{
                    auxAgility = (int) Math.random() * 650;
                }
                
                auxPriority = 1;
                break;
        }
        
        if("A".equals(character)){
            Random random = new Random();
            int auxPosition = random.nextInt(5);
            Characters newCharacterAvatar = new Characters("A-" + String.valueOf(getIdAvatar()), this.avatarCharacters[auxPosition], auxPriority, (int) auxSkill, (int) auxLife, (int) auxStrength, (int) auxAgility, this.avatarImgCharacters[auxPosition]);
            setIdAvatar(getIdAvatar() + 1);
            switch(auxPriority){
                case 1:
                    getP1Avatar().queue(newCharacterAvatar);
                    break;
                case 2:
                    getP2Avatar().queue(newCharacterAvatar);
                    break;
                default:
                    getP3Avatar().queue(newCharacterAvatar);
                    break;
            }
        }else{
            Random random = new Random();
            int auxPosition = random.nextInt(5);
            Characters newCharacterUSM = new Characters("U-" + String.valueOf(getIdUSM()), this.usmCharacters[auxPosition], auxPriority, (int) auxSkill, (int) auxLife, (int) auxStrength, (int) auxAgility, this.usmImgCharacters[auxPosition]);
            setIdUSM(getIdUSM() + 1);
            switch(auxPriority){
                case 1:
                    getP1USM().queue(newCharacterUSM);
                    break;
                case 2:
                    getP2USM().queue(newCharacterUSM);
                    break;
                default:
                    getP3USM().queue(newCharacterUSM);
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
    
//    public void printQueues(){
//        getP1Avatar().print();
//    }
    
    @Override
    public void run(){
        while(true){
            try{
                sem.acquire();
                if(cycles == 1){
                    createRandomCharacters();
                    cycles--;
                }else{
                    cycles++;
                }
                sem.release();
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
}
