/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import Clases.Estacion;
import EDD.Grafo;
import EDD.ListaSimple;
import Interfaces.Menu;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;



/**
 * Clase que representa un visualizador de un grafo de estaciones de transporte.
 * Extiende JFrame para crear una ventana de visualización.
 * @author salom
 */
public class VerGrafo extends JFrame {


    private Grafo grafo;
    private Viewer visor;
    private ViewPanel panelVista;
    
    /**
     * Constructor que inicializa el visualizador con un grafo dado.
     * 
     * @param grafo El grafo a visualizar.
     */
    public VerGrafo(Grafo grafo) {
        this.grafo = grafo;
        setearInterfaz();
        iniciarVerGrafo();
        volverMenu();
    }
    
    /**
     * Configura la interfaz del JFrame.
     */
    private void setearInterfaz() {
        setTitle("Visiaulizador de Red de Transporte");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }
    
    /**
     * Inicia la visualización del grafo.
     */
    private void iniciarVerGrafo() {
        Graph imagenGrafo = new SingleGraph("Estaciones");
        armarGrafo(imagenGrafo);

       
        visor = imagenGrafo.display(false);
        visor.enableAutoLayout();  

        
        if (panelVista == null) {
            panelVista = (ViewPanel) visor.getDefaultView();  
            add(panelVista, BorderLayout.CENTER); 
        }
    }
    
    /**
     * Construye el grafo visual a partir de las estaciones.
     * 
     * @param grafoVisual El grafo visual a construir.
     */
    private void armarGrafo(Graph grafoVisual) {
        for (int i = 0; i < grafo.getEstaciones().getSize(); i++) {
            Estacion estacion = (Estacion) grafo.getEstaciones().getValor(i);
            Node nodo = grafoVisual.addNode(estacion.getNombreEstacion());
            nodo.setAttribute("ui.label", estacion.getNombreEstacion());

            String color = estacion.isHaySucursal()? "purple" : "green";
            nodo.setAttribute("ui.style", "fill-color: " + color + ";");
        }

        insertarRuta(grafoVisual);

        
        grafoVisual.setAttribute("ui.stylesheet", 
            "node { text-size: 15px; size: 30px; text-alignment: under; }" +
            "edge { size: 2px; }"
        );
    }
    
    /**
     * Inserta las rutas entre las estaciones en el grafo visual.
     * 
     * @param grafoVisual El grafo visual donde insertar las rutas.
     */
    private void insertarRuta(Graph grafoVisual) {
        for (int i = 0; i < grafo.getEstaciones().getSize(); i++) {
            Estacion estacion = (Estacion) grafo.getEstaciones().getValor(i);
            ListaSimple adyacencias = estacion.getListaAdyacencia();

            for (int j = 0; j < adyacencias.getSize(); j++) {
                Estacion estacionConectada = (Estacion) adyacencias.getValor(j);
                String referenciaConexion = estacion.getNombreEstacion() + "-" + estacionConectada.getNombreEstacion();

                if (grafoVisual.getEdge(referenciaConexion) == null && grafoVisual.getEdge(estacionConectada.getNombreEstacion() + "-" + estacion.getNombreEstacion()) == null) {
                    grafoVisual.addEdge(referenciaConexion, estacion.getNombreEstacion(), estacionConectada.getNombreEstacion());
                }
            }
            insertarPeatonales(grafoVisual, estacion);
        }
    }
    
    /**
     * Inserta las rutas peatonales en el grafo visual.
     * 
     * @param grafoVisual El grafo visual donde insertar las rutas peatonales.
     * @param estacion La estación actual para verificar rutas peatonales.
     */
    private void insertarPeatonales(Graph grafoVisual, Estacion estacion) {
        Estacion peatonal = estacion.getPeaton();
        if (peatonal != null) {
            String referenciaPeatonal = estacion.getNombreEstacion() + "-" + peatonal.getNombreEstacion() + "-peatonal";

            if (grafoVisual.getEdge(referenciaPeatonal) == null) {
                Edge aristaPeatonal = grafoVisual.addEdge(referenciaPeatonal, estacion.getNombreEstacion(), peatonal.getNombreEstacion(), true);
                aristaPeatonal.setAttribute("ui.style", "stroke-mode: dots; stroke-color: blue;");
            }
        }
    }

    /**
     * Configura el botón para volver al menú principal.
     */
    private void volverMenu() {
        JButton botonRegresar = new JButton("Volver al Menu");
        botonRegresar.addActionListener(e -> {
            CerrarVentana();
            this.dispose();
            Menu menu = new Menu();
            menu.setVisible(true);
            menu.setLocationRelativeTo(null);
            menu.setResizable(false);
        });
        add(botonRegresar, BorderLayout.SOUTH);
    }

     /**
     * Cierra la ventana del visor.
     */
    private void CerrarVentana() {
        if (visor != null) {
            visor.disableAutoLayout();
            visor.close();
        }
        if (panelVista != null) {
            remove(panelVista);
            panelVista = null;
        }
    }
}

