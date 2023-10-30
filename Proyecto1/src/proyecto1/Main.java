/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;


import interfaces.CargarArchivo;
import java.io.FileNotFoundException;
import javax.swing.JFrame;


//Main
/**
 *
 * @author Antonella
 */

public class Main {
    public static void main (String[] args) throws FileNotFoundException, Exception{
        
        CargarArchivo carga= new CargarArchivo(); //Ventana Para cargar Archivo
        carga.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        carga.setVisible(true);
        }
    }
   
