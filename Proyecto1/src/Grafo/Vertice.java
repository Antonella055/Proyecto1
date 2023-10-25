/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import proyecto1.GestordeArchivo;

/**
 *
 * @author Antonella
 */
public class Vertice {
    int Id;

    List<Vertice> arcos;
    
    
    public Vertice(int Id){
        this.Id= Id;
        this.arcos= new ArrayList<>();
      
    }
    
    public void addAdyacente(Vertice vertice){
        arcos.add(vertice);
    }
    
    public List<Vertice> getAdyacente(){
        return arcos;
    }
    public int getId(){
        return Id;
    }
    
    public void setId(int Id){
        this.Id=Id;
    }
    
    
         }
  
   

