/*
Archivo: VentanaInicio.java

Proyecto 1 - El ahorcado

Autores: 
Juan Camilo Narvaez Tascon - juan.narvaez.tascon@correounivalle.edu.co - 2140112-3743
Christian David Vargas Gutiérrez - vargas.christian@correounivalle.edu.co - 2179172-3743

Fundamentos de Programación Orientada a Eventos - 750014C Grupo 01

Profesor:
Ing. M.Sc. Luis Yovany Romo Portilla

Licencia: GNU-GPL
*/

/**
  CLASE: VentanaInicio
  INTENCIÓN: Pantalla de inicio donde se registrará el nombre del usuario
  que desea jugar. El usuario podrá seleccionar uno de tres botones: Jugar,
  Instrucciones, Para qué sirve. Si no hay un nombre de usuario registrado
  entonces no podrá acceder a «Jugar».
  RELACIONES:
  - Es una Ventana.
*/

package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VentanaInicio extends Ventana {
    // Atributos:
    private JButton botonJugar;
    
    // Métodos:
    public VentanaInicio(){
        super();
    }
}
