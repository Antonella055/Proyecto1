/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.layout.mxGraphLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFrame;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import proyecto1.GestordeArchivo;

/**
 *
 * @author Antonella
 */
public class GrafoJgraphT {
    private final SimpleGraph<Integer, DefaultEdge> grafo;
    private final mxGraph grafos;
    private final HashMap <Integer, Object> vertexMap;
    private final List<String>usuarios;
    private HashMap <Integer, String> usuarioMap;
    private final int [][] matrizAdyacencia; 
    public final DefaultDirectedGraph<Integer, DefaultEdge> graf2;
    private List<Vertice> vertices;
    private List<Arco> adyacentes;
    
    
    
    public GrafoJgraphT(GestordeArchivo gestor){ 
        this.matrizAdyacencia= gestor.getMatriz();
        this.usuarios= gestor.getusuarios();
        grafo= new SimpleGraph<>(DefaultEdge.class);
        grafos=new mxGraph();
        vertexMap=new HashMap();
        usuarioMap=new HashMap();
        graf2= new DefaultDirectedGraph<>(DefaultEdge.class);
        
        
        this.vertices = new ArrayList<>();
        this.adyacentes = new ArrayList<>();
    }
    
    public HashMap<Integer, String> crearMapaUser(List<String>usuarios) { //Crear un mapa de usuarios para vincular su posicion de matriz con su nombre de usuario
        HashMap<Integer, String> usuarioMap = new HashMap<>();
        for (int i=0; i< usuarios.size(); i++){
            usuarioMap.put(i, usuarios.get(i)); //agregar el valor posicion y el user al mapa
        }
        return usuarioMap;
    }
    
    public void generarGrafo (int[][] matrizAdyacencia, HashMap<Integer, String> relaciones, Grafo grafo){
        int numVertices= matrizAdyacencia.length; //numero de vertices del grafo partiendo de los datos de la matriz
        this.usuarioMap = relaciones;
        
     
        List<Vertice> verticeList=new ArrayList<>();
        List<Arco> adyacentes=new ArrayList<>();
       

        for (int i=0; i< numVertices; i++){ //iteracion para agregar los vertices 
            Vertice vertice= new Vertice(i);
            verticeList.add(vertice);
            
    }
            
        for (int i =0 ; i < numVertices; i++){  //itera cada par de vertice
            for (int j=0;j< numVertices;j++){
                if (matrizAdyacencia[i][j]==1){ //agrega las relaciones de los vertices mediante artistas, evaluando si en la matriz el valor es 1.
                    Vertice origen=verticeList.get(i);
                     Vertice destino =verticeList.get(j);
                     Arco arco= new Arco(origen,destino);
                     origen.addVecino(destino);
                     adyacentes.add(arco);
                     

                }}}
        
        Grafo constructor= new Grafo(verticeList,adyacentes);

        for(Vertice y:grafo.getVertices()){
            for (Vertice x: y.getAdyacente())
           System.out.println(y+"->"+x);
        }
        
       for (Vertice vertice :verticeList ){
           System.out.println(vertice+"-"+vertice.getcompId());
       }
         
    }
        
    }
    
//        
//    }
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
    
      
        
    

    

//   verticeList.get(verticeList.indexOf(arco.getDestino())).addVecino(arco.getOrigen());
                        