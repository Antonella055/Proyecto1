/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.layout.mxGraphLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFrame;
import proyecto1.GestordeArchivo;

/**
 *
 * @author Antonella
 */
public class ConstructordeGrafoD {
    private Grafoprueba <Integer> grafo;
    private final mxGraph grafos;
    private final HashMap <Integer, Object> vertexMap;
    private final List<String>usuarios;
    private HashMap <Integer, String> usuarioMap;
    private final int [][] matrizAdyacencia; 
 
    
    public ConstructordeGrafoD (GestordeArchivo gestor){ 
        this.matrizAdyacencia= gestor.getMatriz();
        this.usuarios= gestor.getusuarios();
        
       
        grafos=new mxGraph();
        vertexMap=new HashMap();
        usuarioMap=new HashMap();
         grafo= new Grafoprueba<>();
        
    }
    
    public HashMap<Integer, String> crearMapaUser(List<String>usuarios) { //Crear un mapa de usuarios para vincular su posicion de matriz con su nombre de usuario
        HashMap<Integer, String> usuarioMap = new HashMap<>();
        for (int i=0; i< usuarios.size(); i++){
            usuarioMap.put(i, usuarios.get(i)); //agregar el valor posicion y el user al mapa
        }
        return usuarioMap;
    }
    

    
    public void generarGrafo (int[][] matrizAdyacencia, HashMap<Integer, String> usuarioMap){
        int numVertices= matrizAdyacencia.length; //numero de vertices del grafo partiendo de los datos de la matriz
        this.usuarioMap = usuarioMap;
       
        
        for (int i=0; i< numVertices; i++){ //iteracion para agregar los vertices 
            String nodo= usuarioMap.get(i);
            grafo.agregarVertice(i);
            
        }
        for (Integer vertex :grafo.ObtenerVertices()){ //crea los pares de vertices 
            Object obj=grafos.insertVertex(null, null,usuarioMap.get(vertex),20,20,80,30);
            vertexMap.put(vertex, obj);
        }
        
        for (int i =0 ; i < numVertices; i++){  //itera cada par de vertice
            for (int j=0;j< numVertices;j++){
                if (matrizAdyacencia[i][j]==1){ //agrega las relaciones de los vertices mediante artistas, evaluando si en la matriz el valor es 1.
                    grafo.agregarArista(i,j);
                    
                    }
                }
        for (Integer origen: grafo.ObtenerVertices()){ //iteracion sobre las aristas del grafo
            for (Integer destino: grafo.obtenerAdyacente(origen)){
                grafos.insertEdge(null, null," ",vertexMap.get(origen),vertexMap.get(destino));
           
            }
          
        }
        
    }
         System.out.println(grafo.toString()); // printear el grafo JGraphT 
         GrafoVisual(matrizAdyacencia);
    }
    
    
    public void GrafoVisual(int[][] matrizAdyacencia){
        mxGraph visualgrafo= new mxGraph();
       int numVertices = matrizAdyacencia.length;
        Object parent= visualgrafo.getDefaultParent();
        visualgrafo.getModel().beginUpdate();
        try{
            for (int i=0;i<numVertices;i++){
                String nodo= usuarioMap.get(i);
                Object vertex =visualgrafo.insertVertex(parent, "", nodo, 20,20, 80, 30);
                vertexMap.put(i, vertex);
            }
            
        }finally{
            visualgrafo.getModel().endUpdate();
        }
        
        visualgrafo.getModel().beginUpdate();
        try{
            for(int i=0;i<numVertices; i++){
                for (int j=0;j<numVertices; j++){
                    if (matrizAdyacencia[i][j]==1){
                        visualgrafo.insertEdge(parent, null, "", vertexMap.get(i), vertexMap.get(j));
                    }
                }
            }
        }finally{
            visualgrafo.getModel().endUpdate();
        }
        
        mxCompactTreeLayout layout = new mxCompactTreeLayout(visualgrafo);
        layout.setHorizontal(false);
        layout.execute(visualgrafo.getDefaultParent());

        // Crear un componente de grafo y mostrarlo en una ventana
        mxGraphComponent graphComponent = new mxGraphComponent(visualgrafo);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(graphComponent);
        frame.pack();
        frame.setVisible(true);
        
    }
    
    
        
//    public void visualizarGrafo() {
//        JFrame frame = new JFrame();
//        frame.setTitle("Grafo");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        mxGraphComponent graphComponent = new mxGraphComponent(grafos);
//        mxGraphLayout layout = new mxHierarchicalLayout(grafos);
//        layout.execute(graphComponent.getGraph().getDefaultParent());
//        frame.getContentPane().add(graphComponent);
//        frame.pack();
//        frame.setVisible(true);
//    }
    
      
        }
    
