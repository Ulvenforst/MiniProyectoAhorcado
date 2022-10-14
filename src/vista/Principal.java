/*
Archivo: Principal.java

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

import javax.swing.JFrame;

public class Principal {
    public static void main(String[] args) {
        VentanaInicio ventanaInicio = new VentanaInicio();
        ventanaInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
    }
}
