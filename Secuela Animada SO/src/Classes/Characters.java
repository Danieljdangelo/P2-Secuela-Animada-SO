/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author José
 */
public class Characters {
//Para efectos de la simulación, sólo debe tomar en
//cuenta que cada personaje tiene un ID único asociado y alguno de los tres
//niveles de prioridad expuestos a continuación, cada uno de estos niveles
//con su propia cola.
    
    private String id;
    private String name;
    private int priority;
    private int counter;
    private int skill;
    private int life;
    private int strength;
    private int agility;
    private String imagePath;
    private Characters pNext;
    
    public Characters(String id, String name, int priority, int skill, int life, int strength, int agility, String imagePath){
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.counter = 0;
        this.skill = skill;
        this.life = life;
        this.strength = strength;
        this.agility = agility;
        this.imagePath = imagePath;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * @return the counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * @param counter the counter to set
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }
    
    public void incrementarContador() {
        counter++;
        if (counter >= 8 && priority != 1) {
            // Si el contador llega a 8 y el personaje no tiene prioridad 1, se reduce la prioridad
            priority--;
            counter = 0; // Reiniciar contador
        }
    }

    /**
     * @return the skill
     */
    public int getSkill() {
        return skill;
    }

    /**
     * @param skill the skill to set
     */
    public void setSkill(int skill) {
        this.skill = skill;
    }

    /**
     * @return the life
     */
    public int getLife() {
        return life;
    }

    /**
     * @param life the life to set
     */
    public void setLife(int life) {
        this.life = life;
    }

    /**
     * @return the strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * @param strength the strength to set
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * @return the agility
     */
    public int getAgility() {
        return agility;
    }

    /**
     * @param agility the agility to set
     */
    public void setAgility(int agility) {
        this.agility = agility;
    }

    /**
     * @return the imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * @param imagePath the imagePath to set
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * @return the pNext
     */
    public Characters getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(Characters pNext) {
        this.pNext = pNext;
    }
    
    public String getInfo(){
        String infoChar;
        return infoChar = "\nID: " + this.getId() + "\nNombre: " + this.getName() + "\nSkill: " + this.getSkill() + "\nLife: " + this.getLife() + "\nStrength: " + this.getStrength() + "\nAgility: " + this.getAgility();
    }
    
    public String getPath(){
        String pathChar;
        return pathChar = this.getImagePath();
    }
    
}
