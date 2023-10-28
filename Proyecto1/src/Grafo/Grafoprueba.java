/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Antonella
 * @param <T>
 */
public class Grafoprueba<T> {
    private Map<T,List<T>> adyacencia;
    
    public Grafoprueba(){
        adyacencia=new HashMap<>();
    }
    
    public void agregarVertice(T vertice){
        adyacencia.put(vertice, new ArrayList<>());
    }
    
    public void agregarArista(T origen, T destino){
        adyacencia.get(origen).add(destino);
        adyacencia.get(destino).add(origen);
    }
    
    public List<T> obtenerAdyacente(T vertice){
        return adyacencia.get(vertice);
    }
    public boolean existeArista(T origen,T destino){
        return adyacencia.get(origen).contains(destino);
    }
    public int obtenerNumVertices(){
        return adyacencia.size();
    }
    
    public int ObtenerNumAristas(){
        int contador=0;
        for (List<T> adyacentes: adyacencia.values()){
            contador+= adyacentes.size();
        }
        return contador/2;
    }
    
    public List<T> ObtenerVertices(){
        return new ArrayList<>(adyacencia.keySet());
    }
    
    public String toString(){
        List<T> vertices = ObtenerVertices();
        StringBuilder sb= new StringBuilder();
        
        sb.append("Grafo: \n");
        sb.append("Vértices: ");
        for (T vertice : vertices) {
            sb.append(vertice.toString()).append(" ");
        }
        sb.append("\n");

        // Imprimir las aristas
        sb.append("Aristas:\n");
        for (T origen : vertices) {
            for (T destino : obtenerAdyacente(origen)) {
                sb.append(origen.toString()).append(" -> ").append(destino.toString()).append("\n");
            }
        }

        
        
        return sb.toString();

    }
}
