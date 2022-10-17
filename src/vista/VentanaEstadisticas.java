/*
    Archivo: VentanaEstadisticas.java
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
    CLASE: VentanaEstadisticas
    INTENCIÓN: Se mostrarán las estadísticas de las rondas jugadas por el jugador; rondas
    realizadas, mejor ronda, peor ronda, palabra más acertada. Toda esta información es
    recopilada a durante los juegos de cada jugador. Consiguiente el usuario podrá volver
    a la pantalla de inicio para iniciar un nuevo juego.
    RELACIONES:
    -Es una Ventana.
 */

package vista;

import logica.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaEstadisticas extends Ventana {
    // Atributos:
    private JPanel panelCabecera = new JPanel();
    private JPanel rejillaGeneral = new JPanel();
    private JPanel rejillaEstadisticas = new JPanel();
    private JPanel cabezaEstadisticas = new JPanel();
    private JPanel cuerpoEstadisticas = new JPanel();
    private JPanel cajaInferior = new JPanel();
    private JPanel cajaBoton = new JPanel();
    private JLabel labelTitulo = new JLabel("El Ahorcado");
    private JLabel labelSubtitulo = new JLabel("Universidad del Valle");
    private JButton buttonVolver = new JButton("Volver");
    private JLabel labelEstadisticas = new JLabel("Estadisticas");
    private JLabel labelRodasRealizadas = new JLabel("Rondas realizadas:");
    private JLabel labelMejorRonda = new JLabel("Mejor ronda:");
    private JLabel labelPeorRonda = new JLabel("Peor ronda:");
    private JLabel labelModaPalabra = new JLabel("Palabra más acertada:");
    
    // Constructor:
    public VentanaEstadisticas(){
        // Listeners:
        buttonVolver.addActionListener(this);
		
        // Configuración de páneles propios.
        northPanel.setPreferredSize(new Dimension(100, 90));
        northPanel.setBackground(new Color(79, 198, 198));
        panelCabecera.setLayout(new GridLayout(2, 1));
        panelCabecera.setBackground(new Color(0, 0, 0, 0));
        rejillaGeneral.setPreferredSize(new Dimension(150, 300));
        rejillaGeneral.setLayout(new GridLayout(2, 1));
        rejillaEstadisticas.setLayout(new GridLayout(2, 1));
        cajaInferior.setLayout(new GridLayout(2, 1));
        cuerpoEstadisticas.setLayout(new GridLayout(4, 1, 0, 10));
        
        // Añadidos de ventana inicial. 
        labelEstadisticas.setFont(new Font("Arial", Font.BOLD, 20));
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 34));
        labelTitulo.setHorizontalAlignment(JLabel.CENTER);
        labelSubtitulo.setFont(new Font("Arial", Font.BOLD, 16));
        labelSubtitulo.setHorizontalAlignment(JLabel.CENTER);
        labelEstadisticas.setHorizontalAlignment(JLabel.CENTER);
        panelCabecera.add(labelTitulo);
        panelCabecera.add(labelSubtitulo);
        northPanel.add(panelCabecera);
        cabezaEstadisticas.add(labelEstadisticas);
        cuerpoEstadisticas.add(labelRodasRealizadas);
        cuerpoEstadisticas.add(labelMejorRonda);
        cuerpoEstadisticas.add(labelPeorRonda);
        cuerpoEstadisticas.add(labelModaPalabra);
        rejillaEstadisticas.add(cabezaEstadisticas);
        rejillaEstadisticas.add(cuerpoEstadisticas);
        rejillaGeneral.add(rejillaEstadisticas);
        cajaBoton.add(buttonVolver);
        cajaInferior.add(new JPanel());
        cajaInferior.add(cajaBoton);
        rejillaGeneral.add(cajaInferior);
        centerPanel.add(rejillaGeneral);

        // Mostrar Pantalla Inicial.
        setVisible(true);
    }   

    @Override
    public void actionPerformed(ActionEvent evento){
        if (evento.getSource() == buttonVolver){
            dispose();
            VentanaInicio ventana = new VentanaInicio(); 
        }
    }
}