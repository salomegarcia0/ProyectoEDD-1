/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import EDD.ListaSimple;

/**
 *
 * @author salom
 * 
 * Clase Estacion: representa una estación en un sistema de transporte que
 * incluye atributos para el nombre, identificador, conexiones adyacentes, 
 * estado de sucursal y enlaces a estaciones peatonales.
 */

/**
 * Clase Estacion - modela una estación con atributos como nombre, id, lista de adyacencias,
 * sucursal y conexión peatonal. Permite gestionar información básica de cada estación.
 */
public class Estacion {

    private String nombreEstacion; // Nombre de la estación
    private int idEstacion;        // Identificador único de la estación
    private ListaSimple listaAdyacencia; // Lista de estaciones adyacentes
    private boolean haySucursal;   // Indica si la estación tiene una sucursal
    private Estacion peaton;       // Referencia a una estación peatonal conectada

    /**
     * Constructor de la clase Estacion.
     * Inicializa el nombre de la estación y establece valores predeterminados para
     * id (-1), lista de adyacencia (nueva lista), haySucursal (falso) y peaton (null).
     * @param nombreEstacion El nombre de la estación.
     */
    public Estacion(String nombreEstacion) {
        this.nombreEstacion = nombreEstacion;
        this.idEstacion = -1;
        this.listaAdyacencia = new ListaSimple();
        this.haySucursal = false;
        this.peaton = null;
    }

    // Getters y Setters para obtener y establecer los atributos de la estación.

    public String getNombreEstacion() {
        return nombreEstacion;
    }

    public void setNombreEstacion(String nombreEstacion) {
        this.nombreEstacion = nombreEstacion;
    }

    public int getIdEstacion() {
        return idEstacion;
    }

    public void setIdEstacion(int idEstacion) {
        this.idEstacion = idEstacion;
    }

    public ListaSimple getListaAdyacencia() {
        return listaAdyacencia;
    }

    public void setListaAdyacencia(ListaSimple listaAdyacencia) {
        this.listaAdyacencia = listaAdyacencia;
    }

    public boolean isHaySucursal() {
        return haySucursal;
    }

    public void setHaySucursal(boolean haySucursal) {
        this.haySucursal = haySucursal;
    }

    public Estacion getPeaton() {
        return peaton;
    }

    public void setPeaton(Estacion peaton) {
        this.peaton = peaton;
    }

    /**
     * Convierte la lista de estaciones adyacentes en un String.
     * @return Una cadena con los nombres de las estaciones adyacentes en formato "NombreEstacion=>", o null si no hay estaciones adyacentes.
     */
    public String ConvertirListaAdyacencia() {
        if (!this.listaAdyacencia.isEmpty()) {
            String listaAdyacenciaStr = "";
            for (int i = 0; i < this.listaAdyacencia.getSize(); i++) {
                Estacion estacion = (Estacion) this.listaAdyacencia.getValor(i);
                listaAdyacenciaStr += estacion.getNombreEstacion() + "=>";
            }
            return listaAdyacenciaStr;
        } else {
            return null;
        }
    }

    @Override
    /**
     * Método toString: genera una representación en forma de texto de la estación.
     * Incluye nombre, ID, estado de sucursal y lista de estaciones cercanas y peatonales.
     * Utiliza StringBuilder para optimizar la creación de la cadena.
     * @return Una cadena representando los detalles de la estación.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombreEstacion)
          .append("\nID de Estacion: ").append(idEstacion)
          .append("\nPosee Sucursal: ").append(haySucursal)
          .append("\nEstaciones cercanas: ");

        for (int i = 0; i < listaAdyacencia.getSize(); i++) {
            Estacion adyacente = (Estacion) listaAdyacencia.getValor(i);
            sb.append(adyacente.getNombreEstacion()).append(", ");
        }

        // Mostrar nombres de las estaciones peatonales si existen
        if (this.peaton != null) {
            sb.append("\nEstaciones Peatonales: ").append(this.peaton.getNombreEstacion());
        }

        return sb.toString();
    }

}
