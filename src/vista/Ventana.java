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

import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame{
    // Páneles distributivos:
    protected JPanel centerPanel = new JPanel(); 
    protected JPanel northPanel = new JPanel(); 
    protected JPanel eastPanel = new JPanel(); 
    protected JPanel westPanel = new JPanel(); 
    protected JPanel southPanel = new JPanel(); 

    public Ventana(){
        setTitle("El Ahorcado - Universidad del Valle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850,480);
        setResizable(false);
        setLocationRelativeTo(null);

        // Distribución de páneles:
        centerPanel.setBackground(Color.GRAY);
        northPanel.setBackground(Color.GRAY);
        eastPanel.setBackground(Color.GRAY);
        westPanel.setBackground(Color.GRAY);
        southPanel.setBackground(Color.GRAY);
        setLayout(new BorderLayout(15, 15));
        add(centerPanel, BorderLayout.CENTER);
        add(northPanel, BorderLayout.NORTH);
        add(eastPanel, BorderLayout.EAST);
        add(westPanel, BorderLayout.WEST);
        add(southPanel, BorderLayout.SOUTH);
    }
}
