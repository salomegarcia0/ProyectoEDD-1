/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Clases.Estacion;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandra Oporto
 */

/**
 * Clase Grafo que representa un grafo no dirigido, donde los nodos son estaciones de un sistema de transporte.
 * Utiliza una lista enlazada simple para almacenar las estaciones y sus conexiones.
 */
public class Grafo {

    private ListaSimple estaciones;
    
    public Grafo(){
        this.estaciones = new ListaSimple();
    }
    
    public Grafo(ListaSimple estaciones) {
        this.estaciones = estaciones;
    }
    
       public boolean grafoVacio(){
        return this.estaciones.isEmpty();
    }

    public ListaSimple getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(ListaSimple estaciones) {
        this.estaciones = estaciones;
    }
    
    
    /**
     * Busca una estación en el grafo por su nombre.
     *
     * @param nombre El nombre de la estación a buscar.
     * @return La estación encontrada, o null si no existe.
     */
    public Estacion encontrarEstacion(String nombre) {
        if (this.estaciones.isEmpty()) {
            return null;
        }
        String nombreLower = nombre.toLowerCase();

        for (int i = 0; i < this.estaciones.getSize(); i++) {
            Estacion estacion = (Estacion) this.estaciones.getValor(i);
            String nombreEstacionLower = estacion.getNombreEstacion().toLowerCase();

            if (nombreEstacionLower.equals(nombreLower)) {
                return estacion;
            }
        }

        return null;
    }

    /**
     * Agrega una nueva estación al grafo, verificando que no exista previamente.
     * Asigna un número de estación único a la nueva estación.
     *
     * @param estacion La estación a agregar.
     */
    
    public void agregarEstacion(Estacion estacion){
        if(encontrarEstacion(estacion.getNombreEstacion())!= null){
            int idEstacion = this.estaciones.getSize();
            estacion.setIdEstacion(idEstacion);
            this.estaciones.aggFinal(estacion);
            
            JOptionPane.showMessageDialog(null, "Estacion creada correctamente.");
        }else{
            JOptionPane.showMessageDialog(null, "Estacion existente");
        }
    }
    
    /**
     * Funcion para verificar si las estaciones son validas o no <code>null</code>
     */
    private boolean sonEstacionesValidas(Estacion estacion1, Estacion estacion2){
        return estacion1 != null && estacion2 != null;
    }
    
    public void agregarConexion(String nombreE1, String nombreE2){
        Estacion estacion1 = this.encontrarEstacion(nombreE1);
        Estacion estacion2 = this.encontrarEstacion(nombreE2);
        
        if(sonEstacionesValidas(estacion1, estacion2)){
            estacion1.getListaAdyacencia().aggFinal(estacion1);
            estacion2.getListaAdyacencia().aggFinal(estacion2);
            
            JOptionPane.showMessageDialog(null, "Conexion establecida exitosamente");
        }else{
            JOptionPane.showMessageDialog(null, "Error en agregar la conexion,"
                    + "asegurese de escribir ambas estaciones correctamente");
        }
    }
    
    public ListaSimple getAdyacentes(String nombreEstacion){
        Estacion estacion = this.encontrarEstacion(nombreEstacion);
        if(estacion != null){
            return estacion.getListaAdyacencia();
        }else{
            return null;
        }
    }
    
     private boolean verificarConexiones(ListaSimple adyacentes, Estacion estacion2) {
        for (int i = 0; i < adyacentes.getSize(); i++) {
            if (adyacentes.getValor(i) == estacion2) {
               return true;
            }
        }
        return false;
    }
     
      public boolean estanConectadas(String nombreE1, String nombreE2){
        Estacion estacion1 = this.encontrarEstacion(nombreE1);
        Estacion estacion2 = this.encontrarEstacion(nombreE2);
        
        if (sonEstacionesValidas(estacion1, estacion2)){
            ListaSimple adyacentes = estacion1.getListaAdyacencia();
            return verificarConexiones(adyacentes, estacion2);    
            }
            return false;
    }
    
     private String construirGrafoString() {
        StringBuilder strGrafo = new StringBuilder();
        for (int i = 0; i < this.estaciones.getSize(); i++) {
            Estacion estacion = (Estacion) estaciones.getValor(i);
            strGrafo.append(estacion.getNombreEstacion())
                    .append(" -> ")
                    .append(estacion.ConvertirListaAdyacencia())
                    .append("\n");
        }
        return strGrafo.toString();
    }

    public void mostrarGrafo() {
        if (!estaciones.isEmpty()) {
            String strGrafo = construirGrafoString();
            JOptionPane.showMessageDialog(null, strGrafo);
        } else {
            
            JOptionPane.showMessageDialog(null, "El grafo no presenta estaciones.");
        }
    }

    
    


}