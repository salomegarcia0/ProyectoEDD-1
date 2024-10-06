/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author salom
 */
public class Nodo {
    private Object data;
    private Nodo next;

    // Constructor
    public Nodo() {
        this.data = null;
        this.next = null;
    }

    // Solo info
    public Nodo(Object data) {
        this.data = data;
        this.next = null;
    }

    //Constructor completo
    public Nodo(Object data, Nodo pnext) {
        this.data = data;
        this.next = pnext;
    }
    
    // Getters y setters
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Nodo getnext() {
        return next;
    }

    public void setnext(Nodo pnext) {
        this.next = pnext;
    }
    
}
