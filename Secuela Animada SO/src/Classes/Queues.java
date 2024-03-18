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
    
//    private Node pHead;
//    private Node pTail;
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

//    /**
//     * @return the pHead
//     */
//    public Node getpHead() {
//        return pHead;
//    }
//
//    /**
//     * @param pHead the pHead to set
//     */
//    public void setpHead(Node pHead) {
//        this.pHead = pHead;
//    }
//
//    /**
//     * @return the pTail
//     */
//    public Node getpTail() {
//        return pTail;
//    }
//
//    /**
//     * @param pTail the pTail to set
//     */
//    public void setpTail(Node pTail) {
//        this.pTail = pTail;
//    }

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
//    public Object readHead(){
//        return pHead.getData();
//    }
    
//    public void queue(Characters data){
//        Node pNew = new Node(data);
//        pNew.setpNext(null);
//        
//        if(pHead == null){
//            pHead = pNew;
//        }else{
//            pTail.setpNext(pNew);
//        }
//        pTail = pNew;
//        size++;
//    }
    
    public void queue(Characters data){
        if(isEmpty()){
            pHead = pTail = data;
        }else{
            Characters pNew = pTail;
            pNew.setpNext(data);
            pTail = pNew.getpNext();
        }
        size++;
    }
    
//    public void dequeue(){
//        Node pTemp = pHead;
//        pHead = pHead.getpNext();
//        size--;
//        if(pHead == null){
//            pTail = null;
//        }
//    }
    
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
    
//    public String print(){
//        Node pAux = pHead;
//        String cola = "";
//        
//        while(pAux != null){
//            cola += pAux.getData() + ", ";
//            pAux = pAux.pNext;
//        }
//        return cola;
//    }   
    
    public String print(){
        String cola = "";
        if(isEmpty()){
            return "Vacía";
        }else{
            Characters pNew = pHead;
            int auxSize = 0;
            while(auxSize < size){
                cola += pNew.getId() + ", ";
                pNew = pNew.getpNext();
                auxSize++;
            }
        }
        return cola;
    }   
    
}
