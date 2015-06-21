package compiler;
import java.util.Vector;

class Pila {

	Vector pila;

	Pila() {
		pila = new Vector();
	}

	void apilar(int n) {
		pila.addElement(new Integer(n));
	}

	int desapilar() {
		int retorno = ((Integer)pila.lastElement()).intValue();
		pila.removeElementAt(pila.size()-1);
		return retorno;
	}

	int verCima() {
		return ((Integer)pila.lastElement()).intValue();
	}
}