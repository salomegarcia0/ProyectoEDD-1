/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
*
* @author Alejandra Oporto
*/

/**
 * /**
 * La clase Cola implementa una estructura de datos tipo cola utilizando nodos.
 * Esta estructura sigue el principio FIFO (First In, First Out), donde 
 * el primer elemento en entrar es el primero en salir.
 */
public class Cola {
    
    private Nodo inicio; // Nodo que indica el inicio de la cola
    private Nodo cola;// Nodo que indica el final de la cola
    private int medida; // Contador que almacena el número 
    
    /**
     * Constructor por defecto que inicializa una cola vacía.
    */
    public Cola() {
        this.inicio = null;
        this.cola = null;
        this.medida = 0;
    }

    //Getters y setters
    
    /**
     * Obtiene el nodo que está al inicio de la cola.
     * @return el nodo inicio de la cola
     */
    public Nodo getInicio() {
        return inicio;
    }

    /**
     * Establece el nodo que estará al inicio de la cola.
     * @param inicio el nodo a establecer como inicio de la cola
     */
    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }
    
    /**
     * Obtiene el nodo que está al final de la cola.
     * @return el nodo cola de la cola
     */
    public Nodo getCola() {
        return cola;
    }

    /**
     * Establece el nodo que estará al final de la cola.
     * @param cola el nodo a establecer como cola de la cola
     */
    public void setCola(Nodo cola) {
        this.cola = cola;
    }

    /**
     * Obtiene la medida (número de elementos) de la cola.
     * @return la medida de la cola
     */
    public int getMedida() {
        return medida;
    }

    /**
     * Establece la medida de la cola.
     * @param medida la nueva medida de la cola
     */
    public void setMedida(int medida) {
        this.medida = medida;
    }

    /**
     * Verifica si la cola está vacía.
     * @return true si la cola está vacía, false en caso contrario
     */
    public boolean colaVacia() {
        return this.inicio == null;
    }
    
    /**
     * Agrega un nuevo elemento al final de la cola.
     * @param dato el dato a agregar a la cola
     */
    public void enColar(Object dato) {
        Nodo pNew = new Nodo(dato);
        if (this.colaVacia()) {
            this.setInicio(pNew);
            this.setCola(pNew);
        } else {
            this.cola.setnext(pNew);
            this.setCola(pNew);
        }
        medida++;
    }
    
     /**
     * Elimina y retorna el elemento al inicio de la cola.
     * 
     * @return el dato que fue eliminado de la cola
     */
    public Object desEnColar() {
        if (this.colaVacia()) {
            Object quitar = this.inicio.getData();
            this.setInicio(null);
            this.setCola(null);
            medida--;
            return quitar;

        } else {
            Object quitar = this.inicio.getData();
            this.setInicio(this.inicio.getnext());
            medida--;
            return quitar;
        }
    }
    
    /**
     * Destruye la cola, liberando todos sus elementos.
     */
    public void destruir() {
        inicio = null;
        cola = null;
        medida = 0;
    }

    /**
     * Muestra todos los elementos de la cola en consola.
     */
    public void listar() {
        Nodo aux = inicio;
        String pila = "COLA:\n";
        while (aux != null) {
            pila = pila + aux.getData() + "\n";
            aux = aux.getnext();
        }
        System.out.println(pila);
    }
}
