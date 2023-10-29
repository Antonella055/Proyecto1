/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import static java.lang.System.out;
import java.util.Stack;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import proyecto1.GestordeArchivo;

/**
 *
 * @author Antonella
 */
public class ComponentesFConectados {
        
        public ComponentesFConectados(){
            GestordeArchivo gestor= new GestordeArchivo();
           
         
            
}
        
    public void busquedadDFS(Graph<Integer, DefaultEdge> graf2,int verticeInicial){
        boolean [] revisado= new boolean [graf2.vertexSet().size()];
        Stack<Integer> stack= new Stack<>();
        
        revisado[verticeInicial]=true;
        stack.push(verticeInicial);
        
        while (!stack.isEmpty()){
            int x=stack.pop();
            System.out.println("Vertice revisado:"+x);
            
            for(DefaultEdge edge: graf2.outgoingEdgesOf(x)){
                int vecino=graf2.getEdgeTarget(edge);
                if(!revisado[vecino]){
                    revisado[vecino]=true;
                    stack.push(vecino);
                }
            }
            
        }
        
        
        
        
    }
    
}
