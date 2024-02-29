/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author José
 */
public class Node {
    private Characters data;
    Node pNext;
    private Node pPrev;
    
    public Node(Characters data) {
        this.data = data;
        this.pNext = null;
        this.pPrev = null;
    }

    /**
     * @return the data
     */
    public Characters getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Characters data) {
        this.data = data;
    }

    /**
     * @return the pNext
     */
    public Node getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(Node pNext) {
        this.pNext = pNext;
    }

    /**
     * @return the pPrev
     */
    public Node getpPrev() {
        return pPrev;
    }

    /**
     * @param pPrev the pPrev to set
     */
    public void setpPrev(Node pPrev) {
        this.pPrev = pPrev;
    }

    
    
}
