package compiler;
class Tipo {

	private int cod;
	private String id;
	private int tipoBase;
	private int dimension;
	private int maximo;
	private int padre;

	Tipo() {
		cod = -1;
		id = "";
		tipoBase = -1;
		dimension = 0;
		maximo = -1;
		padre = -1;
	}

	Tipo(int c, String i) {
		cod = c;
		id = i;
		tipoBase = -1;
		dimension = 0;
		maximo = -1;
		padre = -1;
	}

	void imprimir() {
		System.out.println("Codigo = "+getCod());
		System.out.println("Ident  = "+getId());
		System.out.println("T Base = "+getTipoBase());
		System.out.println("Dimens = "+getDimension());
		System.out.println("Maximo = "+getMaximo());
		System.out.println("Padre  = "+getPadre());
	}

	void setCod(int c) {
		cod = c;
	}

	void setId(String i) {
		id = i;
	}

	int getCod() {
		return cod;
	}

	String getId() {
		return id;
	}

	void setTipoBase(int tb) {
		tipoBase = tb;
	}

	int getTipoBase() {
		return tipoBase;
	}

	void setDimension(int d) {
		dimension = d;
	}

	int getDimension() {
		return dimension;
	}

	void setMaximo(int m) {
		maximo = m;
	}

	int getMaximo() {
		return maximo;
	}

	void setPadre(int p) {
		padre = p;
	}

	int getPadre() {
		return padre;
	}
}