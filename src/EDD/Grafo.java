/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Clases.Estacion;
import Funciones.BFS;
import static Interfaces.CargarRed.t;
import javax.swing.JOptionPane;


/**
 *
 * @author Alejandra Oporto
 */

/**
 * Clase Grafo que representa un grafo no dirigido, donde los nodos son estaciones 
 * de un sistema de transporte.
 * Utiliza una lista enlazada simple para almacenar las estaciones y sus conexiones.
 */
public class Grafo {

    private ListaSimple estaciones;
    
    /**
    * Constructor por defecto que inicializa un grafo vacío.
    */
    public Grafo(){
        this.estaciones = new ListaSimple();
    }
    
    /**
    * Constructor que inicializa el grafo con una lista de estaciones.
    * @param estaciones La lista de estaciones inicial.
    */
    public Grafo(ListaSimple estaciones) {
        this.estaciones = estaciones;
    }
    
    /**
    * Verifica si el grafo está vacío.
    * @return true si el grafo no contiene estaciones, false en caso contrario.
    */
       public boolean grafoVacio(){
        return this.estaciones.isEmpty();
    }

    /**
    * Obtiene la lista de estaciones del grafo.
    * @return La lista de estaciones.
    */
    public ListaSimple getEstaciones() {
        return estaciones;
    }
    
    /**
    * Establece una nueva lista de estaciones en el grafo.
    * @param estaciones La nueva lista de estaciones.
    */
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
            
            JOptionPane.showMessageDialog(null, "Estacion creada satisfactoriamente");
        }else{
            JOptionPane.showMessageDialog(null, "ERROR, por favor ingrese una estacion nueva");
        }
    }
    
     /**
    * Agrega una nueva estación al grafo utilizando el nombre de la estación proporcionado.
    * Se crea una instancia de la clase Estacion y se llama al método {@link #agregarEstacion(Estacion)} 
    * para agregarla al grafo.
    *
    * @param nombreEstacion El nombre de la estación que se desea agregar al grafo.
    */
    public void StringAggEstacion(String nombreEstacion){
        Estacion nuevaEstacion = new Estacion(nombreEstacion);// Crea una nueva instancia de Estacion con el nombre proporcionado.
        agregarEstacion(nuevaEstacion);// Llama al método para agregar la estación al grafo.
        JOptionPane.showMessageDialog(null, "Estacion agregada satisfactoriamente.");// Muestra un mensaje de confirmación.
    }
    
    
    /**
    * Función para verificar si las estaciones son válidas o no <code>null</code>.
    * @param estacion1 La primera estación a verificar.
    * @param estacion2 La segunda estación a verificar.
    * @return true si ambas estaciones son válidas, false en caso contrario.
    */
    private boolean sonEstacionesValidas(Estacion estacion1, Estacion estacion2){
        return estacion1 != null && estacion2 != null;
    }
    
    /**
    * Agrega una conexión entre dos estaciones en el grafo.
    * @param nombreE1 El nombre de la primera estación.
    * @param nombreE2 El nombre de la segunda estación.
    */
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
    
    /**
    * Obtiene la lista de estaciones adyacentes a una estación específica.
    * @param nombreEstacion El nombre de la estación de la cual se desean conocer los adyacentes.
    * @return La lista de estaciones adyacentes o null si la estación no existe.
    */
    public ListaSimple getAdyacentes(String nombreEstacion){
        Estacion estacion = this.encontrarEstacion(nombreEstacion);
        if(estacion != null){
            return estacion.getListaAdyacencia();
        }else{
            return null;
        }
    }
    
    /**
    * Verifica si una estación está conectada a otra.
    * @param adyacentes La lista de estaciones adyacentes.
    * @param estacion2 La estación a verificar.
    * @return true si la estación está conectada, false en caso contrario.
    */
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
    
    /**
    * Muestra el contenido del grafo en un cuadro de diálogo.
    */

    public void mostrarGrafo() {
        if (!estaciones.isEmpty()) {
            String strGrafo = construirGrafoString();
            JOptionPane.showMessageDialog(null, strGrafo);
        } else {
            JOptionPane.showMessageDialog(null, "El grafo no presenta estaciones.");
        }
    }
    
    /**
    * Devuelve una lista de nombres de estaciones en el grafo.
    * @return Una lista de nombres de estaciones o null si el grafo está vacío.
    */
    public ListaSimple verEstaciones() {
        if (!this.grafoVacio()) {
            ListaSimple nombresEstaciones = new ListaSimple();
            for (int i = 0; i < this.getEstaciones().getSize(); i++) {
                Estacion estacion = (Estacion) this.getEstaciones().getValor(i);
                nombresEstaciones.aggFinal(estacion.getNombreEstacion());
            }
            return nombresEstaciones;
        }else{
            return null;
        }  
    }
    
    /**
    * Obtiene una lista de estaciones que no tienen sucursal.
    * @return Una instancia de {@link ListaSimple} que contiene los nombres de las estaciones sin sucursal.
    * Si el grafo está vacío, se retorna una lista vacía.
    */
    public ListaSimple verEstacionesSinSucursal() {
        ListaSimple EstacionesSinSucursal = new ListaSimple();// Inicializa una lista para almacenar estaciones sin sucursal.
        if (!this.grafoVacio()) { // Verifica que el grafo no esté vacío.
            for (int i = 0; i < this.getEstaciones().getSize(); i++) {
                Estacion estacion = (Estacion) this.getEstaciones().getValor(i);
                if (!estacion.isHaySucursal()) {// Comprueba si la estación no tiene sucursal.
                    EstacionesSinSucursal.aggFinal(estacion.getNombreEstacion());// Agrega el nombre de la estación a la lista.
                }
            }
        }
        return EstacionesSinSucursal;// Retorna la lista de estaciones sin sucursal.
    }
    
    /**
    * Obtiene una lista de estaciones que tienen sucursal.
    * @return Una instancia de {@link ListaSimple} que contiene los nombres de las estaciones con sucursal.
    * Si el grafo está vacío, se retorna una lista vacía.
    */
    public ListaSimple obtenerEstacionesConSucursal() {
        ListaSimple estacionesConSucursal = new ListaSimple();// Inicializa una lista para almacenar estaciones con sucursal.
        if (!grafoVacio()) {// Verifica que el grafo no esté vacío.
            for (int i = 0; i < this.getEstaciones().getSize(); i++) {
                Estacion estacion = (Estacion) this.getEstaciones().getValor(i);
                if (estacion.isHaySucursal()) { // Comprueba si la estación tiene sucursal.
                    estacionesConSucursal.aggFinal(estacion.getNombreEstacion()); // Agrega el nombre de la estación a la lista.
                }
            }
        }
        return estacionesConSucursal; // Retorna la lista de estaciones con sucursal.
    }
    
    /**
    * Establece una sucursal en la estación con el nombre dado.
    * @param nombreEstacion El nombre de la estación en la que se desea establecer la sucursal.
    */
    public void agregarSucursal(String nombreEstacion) {
        Estacion estacionParaAgregar = encontrarEstacion(nombreEstacion);// Busca la estación por su nombre.
        if (estacionParaAgregar != null) {
            estacionParaAgregar.setHaySucursal(true);// Establece que la estación tiene una sucursal.
            JOptionPane.showMessageDialog(null, "Sucursal creada satisfactoriamente."); // Mensaje de confirmación.
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo agregar la sucursal debido a que la estacion no existe.");// Mensaje de error.
        }
    }
    
    /**
    * Remueve la sucursal de la estación con el nombre dado.
    *  @param nombreEstacion El nombre de la estación de la que se desea remover la sucursal.
    */
    public void eliminarSucursal(String nombreEstacion) {
        Estacion estacionParaEliminar = encontrarEstacion(nombreEstacion);// Busca la estación por su nombre.
        if (estacionParaEliminar != null) {
            estacionParaEliminar.setHaySucursal(true);// Establece que la estación no tiene una sucursal.
            JOptionPane.showMessageDialog(null, "Sucursal eliminada satisfactoriamente.");// Mensaje de confirmación.
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar la sucursal porque la estacion seleccionada no existe"); // Mensaje de error.
        }
    }
    
     /**
    * Verifica si todas las estaciones están cubiertas por al menos una sucursal.
    * @return true si todas las estaciones tienen cobertura; false en caso contrario.
    */
    public boolean ComprobarCoberturaTotal() {
        ListaSimple estacionesCubiertas = new ListaSimple();// Inicializa una lista para las estaciones cubiertas.

        for (int i = 0; i < getEstaciones().getSize(); i++) {
            Estacion estaciones = (Estacion) getEstaciones().getValor(i);
            
            if (estaciones.isHaySucursal()) { // Inicializa el algoritmo BFS.
                BFS bfs = new BFS(t);
                bfs.DefinirCoberturaDesdeSucursal(estaciones, estacionesCubiertas);
            }
        }

        for (int i = 0; i < getEstaciones().getSize(); i++) {
            Estacion estacion = (Estacion) getEstaciones().getValor(i);
            if (!estacionesCubiertas.encontrar(estacion)) {
                JOptionPane.showMessageDialog(null, "Una sucursal en la estacion: " + estacion.getNombreEstacion()+ "\n" + "Ayudaria a cubrir la red de metro");
                return false;
            }
        }
        return true;
    }
}