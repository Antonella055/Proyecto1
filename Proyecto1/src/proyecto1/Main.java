/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

import Grafo.Arco;
import Grafo.ComponentesFConectados;
import Grafo.ConstructordeGrafoD;
import Grafo.Grafoprueba;
import Grafo.Vertice;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;


//Main
/**
 *
 * @author Antonella
 */

public class Main {
    public static void main (String[] args) throws FileNotFoundException, Exception{
           GestordeArchivo gestor = new GestordeArchivo();
           Grafoprueba vertice= new Grafoprueba();
           
            // Crear una instancia de GeneradorGrafo con los parámetros gestor y ventana 
            ConstructordeGrafoD cons= new ConstructordeGrafoD(gestor, vertice);

        
        ComponentesFConectados comp= new ComponentesFConectados();
        gestor.ArchivoSeleccionado();
        Map <String, List<String>> relaciones= gestor.obtenerRelaciones();

        List<String> usuarios=gestor.obtenerUsuarios(relaciones);
        
        HashMap<Integer, String> usuarioMap = cons.crearMapaUser(usuarios);
        
        List<Vertice> vertices= new ArrayList();
        List<Arco> adyacentes=new ArrayList();
      
        int[][] matrizAdyacencia = gestor.crearmatrizAdyacencia(usuarios,relaciones);
//     
//       gestor.mostrarmatrizAdyacencia(matrizAdyacencia, usuarios);
//        generador.generarGrafo(matrizAdyacencia, usuarioMap);
        cons.generarGrafo(matrizAdyacencia, usuarioMap);
        
        }
    }
    
    
//    public void eliminarUsuario(String usuario){
//        usuarios.remove(usuario);   //metodo remover
//        for (List<String> conexiones :usuarios.values()){ //ingresar a la lista para eliminar al usuario
//            conexiones.remove(usuario);
//        }
//    }
    
    
   
