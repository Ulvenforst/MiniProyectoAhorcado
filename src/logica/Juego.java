/*
    Archivo: Juego.java
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
    CLASE: Juego
    INTENCIÓN: Esta clase se encargará de implementar la lógica del juego ahorcado.
    RELACIONES:
    -Conoce un jugador.
*/

package logica;

import java.util.*;

public class Juego {
    //Atributos:
    private String[] categorias = {"Países", "Frutas", "Colores", "Animales", "Herramientas"};
    private String[][] palabrasPorCategoria = new String[categorias.length][]; 
    private int indexCategoriaSeleccionada;
    private int numeroDePalabrasAAdividnar;
    
    //Métodos:
    public Juego() {
        palabrasPorCategoria[0] = new String[]{"Alemania", "Australia", "Argentina", "Bolivia", "Bulgaria", "Colombia", "Croacia", "Camboya", "Dinamarca", "Estados Unidos", "España", "Finlandia", "Honduras", "Jamaica", "Jordania", "Kenia", "Kirguistan", "Kuwait", "Namibia", "Nigeria", "Noruega", "Nueva Zelanda", "Peru", "Polonia", "Portugal", "Panama", "Reino Unido", "Suecia", "Suiza", "Somalia", "Siria", "Tanzania", "Trinidad y Tobago", "Ucrania", "Uganda", "Uruguay", "Venezuela", "Vietnam"};
        palabrasPorCategoria[1] = new String[]{"Arandano", "Banano", "Cereza", "Ciruela", "Durazno", "Frambuesa", "Fresa", "Granadilla", "Granada", "Kiwi", "Limon", "Mandarina", "Mango", "Manzana", "Maracuya", "Melon", "Mora", "Naranja", "Papaya"};
        palabrasPorCategoria[2] = new String[]{"Amarillo", "Ambar", "Azabache", "Azul", "Beige", "Blanco", "Bronce", "Cafe", "Carmesi", "Castaño", "Celeste", "Dorado", "Fucsia", "Gris", "Indigo", "Magenta", "Marron", "Naranja", "Negro", "Ocre", "Plata", "Platino", "Purpura", "Turquesa", "Vinotinto", "Violeta"};
        palabrasPorCategoria[3] = new String[]{"Abeja", "Aguila", "Araña", "Ballena", "Caballo", "Cangrejo", "Chimpance", "Cocodrilo", "Elefante", "Estrella de Mar", "Flamenco", "Foca", "Gallina", "Ganso", "Gato", "Hipopotamo", "Hormiga", "Iguana", "Jaguar", "Jirafa", "Koala", "Leon", "Leopardo", "Mapache", "Mariposa", "Murcielago", "Ñu", "Oso", "Oveja", "Paloma", "Panda", "Pato", "Pavo", "Pinguino", "Sapo", "Serpiente", "Tiburon", "Tigre", "Tortuga", "Zorro"};
        palabrasPorCategoria[4] = new String[]{"Alicate", "Brocha", "Broca", "Bisturi", "Cepillo", "Cuchillo",  "Destornillador", "Escalpelo", "Escuadra", "Espatula", "Llave", "Llave Inglesa", "Machete", "Manguera", "Navaja", "Pinza", "Sierra", "Tijeras", "Tornillo"};
    }

    public void setIndexCategoriaSeleccionada(int indexCategoriaSeleccionada){
        this.indexCategoriaSeleccionada = indexCategoriaSeleccionada;
    }
    
    public void setNumeroDePalabrasAAdivinar(int numeroDePalabrasAAdivinar){
        this.numeroDePalabrasAAdividnar = numeroDePalabrasAAdivinar;
    }
        
    public int getIndexCategoriaSeleccionada(){
        return indexCategoriaSeleccionada;
    }
    
    public int getNumeroDePalabrasAAdivinar(){
        return numeroDePalabrasAAdividnar;
    }
    
    public String[] getCategorias() {
        return categorias;
    }
}

