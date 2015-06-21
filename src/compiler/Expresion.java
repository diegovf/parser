package compiler;
class Expresion {

	int direccion;
	int tipo;

	Expresion(int d) {
		direccion = d;
		tipo = -1;
	}
	
	Expresion(int d, int t) {
		direccion = d;
		tipo = t;
	}

	int getDireccion() {
		return direccion;
	}

	void setDireccion(int d) {
		direccion = d;
	}

	int getTipo() {
		return tipo;
	}

	void setTipo(int t) {
		tipo = t;
	}
}