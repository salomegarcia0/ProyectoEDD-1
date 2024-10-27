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
    public void coberturaEstacion(Estacion estacionInicio) {
        // Verificamos si la estación de inicio es nula
        if (estacionInicio == null) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una estación válida.");
            return;
        }

        String resultadoFinal = "Iniciando cálculo de cobertura desde la estación: " + estacionInicio.getNombreEstacion();

        Cola colaEstaciones = new Cola();  // Cola para gestionar las estaciones a visitar
        ListaSimple visitadas = new ListaSimple();  // Lista para las estaciones visitadas
        Cola distancias = new Cola();  // Cola para almacenar las distancias

        // Encolar la estación de inicio y marcarla como visitada
        colaEstaciones.enColar(estacionInicio);
        visitadas.aggFinal(estacionInicio);
        distancias.enColar(0);  // La distancia a la estación de inicio es 0

        // Mientras haya estaciones en la cola
        while (!colaEstaciones.colaVacia()) {
            Estacion estacionActual = (Estacion) colaEstaciones.desEnColar();  // Desencolamos la estación actual
            int distanciaActual = (int) distancias.desEnColar();  // Desencolamos la distancia correspondiente

            // Si hemos alcanzado la distancia máxima, dejamos de explorar
            if (distanciaActual > t) {
                continue;
            }

            resultadoFinal += "Visitando estación: " + estacionActual.getNombreEstacion() + " a una distancia de " + distanciaActual + "\n";

            // Obtener las estaciones adyacentes
            ListaSimple estacionesAdyacentes = estacionActual.getListaAdyacencia();
            for (int i = 0; i < estacionesAdyacentes.getSize(); i++) {
                Estacion estacionVecina = (Estacion) estacionesAdyacentes.getValor(i);

                // Si la estación vecina no ha sido visitada, la encolamos
                if (!visitadas.encontrar(estacionVecina)) {
                    colaEstaciones.enColar(estacionVecina);  // Encolamos la estación vecina
                    visitadas.aggFinal(estacionVecina);  // Marcamos como visitada
                    distancias.enColar(distanciaActual + 1);  // Aumentamos la distancia
                }
            }
        }

        resultadoFinal += "El cálculo de cobertura ha finalizado hasta una distancia de " + t + " paradas.";
        JOptionPane.showMessageDialog(null, resultadoFinal);
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
   
    public void marcarCoberturaDesdeSucursal(Estacion estacionInicial, ListaSimple estacionesCubiertas) {
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
