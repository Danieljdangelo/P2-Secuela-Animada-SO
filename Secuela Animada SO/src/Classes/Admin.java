/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.concurrent.Semaphore;

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
        
        int counter = nCharacters;
        while (counter != 0){
            this.createCharacters("A");
            this.createCharacters("U");
        }
    }
    
    public void createCharacters(String company){
        
    }
}
