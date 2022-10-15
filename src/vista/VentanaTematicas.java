/*
Archivo: VentanaTematicas.java

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

public class VentanaTematicas extends Ventana {
    //Atributos:
    private Juego juego;
    private JButton botonJugar;
    
    //Métodos:
    public VentanaTematicas(Juego juego) {
        this.juego = juego;
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
