/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

import Grafo.ComponentesFConectados;
import Grafo.GeneradorGrafo;
import Grafo.Vertice;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//Main
/**
 *
 * @author Antonella
 */

public class Main {
    public static void main (String[] args) throws FileNotFoundException, Exception{
        GestordeArchivo gestor= new GestordeArchivo();
       
        GeneradorGrafo grafo= new GeneradorGrafo(gestor);
        

        
        ComponentesFConectados comp= new ComponentesFConectados();
      
        
        gestor.ArchivoSeleccionado();
        Map <String, List<String>> relaciones= gestor.obtenerRelaciones();
        List<String> usuarios=gestor.obtenerUsuarios(relaciones);
        
      
        int[][] matrizAdyacencia = gestor.crearmatrizAdyacencia(usuarios, relaciones);
     
        gestor.mostrarmatrizAdyacencia(matrizAdyacencia, usuarios);
        grafo.generarGrafo(matrizAdyacencia);
        
        }

    }
    
    
//    public void eliminarUsuario(String usuario){
//        usuarios.remove(usuario);   //metodo remover
//        for (List<String> conexiones :usuarios.values()){ //ingresar a la lista para eliminar al usuario
//            conexiones.remove(usuario);
//        }
//    }
    
    
   
