/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Dashboard.Dashboard;
import javax.swing.JOptionPane;

/**
 *
 * @author José
 */
public class Queues {
//Cada empresa tendrá 4 colas de prioridad, las de nivel
//1, 2 y 3, y la cola de refuerzo, existiendo un total de 8 colas en la
//simulación.
    
    private Characters pHead;
    private Characters pTail;
    private int size;
    
    public Queues(){
        this.pHead = null;
        this.pTail = null;
        this.size = 0;    
    }
    
    /**
     * @return the pHead
     */
    public Characters getpHead() {
        return pHead;
    }

    /**
     * @param pHead the pHead to set
     */
    public void setpHead(Characters pHead) {
        this.pHead = pHead;
    }

    /**
     * @return the pTail
     */
    public Characters getpTail() {
        return pTail;
    }

    /**
     * @param pTail the pTail to set
     */
    public void setpTail(Characters pTail) {
        this.pTail = pTail;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty(){
        return pHead == null;
    }
    
    public void empty(){
        this.pHead = null;
        this.pTail = null;
        this.size = 0;
    }
    
    public boolean contains(Characters character) {
    Characters current = pHead;
    while (current != null) {
        if (current.equals(character)) {
            return true;
        }
        current = current.getpNext();
    }
    return false;
}
    
        public void queue(Characters data){
        if (this.isEmpty()){
            this.setpHead(pTail = data);
            this.setpTail(data);
        }else{
            if(this.getpTail()== null){
                return;
            }
            this.getpTail().setpNext(data);
            this.setpTail(data);
        }
        this.setSize(this.getSize() + 1);
    }

    public Characters dequeue(){
        if(isEmpty()){
            return null;
        }else{
            Characters pNew = pHead;
            pHead = pNew.getpNext();
            size--;
            pNew.setpNext(null);
            return pNew;
        }
    }
 
    public String print(){
        String cola = "";
        if(isEmpty()){
            return "Vacía";
        }else{
            Characters pNew = pHead;
//            int auxSize = 0;
//            while(auxSize < size){
            while(pNew != null){
                cola += pNew.getId() + ", ";
                if(pNew.getpNext() == null){
                    break;
                }
                pNew = pNew.getpNext();
//                auxSize++;
//            }
            }
        }
        return cola;
    }   
    
    public void extractP2toP1(int num, Queues p1){
        Characters actual = getpHead();
        Characters anterior = null;
        while(actual != null){
            if(actual.getCounter() == 8){
                if(anterior == null){
                    setpHead(getpHead().getpNext());
                }else{
                    anterior.setpNext(actual.getpNext());
                }
                if(actual == getpTail()){
                    setpTail(anterior);
                }
                actual.setCounter(0);
                p1.queue(actual);
            }else{
                actual.setCounter(actual.getCounter() + 1);
                anterior = actual;
            }
            actual = actual.getpNext();
        }
    }
    public void extractP3toP2(int num, Queues p2){
        Characters actual = getpHead();
        Characters anterior = null;
        while(actual != null){
            if(actual.getCounter() == 8){
                if(anterior == null){
                    setpHead(getpHead().getpNext());
                }else{
                    anterior.setpNext(actual.getpNext());
                }
                if(actual == getpTail()){
                    setpTail(anterior);
                }
                actual.setCounter(0);
                p2.queue(actual);
            }else{
                actual.setCounter(actual.getCounter() + 1);
                anterior = actual;
            }
            actual = actual.getpNext();
        }
    }
    
}
