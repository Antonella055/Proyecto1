/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package borrararchivojava;

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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Borrararchivojava{   
    static void modifyFile(String file, String lineToRemove)
      {

    try {

      File inFile = new File(file);

      if (!inFile.isFile()) {
        System.out.println("Parameter is not an existing file");
        return;
      }

      //Construct the new file that will later be renamed to the original filename.
      File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

      BufferedReader br = new BufferedReader(new FileReader(file));
      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

      String line = null;

      //Read from the original file and write to the new
      //unless content matches data to be removed.
      while ((line = br.readLine()) != null) {

        if (!line.trim().contains(lineToRemove)) {

          pw.println(line);
          pw.flush();
        }
      }
      pw.close();
      br.close();

      //Delete the original file
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
     
    public static void main(String[] args)
    {
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

String eliminar = (String)JOptionPane.showInputDialog(
                    "Ingrese el usuario a eliminar");
                    

   String arc =  chooser.getSelectedFile().toString();

      modifyFile(arc, eliminar);
        
//Oldstring es la string que será reemplazada, new string será el reemplazo.
        System.out.println("done");
    }
}