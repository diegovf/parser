package compiler;
import java.util.Vector;

class Simbolo {

	private int cod;
	private String id;
	private int direccion;
	private int tipo;
	private String categoria;
	private int numeroParametros;
	private Vector parametros;
	private int ambito;

	Simbolo() {
		cod = -1;
		id = "";
		direccion = -1;
		tipo = -1;
		categoria = "";
		numeroParametros = 0;
		parametros = new Vector();
		ambito = 0;
	}

	Simbolo(int c, String i) {
		cod = c;
		id = i;
		direccion = -1;
		tipo = -1;
		categoria = "";
		numeroParametros = 0;
		parametros = new Vector();
		ambito = 0;
	}

	void imprimir() {
		System.out.println("Codigo = "+getCod());
		System.out.println("Identi = "+getId());
		System.out.println("Direcc = "+getDireccion());
		System.out.println("Tipo   = "+getTipo());
		System.out.println("Catego = "+getCategoria());
		System.out.println("N Para = "+getNumeroParametros());
		System.out.println("Ambito = "+getAmbito());
		System.out.print("Parame = [");
		for(int i=0;i<getNumeroParametros();i++) {
			System.out.print(parametros.elementAt(i)+",");
		}
		System.out.println("]");
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

	void setDireccion(int d) {
		direccion = d;
	}

	int getDireccion() {
		return direccion;
	}

	void setTipo(int t) {
		tipo = t;
	}

	int getTipo() {
		return tipo;
	}

	void setCategoria(String c) {
		categoria = c;
	}

	String getCategoria() {
		return categoria;
	}

	void setNumeroParametros(int np) {
		numeroParametros = np;
	}

	int getNumeroParametros() {
		return numeroParametros;
	}

	void addParametro(int p) {
		parametros.addElement(new Integer(p));
	}

	int getParametro(int pos) {
		return ((Integer)parametros.elementAt(pos)).intValue();
	}

	void setAmbito(int a) {
		ambito = a;
	}

	int getAmbito() {
		return ambito;
	}

	boolean comprobarTiposParametros(Vector v) {
		boolean retorno = true;
		Expresion e;
		int t;
		for(int i=0;i<v.size()-1;i++) {
			t = getParametro(i);
			e = (Expresion)v.elementAt(i);
			if(e.getTipo()!=t) {
				retorno = false;
				break;
			}
		}
		return retorno;
	}
}