/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author salom
 */

/**
 * Clase Nodo que representa un nodo en una lista enlazada.
 * Cada nodo contiene un dato y una referencia al siguiente nodo en la lista.
 */
public class Nodo {
    private Object data; // Dato almacenado en el nodo
    private Nodo next; // Referencia al siguiente nodo

    /**
     * Constructor por defecto que inicializa un nodo vacío.
     */
    public Nodo() {
        this.data = null;
        this.next = null;
    }

     /**
     * Constructor que inicializa un nodo con un dato específico.
     * @param data El dato a almacenar en el nodo.
     */
    public Nodo(Object data) {
        this.data = data;
        this.next = null;
    }

     /**
     * Constructor que inicializa un nodo con un dato y una referencia al siguiente nodo.
     * @param data El dato a almacenar en el nodo.
     * @param pnext La referencia al siguiente nodo.
     */
    public Nodo(Object data, Nodo pnext) {
        this.data = data;
        this.next = pnext;
    }
    
    // Getters y setters
    
    /**
     * Obtiene el dato almacenado en el nodo.
     * @return El dato del nodo.
     */
    public Object getData() {
        return data;
    }
    
     /**
     * Establece el dato del nodo.
     * @param data El nuevo dato a almacenar en el nodo.
     */
    public void setData(Object data) {
        this.data = data;
    }
    
    /**
     * Obtiene la referencia al siguiente nodo.
     * @return El siguiente nodo.
     */
    public Nodo getnext() {
        return next;
    }
    
    /**
     * Establece la referencia al siguiente nodo.
     * @param pnext El nuevo siguiente nodo.
     */
    public void setnext(Nodo pnext) {
        this.next = pnext;
    }
    
}
