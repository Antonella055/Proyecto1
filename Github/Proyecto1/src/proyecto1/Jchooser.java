/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1;

//
//import java.awt.BorderLayout;
//import java.awt.Desktop;
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//import javax.swing.JFileChooser;
//import javax.swing.filechooser.FileNameExtensionFilter;
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//
//import javax.swing.JTextArea;
///**
// *
// * @author Antonella
// */
//
//public class Jchooser {
//    /**
//     * @param args the command line arguments
//     * @throws java.io.FileNotFoundException
//     */
//   
////    public static void main(String[] args) throws FileNotFoundException, IOException {
////        JFileChooser fileChooser = new JFileChooser(); //crear un JFilechooser --> JFileChooser nos permite abrir un cuadro de diálogo donde el usuario puede elegir un fichero a través del explorador de archivos de su equipo.
////        JTextArea text = new JTextArea(); // JTextArea permite ingresar múltiples líneas, a diferencia del control de tipo JTextField.
////        text.setEditable(false); //el usuario no tiene permitido editar el contenido
////        
////        fileChooser.setCurrentDirectory(new File("C:/PROYECTO")); //abrir una carpeta predeterminada
////        
////        // Filtrar solo archivos de texto 
////        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt", "txt");
////        fileChooser.setFileFilter(filter);
////        
////        // llamada a  el cuadro de diálogo de selección de archivo
////        int returnValue = fileChooser.showOpenDialog(null);
////        
////        if (returnValue == JFileChooser.APPROVE_OPTION) { //SI el usuario elige el boton abrir(previsualizacion)
////            File selectedFile = fileChooser.getSelectedFile(); //file seleccionado
////            System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath()); //PRueba
////
////            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) { //lee el contenido del archivo 
////                StringBuilder sb = new StringBuilder(); //'sb' almacena  el contenido del archivo
////                String line; //variable 'line'
////                while ((line = reader.readLine()) != null) {
////                    sb.append(line).append("\n"); // lee todas las lineas del archivo (agrega a v.line la linea leida) hasta llegar a la null donde se detiene el bucle 
////                     //text.setText() es un método que se utiliza para establecer el texto de un elemento de interfaz de usuario
////                    text.setText(sb.toString()); //muestra el contenido de una cadena generada por un objeto StringBuilder en un elemento de interfaz de usuario
////
////                }
////            
////                    //Interface de la previsualizacion
////                    // Crear un botón "Abrir"
////                    JButton openButton = new JButton("Abrir");                     //new ActionListener() { } crea una instancia anónima de la interfaz ActionListener y define el comportamiento que se ejecutará cuando se produzca un evento de acción en el botón. El código 
////                    openButton.addActionListener(new ActionListener() {            //dentro de las llaves {} define la lógica de la acción a realizar.
////                        @Override  //                                                                     //Override se utiliza para indicar que un método en una clase hija está anulando correctamente un método de la clase padre
////                        public void actionPerformed(ActionEvent e) {                    //Metodo 
////                            try {
////                                Desktop.getDesktop().open(selectedFile);           //(accion)abre el archivo seleccionado 
////                            } catch (IOException ex) {
////                                ex.printStackTrace();
////                            }
////                        }
////                    });
////
////                    // Crear un botón "Cerrar"
////                    JButton closeButton = new JButton("Cerrar");
////                    closeButton.addActionListener(new ActionListener() {
////                      //  @Override
////                    //    public void actionPerformed(ActionEvent e) {
////   //                         System.exit(0);
////
////                        }
////                    });
////
////
////                    // Panel con la previsualizacion
////                    JPanel panel = new JPanel();
////                    panel.setLayout(new BorderLayout()); //configuracion del diseno
////                    JPanel buttonPanel = new JPanel();
////                    buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Alineación horizontal a la izquierda
////
////                    buttonPanel.add(openButton); // botón "Abrir"
////                    buttonPanel.add(closeButton); // botón "Cerrar"
////
////                    panel.add(new JScrollPane(text), BorderLayout.CENTER); // JcroolPane permite que el texto dentro de text sea desplazable si el contenido es demasiado grande para ajustarse en el área visible.
////                    panel.add(buttonPanel, BorderLayout.SOUTH); // panel de botones en la parte inferior
////
////                    // marco para  el panel
////                    JFrame frame = new JFrame();
////                    frame.add(panel);
//                    frame.pack();
//                    frame.setVisible(true);
//
//
//            } catch (IOException ex) {
//               ex.printStackTrace();
//
//            }
//        } else {
//            System.out.println("No se seleccionó ningún archivo.");
//        }
//    }
//}
//
//            
    
    
    
    
    
    
    
    
    

            
    
    
    
    
    
    
    
    
    

            
    
    
    
    
    
    
    
    
    

            
    
    
    
    
    
    
    
    
    

            
    
    
    
    
    
    
    
    
    

            
    
    
    
    
    
    
    
    
    

            
    
    
    
    
    
    
    
    
    

            
    
    

