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


public class GestionUsers{
    public static String ObtenerNombre(String mensaje){
        String usuario = (String)JOptionPane.showInputDialog(
                    mensaje);
        return usuario;
    
}
    public static boolean ValidadorRelaciones(String file, String[] Verificar) throws IOException{
        int counter = 0;
        if(validador(file, Verificar[0])){
            counter = counter + 1;
        }
        if(validador(file, Verificar[1])){
            counter = counter + 1;
        }
        
        if(counter == 2){
            return true;
        }

        return false;
    }
    public static boolean validador(String file, String nombre) throws FileNotFoundException, IOException{
        String line = null;
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((line = br.readLine()) != null) {

        if (line.trim().equals(nombre)) {
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
  
  
} else {
   JOptionPane.showMessageDialog(null, "No hay selección", "Alerta", JOptionPane.ERROR_MESSAGE);
   System.exit(0);
  
  
}
        return chooser;
        
    }
    
    static void AñadirUser(String file, String user) throws IOException{
        Path path = Paths.get(file);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        int position = 3/2;
        String extraLine = user;  

        lines.add(position, extraLine);
        Files.write(path, lines, StandardCharsets.UTF_8);


        //Añadir las relaciones 

        while(true){
         BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
          String relacion = ObtenerNombre("Por favor ingrese las relaciones del usuario (Escriba 'end' para salir)");
          if(relacion.equals("end")){
          break;
    
}
        else if(relacion.contains(",") && relacion.split(",").length== 2 && ValidadorRelaciones(file, relacion.split(",")) ){
        output.append(relacion);
        output.newLine();
        output.close();
}
        else{
             JOptionPane.showMessageDialog(null, "Invalido, ponga una relacion con usuarios que existan", "Alerta", JOptionPane.ERROR_MESSAGE);
}
          output.close();
          
        }JOptionPane.showMessageDialog(null, "El Usuario fue añadido existosamente", "Operación existosa", JOptionPane.INFORMATION_MESSAGE);
        
    }
    static void EliminarUsuario(String file, String lineToRemove)
      {

    try {

      File inFile = new File(file);

      if (!inFile.isFile()) {
        JOptionPane.showMessageDialog(null, "El archivo seleccionado no existe, o esta vacio", "Alerta", JOptionPane.ERROR_MESSAGE);
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
      JOptionPane.showMessageDialog(null, "El Usuario fue eliminado existosamente", "Operación existosa", JOptionPane.INFORMATION_MESSAGE);

      pw.close();
      br.close();

      if (!inFile.delete()) {
        JOptionPane.showMessageDialog(null, "No se pudo borrar el archivo", "Alerta", JOptionPane.ERROR_MESSAGE);
        return;
      }

      if (!tempFile.renameTo(inFile))
        JOptionPane.showMessageDialog(null, "No se pudo renombrar el archivo", "Alerta", JOptionPane.ERROR_MESSAGE);

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
                }else{
                            JOptionPane.showMessageDialog(null, "ERROR: El usuario no fue encontrado, por favor ingrese un usuario que exista", "Alerta", JOptionPane.ERROR_MESSAGE);
                }
                
                
        
    }
    public static void InputAñadirUser() throws IOException{
        String arc = obtenerArchivo().getSelectedFile().toString();
        System.out.print(arc);
        String user = ObtenerNombre("Por favor ingrese el nombre del usuario"); 
        if(!validador(arc,user)){ //Verifica que el usuario a agregar no existe dentro del archivo para evitar duplicados
            AñadirUser(arc,user);
                }else{
                            JOptionPane.showMessageDialog(null, "ERROR: El usuario existe, por favor ingrese un usuario que no exista", "Alerta", JOptionPane.ERROR_MESSAGE);
                }
                
                
        
        
    }
            
            public static void main(String[] args) throws IOException 
            {
                InputAñadirUser();
                
            }
        }

        


