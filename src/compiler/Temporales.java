package compiler;
import java.util.Vector;

class Temporales {

	Vector pila;

	Temporales() {
		pila = new Vector();
	}

	void apilar(int db, int ip) {
		pila.addElement(new Temporal(db,ip));
	}

	void desapilar() {
		pila.removeElement(pila.size()-1);
	}

	int getBase() {
		return ((Temporal)pila.elementAt(pila.size()-1)).getBase();
	}

	int getIndice() {
		return ((Temporal)pila.elementAt(pila.size()-1)).getIndice();
	}
}