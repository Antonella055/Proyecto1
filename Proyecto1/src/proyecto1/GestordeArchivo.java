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
    public static File selectedFile; 
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

                    try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                        String linea;
                       boolean leerUsuarios= true;
                       boolean leerRelaciones= false;
                       List<String> usuarios = new ArrayList<>();

                        while ((linea = br.readLine()) != null) {
                            if (linea.equals("relaciones")){
                                leerUsuarios= false;
                                leerRelaciones=true;
                            }else if (leerUsuarios){
                                usuarios.add(linea.trim());
                            }else if (leerRelaciones){
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
                                    
                                    relaciones.get(usuario1).add(usuario2);
                                    relaciones.get(usuario2).add(usuario1);
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
        Collections.sort(usuarios); //ordenar alf
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
                matrizAdyacencia[i][j] = 1;
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
    
    
    public static void mostrarmatrizAdyacencia(int[][] matrizAdyacencia, List<String> usuarios) {
        System.out.print("  \t");
        for (String usuario : usuarios) {
            System.out.print(usuario + " \t");
        }
        System.out.println();

        for (int i = 0; i < matrizAdyacencia.length; i++) {
            System.out.print(usuarios.get(i) + " \t");
            for (int j = 0; j < matrizAdyacencia[i].length; j++) {
                System.out.print(matrizAdyacencia[i][j] + " \t");
            }
            System.out.println();
        }
    }
    
    }


            
    
    
    
    
    
    
    
    
    

            
    
    
    
    
    
    
    
    
    

            
    
    
    
    
    
    
    
    
    

            
    
    
    
    
    
    
    
    
    

            
    
    
    
    
    
    
    
    
    

            
    
    
    
    
    
    
    
    
    

            
    
    
    
    
    
    
    
    
    

            
    
    

