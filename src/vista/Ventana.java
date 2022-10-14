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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ventana extends JFrame {

    
    public Ventana(){
        iniciarComponentes();
    }
    
    protected void iniciarComponentes(){

        setTitle("El Ahorcado - Universidad del Valle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850,480);
        setLocationRelativeTo(null);
        setVisible(true); 
        setResizable(false);
        setLayout(null);             
    }

    
}
