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
import java.util.*;
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
    private JLabel labelSprites;
    private ImageIcon ahorcadoSprites;
    private JLabel lineasPalabra;
    private JButton abecedario[] = new JButton[27];
    private JButton buttonSalir = new JButton("Salir");

    // Palabras a adivinar (CAMBIAR PARA USO CON Juego.java)
    private String palabraAdivinar = "Manzana"; // 7 letras.
    String listaLetrasValidas[] = palabraAdivinar.toLowerCase().split("");
    int spriteContador = 2;

    
	// Constructor:
	public VentanaJuego() {
        // Listeners:
        buttonSalir.addActionListener(this);
		
        // Configuración de páneles propios.
        rejillaGeneral.setPreferredSize(new Dimension(776, 385));
        centerPanel.setBackground(new Color(0, 0, 0, 0));
        rejillaGeneral.setBackground(new Color(0, 0, 0, 0));
        cajaButton.setBackground(new Color(0, 0, 0, 0));
        interaccionJugador.setBackground(new Color(0, 0, 0, 0));
        rejillaEstadisticas.setLayout(new GridLayout(3, 1));
        rejillaGeneral.setLayout(new GridLayout(1, 2));
        rejillaAbecedario.setLayout(new GridLayout(3, 9, 3, 3));
        interaccionJugador.setLayout(new GridLayout(4, 1, 0, 20));

        // Creación del abecedario con ASCII.
        int ubicacionLetra = 0;
        for(int asciiLetra = 97; asciiLetra <= 122; asciiLetra++) {
            char letra = (char) asciiLetra;
            abecedario[ubicacionLetra] = new JButton(String.valueOf(letra));
            rejillaAbecedario.add(abecedario[ubicacionLetra]);
            abecedario[ubicacionLetra].addActionListener(this);
            abecedario[ubicacionLetra].setMargin(new Insets(0, 0, 0, 0));
            if(asciiLetra == 110) { // Manipulación de letra «ñ»
                abecedario[ubicacionLetra + 1] = new JButton("ñ");
                rejillaAbecedario.add(abecedario[ubicacionLetra + 1]);
                abecedario[ubicacionLetra + 1].addActionListener(this);
                abecedario[ubicacionLetra + 1].setMargin(new Insets(0, 0, 0, 0));
                ubicacionLetra++;
            }
            ubicacionLetra++;
        }

        // Carga de sprites.
        try {
            ahorcadoSprites = new ImageIcon(getClass().getResource("AhorcadoSprites/1.png"));
            labelSprites = new JLabel(ahorcadoSprites);
            graficaAhorcado.add(labelSprites);
        } catch (Exception e) {
            System.out.println("La imagen no pudo ser encontrada.");
        }

        // Visualización de líneas de cada letra.
        StringBuilder letrasPalabraAdivinar = new StringBuilder();
        for(int contadorLetra = 0; contadorLetra < palabraAdivinar.length(); contadorLetra++) {
            if(contadorLetra == palabraAdivinar.length() - 1) {
                letrasPalabraAdivinar.append("___");
            } else {
                letrasPalabraAdivinar.append("___ ");
            }
        }
        lineasPalabra = new JLabel(String.valueOf(letrasPalabraAdivinar));

        // Añadidos de ventana inicial. 
        lineasPalabra.setFont(new Font("Arial", Font.BOLD, 16));
        lineasPalabra.setHorizontalAlignment(JLabel.CENTER);
        cajaButton.add(buttonSalir);
        rejillaEstadisticas.add(intentosTotales);
        rejillaEstadisticas.add(intentosRestantes);
        rejillaEstadisticas.add(intentosEjecutados);
        interaccionJugador.add(rejillaEstadisticas);
        interaccionJugador.add(lineasPalabra);
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
            dispose();
            VentanaInicio ventanaInicio = new VentanaInicio();
        } else if (evento.getSource() != null) {
            for (int busquedaBoton = 0; busquedaBoton < 27; busquedaBoton++) {
                // Se obtiene el texto de la letra presionada.
                if (evento.getSource() == abecedario[busquedaBoton]){
                    System.out.println(abecedario[busquedaBoton].getText());
                    // Validación de letra en palabra.
                    if(Arrays.asList(listaLetrasValidas).contains(abecedario[busquedaBoton].getText())) {
                        abecedario[busquedaBoton].setBackground(Color.GREEN);              
                    } else if (!Arrays.asList(listaLetrasValidas).contains(abecedario[busquedaBoton].getText()) && spriteContador <= 10) {
                        abecedario[busquedaBoton].setBackground(Color.RED);
                        ahorcadoSprites = new ImageIcon(getClass().getResource("AhorcadoSprites/"+ spriteContador++ +".png"));
                        labelSprites.setIcon(ahorcadoSprites);
                    } else {
                        abecedario[busquedaBoton].setBackground(Color.RED);
                    }
                }
            }
        }
    }
}