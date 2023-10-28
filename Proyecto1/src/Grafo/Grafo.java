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
    
    
        
    }

}

