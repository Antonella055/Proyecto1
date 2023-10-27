/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import java.util.ArrayList;
import java.util.List;
import proyecto1.GestordeArchivo;

/**
 *
 * @author Antonella
 */
public class Grafo {
    private final int [][] matrizAdyacencia; 
    private List<Vertice> vertices;
    private List<Arco> adyacentes;
    
    public Grafo(List<Vertice> vertices, List<Arco> adyacentes){
        this.vertices= vertices;
        this.adyacentes=adyacentes;
        this.matrizAdyacencia = null;
        
    }
    public Grafo(GestordeArchivo gestor){
    this.matrizAdyacencia= gestor.getMatriz();
    }
    
    public List<Vertice> getVertices(){
        return vertices;
    }
    
    public void setVertices(List<Vertice> vertices){
        this.vertices=vertices;
    }
    
    public List<Arco> getAdyacentes(){
        return adyacentes;
    }
    
    public void setAdyacentes(List<Arco> adyacente){
        this.adyacentes=adyacente;
    }
    
    public static Grafo construirGrafoDesdeMatrizAdyacencia(boolean[][] matrizAdyacencia) {
        List<Vertice> vertices = new ArrayList<>();
        List<Arco> adyacentes = new ArrayList<>();
        
        int numVertices = matrizAdyacencia.length;
        
        // Crear los vértices
        for (int i = 0; i < numVertices; i++) {
            Vertice vertice = new Vertice(i);
            vertices.add(vertice);
        }
        
        // Crear los arcos
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matrizAdyacencia[i][j]) {
                    Vertice origen = vertices.get(i);
                    Vertice destino = vertices.get(j);
                    Arco arco = new Arco(origen, destino);
                    adyacentes.add(arco);
                }
            }             

        }
        
        return new Grafo(vertices, adyacentes);
        
        
    }
    
}

