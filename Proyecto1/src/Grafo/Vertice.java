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
    private int Id;
    private String nombre;
    private boolean visitado;
    private List<Vertice> adyacentes;
    private int compId;
    

    
    public Vertice(int Id){
        this.Id= Id;
        this.nombre= nombre;
        this.adyacentes= new ArrayList<>();
    }
    
   
    public List<Vertice> getAdyacente(){
        return adyacentes;
    }
    public int getId(){
        return this.Id;
    }
    
    public void setcompId(int compId){
        this.compId=compId;
    }
    
    public int getcompId(){
        return compId;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public boolean Vistado(){
        return visitado;
    } 
    public void setVisita(boolean visitado){
        this.visitado=visitado;
    }
    
    public void addVecino(Vertice vertice){
        this.adyacentes.add(vertice);
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
    
         }
  
   

