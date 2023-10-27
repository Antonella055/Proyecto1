/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

/**
 *
 * @author Antonella
 */
public class Arco {
    private Vertice origen;
    private Vertice destino;

    
    public Arco(Vertice origen, Vertice destino){
        this.origen=origen;
        this.destino=destino;
   
    }
    

    public Vertice getOrigen(){
        return origen;
    }
    
    public Vertice getDestino(){
        return destino;
    }
    public void setOrigen(Vertice vOrigen){
        this.origen=vOrigen;
    }
   public void setDestino(Vertice vdestino){
       this.destino=vdestino;
   }
}

