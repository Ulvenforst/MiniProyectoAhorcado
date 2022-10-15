/*
Archivo: Jugador.java

Proyecto 1 - El ahorcado

Autores: 
Juan Camilo Narvaez Tascon - juan.narvaez.tascon@correounivalle.edu.co - 
Christian David Vargas Gutiérrez - vargas.christian@correounivalle.edu.co - 2179172-3743

Fundamentos de Programación Orientada a Eventos - 750014C Grupo 01

Profesor:
Ing. M.Sc. Luis Yovany Romo Portilla

Licencia: GNU-GPL
*/

package logica;


public class Jugador {
    //Atributos:
    private String nombreDelJugador;

    //Métodos:
    public Jugador() {
        nombreDelJugador = "Jugador01";
    }
    
    public Jugador(String nombreDelJugador){
        this.nombreDelJugador = nombreDelJugador;
    }
    
    public String getNombreDelJugador(){
        return nombreDelJugador;
    }
    
}
