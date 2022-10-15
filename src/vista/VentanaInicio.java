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

import logica.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class VentanaInicio extends Ventana {
    // Atributos:
    private JPanel panelSuperior;
    private JPanel panelContenido;
    
    private JLabel labelTitulo;
    private JLabel labelSubtitulo;
    private JLabel labelNombre;
    
    private JTextField textoNombre;
    
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
        
        textoNombre = new JTextField("");
        textoNombre.setHorizontalAlignment(JTextField.CENTER);
        textoNombre.setForeground(Color.BLACK);
        textoNombre.setFont(new Font("Arial", Font.BOLD, 20));
        textoNombre.setBounds(210, 100, 330, 40);
        
        botonJugar = new JButton("JUGAR");
        botonJugar.setBounds(280, 160, 200, 50);
        botonJugar.addActionListener(this);
        
        botonInstrucciones = new JButton("INSTRUCCIONES");
        botonInstrucciones.setBounds(280, 220, 200, 50);
        botonInstrucciones.addActionListener(this);
        
        botonParaQueSirve= new JButton("¿PARA QUÉ SIRVE?");
        botonParaQueSirve.setBounds(280, 280, 200, 50);
        botonParaQueSirve.addActionListener(this);
        
        panelContenido.add(labelNombre);
        panelContenido.add(textoNombre);
        panelContenido.add(botonJugar);
        panelContenido.add(botonInstrucciones);
        panelContenido.add(botonParaQueSirve);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento){
        if (evento.getSource() == botonJugar)
            iniciarJuego();
        
    }
    
    public void iniciarJuego(){
        String nombreJugador = textoNombre.getText();
        
        if(!nombreJugador.trim().isEmpty() || nombreJugador.trim().length() > 0){
            Jugador jugador = new Jugador(nombreJugador);
            Juego juego = new Juego(jugador);
            ventana.dispose(); 
            VentanaTematicas ventanaTematicas = new VentanaTematicas(juego);
            
        } else {
            JOptionPane.showMessageDialog(null,"Por favor ingrese su nombre", "Advertencia", JOptionPane.ERROR_MESSAGE);
            textoNombre.requestFocusInWindow();
        }
    }
}
