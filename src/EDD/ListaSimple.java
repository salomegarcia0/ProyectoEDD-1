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
 * Clase ListaSimple que representa una lista enlazada simple.
 * Esta lista permite almacenar elementos de manera dinámica y realizar operaciones básicas sobre ellos.
*/
public class ListaSimple {
    private Nodo first;
    private int size;
    
    /**
     * Constructor por defecto que inicializa una lista vacía.
     */
    public ListaSimple() {
        this.first = null;
        this.size = 0;
    }
    
    //getters y setters
    
    /**
     * Obtiene el primer nodo de la lista.
     * @return El primer nodo.
     */
    public Nodo getFirst() {
        return first;
    }

    /**
     * Establece el primer nodo de la lista.
     * @param first El nuevo primer nodo.
     */
    public void setFirst(Nodo first) {
        this.first = first;
    }

    /**
     * Obtiene el tamaño de la lista.
     * @return El tamaño de la lista.
     */
    public int getSize() {
        return size;
    }

     /**
     * Establece el tamaño de la lista.
     * @param size El nuevo tamaño de la lista.
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * Verifica si la lista está vacía.
     * @return true si la lista no contiene elementos, false en caso contrario.
     */
    public boolean isEmpty(){
        return this.first == null;
    }
    
     
    /**
     * Agrega un nuevo elemento al final de la lista.
     * @param data El dato a agregar.
     */
    public void aggFinal(Object data){
        Nodo newNodo = new Nodo(data);
        if(isEmpty()){
            first = newNodo;
        }else{
            Nodo tmp = first;
            while(tmp.getnext() != null){
                tmp = tmp.getnext();
            } 
            tmp.setnext(newNodo);
        }
        size++;
    }
    
    /**
     * Obtiene el valor de un nodo en una posición específica de la lista.
     * @param index La posición del nodo a obtener.
     * @return El dato del nodo en la posición especificada.
     * @throws IndexOutOfBoundsException Si el índice está fuera de rango.
     */
    public Object getValor(int index){
        if(index < 0|| index>= size){
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        Nodo tmp = first;
        for(int i = 0; i < index; i++){
            tmp = tmp.getnext();
        }
        return tmp.getData();
    }
    
    /**
     * Busca un objeto en la lista.
     * @param objetivo El objeto a buscar.
     * @return true si el objeto se encuentra en la lista, false en caso contrario.
     */
    public boolean encontrar(Object objetivo) {
        // Nodo que se utiliza para recorrer la lista
        Nodo nodoActual = this.first; 
        boolean encontrado = false; 
        // Itera mientras haya nodos por recorrer y el objeto no haya sido encontrado
        while (nodoActual != null && !encontrado) {
            // Compara el objeto objetivo con el dato del nodo actual
            if (objetivo == nodoActual.getData()) {
                encontrado = true; // Se encontró el objeto
            } else {
                nodoActual = nodoActual.getnext();
            }
        }
        // Retorna el resultado de la búsqueda
        return encontrado;
    }
    
    public String Transformar() {
        if (!isEmpty()) {
            Nodo aux = first;
            StringBuilder expresion = new StringBuilder();
            for (int i = 0; i < size; i++) {
                // Aquí deberías evitar la recursión infinita, mostrando solo lo necesario
                expresion.append(aux.getData().toString()).append("\n");
                aux = aux.getnext();
            }
            return expresion.toString();
        }
        return "Lista vacia";
    }
}
