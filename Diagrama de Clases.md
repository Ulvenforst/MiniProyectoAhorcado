# El Ahorcado - Universidad del Valle

Juan Camilo Narvaez Tascon y Christian David Vargas Gutiérrez 

<div style="text-align:center">

  ```mermaid
  classDiagram

  class Principal{
    +main(String[] args) static void
  }
  
  class Ventana{
    #centerPanel : JPanel
    #northPanel : JPanel
    #eastPanel : JPanel
    #westPanel : JPanel
    #southPanel : JPanel
    +Ventana()
  }

  class VentanaInicio{
    -labelTitulo : JLabel
    -labelSubtitulo : JLabel
    -labelNombre : JLabel
    -panelInputNombre : JPanel
    -panelCabecera : JPanel
    -panelFormulario : JPanel
    -fieldNombre : JTextField
    -buttonJugar : JButton
    -buttonInstrucciones : JButton
    -buttonParaQueSirve : JButton
    +VentanaInicio()
    +actionPerformed(ActionEvent evento) void
    iniciarJuego() void
  }

  class VentanaInformacion{
    -labelTitulo : JLabel
    -labelSubtitulo : JLabel
    -labelBeneficios : JLabel
    -labelLinea1 : JLabel
    -labellinea2 : JLabel
    -labelLinea3 : JLabel
    -labelLinea4 : JLabel
    -panelCabecera : JPanel
    -panelPrincipal : JPanel
    -panelFinal : JPanel
    -buttonVolver : JButton
    +VentanaInformacion()
    +actionPerformed(ActionEvent evento) void
  }

  class VentanaInstrucciones{
    -labelTitulo : JLabel
    -labelSubtitulo : JLabel
    -labelInstrucciones : JLabel
    -labelPrimeraInstruccion : JLabel
    -labelSegundaInstruccion : JLabel
    -panelCabecera : JPanel
    -panelPrincipal : JPanel
    -panelFinal : JPanel
    -buttonVolver : JButton
    +VentanaInstrucciones()
    +actionPerformed(ActionEvent evento) void
  }

  class VentanaTematicas{
    -juego : Juego
    -labelTitulo : JLabel
    -labelSubtitulo : JLabel
    -labelEscogerTematica : JLabel
    -labelNumeroDePalabras : JLabel
    -boxCategorias : JComboBox
    -fieldNumeroDePalabras : JTextField  
    -panelCabecera : JPanel
    -panelPrincipal : JPanel
    -panelEscogerTematica : JPanel
    -panelEscogerNumeroDePalabras : JPanel
    -buttonJugar : JButton
    -buttonSalir : JButton
    +VentanaTematicas(Juego juego)
    +actionPerformed(ActionEvent evento) void
  }

  class VentanaJuego{
    -juego : Juego
    -panelRejillaGeneral : JPanel
    -panelGraficaAhorcado : JPanel
    -panelInteraccionJugador : JPanel
    -panelRejillaEstadistica : JPanel
    -panelRejillaAbecedario : JPanel
    -panelBoton : JPanel
    -labelIntentosTotales : JLabel
    -labelIntentosRestantes : JLabel
    -labelIntentosEjecutados : JLabel
    -labelSprites : JLabel
    -ahoracoSprites : ImageIcone
    -labelLineasPorPalabra : JLabel
    -buttonAbecedario : Jbutton[]
    -buttonSalir : JButton[]
    -lineasLetrasValidas : String[]
    -spriteContador : int
    -totalLetrasEnPalabaraAAdivinar : int
    -totalLetrasAdivinadas : int
    -intentosEjecutados : int
    -intentosCorrectos : int
    -intentosFallados : int
    +VentanaJuego(Juego juego)
    +cargarLineas(String palabraAAdivinar, char letraEscogida) void
    +cargarSprites() void
    +actionPerformed(ActionEvent event) void
    +verificarPerdedorOGanador() void
    +siguientePalabra() void
    +mostrarEstadisticasRonda() void
    +mostrarEstadisticasFinales() void
    +jugarOtraRonda() void
    +continuarJugando() void
  }

  class Juego{
    -nombreDelJugador : String
    -categorias : String[]
    -palabrasPorCategoria : String[][]
    -palabraAAdivinar : String
    -indexCategoriaSeleccionada : int
    -numeroDePalabrasAAdivinar : int
    -palabrasJugadas : int
    -PalabrasNoAdivinadas : int
    -palabrasAdivinas : int
    -rondasEjecutadas : int
    +Juego(String nombreDelJugaodr)
    +setIndexCategoriaSeleccionada() void
    +setNumeroDePalabrasAAdivinar() void
    +getNombreDelJugador() String
    +getIndexCategoriaSeleccionada() int
    +getNumeroDePalabrasAAdivinar() int
    +getPalabraAAdivinar() String
    +getCategorias() String[]
    +getPalabrasJugadas() int
    +getRondasEjecutadas() int
    +getPalabrasNoAdivinadas() int
    +getPalabrasAdivinadas() int
    +nuevaPalabra() void
    +contarOcurrencias(String letra) int
    +verificacionDeLetra(String letra) boolean
    +palabraNoAdivinada() void
    +palabraAdivinda() void
    +palabraJugada() void
    +rondaEjecutada() void
    +nuevaRonda() void
  }

  class VentanaEstadisticas{

    +VentanaEstadisticas()
  }

  Principal -- VentanaInicio
  Ventana <|-- VentanaInicio
  Ventana <|-- VentanaInformacion
  Ventana <|-- VentanaInstrucciones
  Ventana <|-- VentanaTematicas
  Ventana <|-- VentanaJuego
  Ventana <|-- VentanaEstadisticas
  VentanaInicio -- VentanaInformacion
  VentanaInicio -- VentanaInstrucciones
  VentanaInicio -- VentanaTematicas
  VentanaInicio -- Juego
  VentanaTematicas -- VentanaJuego
  VentanaJuego -- VentanaEstadisticas
  VentanaTematicas o-- Juego
  VentanaJuego o-- Juego
  VentanaEstadisticas o-- Juego

  ```

</div>
