package compiler;
class Temporal {
	int direccionBase;
	int indiceParametro;

	Temporal(int db, int ip) {
		direccionBase = db;
		indiceParametro = ip;
	}

	int getBase() {
		return direccionBase;
	}
	
	int getIndice() {
		return indiceParametro;
	}

	void setIndice(int i) {
		indiceParametro = i;
	}
}