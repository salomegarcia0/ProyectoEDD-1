/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import Clases.Estacion;
import EDD.Grafo;
import EDD.ListaSimple;
import com.google.gson.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandra Oporto
 */
public class Funciones {


    private ListaSimple listaEstaciones = new ListaSimple(); // Colección de estaciones

    // Método para obtener la lista de estaciones
    public ListaSimple obtenerEstaciones() {
        return listaEstaciones;
    }

    // Método para establecer la lista de estaciones
    public void establecerEstaciones(ListaSimple nuevasEstaciones) {
        this.listaEstaciones = nuevasEstaciones;
    }

   /**
    * Este método se encarga de cargar la red de transporte a partir de un archivo JSON.
     * La información contenida en el archivo se procesa para construir la red de transporte
     * en el sistema.
    *
    * @param rutaArchivo La ruta del archivo JSON que contiene los datos de la red de transporte.
    */
    public void cargarRedTransporte(String rutaArchivo) {
        // Intentamos ejecutar el bloque de código que puede lanzar una excepción
        try {
            // Creamos una instancia de Gson para manejar la lectura de archivos JSON
            Gson gson = new Gson();
        
            // Leemos el contenido del archivo JSON y lo convertimos a un objeto JsonObject
            JsonObject datosTransporte = gson.fromJson(new FileReader(rutaArchivo), JsonObject.class);

            // Extraemos los nombres de las redes de transporte (son las claves principales del JSON)
            ListaSimple listaNombresRedes = extraerClavesDesdeJson(datosTransporte);

            // Iteramos sobre cada red de transporte obtenida
            for (int i = 0; i < listaNombresRedes.getSize(); i++) {
                // Obtenemos el nombre de la red actual
                String nombreRed = (String) listaNombresRedes.getValor(i);
            
                // Accedemos al elemento correspondiente a esa red en el objeto JSON
                JsonElement elementoRed = datosTransporte.get(nombreRed);

                // Verificamos si el elemento es un objeto JSON
                if (elementoRed.isJsonObject()) {
                    // Si es un objeto, lo convertimos a JsonObject para procesarlo
                    JsonObject objetoLineas = elementoRed.getAsJsonObject();
                    // Llamamos al método para procesar las líneas de esta red
                    procesarLineasDesdeJson(objetoLineas);
                } 
                // Verificamos si el elemento es un arreglo JSON
                else if (elementoRed.isJsonArray()) {
                    // Si es un arreglo, lo convertimos a JsonArray
                    JsonArray arrayLineas = elementoRed.getAsJsonArray();
                    // Iteramos sobre cada elemento dentro del arreglo
                    for (JsonElement elementoLinea : arrayLineas) {
                        // Verificamos si el elemento actual es un objeto JSON
                        if (elementoLinea.isJsonObject()) {
                            // Convertimos el elemento a JsonObject para procesarlo
                            JsonObject objetoLinea = elementoLinea.getAsJsonObject();
                            // Llamamos al método para procesar cada objeto de línea
                            procesarLineasDesdeJson(objetoLinea);
                        }
                    }
                }
            }

        // Capturamos cualquier excepción de tipo IOException que pueda ocurrir al leer el archivo
        } catch (IOException e) {
            // Imprimimos la traza de la excepción para ayudar en la depuración
            e.printStackTrace();
        }
    }

    /**
    * Método auxiliar que extrae las claves de un objeto JSON y las devuelve como una lista simple.
    *
    * @param objetoJson el objeto JSON del cual se extraen las claves.
    * @return una instancia de ListaSimple que contiene las claves del objeto JSON.
    */
    private ListaSimple extraerClavesDesdeJson(JsonObject objetoJson) {
    ListaSimple clavesExtraidas = new ListaSimple();  

    // Iniciamos un bucle para iterar sobre cada entrada del objeto JSON
    // La entrada consiste en un par clave-valor, donde la clave es de tipo String
    // y el valor es de tipo JsonElement
        for (Map.Entry<String, JsonElement> entrada : objetoJson.entrySet()) {
            // Extraemos la clave de la entrada actual y la agregamos a la lista de claves
            clavesExtraidas.aggFinal(entrada.getKey());
    }
    
    // Al finalizar el bucle, devolvemos la lista con todas las claves extraídas
    return clavesExtraidas;
}
    
    
    
    /**
    * Este método es un auxiliar que se encarga de procesar las líneas y las estaciones
    * del sistema de transporte a partir de un objeto JSON que contiene toda la información
    * necesaria.
    *
    * @param lineasJson Objeto JSON que contiene las líneas y sus estaciones.
    */
    private void procesarLineasDesdeJson(JsonObject lineasJson) {
        // Primero, obtenemos las claves que representan las líneas del sistema de transporte
        ListaSimple clavesLineas = extraerClavesDesdeJson(lineasJson);
        for (int i = 0; i < clavesLineas.getSize(); i++) {
            // Obtenemos el nombre de la línea actual
            String lineaNombre = (String) clavesLineas.getValor(i);
        
            JsonArray estacionesArray = lineasJson.getAsJsonArray(lineaNombre);

        // Inicializamos una variable para la estación anterior como null
        Estacion estacionPrev = null;  // Esta variable servirá para enlazar estaciones adyacentes
        Estacion estacionActual;  // Variable que representa la estación actual que estamos procesando

        // Ahora, procedemos a procesar cada estación dentro del array de estaciones
        for (JsonElement elementoEstacion : estacionesArray) {
            if (elementoEstacion.isJsonPrimitive()) {
                // Si es un primitivo, obtenemos el nombre de la estación
                String nombreEstacion = elementoEstacion.getAsString();
                // Llamamos a un método que nos devuelve o crea la estación según el nombre
                estacionActual = obtenerOcrearEstacionDesdeNombre(nombreEstacion);

                // Si ya tenemos una estación previa, las enlazamos como adyacentes
                if (estacionPrev != null) {
                    // Agregamos la estación actual.
                    estacionPrev.getListaAdyacencia().aggFinal(estacionActual);
                    // Hacemos lo mismo en sentido contrario para que ambas estaciones se reconozcan
                    estacionActual.getListaAdyacencia().aggFinal(estacionPrev);
                }

                // La estación actual se convierte en la estación previa
                estacionPrev = estacionActual;

                } else if (elementoEstacion.isJsonObject()) {

                    JsonObject conexionPeatonal = elementoEstacion.getAsJsonObject();
                
                    // Obtenemos las claves que indican las estaciones involucradas en la conexión peatonal
                    ListaSimple clavesConexiones = extraerClavesDesdeJson(conexionPeatonal);

                    // Iteramos sobre cada clave para procesar las conexiones peatonales
                    for (int j = 0; j < clavesConexiones.getSize(); j++) {
                        // Obtenemos el nombre de la primera estación en la conexión
                        String estacion1Nombre = (String) clavesConexiones.getValor(j);
                        // Luego, obtenemos el nombre de la segunda estación usando la clave
                        String estacion2Nombre = conexionPeatonal.get(estacion1Nombre).getAsString();

                        // Ahora, obtenemos o creamos ambas estaciones a partir de sus nombres
                        Estacion estacion1 = obtenerOcrearEstacionDesdeNombre(estacion1Nombre);
                        Estacion estacion2 = obtenerOcrearEstacionDesdeNombre(estacion2Nombre);

                        // Establecemos una conexión peatonal entre ambas estaciones
                        estacion1.setPeaton(estacion2); // Añadir conexión peatonal de estación 1 a estación 2
                        estacion2.setPeaton(estacion1); // Añadir conexión peatonal de estación 2 a estación 1
                    
                        // También debemos asegurarnos de que haya adyacencia lógica entre las estaciones de la misma línea
                    if (estacionPrev != null) {
                        // Agregamos estacion1 a la lista de adyacencia de estacionPrev
                        estacionPrev.getListaAdyacencia().aggFinal(estacion1);
                        // Hacemos lo mismo en el sentido inverso
                        estacion1.getListaAdyacencia().aggFinal(estacionPrev);
                    }
                    // Actualizamos la estación previa para el siguiente ciclo
                    estacionPrev = estacion1; // La estación actual se convierte en la anterior para el próximo ciclo
                }
            }
        }
    }
}

    /**
     * Método auxiliar para obtener una estación existente o crear una nueva si no existe
     * Busca una estación por su nombre y la crea si no existe.
     *
     * @param nombreDeEstacion El nombre de la estación a buscar o crear.
     * @return La estación encontrada o la nueva estación creada.
     */
    private Estacion obtenerOcrearEstacionDesdeNombre(String nombreDeEstacion) {
        // Iniciamos un bucle para buscar si la estación ya fue creada en la lista de estaciones
        for (int indice = 0; indice < listaEstaciones.getSize(); indice++) {
            Estacion estacionActual = (Estacion) listaEstaciones.getValor(indice);
            // Verificamos si el nombre de la estación actual coincide con el nombre buscado
            if (estacionActual.getNombreEstacion().equals(nombreDeEstacion)) {
                // Si encontramos la estación, la devolvemos
                return estacionActual;
            }
        }
        // Si no encontramos la estación, creamos una nueva y la añadimos a la lista
        Estacion nuevaEstacion = new Estacion(nombreDeEstacion);
        listaEstaciones.aggFinal(nuevaEstacion); // Añadimos la nueva estación a la lista
        return nuevaEstacion; // Devolvemos la nueva estación creada
    }

    /**
     * Método para obtener una lista de los nombres de las estaciones en el grafo.
     *
     * @param grafo El grafo que contiene las estaciones.
     * @return Una lista simple con los nombres de las estaciones o null si el grafo está vacío.
     */
    public ListaSimple listarEstaciones(Grafo grafo) {
        // Verificamos si el grafo no está vacío
        if (!grafo.grafoVacio()) {
            ListaSimple listaNombresEstaciones = new ListaSimple(); // Creamos una nueva lista para los nombres
            // Iteramos sobre cada estación en el grafo
            for (int indice = 0; indice < grafo.getEstaciones().getSize(); indice++) {
                Estacion estacionActual = (Estacion) grafo.getEstaciones().getValor(indice);
                // Agregamos el nombre de la estación a la lista
                listaNombresEstaciones.aggFinal(estacionActual.getNombreEstacion());
            }
            return listaNombresEstaciones; // Devolvemos la lista de nombres
        } else {
            return null; // Si el grafo está vacío, devolvemos null
        }
    }

    /**
     * Método para obtener una lista de los nombres de las estaciones que tienen sucursal.
     *
     * @param grafo El grafo que contiene las estaciones.
     * @return Una lista simple con los nombres de las estaciones que tienen sucursal.
     */
    public ListaSimple listarEstacionesConSucursal(Grafo grafo) {
        ListaSimple listaConSucursal = new ListaSimple(); // Lista para almacenar estaciones con sucursal
        // Verificamos si el grafo no está vacío
        if (!grafo.grafoVacio()) {
            // Iteramos sobre cada estación en el grafo
            for (int indice = 0; indice < grafo.getEstaciones().getSize(); indice++) {
                Estacion estacionActual = (Estacion) grafo.getEstaciones().getValor(indice);
                // Verificamos si la estación tiene sucursal
                if (estacionActual.isHaySucursal()) {
                    // Si tiene sucursal, la agregamos a la lista
                    listaConSucursal.aggFinal(estacionActual.getNombreEstacion());
                }
            }
        }
        return listaConSucursal; // Devolvemos la lista de estaciones con sucursal
    }

    /**
     * Método para obtener una lista de los nombres de las estaciones que no tienen sucursal.
     *
     * @param grafo El grafo que contiene las estaciones.
     * @return Una lista simple con los nombres de las estaciones sin sucursal.
     */
    public ListaSimple listarEstacionesSinSucursal(Grafo grafo) {
        ListaSimple listaSinSucursal = new ListaSimple(); // Lista para almacenar estaciones sin sucursal
        // Verificamos si el grafo no está vacío
        if (!grafo.grafoVacio()) {
            // Iteramos sobre cada estación en el grafo
            for (int indice = 0; indice < grafo.getEstaciones().getSize(); indice++) {
                Estacion estacionActual = (Estacion) grafo.getEstaciones().getValor(indice);
                // Verificamos si la estación no tiene sucursal
                if (!estacionActual.isHaySucursal()) {
                    // Si no tiene sucursal, la agregamos a la lista
                    listaSinSucursal.aggFinal(estacionActual.getNombreEstacion());
                }
            }
        }
        return listaSinSucursal; // Devolvemos la lista de estaciones sin sucursal
    }

    /**
    * Método para establecer una sucursal en una estación específica.
    *
    * @param nombreDeEstacion El nombre de la estación donde se desea agregar la sucursal.
    * @param grafo El grafo que contiene las estaciones.
    */
    public void agregarSucursal(String nombreDeEstacion, Grafo grafo) {
        Estacion estacionActual = grafo.encontrarEstacion(nombreDeEstacion); // Buscamos la estación
        // Verificamos si la estación existe
        if (estacionActual != null) {
            estacionActual.setHaySucursal(true); // Establecemos que la estación tiene sucursal
            JOptionPane.showMessageDialog(null, "La sucursal se ha agregado correctamente a la estación."); // Mensaje de éxito
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo encontrar la estación especificada. Intente de nuevo."); // Mensaje de error
        }
    }

    /**
    * Método para remover una sucursal de una estación específica.
    *
    * @param nombreDeEstacion El nombre de la estación de la que se desea remover la sucursal.
    * @param grafo El grafo que contiene las estaciones.
    */
    public void eliminarSucursal(String nombreDeEstacion, Grafo grafo) {
        Estacion estacionActual = grafo.encontrarEstacion(nombreDeEstacion); // Buscamos la estación
        // Verificamos si la estación existe
        if (estacionActual != null) {
            estacionActual.setHaySucursal(false); // Establecemos que la estación no tiene sucursal
            JOptionPane.showMessageDialog(null, "La sucursal ha sido eliminada de la estación con éxito."); // Mensaje de éxito
        } else {
            JOptionPane.showMessageDialog(null, "La estación no fue encontrada. No se pudo eliminar la sucursal."); // Mensaje de error
        }
    }
}