/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author salom
 */
public class ListaSimple {
    private Nodo first;
    private int size;

    public ListaSimple() {
        this.first = null;
        this.size = 0;
    }

    public Nodo getFirst() {
        return first;
    }

    public void setFirst(Nodo first) {
        this.first = first;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    // funcion para verificar si la lista esta vacia
    public boolean isEmpty(){
        return this.first == null;
    }
    
    // funcion para agregar al final
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
    
    //funcion para obtener la info de una posicion especifica de la lista
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
    
    
}
