package Grafo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.layout.mxGraphLayout;

import com.mxgraph.swing.mxGraphComponent;


import com.mxgraph.view.mxGraph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;
import proyecto1.GestordeArchivo;
import interfaces.VerGrafo;
import javax.swing.JFrame;


/**
 *
 * @author Antonella
 */
public class GeneradorGrafo  {

    int [][] matrizAdyacencia;
    private List<Vertice> vertices;
    String VString;
    private final mxGraph grafo;
    public JPanel panelGrafo;
    private final HashMap <Integer, Object> vertexMap;
    private final HashMap<Integer, String>usuario;
    private final HashMap<Integer, List<String>>usuarioMap;
    HashMap<Integer,String> crearMapaUsers;

  
    private Object parent;
    private List<String> usuarios;


    
    public GeneradorGrafo(GestordeArchivo gestor){ 
        this.matrizAdyacencia= gestor.getMatriz();
        this.usuarios= gestor.getusuarios();
        grafo= new mxGraph();
        usuarioMap= new HashMap<>();
        vertices= new ArrayList<>();
        vertexMap=new HashMap();
        usuario=new HashMap<>();
        usuarios=new ArrayList<>();
      
    }
    
     public HashMap<Integer, String> crearMapaUser(List<String>usuarios) { //Crear un mapa de usuarios para vincular su posicion de matriz con su nombre de usuario
        HashMap<Integer, String> usuario = new HashMap<>();
        for (int i=0; i< usuarios.size(); i++){
            usuario.put(i, usuarios.get(i)); //agregar el valor posicion y el user al mapa
        }
        return usuario;
    }
     
     public List<String> getUsuario(){
         return new ArrayList<>(usuario.values());
     }
    public void generarGrafo (int[][] matrizAdyacencia) throws Exception{
        // Agrega más usuarios si es necesario
        mxGraph grafo= new mxGraph();
        HashMap<Integer, String> mapaUsuarios = crearMapaUser(usuarios);
        
        
        for (int i=0; i< matrizAdyacencia.length; i++){ //iteracion para agregar los vertices 
            Vertice vertice = new Vertice(i),;
            vertices.add(vertice);
            usuarioMap.put(i, getUsuario());
        }
        for (int i=0; i< matrizAdyacencia.length; i++){
             for (int j=i+1;j< matrizAdyacencia[i].length;j++){
                if (matrizAdyacencia[i][j]==1){ //agrega las relaciones de los vertices mediante artistas, evaluando si en la matriz el valor es 1.
                   Vertice origen= vertices.get(i);
                   Vertice destino= vertices.get(j);
                   origen.addAdyacente(destino);
                   destino.addAdyacente(origen);
                   
                    }
                }}
    ImprimirG();
    GrafoVisual(usuarioMap);
    }
    //Output de los pares (eliminar)
    public void ImprimirG (){
    for (Vertice vertice: vertices){
        System.out.print("vertice:"+ vertice.Id+":");
        for (Vertice adyacente: vertice.arcos){
            System.out.print("("+vertice.Id+","+adyacente.Id+")");
        }
        System.out.println();
    }
   
     
    }
    
    
      public void GrafoVisual(HashMap<Integer,List<String>> usuarioMap){
          Object parentG=grafo.getDefaultParent();
          grafo.getModel().beginUpdate();
          
          
          try{
              HashMap<Vertice, Object> vertexMap = new HashMap<>();
              for (Vertice origen: vertices){
                  if (!vertexMap.containsKey(origen)){
                      
                      
                       Object v1= grafo.insertVertex(parentG, null, origen, 20, 20, 80, 30); 
                  }
                for (Vertice destino: origen.getAdyacente()){
                     if (!vertexMap.containsKey(destino)){
                    Object v2 = grafo.insertVertex(parentG, null, destino, 20, 20, 80, 30);
                    vertexMap.put(destino, v2);
                    
                }
                     Object v1= vertexMap.get(origen);
                     Object v2= vertexMap.get(destino);
                     grafo.insertEdge(parentG, null, " ", v1, v2);
                     
              }
              }
          }finally {
              grafo.getModel().endUpdate();
          }
          
          
          visualizarGrafo(panelGrafo,grafo);
      }
    
        
    public void visualizarGrafo(JPanel panel, mxGraph grafo) {
        
           JFrame frame = new JFrame();
        frame.setTitle("Grafo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
        mxGraphComponent graphComponent = new mxGraphComponent(grafo);
        mxGraphLayout layout = new mxHierarchicalLayout(grafo);
        layout.execute(grafo.getDefaultParent());
         frame.getContentPane().add(graphComponent);
        frame.pack();
        frame.setVisible(true);
        
   
   
    }
    
        }
    



