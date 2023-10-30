/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1;

//matriz  y lectura del Jchooser

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;



import javax.swing.JTextArea;
/**
 *
 * @author Antonella
 */

public class GestordeArchivo { 
    /**
     * @throws java.io.FileNotFoundException
     */
    private static File selectedFile; 
    public int[][] matrizAdyacencia;
    private List<String> usuarios;

    

    
    public static void ArchivoSeleccionado() throws FileNotFoundException{
        JFileChooser fileChooser = new JFileChooser(); //JFileChooser ->abrir un cuadro de diálogo donde el usuario puede elegir un fichero a través del explorador de archivos de su equipo.
        JTextArea text = new JTextArea();
        text.setEditable(false); //el usuario no tiene permitido editar el contenido
        
        fileChooser.setCurrentDirectory(new File("C:\\Users\\Antonella\\OneDrive\\Escritorio\\Proyecto Github\\Github\\Proyecto1\\Usuarios txt")); //abrir una carpeta predeterminada
        
        // Filtrar solo archivos de texto 
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt", "txt");
        fileChooser.setFileFilter(filter);
        
        // llamada a  el cuadro de diálogo de selección de archivo
        int returnValue = fileChooser.showOpenDialog(null);
        
        if (returnValue == JFileChooser.APPROVE_OPTION ) { 
            selectedFile = fileChooser.getSelectedFile(); //file seleccionado
            
            if (selectedFile.length() !=0 && selectedFile.exists()){ //validar que exista y que contenga informacion
                System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath()); //PRueba
                JOptionPane.showMessageDialog(null, "Se requiere guardar los datos actualmente cargados en memoria","Alerta" ,JOptionPane.WARNING_MESSAGE);
             }else {JOptionPane.showMessageDialog(null, "El archivo seleccionado no existe, o esta vacio", "Alerta", JOptionPane.ERROR_MESSAGE);}
        }
        
    }
    
                    
    public static Map<String, List<String>> obtenerRelaciones() {
                    Map<String, List<String>> relaciones = new HashMap<>();

                    try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) { //leer el contenido linea por linea de SelectedFile
                        String linea;
                       boolean leerUsuarios= true; 
                       boolean leerRelaciones= false;
                       List<String> usuarios = new ArrayList<>(); //almacena los nombres de usuario leidos 

                        while ((linea = br.readLine()) != null) { //leer archivo hasta llegar al final 
                            if (linea.equals("relaciones")){ // Si se llega a la linea con indice de relaciones el programa comenzara a leer las relaciones de cada usuario 
                                leerUsuarios= false;
                                leerRelaciones=true;
                            }else if (leerUsuarios){ //si leer usuarios es true, se agrega el nombre de usuario a la lista usuarios
                                usuarios.add(linea.trim());
                            }else if (leerRelaciones){ //se divide la linea en partes usando "," . Si hay al menos dos partes significa que hay una relacion y se agrega al Map 
                                String [] partes= linea.split(",");
                                if (partes.length >=2){
                                    String usuario1=partes[0].trim();
                                    String usuario2=partes[1].trim();
                                    
                                    
                                    if (!relaciones.containsKey(usuario1)){
                                        relaciones.put(usuario1,new ArrayList<>());
                                    }
                                    if (!relaciones.containsKey(usuario2)){
                                        relaciones.put(usuario2,new ArrayList<>());
                                    }
                                    
                                    //en caso de ser bidireccionales las conexiones
                                    if (relaciones.get(usuario2).contains(usuario1)){
                                        relaciones.get(usuario1).add(usuario2);
                                        relaciones.get(usuario2).add(usuario1);
                                    }else{
                                        relaciones.get(usuario1).add(usuario2);
                                    }
                          
                                }
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    return relaciones;
                }

    public static List<String> obtenerUsuarios(Map<String, List<String>> relaciones) {
        List<String> usuarios = new ArrayList<>(relaciones.keySet());
        Collections.sort(usuarios); //ordenar alfabeticamente
        return usuarios;
    }


    public static int[][] crearmatrizAdyacencia(List<String> usuarios, Map<String, List<String>> relaciones) {
        int n = usuarios.size();
        int[][] matrizAdyacencia = new int[n][n];

        for (int i = 0; i < n; i++) {
            String usuario = usuarios.get(i);
            List<String> conexiones = relaciones.get(usuario);

            for (String conexion : conexiones) {
                int j = usuarios.indexOf(conexion);
                matrizAdyacencia[i][j]=1;
                if(!relaciones.get(conexion).contains(usuario)){
                    matrizAdyacencia[j][i]=0;
                }
            }
        }

        return matrizAdyacencia;
    }
    
    public int [][] getMatriz(){
        return matrizAdyacencia;
    }
    public List<String> getusuarios(){
        return usuarios;
    }
    
    
    public static StringBuilder mostrarmatrizAdyacencia(int[][] matrizAdyacencia, List<String> usuarios) {
            
        StringBuilder sb= new StringBuilder(); //crear instancia de Stringbuilder para almacenar el texto de la matriz 
            sb.append("  \t");
            for (String usuario : usuarios) { //iterar lista de usuarios
                sb.append(usuario).append(" \t"); //se agrega cada nombre de usuario al StringBuilder, seguido de un espacio y un tabulador.
            }
            sb.append("\n"); // Despues de agregar los usuarios en la primera fila, se agrega un salto de linea 

            for (int i = 0; i < matrizAdyacencia.length; i++) { //iterar en las filas de la matriz
                sb.append(usuarios.get(i)).append(" \t");
                for (int j = 0; j < matrizAdyacencia[i].length; j++) {
                    sb.append(matrizAdyacencia[i][j]).append(" \t"); //se agrega el valor de la matriz de adyacencia correspondiente a la fila y columna actual
                }
                sb.append("\n");
            }
        return sb;
        }
    }
    
    


            
    
    
    
    
    
    
    
    
    

            
    
    
    
    
    
    
    
    
    

            
    
    
    
    
    
    
    
    
    

            
    
    
    
    
    
    
    
    
    

            
    
    
    
    
    
    
    
    
    

            
    
    
    
    
    
    
    
    
    

            
    
    
    
    
    
    
    
    
    

            
    
    

