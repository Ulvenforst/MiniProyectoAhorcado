/*
Archivo: Ventana.java
Fundamentos de Programación Orientada a Eventos - 750014C Grupo 01
Proyecto 1 - El ahorcado

Autores: 
Juan Camilo Narvaez Tascon - juan.narvaez.tascon@correounivalle.edu.co - 2140112-3743
Christian David Vargas Gutiérrez - vargas.christian@correounivalle.edu.co - 2179172-3743

Profesor:
Ing. M.Sc. Luis Yovany Romo Portilla

Licencia: GNU-GPL
*/

/**
  CLASE: Ventana
  INTENCIÓN: Esta clase definirá los valores iniciales de todas las ventanas hijas.
  RELACIONES: -por definir-
*/

package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Ventana extends JFrame {
    
    public Ventana(){
        iniciarComponentes();
    }
    
    protected void iniciarComponentes(){
        setVisible(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850,480);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle("El Ahorcado - Universidad del Valle");
    }
}
