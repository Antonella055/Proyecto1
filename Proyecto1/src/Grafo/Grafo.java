/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import java.util.List;

/**
 *
 * @author Antonella
 */
public class Grafo {
    private List<Vertice> vertices;
    private List<Arco> adyacentes;
    
    public Grafo(){
        
    }
    
    public Grafo(List<Vertice>vertices,List<Arco> adyacentes){
        this.vertices= vertices;
        this.adyacentes=adyacentes;
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
