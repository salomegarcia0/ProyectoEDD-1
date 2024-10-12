/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import EDD.ListaSimple;

/**
 *
 * @author salom
 */
public class Estacion {

    private String nombreEstacion;
    private int idEstacion;
    private ListaSimple listaAdyacencia;
    private boolean haySucursal;
    private Estacion peaton;

    //Constructor
    public Estacion(String nombreEstacion) {
        this.nombreEstacion = nombreEstacion;
        this.idEstacion = -1;
        this.listaAdyacencia = new ListaSimple();
        this.haySucursal = false;
        this.peaton = null;
    }

    // Getters y Setters
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
     * Funcion que utiliza un string builder para facilitar la creacion de cadenas de texto
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombreEstacion).append("\nID de Estacion: ")
                .append(idEstacion).append("\n Posee Sucursal: ")
                .append(haySucursal).append("\nEstaciones cercanas: ");

        for (int i = 0; i < listaAdyacencia.getSize(); i++) {
            Estacion adyacente = (Estacion) listaAdyacencia.getValor(i);
            sb.append(adyacente.getNombreEstacion()).append(", ");
        }

        //Mostrar nombres de las estaciones peatonales
        if (this.peaton != null) {
            sb.append("\nESTACIONES PEATONALES: ");
            sb.append(this.peaton.getNombreEstacion());
        }

        return sb.toString();
    }

}
