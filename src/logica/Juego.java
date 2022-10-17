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
import java.util.Map.Entry;
import java.util.*;

public class Juego {
    //Atributos:
    private double porcentajesRondas[] = new double[0];
    private String modaPalabraAdivinada[] = new String[0];
    private String nombreDelJugador;
    private String[] categorias = {"Países", "Frutas", "Colores", "Animales", "Herramientas"};
    private String[][] palabrasPorCategoria = new String[categorias.length][];
    private String palabraAAdivinar;
    private int indexCategoriaSeleccionada;
    private int numeroDePalabrasAAdividnar;
    private int palabrasJugadas = 0;
    private int palabrasNoAdivinadas = 0;
    private int palabrasAdivinadas = 0;
    private int rondasEjecutadas = 0;
    
    //Métodos:
    public Juego(String nombreDelJugador) {
        this.nombreDelJugador = nombreDelJugador;

        palabrasPorCategoria[0] = new String[]{"Alemania", "Australia", "Argentina", "Bolivia", "Bulgaria", "Colombia", "Croacia", "Camboya", "Dinamarca", "España", "Finlandia", "Honduras", "Jamaica", "Jordania", "Kenia", "Kirguistan", "Kuwait", "Namibia", "Nigeria", "Noruega", "Peru", "Polonia", "Portugal", "Panama", "Suecia", "Suiza", "Somalia", "Siria", "Tanzania", "Ucrania", "Uganda", "Uruguay", "Venezuela", "Vietnam"};
        palabrasPorCategoria[1] = new String[]{"Arandano", "Banano", "Cereza", "Ciruela", "Durazno", "Frambuesa", "Fresa", "Granadilla", "Granada", "Kiwi", "Limon", "Mandarina", "Mango", "Manzana", "Maracuya", "Melon", "Mora", "Naranja", "Papaya"};
        palabrasPorCategoria[2] = new String[]{"Amarillo", "Ambar", "Azabache", "Azul", "Beige", "Blanco", "Bronce", "Cafe", "Carmesi", "Castaño", "Celeste", "Dorado", "Fucsia", "Gris", "Indigo", "Magenta", "Marron", "Naranja", "Negro", "Ocre", "Plata", "Platino", "Purpura", "Turquesa", "Vinotinto", "Violeta"};
        palabrasPorCategoria[3] = new String[]{"Abeja", "Aguila", "Araña", "Ballena", "Caballo", "Cangrejo", "Chimpance", "Cocodrilo", "Elefante", "Estrella de Mar", "Flamenco", "Foca", "Gallina", "Ganso", "Gato", "Hipopotamo", "Hormiga", "Iguana", "Jaguar", "Jirafa", "Koala", "Leon", "Leopardo", "Mapache", "Mariposa", "Murcielago", "Ñu", "Oso", "Oveja", "Paloma", "Panda", "Pato", "Pavo", "Pinguino", "Sapo", "Serpiente", "Tiburon", "Tigre", "Tortuga", "Zorro"};
        palabrasPorCategoria[4] = new String[]{"Alicate", "Brocha", "Broca", "Bisturi", "Cepillo", "Cuchillo",  "Destornillador", "Escalpelo", "Escuadra", "Espatula", "Llave", "Machete", "Manguera", "Navaja", "Pinza", "Sierra", "Tijeras", "Tornillo"};
    }

    public void setIndexCategoriaSeleccionada(int indexCategoriaSeleccionada){
        this.indexCategoriaSeleccionada = indexCategoriaSeleccionada;
    }
    
    public void setNumeroDePalabrasAAdivinar(int numeroDePalabrasAAdivinar){
        System.out.println("numeroDePalabrasAAdivinar: " + numeroDePalabrasAAdivinar);
        this.numeroDePalabrasAAdividnar = numeroDePalabrasAAdivinar;
    }
    
    public int getMejorRonda(){
        int ronda = 0;
        for(int buscadorPosicion = 0; buscadorPosicion < porcentajesRondas.length; buscadorPosicion++) {
            if(porcentajesRondas[buscadorPosicion] == getMayorPorcentajeRondas()) {
                if(getMayorPorcentajeRondas() == 0) {
                    ronda = 0;
                } else {
                    ronda = buscadorPosicion + 1;
                }
                break;
            }
        }
        return ronda;
    }

    public int getPeorRonda(){
        int ronda = 0;
        for(int buscadorPosicion = 0; buscadorPosicion < porcentajesRondas.length; buscadorPosicion++) {
            if(porcentajesRondas[buscadorPosicion] == getPeorPorcentajeRondas()) {
                ronda = buscadorPosicion + 1;
                break;
            }
        }
        return ronda;
    }

    public String getNombreDelJugador(){
        return nombreDelJugador;
    }
        
    public int getIndexCategoriaSeleccionada(){
        return indexCategoriaSeleccionada;
    }
    
    public int getNumeroDePalabrasAAdivinar(){
        return numeroDePalabrasAAdividnar;
    }
    
    public String getPalabraAAdivinar(){
        return palabraAAdivinar;
    }
    
    public String[] getCategorias() {
        return categorias;
    }
    
    public int getPalabrasJugadas(){
        return palabrasJugadas;
    }
    
    public int getRondasEjecutadas(){
        return rondasEjecutadas;
    }

    public String palabraMasAcertada(){
        String moda = "";

        Map<String, Integer> mp = new HashMap<>();
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
 
        for (int i = 0; i < modaPalabraAdivinada.length; i++)
        {
            if (mp.containsKey(modaPalabraAdivinada[i]))
            {
                mp.put(modaPalabraAdivinada[i], mp.get(modaPalabraAdivinada[i]) + 1);
            }
            else
            {
                mp.put(modaPalabraAdivinada[i], 1);
            }
        }

        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list); 
        for (int num : list) {
            for (Entry<String, Integer> entry : mp.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }

        Set<String> keySet = sortedMap.keySet();
        ArrayList<String> listOfKeys = new ArrayList<String>(keySet); 
  
        Collection<Integer> values = sortedMap.values(); 
  
        ArrayList<Integer> listOfValues = new ArrayList<>(values); 
        
        if(modaPalabraAdivinada.length > 1){
            if(listOfValues.get(listOfValues.size()-1) == listOfValues.get(listOfValues.size()-2)) {
                moda = "Empate";
            } else {
                moda = listOfKeys.get(listOfValues.size()-1);
            }
        } else if (listOfValues.size() == 1){
            moda = modaPalabraAdivinada[0];
        }

        return moda;
    }

    public double getMayorPorcentajeRondas(){
        double mayorPorcentaje = 0;
        double porcentajesMayor[] = new double[porcentajesRondas.length];
        porcentajesMayor = Arrays.copyOf(porcentajesRondas, porcentajesRondas.length);
        Arrays.sort(porcentajesMayor);
        mayorPorcentaje = porcentajesMayor[porcentajesMayor.length - 1];

        return mayorPorcentaje;
    }

    public double getPeorPorcentajeRondas(){
        double peorPorcentaje = 0;
        double porcentajesMayor[] = new double[porcentajesRondas.length];
        porcentajesMayor = Arrays.copyOf(porcentajesRondas, porcentajesRondas.length);
        Arrays.sort(porcentajesMayor);

        if(porcentajesRondas.length > 1 && (porcentajesMayor[porcentajesMayor.length-1] != porcentajesMayor[0]))
            peorPorcentaje = porcentajesMayor[0];
        else
            peorPorcentaje = 0;

        return peorPorcentaje;
    }
    
    public int getPalabrasNoAdivinadas(){
        return palabrasNoAdivinadas;
    }
    
    public int getPalabrasAdivinadas(){
        return palabrasAdivinadas;
    }
    
    public void nuevaPalabra(){
        int totalPalabrasEnCategoria = palabrasPorCategoria[indexCategoriaSeleccionada].length - 1;
        int ubicacionAleatoria = (int) (Math.random() * totalPalabrasEnCategoria);
        palabraAAdivinar = palabrasPorCategoria[indexCategoriaSeleccionada][ubicacionAleatoria];
    }
    
    public int contarOcurrencias(String letra){
        String[] letrasEnPalabra = palabraAAdivinar.toLowerCase().split("");
        int ocurrencias = 0;
        for (int contadorLetra = 0; contadorLetra < palabraAAdivinar.length(); contadorLetra++){
            if (letra.charAt(0) == letrasEnPalabra[contadorLetra].charAt(0))
                ocurrencias++;
        }
        return ocurrencias;
    }
    
    public boolean verificacionDeLetra(String letra){
        String[] letrasEnPalabra = palabraAAdivinar.toLowerCase().split("");
        if (Arrays.asList(letrasEnPalabra).contains(letra)){
            return true;
        }
        return false;
    }
    
    public void palabraNoAdivinada(){
        palabrasNoAdivinadas++;
    }
    
    public void palabraAdivinada(){
        palabrasAdivinadas++;
        modaPalabraAdivinada = Arrays.copyOf(modaPalabraAdivinada, modaPalabraAdivinada.length + 1);
        modaPalabraAdivinada[modaPalabraAdivinada.length - 1] = getPalabraAAdivinar();
    }
    
    public void palabraJugada(){
        palabrasJugadas++;
    }
    
    public void rondaEjecutada(){
        // Se simula un append al arreglo de juegos.
        porcentajesRondas = Arrays.copyOf(porcentajesRondas, porcentajesRondas.length + 1);
        double porcentajeRonda;
        porcentajeRonda = (double) getPalabrasAdivinadas()/getNumeroDePalabrasAAdivinar() * 100;
        porcentajeRonda = Math.round(porcentajeRonda*100.0)/100.0;
        porcentajesRondas[porcentajesRondas.length - 1] = porcentajeRonda;
        getMejorRonda();
        
        rondasEjecutadas++;
    }
    
    public void nuevaRonda(){
        indexCategoriaSeleccionada = 0;
        numeroDePalabrasAAdividnar = 0;
        palabrasNoAdivinadas = 0;
        palabrasAdivinadas = 0;
        palabrasJugadas = 0;
    }
 }