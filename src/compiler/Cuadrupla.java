package compiler;
class Cuadrupla {

	String nombre;
	String op1;
	String op2;
	String res;

	Cuadrupla(String n,String p1,String p2,String r) {
		nombre = n;
		op1 = p1;
		op2 = p2;
		res = r;
	}

	String getNombre() {
		return nombre;
	}

	String getOp1() {
		return op1;
	}

	String getOp2() {
		return op2;
	}

	String getRes() {
		return res;
	}

}