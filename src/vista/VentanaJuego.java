/*
    Archivo: VentanaJuego.java
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
    CLASE: VentanaJuego
    INTENCIÓN: Esta ventana muestra el juego: las palabra a divinar y las letras que hayan
    sido usadas, también brinda información de las rondas que quedan, y las que ha jugado
    dando una idea de los intentos restantes, todo esto con base en la información suministrada
    en VentanaTematicas. La información recolectada del estado de juego se asocia a un jugador.
    RELACIONES:
    -Es una Ventana.
 */

package vista;

import logica.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaJuego extends Ventana {
    // Atributos:
    private JPanel rejillaGeneral = new JPanel();
    private JPanel graficaAhorcado = new JPanel();
    private JPanel interaccionJugador = new JPanel();
    private JPanel rejillaEstadisticas = new JPanel();
    private JPanel rejillaAbecedario = new JPanel();
    private JPanel cajaButton = new JPanel();

	private JLabel intentosTotales = new JLabel("Intentos Totales:");
	private JLabel intentosRestantes = new JLabel("Intentos Restantes:");
	private JLabel intentosEjecutados = new JLabel("Intentos Ejecutados:");

    // CAMBIAR LÍNEA DE CÓDIGO!!
    private JTextField palabraAdivinar = new JTextField();
    private JButton abecedario[] = new JButton[27];
    private JButton buttonSalir = new JButton("Salir");
    
	// Constructor:
	public VentanaJuego() {
        // Listeners:
        buttonSalir.addActionListener(this);
		
        // Configuración de páneles propios.
        rejillaGeneral.setPreferredSize(new Dimension(776, 385));
        centerPanel.setBackground(Color.GRAY);
        rejillaGeneral.setBackground(Color.BLUE);
        cajaButton.setBackground(Color.yellow);
        interaccionJugador.setBackground(Color.RED);
        graficaAhorcado.setBackground(Color.orange);
        rejillaEstadisticas.setLayout(new GridLayout(3, 1));
        rejillaGeneral.setLayout(new GridLayout(1, 2));
        rejillaAbecedario.setLayout(new GridLayout(3, 9, 2, 2));
        interaccionJugador.setLayout(new GridLayout(4, 1, 0, 20));
        interaccionJugador.setPreferredSize(new Dimension(500, rejillaGeneral.getHeight()));

        // Creación del abecedario con ASCII.
        int ubicacionLetra = 0;
        for(int asciiLetra = 97; asciiLetra <= 122; asciiLetra++) {
            char letra = (char) asciiLetra;
            abecedario[ubicacionLetra] = new JButton(String.valueOf(letra));
            rejillaAbecedario.add(abecedario[ubicacionLetra]);
            
            if(asciiLetra == 110) {
                abecedario[ubicacionLetra + 1] = new JButton("ñ");
                rejillaAbecedario.add(abecedario[ubicacionLetra + 1]);
            }
        }

        // Añadidos de ventana inicial. 
        cajaButton.add(buttonSalir);
        rejillaEstadisticas.add(intentosTotales);
        rejillaEstadisticas.add(intentosRestantes);
        rejillaEstadisticas.add(intentosEjecutados);
        interaccionJugador.add(rejillaEstadisticas);
        interaccionJugador.add(palabraAdivinar);
        interaccionJugador.add(rejillaAbecedario);
        interaccionJugador.add(cajaButton);
        rejillaGeneral.add(interaccionJugador);
        rejillaGeneral.add(graficaAhorcado);
        centerPanel.add(rejillaGeneral);
		
		// Mostrar Pantalla Inicial.
        setVisible(true);
	}

    // Métodos
    @Override
    public void actionPerformed(ActionEvent evento){
        if (evento.getSource() == buttonSalir){

        }
    }
}