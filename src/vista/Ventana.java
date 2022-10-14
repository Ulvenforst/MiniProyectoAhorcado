/*
Archivo: Ventana.java

Proyecto 1 - El ahorcado

Autores: 
Juan Camilo Narvaez Tascon - juan.narvaez.tascon@correounivalle.edu.co - 
Christian David Vargas Gutiérrez - vargas.christian@correounivalle.edu.co - 2179172-3743

Fundamentos de Programación Orientada a Eventos - 750014C Grupo 01

Profesor:
Ing. M.Sc. Luis Yovany Romo Portilla

Licencia: GNU-GPL
*/

package vista;

import java.awt.*;
import javax.swing.*;


public class Ventana extends JFrame {
    
    protected JFrame ventana; 
        
    protected void iniciarComponentes(){
        ventana = new JFrame();
        ventana.setTitle("El Ahorcado - Universidad del Valle");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(750,500);
        ventana.setLayout(new BorderLayout());
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true); 
//        ventana.setResizable(false);       
    }
}
