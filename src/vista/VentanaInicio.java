/*
Archivo: VentanaInicio.java

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
import java.util.HashSet;
import javax.swing.*;


public class VentanaInicio extends Ventana {
    // Atributos:
    private JPanel panelSuperior;
    private JPanel panelContenido;
    private JLabel labelTitulo;
    private JLabel labelSubtitulo;
    private JLabel labelNombre;
    private JTextField textNombre;
    private JButton botonJugar;
    private JButton botonInstrucciones;
    private JButton botonParaQueSirve;
    
    
    // Métodos:
    public VentanaInicio(){
        iniciarComponentes();
    }
    
    @Override
    protected void iniciarComponentes(){
        
        super.iniciarComponentes();
        
        panelSuperior = new JPanel();
        panelSuperior.setBackground(new Color(226, 201, 99));
        panelSuperior.setPreferredSize(new Dimension(100, 90));
        panelSuperior.setLayout(new GridLayout(4, 1));
        
        panelContenido = new JPanel();
        panelContenido.setBackground(Color.LIGHT_GRAY);
        panelContenido.setLayout(null);
        
        ventana.add(panelSuperior, BorderLayout.NORTH);
        ventana.add(panelContenido, BorderLayout.CENTER);

        
        labelTitulo = new JLabel("El Ahorcado", SwingConstants.CENTER);
        labelTitulo.setForeground(new Color(20, 7, 7));
        labelTitulo.setFont(new Font("Monospaced", Font.BOLD, 50));
        
        labelSubtitulo = new JLabel("Universidad del Valle", SwingConstants.CENTER);
        labelSubtitulo.setForeground(new Color(20, 7, 7));
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 30));
        
        panelSuperior.add(new JLabel(""));
        panelSuperior.add(labelTitulo);
        panelSuperior.add(labelSubtitulo);
        panelSuperior.add(new JLabel(""));

        labelNombre = new JLabel("Ingrese su nombre: ", SwingConstants.LEFT);
        labelNombre.setForeground(new Color(0, 0, 0)); //0,88,176
        labelNombre.setFont(new Font("Arial", Font.BOLD, 22));
        labelNombre.setBounds(270, 20, 240, 100);
        
        textNombre = new JTextField("");
        textNombre.setHorizontalAlignment(JTextField.CENTER);
        textNombre.setForeground(Color.BLACK);
        textNombre.setFont(new Font("Arial", Font.BOLD, 20));
        textNombre.setBounds(210, 100, 330, 40);
        
        botonJugar = new JButton("JUGAR");
        botonJugar.setBounds(280, 160, 200, 50);
        
        botonInstrucciones = new JButton("INSTRUCCIONES");
        botonInstrucciones.setBounds(280, 220, 200, 50);
        
        botonParaQueSirve= new JButton("¿PARA QUÉ SIRVE?");
        botonParaQueSirve.setBounds(280, 280, 200, 50);
        
        panelContenido.add(labelNombre);
        panelContenido.add(textNombre);
        panelContenido.add(botonJugar);
        panelContenido.add(botonInstrucciones);
        panelContenido.add(botonParaQueSirve);
        
        
        
        
    }
}
