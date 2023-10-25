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
    Vertice origen;
    Vertice destino;
    int peso;
    
    public Arco(Vertice origen,Vertice destino, int peso){
        this.origen=origen;
        this.destino=destino;
        this.peso=peso;
    }
    
}
