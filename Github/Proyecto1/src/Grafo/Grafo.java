package Grafo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




/**
 *
 * @author Antonella
 */
public class Grafo {
    private int [][] matrizAdyacencia; 
    
    public void importarMatriz(int [][]matriz){
        matrizAdyacencia = matriz;
    }
    
    private void grafoVisual(){
        Grafo grafo = new SingleGraph("Grafo");
        int n = matrizAdyacencia.length;
        
        for (int i=0; i <n; i++){
            Nodo nodo= graph.addNode(String.valueOf(i));
        }
        
        for (int i =0; i<n ;i++){
            for (int j=0; j<n;j++)
                if (matrizAdyacencia[i][j]==1){
                    graph.addEdge(String.valueOf(i)+ "-" + String.valueOf(j), String.valueOf(i), String.valueOf(j)
                    );
                }
            graph.display();
        }
        
        
        
        
    }
    
}
