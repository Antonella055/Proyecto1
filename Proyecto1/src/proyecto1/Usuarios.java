/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;



/**
 *
 * @author luciano
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Usuarios{
    public static String ObtenerNombre(String mensaje){
        String usuario = (String)JOptionPane.showInputDialog(
                    mensaje);
        return usuario;
    
}
    public static boolean validador(String file, String nombre) throws FileNotFoundException, IOException{
        String line = null;
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((line = br.readLine()) != null) {

        if (line.trim().equals(nombre)) {
            System.out.println("El usuario existe");
            br.close();
            return true;
        }
      }
        br.close();
        return false;
       
    }
    public static JFileChooser obtenerArchivo(){
        JFileChooser chooser = new JFileChooser();
chooser.setCurrentDirectory(new java.io.File("."));
chooser.setDialogTitle("Seleccione un archivo txt");
chooser.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
chooser.setAcceptAllFileFilterUsed(false);

if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
  
  System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
} else {
  System.out.println("No hay selección ");
  
}
        return chooser;
        
    }
    
    static void AñadirUser(String file, String user, String relacion) throws IOException{
        Path path = Paths.get(file);
List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

int position = 3/2;
String extraLine = user;  

lines.add(position, extraLine);
Files.write(path, lines, StandardCharsets.UTF_8);

        //Añadir las relaciones (Falta autentificar)
BufferedWriter output = new BufferedWriter(new FileWriter(file, true));  //clears file every time

output.append(relacion);

output.close();
     
    }
    static void EliminarUsuario(String file, String lineToRemove)
      {

    try {

      File inFile = new File(file);

      if (!inFile.isFile()) {
        System.out.println("Parametero no es un archivo existente");
        return;
      }

      File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

      BufferedReader br = new BufferedReader(new FileReader(file));
      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

      String line = null;

      
      while ((line = br.readLine()) != null) {

        if (!line.contains(lineToRemove)) {

          pw.println(line);
          pw.flush();
        }
      }
      pw.close();
      br.close();

      if (!inFile.delete()) {
        System.out.println("No se pudo borrar el archivo");
        return;
      }

      if (!tempFile.renameTo(inFile))
        System.out.println("No se pudo renombrar el archivo");

    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
    // Acá se encuentran los archivos que utiliza el usuario para los inputs. Los de arriba son mayoritariamente para ejecutar el código
  }
    public static void InputEliminacionUser() throws IOException{
        String arc = obtenerArchivo().getSelectedFile().toString();
                System.out.print(arc);
                String user = ObtenerNombre("Por favor ingrese el nombre del usuario");
                if(validador(arc,user)){
                    EliminarUsuario(arc, user);
                }
                
                
        
    }
    public static void InputAñadirUser() throws IOException{
        String arc = obtenerArchivo().getSelectedFile().toString();
        System.out.print(arc);
        String user = ObtenerNombre("Por favor ingrese el nombre del usuario");
                
        String relacion = ObtenerNombre("Por favor ingrese las relaciones del usuario");
        
        AñadirUser(arc,user, relacion);
        
    }
            
            public static void main(String[] args) throws IOException 
            {
                InputEliminacionUser();
                
            }
        }

        


