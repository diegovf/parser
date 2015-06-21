// Esta clase se utiliza para crear el fichero que contiene el codigo intermedio
package compiler;
import java.io.*;
import java.util.*;

class CodigoIntermedio {
	String nombreFichero = null;
	PrintWriter ficheroEscritura;
	BufferedReader ficheroLectura;
	Vector instrucciones;

	
	// Constructor
	public CodigoIntermedio(String nombre) {
		nombreFichero = nombre;
		ficheroLectura = null;
		ficheroEscritura = null;
		crearInstrucciones();
	}

	// Crea una tabla indicando todas las instrucciones que deben escribir
	// el n�mero de l�nea
	private void crearInstrucciones() {
		instrucciones = new Vector();
	}

	// Abre el fichero de donde leer el c�digo intermedio
	public void abrirFicheroLectura() throws IOException {
		ficheroLectura = new BufferedReader(
			new FileReader(nombreFichero));
	}

	// Cierra el fichero de lectura
	public void cerrarFicheroLectura() throws IOException {
		ficheroLectura.close();
	}

	// Abre un nuevo fichero donde guardar c�digo
	public void abrirFicheroEscritura() throws IOException {
		ficheroEscritura = new PrintWriter(
			new BufferedWriter(
				new FileWriter(nombreFichero)));
	}

	// Cierra el fichero de escritura
	public void cerrarFicheroEscritura() {
		Cuadrupla cuadrupla;
		for(int i=0;i<instrucciones.size();i++) {
			cuadrupla = (Cuadrupla)instrucciones.elementAt(i);
			ficheroEscritura.println(cuadrupla.getNombre()+
			" "+cuadrupla.getOp1()+
			" "+cuadrupla.getOp2()+
			" "+cuadrupla.getRes());
		}
		ficheroEscritura.close();
	}

	// Guarda una cuadrupla en el fichero abierto
	public void guardarCuadrupla(Cuadrupla cuadrupla) {
		instrucciones.addElement(cuadrupla);
	}
}