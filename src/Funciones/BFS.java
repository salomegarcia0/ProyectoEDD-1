/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import Clases.Estacion;
import EDD.Cola;
import EDD.ListaSimple;
import javax.swing.JOptionPane;

/**
 *@author Alejandra Oporto
 * 
 * Clase que implementa el algoritmo BFS (Breadth-First Search) 
 * para calcular la cobertura de estaciones en un sistema de transporte.
 */
public class BFS {

    private int t; // Distancia máxima para la cobertura

    /**
     * Constructor de la clase BFS que inicializa la distancia máxima.
     *
     * @param t La distancia máxima hasta donde se calculará la cobertura.
     */
    public BFS(int t) {
        this.t = t;
    }
    /**
     * Método para obtener la distancia máxima.
     *
     * @return La distancia máxima establecida.
     */
    public int getT() {
        return t;
    }
    /**
     * Método para establecer una nueva distancia máxima.
     *
     * @param t La nueva distancia máxima a establecer.
     */
    public void setT(int t) {
        this.t = t;
    }
    /**
     * Método que calcula la cobertura de estaciones utilizando el algoritmo BFS.
     *
     * @param estacionInicio La estación desde la cual se iniciará el cálculo de cobertura.
     */
    public void coberturaEstacion(Estacion primeraEstacion) {
        // Verificamos si la estación de inicio es nula
        if (primeraEstacion == null) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione una estacion valida.");
            return;
        }

        String resultado = "se calcula el BFS desde " + primeraEstacion.getNombreEstacion();

        Cola colaEstaciones = new Cola();  
        ListaSimple visitadas = new ListaSimple();
        Cola distancias = new Cola(); 

        
        colaEstaciones.enColar(primeraEstacion);
        visitadas.aggFinal(primeraEstacion);
        distancias.enColar(0);  

        
        while (!colaEstaciones.colaVacia()) {
            Estacion visitandoEstacion = (Estacion) colaEstaciones.desEnColar(); 
            int distancia = (int) distancias.desEnColar(); 

            
            if (distancia > t) {
                continue;
            }

            resultado += "Visitando estación: " + visitandoEstacion.getNombreEstacion() + " con una distancia de " + distancia + "\n";

            
            ListaSimple estacionesAdyacentes = visitandoEstacion.getListaAdyacencia();
            for (int i = 0; i < estacionesAdyacentes.getSize(); i++) {
                Estacion estacionVecina = (Estacion) estacionesAdyacentes.getValor(i);

                
                if (!visitadas.encontrar(estacionVecina)) {
                    colaEstaciones.enColar(estacionVecina);  
                    visitadas.aggFinal(estacionVecina);  
                    distancias.enColar(distancia + 1);  
                }
            }
        }

        resultado += "El cálculo de cobertura ha finalizado hasta una distancia de " + t + " paradas.";
        JOptionPane.showMessageDialog(null, resultado);
    }
    
    /**
    * Marca la cobertura de estaciones a partir de una estación inicial que tiene una sucursal.
    * Utiliza un algoritmo de búsqueda en anchura (BFS) para explorar las estaciones adyacentes
    * hasta una distancia máxima especificada.
    *
    * @param estacionInicial La estación desde la cual se comienza a marcar la cobertura. 
    *                       Debe ser una estación válida y no nula.
    * @param estacionesCubiertas La lista donde se almacenarán las estaciones que han sido cubiertas.
    *                       Esta lista se actualizará con las estaciones alcanzadas durante 
    *                       la búsqueda.
    * 
    * @throws IllegalArgumentException si estacionInicial es null.
    */
   
    public void establecerCoberturaDesdeSucursal(Estacion estacionInicial, ListaSimple estacionesCubiertas) {
        if (estacionInicial == null) {
            return;
        }

        Cola cola = new Cola();
        Cola distancias = new Cola();

        cola.enColar(estacionInicial);
        estacionesCubiertas.aggFinal(estacionInicial); 
        distancias.enColar(0);

        while (!cola.colaVacia()) {
            Estacion actual = (Estacion) cola.desEnColar();
            int distanciaActual = (int) distancias.desEnColar();

            if (distanciaActual >= t) {
                continue;
            }

            ListaSimple adyacentes = actual.getListaAdyacencia();
            for (int i = 0; i < adyacentes.getSize(); i++) {
                Estacion adyacente = (Estacion) adyacentes.getValor(i);

                
                if (!estacionesCubiertas.encontrar(adyacente)) {
                    cola.enColar(adyacente);
                    estacionesCubiertas.aggFinal(adyacente); 
                    distancias.enColar(distanciaActual + 1);
                }
            }
        }
    }
}
