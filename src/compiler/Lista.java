package compiler;
import java.util.Vector;

class Lista {

	Vector lista;

	Lista() {
		lista = new Vector();
	}

	void addCadena(String c) {
		lista.addElement(c);
	}

	String getCadena(int i) {
		return(String)lista.elementAt(i);
	}

	int size() {
		return lista.size();
	}
}