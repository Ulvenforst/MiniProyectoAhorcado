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
    private Juego juego;
    private Jugador jugador;
    private JPanel panelRejillaGeneral = new JPanel();
    private JPanel panelGraficaAhorcado = new JPanel();
    private JPanel panelInteraccionJugador = new JPanel();
    private JPanel panelRejillaEstadisticas = new JPanel();
    private JPanel panelRejillaAbecedario = new JPanel();
    private JPanel panelBoton = new JPanel();
    private JLabel labelItentosTotales = new JLabel("Intentos Totales:");
    private JLabel labelIntentosRestantes = new JLabel("Intentos Restantes:");
    private JLabel labelIntentosEjecutados = new JLabel("Intentos Ejecutados:");
    private JLabel labelSprites;
    private ImageIcon ahorcadoSprites;
    private JLabel labelLineasPalabra;
    private JButton[] buttonAbecedario = new JButton[27];
    private JButton buttonSalir = new JButton("Salir");

    // Palabras a adivinar (CAMBIAR PARA USO CON Juego.java)
    private String palabraAdivinar = "Zanahoria"; // 7 letras.
    private String listaLetrasValidas[] = palabraAdivinar.toLowerCase().split("");
    private String lineas = new String();
    private String lineasLetrasValidas[] = new String[palabraAdivinar.length()];
    private int spriteContador = 2;

    
    // Constructor:
    public VentanaJuego(Juego juego, Jugador jugador){
        this.juego = juego;
        this.jugador = jugador;
        // Listeners:
        buttonSalir.addActionListener(this);
		
        // Configuración de páneles propios.
        panelRejillaGeneral.setPreferredSize(new Dimension(776, 385));
        panelRejillaEstadisticas.setLayout(new GridLayout(3, 1));
        panelRejillaGeneral.setLayout(new GridLayout(1, 2));
        panelRejillaAbecedario.setLayout(new GridLayout(3, 9, 3, 3));
        panelInteraccionJugador.setLayout(new GridLayout(4, 1, 0, 20));

        // Creación del abecedario con ASCII.
        int ubicacionLetra = 0;
        for(int asciiLetra = 97; asciiLetra <= 122; asciiLetra++) {
            char letra = (char) asciiLetra;
            buttonAbecedario[ubicacionLetra] = new JButton(String.valueOf(letra));
            panelRejillaAbecedario.add(buttonAbecedario[ubicacionLetra]);
            buttonAbecedario[ubicacionLetra].addActionListener(this);
            buttonAbecedario[ubicacionLetra].setMargin(new Insets(0, 0, 0, 0));
            if(asciiLetra == 110) { // Manipulación de letra «ñ»
                buttonAbecedario[ubicacionLetra + 1] = new JButton("ñ");
                panelRejillaAbecedario.add(buttonAbecedario[ubicacionLetra + 1]);
                buttonAbecedario[ubicacionLetra + 1].addActionListener(this);
                buttonAbecedario[ubicacionLetra + 1].setMargin(new Insets(0, 0, 0, 0));
                ubicacionLetra++;
            }
            ubicacionLetra++;
        }

        // Carga de sprites.
        try {
            ahorcadoSprites = new ImageIcon(getClass().getResource("AhorcadoSprites/1.png"));
            labelSprites = new JLabel(ahorcadoSprites);
            panelGraficaAhorcado.add(labelSprites);
        } catch (Exception e) {
            System.out.println("La imagen no pudo ser encontrada.");
        }

        // Visualización de líneas de cada letra.
        for(int contadorLetra = 0; contadorLetra < palabraAdivinar.length(); contadorLetra++) {
            if(contadorLetra == palabraAdivinar.length() - 1) {
                lineasLetrasValidas[contadorLetra] = "___";
            } else {
                lineasLetrasValidas[contadorLetra] = "___ ";
            }
        }
        lineas = String.join("", lineasLetrasValidas);
        labelLineasPalabra = new JLabel(lineas);

        // Añadidos de ventana inicial. 
        labelLineasPalabra.setFont(new Font("Arial", Font.BOLD, 16));
        labelLineasPalabra.setHorizontalAlignment(JLabel.CENTER);
        panelBoton.add(buttonSalir);
        panelRejillaEstadisticas.add(labelItentosTotales);
        panelRejillaEstadisticas.add(labelIntentosRestantes);
        panelRejillaEstadisticas.add(labelIntentosEjecutados);
        panelInteraccionJugador.add(panelRejillaEstadisticas);
        panelInteraccionJugador.add(labelLineasPalabra);
        panelInteraccionJugador.add(panelRejillaAbecedario);
        panelInteraccionJugador.add(panelBoton);
        panelRejillaGeneral.add(panelInteraccionJugador);
        panelRejillaGeneral.add(panelGraficaAhorcado);
        centerPanel.add(panelRejillaGeneral);        

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
                if (evento.getSource() == buttonAbecedario[busquedaBoton]){
                    System.out.println(buttonAbecedario[busquedaBoton].getText());
                    // Validación de letra en palabra.
                    if(Arrays.asList(listaLetrasValidas).contains(buttonAbecedario[busquedaBoton].getText())) {
                        buttonAbecedario[busquedaBoton].setBackground(Color.GREEN);  

                        // Aquí se cambia la línea por la letra
                        for(int buscadorLetraElegida = 0; buscadorLetraElegida < palabraAdivinar.length(); buscadorLetraElegida++) {
                            if(buttonAbecedario[busquedaBoton].getText().charAt(0) == listaLetrasValidas[buscadorLetraElegida].charAt(0)) {
                                if(buscadorLetraElegida == palabraAdivinar.length() - 1) {
                                    lineasLetrasValidas[buscadorLetraElegida] = "  "+ buttonAbecedario[busquedaBoton].getText() + "  ";
                                } else {
                                    lineasLetrasValidas[buscadorLetraElegida] = "  "+ buttonAbecedario[busquedaBoton].getText() + "   ";
                                }
                            }
                        }
                        lineas = String.join("", lineasLetrasValidas);
                        labelLineasPalabra.setText(lineas);

                    } else if (!Arrays.asList(listaLetrasValidas).contains(buttonAbecedario[busquedaBoton].getText()) && spriteContador <= 10) {
                        buttonAbecedario[busquedaBoton].setBackground(Color.RED);
                        ahorcadoSprites = new ImageIcon(getClass().getResource("AhorcadoSprites/"+ spriteContador++ +".png"));
                        labelSprites.setIcon(ahorcadoSprites);
                    } else {
                        buttonAbecedario[busquedaBoton].setBackground(Color.RED);
                    }
                    buttonAbecedario[busquedaBoton].setEnabled(false);
                }
            }
        }
    }
}