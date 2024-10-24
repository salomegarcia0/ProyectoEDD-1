/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import Clases.Estacion;
import EDD.ListaSimple;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandra Oporto
 */
public class DFS {
    // Acumulador para almacenar los resultados de las estaciones visitadas
    private StringBuilder acumuladorResultados; 
    // Umbral de distancia para limitar el recorrido
    private int t;

    /**
     * Constructor de la clase DFS.
     *
     * @param t El límite de distancia para la búsqueda.
     */
    public DFS(int t) {
        this.t = t; // Inicializa el umbral de distancia
    }

    // Método para obtener los resultados acumulados
    public StringBuilder getAcumuladorResultados() {
        return acumuladorResultados;
    }

    // Método para establecer los resultados acumulados
    public void setAcumuladorResultados(StringBuilder acumuladorResultados) {
        this.acumuladorResultados = acumuladorResultados;
    }

    // Método para obtener el valor del umbral de distancia
    public int getT() {
        return t;
    }

    // Método para establecer un nuevo umbral de distancia
    public void setT(int t) {
        this.t = t;
    }

   /**
     * Método que inicia el proceso de búsqueda en profundidad.
     *
     * @param primeraEstacion La estación desde la que comenzará la búsqueda.
     */
    public void sacarCobertura(Estacion primeraEstacion) {
        // Verifica que la estación proporcionada no sea nula
        if (primeraEstacion == null) {
            JOptionPane.showMessageDialog(null, "Debe escoger una estación existente");
            return; // Sale del método si la estación es nula
        }

        // Inicializa el acumulador de resultados con un mensaje de inicio
        acumuladorResultados = new StringBuilder(); // Asegurarse de inicializar
        acumuladorResultados.append("Inicializando cobertura DFS desde: ")
                .append(primeraEstacion.getNombreEstacion()).append("\n");

        // Lista para almacenar las estaciones visitadas
        ListaSimple estacionesVisitadas = new ListaSimple();

        // Llama al método recursivo para realizar la búsqueda
        realizarDFS(primeraEstacion, estacionesVisitadas, 0);

        // Muestra los resultados de la búsqueda en un cuadro de diálogo
        JOptionPane.showMessageDialog(null, acumuladorResultados.toString());
    }

    /**
     * Método privado que realiza la búsqueda en profundidad de manera recursiva.
     *
     * @param estacionActual La estación que se está visitando actualmente.
     * @param estacionesVisitadas La lista de estaciones que ya han sido visitadas.
     * @param distanciaActual La distancia actual desde la estación inicial.
     */
    private void realizarDFS(Estacion estacionActual, ListaSimple estacionesVisitadas, int distanciaActual) {
        // Marca la estación actual como visitada
        estacionesVisitadas.aggFinal(estacionActual);

        // Registra la visita a la estación y la distancia
        acumuladorResultados.append("Estación visitada: ")
                .append(estacionActual.getNombreEstacion())
                .append(" 'Distancia: ").append(distanciaActual).append("'").append("\n");

        // Si la distancia actual alcanza el umbral, termina la búsqueda
        if (distanciaActual >= t) {
            return; // Sale del método si se ha alcanzado la distancia máxima
        }

        // Obtiene la lista de estaciones adyacentes a la estación actual
        ListaSimple estacionesAdyacentes = estacionActual.getListaAdyacencia();
        // Recorre cada estación adyacente
        for (int j = 0; j < estacionesAdyacentes.getSize(); j++) {
            Estacion estacionVecina = (Estacion) estacionesAdyacentes.getValor(j);

            // Si la estación vecina no ha sido visitada, se llama recursivamente
            if (!estacionesVisitadas.encontrar(estacionVecina)) {
                realizarDFS(estacionVecina, estacionesVisitadas, distanciaActual + 1);
            }
        }
    }
}