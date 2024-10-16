/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
*
* @author Alejandra Oporto
*/
public class Cola {
    
    private Nodo inicio;
    private Nodo cola;
    private int medida;

    public Cola() {
        this.inicio = null;
        this.cola = null;
        this.medida = 0;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getCola() {
        return cola;
    }

    public void setCola(Nodo cola) {
        this.cola = cola;
    }

    public int getMedida() {
        return medida;
    }

    public void setMedida(int medida) {
        this.medida = medida;
    }

    public boolean colaVacia() {
        return this.inicio == null;
    }

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

    public void destruir() {
        inicio = null;
        cola = null;
        medida = 0;
    }

    //Mostrar los elementos de una Pila}
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
