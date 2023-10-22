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
import java.util.ArrayList;
import java.util.List;


public class Usuarios{
    
    
    public static void ObtenerNombre(String []args){
        File archivo= GestordeArchivo.selectedFile;
        
    }
    
    
    public static void  EliminarUsuario (String file,String lineToRemove) throws FileNotFoundException, IOException{   
        String nombreusuario= ObtenerNombre();
        List <String>aux= new ArrayList<>();
        
        try BufferedReader br = new BufferedReader(new FileReader(file));
            String linea; 
        
              PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

              

             
              while ((line = br.readLine()) != null) {

                if (!line.contains(lineToRemove)) {

                  pw.println(line);
                  pw.flush();
                }
              }
              pw.close();
              br.close();

           
              if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
              }

              //Rename the new file to the filename the original file had.
              if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");

            }
            catch (FileNotFoundException ex) {
              ex.printStackTrace();
            }
            catch (IOException ex) {
              ex.printStackTrace();
            }
          }

            public static void main(String[] args) throws IOException
            {
                EliminarUsuario("/home/luciano/Desktop/Universidad/4to trimestre/Java/muestra.txt", "@cipriano");
                 //Oldstring es la string que será reemplazada, new string será el reemplazo.
                System.out.println("done");
            }
        }

        


