/*
Archivo: VentanaInicio.java
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
	CLASE: VentanaInicio
	INTENCIÓN: Pantalla de inicio donde se registrará el nombre del usuario
	que desea jugar. El usuario podrá seleccionar uno de tres botones: Jugar,
	Instrucciones, Para qué sirve. Si no hay un nombre de usuario registrado
	entonces no podrá acceder a «Jugar».
	RELACIONES:
	- Es una Ventana.
*/

package vista;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaInicio extends Ventana {
	// Atributos:
	private JLabel titulo = new JLabel("El Ahorcado");
	private JLabel subtitulo = new JLabel("Universidad del Valle");
	private JLabel nombreLbl = new JLabel("Ingrese su nombre:");
	private JPanel inputNombre = new JPanel();
	private JPanel cabecera = new JPanel();
	private JPanel formularioIncio = new JPanel();
	private JTextField nombreField = new JTextField();
	private JButton btnJugar = new JButton("Jugar");
	private JButton btnInstrucciones = new JButton("Instrucciones");
	private JButton btnParaQueSirve = new JButton("¿Para qué sirve?");
		
	// Constructor:
	public VentanaInicio() {
		// Configuración de páneles propios.
		northPanel.setBackground(new Color(226, 201, 99));
		inputNombre.setLayout(new GridLayout(2, 1));
		cabecera.setLayout(new GridLayout(2, 1));
		cabecera.setBackground(new Color(0, 0, 0, 0));
		formularioIncio.setLayout(new GridLayout(4, 1, 0, 20));
		
		// Mejoras visuales.
		
		
		// Añadidos de ventana inicial. 
		titulo.setFont(new Font("Arial", Font.PLAIN, 34));
		titulo.setHorizontalAlignment(JLabel.CENTER);
		subtitulo.setFont(new Font("Arial", Font.PLAIN, 16));
		subtitulo.setHorizontalAlignment(JLabel.CENTER);
		nombreLbl.setFont(new Font("Arial", Font.PLAIN, 18));
		cabecera.add(titulo);
		cabecera.add(subtitulo);
		northPanel.add(cabecera);
		inputNombre.add(nombreLbl);
		inputNombre.add(nombreField);
		formularioIncio.setPreferredSize(new Dimension(180, 250));
		formularioIncio.add(inputNombre);
		formularioIncio.add(btnJugar);
		formularioIncio.add(btnInstrucciones);
		formularioIncio.add(btnParaQueSirve);
		centerPanel.add(formularioIncio);
		
		// Mostrar Pantalla Inicial.
		setVisible(true);
	}
}
