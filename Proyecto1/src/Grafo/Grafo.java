/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Antonella
 * @param <T>
 */
public class Grafo<T> {
    private Map<T,List<T>> adyacencia;
    
    public Grafo(){
        adyacencia=new HashMap<>();
       
    }
    
    public void agregarVertice(T vertice){
        adyacencia.put(vertice, new ArrayList<>());
    }
    
    public void agregarArista(T origen, T destino){
        adyacencia.get(origen).add(destino);
  
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
    
    @Override
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
        List<List<Integer>> aristas=getAristas();
        for (List<Integer> arista:aristas){
            sb.append(arista).append("\n");
        }
        
             return sb.toString();
    }
    
    public List<List<Integer>> getAristas(){
        List<T> vertices=ObtenerVertices();
        List<List<Integer>> aristas=new ArrayList<>();  //crear una lista vacía  almacena las aristas del grafo. Cada arista se representará como una lista de enteros.
        
        for (T origen : vertices) {
            for (T destino : obtenerAdyacente(origen)) {
                int NoOrigen= Integer.parseInt(origen.toString());
                int NoDestino= Integer.parseInt(destino.toString());
                List<Integer> arista= Arrays.asList(NoOrigen,NoDestino);
                aristas.add(arista);
            }
        }System.out.println("a:" +aristas);
        List<List<Integer>> paresDoblementeConectados =getBidireccionales(aristas); // obtener las aristas que están conectadas en ambas direcciones.
        for (List<Integer> par : paresDoblementeConectados) {
            System.out.println("pares"+par);
        }
    
        return aristas;}
    
    
         public List<List<Integer>> getBidireccionales (List<List<Integer>> aristas){
         List<List<Integer>> ParesBidireccionales= new ArrayList<>();
         
         for (List<Integer> arista: aristas){
              List<Integer> aristaInversa = Arrays.asList(arista.get(1), arista.get(0));//crear una lista inversa intercambiando destino y origen
             
            if (aristas.contains(aristaInversa)){ //si la lista aristas contiene la arista aristaInversa. Si las contiene la arista actual y su inversa son bidireccionales.
                ParesBidireccionales.add(arista);
            }
         }
         return ParesBidireccionales;
    }
}

