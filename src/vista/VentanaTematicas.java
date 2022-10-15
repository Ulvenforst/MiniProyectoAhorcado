/*
Archivo: VentanaTematica.java
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
	CLASE: VentanaTematica
	INTENCIÓN: En esta venta se le pedirá al usuario que indique la temática de palbras
    que desea adivinar, también se le pregutará cuántas rondas desea hacer; esto
    establecerá las vidas del jugador para realizar estadisticas. Una vez seleccionado 
    lo indicado procederá a la pantalla de juego.
	RELACIONES:
	- Es una Ventana.
*/

package vista;

import logica.*;

import java.awt.event.*;
import javax.swing.*;

public class VentanaTematicas extends Ventana {
    //Atributos:
    private Juego juego;
    private JButton botonJugar;
    
    //Métodos:
    public VentanaTematicas(Juego juego) {
        this.juego = juego;
        setVisible(true);
    }   
    
    @Override
    public void actionPerformed(ActionEvent evento){
        if (evento.getSource() == botonJugar)
            iniciarJuego();
    }
    
    public void iniciarJuego(){
        System.out.println("Hello Java");
    }
}
