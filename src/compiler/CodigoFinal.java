// Clase utilizada para guardar el codigo final
package compiler;
import java.io.*;
import java.util.*;

class CodigoFinal {

	private CodigoIntermedio codigoIntermedio = null;
	private String ficheroCF;
	private PrintWriter fichero;
	private int direccion = -1;

	// Constructor
	public CodigoFinal(CodigoIntermedio CI,String nombrePrograma, int d) {
		codigoIntermedio = CI;
		direccion = d;
		String nombre = nombrePrograma.substring(0,nombrePrograma.lastIndexOf("."));
		ficheroCF = nombre.concat(".ens");
	}

	// Abre un nuevo fichero donde guardar codigo
	private void abrirFichero() throws IOException {
		fichero = new PrintWriter(
			new BufferedWriter(
				new FileWriter(ficheroCF)));
	}

	// Cierra el fichero
	private void cerrarFichero() {
		fichero.close();
	}

	// Escribe una linea en el fichero
	private void escribirLinea(String linea) {
		fichero.println(linea);
	}

	// Escribe una nueva linea en blanco
	private void lineaBlanco() {
		fichero.println("");
	}

	// Traduce el codigo intermedio al codigo final
	public void traducirCodigo() throws IOException {
		Cuadrupla cuadrupla;
		abrirFichero();
		for(int i=0;i<codigoIntermedio.instrucciones.size();i++) {
			cuadrupla=(Cuadrupla)codigoIntermedio.instrucciones.elementAt(i);
			procesarCuadrupla(cuadrupla);
		}
		cerrarFichero();
	}

	// Procesa la cuadrupla
	private void procesarCuadrupla(Cuadrupla cuadrupla)throws IOException {
		String op1,op2,inst,res;
		int o1,o2,r;
		String linea = "                                        ";
		op1 = cuadrupla.op1;
		op2 = cuadrupla.op2;
		inst = cuadrupla.nombre;
		res = cuadrupla.res;
		if(inst.equals("CARGAR_DIRECCION")) {
			o1 = Integer.parseInt(op1);
			if(o1<0)op1="[.R1]";else if(o1<direccion)op1="#"+op1+"[.IX]";else op1="/"+op1;
			r = Integer.parseInt(res);
			if(r<0)res="[.R1]";else if(r<direccion)res="#"+res+"[.IX]";else res="/"+res;
			escribirLinea(linea+"MOVE "+op1+" , "+res);
		} else
		if(inst.equals("CARGAR_VALOR")) {
			r = Integer.parseInt(res);
			if(r<0)res="[.R1]";res="#"+res+"[.IX]";
			escribirLinea(linea+"MOVE #"+op1+" , "+res);
		} else
		if(inst.equals("SUMAR")) {
			o1 = Integer.parseInt(op1);
			if(o1<0)op1="[.R1]";else op1="#"+op1+"[.IX]";
			o2 = Integer.parseInt(op2);
			if(o2<0)op2="[.R1]";else op2="#"+op2+"[.IX]";
			r = Integer.parseInt(res);
			if(r<0)res="[.R1]";else res="#"+res+"[.IX]";
			escribirLinea(linea+"ADD "+op1+" , "+op2);
			escribirLinea(linea+"MOVE .A , "+res);
		} else
		if(inst.equals("RESTAR")) {
			o1 = Integer.parseInt(op1);
			if(o1<0)op1="[.R1]";else op1="#"+op1+"[.IX]";
			o2 = Integer.parseInt(op2);
			if(o2<0)op2="[.R1]";else op2="#"+op2+"[.IX]";
			r = Integer.parseInt(res);
			if(r<0)res="[.R1]";else res="#"+res+"[.IX]";
			escribirLinea(linea+"SUB "+op1+" , "+op2);
			escribirLinea(linea+"MOVE .A , "+res);
		} else
		if(inst.equals("MULTIPLICAR")) {
			o1 = Integer.parseInt(op1);
			if(o1<0)op1="[.R1]";else op1="#"+op1+"[.IX]";
			o2 = Integer.parseInt(op2);
			if(o2<0)op2="[.R1]";else op2="#"+op2+"[.IX]";
			r = Integer.parseInt(res);
			if(r<0)res="[.R1]";else res="#"+res+"[.IX]";
			escribirLinea(linea+"MUL "+op1+" , "+op2);
			escribirLinea(linea+"MOVE .A , "+res);
		} else
		if(inst.equals("DIVIDIR")) {
			o1 = Integer.parseInt(op1);
			if(o1<0)op1="[.R1]";else op1="#"+op1+"[.IX]";
			o2 = Integer.parseInt(op2);
			if(o2<0)op2="[.R1]";else op2="#"+op2+"[.IX]";
			r = Integer.parseInt(res);
			if(r<0)res="[.R1]";else res="#"+res+"[.IX]";
			escribirLinea(linea+"DIV "+op1+" , "+op2);
			escribirLinea(linea+"MOVE .A , "+res);
		} else
		if(inst.equals("MODULO")) {
			o1 = Integer.parseInt(op1);
			if(o1<0)op1="[.R1]";else op1="#"+op1+"[.IX]";
			o2 = Integer.parseInt(op2);
			if(o2<0)op2="[.R1]";else op2="#"+op2+"[.IX]";
			r = Integer.parseInt(res);
			if(r<0)res="[.R1]";else res="#"+res+"[.IX]";
			escribirLinea(linea+"MOD "+op1+" , "+op2);
			escribirLinea(linea+"MOVE .A , "+res);
		} else
		if(inst.equals("OR")) {
			o1 = Integer.parseInt(op1);
			if(o1<0)op1="[.R1]";else op1="#"+op1+"[.IX]";
			o2 = Integer.parseInt(op2);
			if(o2<0)op2="[.R1]";else op2="#"+op2+"[.IX]";
			r = Integer.parseInt(res);
			if(r<0)res="[.R1]";else res="#"+res+"[.IX]";
			escribirLinea(linea+"OR "+op1+" , "+op2);
			escribirLinea(linea+"MOVE .A , "+res);
		} else
		if(inst.equals("AND")) {
			o1 = Integer.parseInt(op1);
			if(o1<0)op1="[.R1]";else op1="#"+op1+"[.IX]";
			o2 = Integer.parseInt(op2);
			if(o2<0)op2="[.R1]";else op2="#"+op2+"[.IX]";
			r = Integer.parseInt(res);
			if(r<0)res="[.R1]";else res="#"+res+"[.IX]";
			escribirLinea(linea+"AND "+op1+" , "+op2);
			escribirLinea(linea+"MOVE .A , "+res);
		} else
		if(inst.equals("NOT")) {
			o1 = Integer.parseInt(op1);
			if(o1<0)op1="[.R1]";else op1="#"+op1+"[.IX]";
			r = Integer.parseInt(res);
			if(r<0)res="[.R1]";else res="#"+res+"[.IX]";
			escribirLinea(linea+"CMP #1 , "+op1);
			escribirLinea(linea+"BZ $5");
			escribirLinea(linea+"MOVE #1 , "+res);
			escribirLinea(linea+"BR $3");
			escribirLinea(linea+"MOVE #0 , "+res);
		} else
		if(inst.equals("MAYOR")) {
			o1 = Integer.parseInt(op1);
			if(o1<0)op1="[.R1]";else op1="#"+op1+"[.IX]";
			o2 = Integer.parseInt(op2);
			if(o2<0)op2="[.R1]";else op2="#"+op2+"[.IX]";
			r = Integer.parseInt(res);
			if(r<0)res="[.R1]";else res="#"+res+"[.IX]";
			escribirLinea(linea+"CMP "+op2+" , "+op1);
			escribirLinea(linea+"BN $5");
			escribirLinea(linea+"MOVE #0 , "+res);
			escribirLinea(linea+"BR $3");
			escribirLinea(linea+"MOVE #1 , "+res);
		} else
		if(inst.equals("MENOR")) {
			o1 = Integer.parseInt(op1);
			if(o1<0)op1="[.R1]";else op1="#"+op1+"[.IX]";
			o2 = Integer.parseInt(op2);
			if(o2<0)op2="[.R1]";else op2="#"+op2+"[.IX]";
			r = Integer.parseInt(res);
			if(r<0)res="[.R1]";else res="#"+res+"[.IX]";
			escribirLinea(linea+"CMP "+op1+" , "+op2);
			escribirLinea(linea+"BN $5");
			escribirLinea(linea+"MOVE #0 , "+res);
			escribirLinea(linea+"BR $3");
			escribirLinea(linea+"MOVE #1 , "+res);
		} else
		if(inst.equals("MAYORIGUAL")) {
			o1 = Integer.parseInt(op1);
			if(o1<0)op1="[.R1]";else op1="#"+op1+"[.IX]";
			o2 = Integer.parseInt(op2);
			if(o2<0)op2="[.R1]";else op2="#"+op2+"[.IX]";
			r = Integer.parseInt(res);
			if(r<0)res="[.R1]";else res="#"+res+"[.IX]";
			escribirLinea(linea+"CMP "+op1+" , "+op2);
			escribirLinea(linea+"BN $5");
			escribirLinea(linea+"MOVE #1 , "+res);
			escribirLinea(linea+"BR $3");
			escribirLinea(linea+"MOVE #0 , "+res);
		} else
		if(inst.equals("MENORIGUAL")) {
			o1 = Integer.parseInt(op1);
			if(o1<0)op1="[.R1]";else op1="#"+op1+"[.IX]";
			o2 = Integer.parseInt(op2);
			if(o2<0)op2="[.R1]";else op2="#"+op2+"[.IX]";
			r = Integer.parseInt(res);
			if(r<0)res="[.R1]";else res="#"+res+"[.IX]";
			escribirLinea(linea+"CMP "+op2+" , "+op1);
			escribirLinea(linea+"BN $5");
			escribirLinea(linea+"MOVE #1 , "+res);
			escribirLinea(linea+"BR $3");
			escribirLinea(linea+"MOVE #0 , "+res);
		} else
		if(inst.equals("IGUAL")) {
			o1 = Integer.parseInt(op1);
			if(o1<0)op1="[.R1]";else op1="#"+op1+"[.IX]";
			o2 = Integer.parseInt(op2);
			if(o2<0)op2="[.R1]";else op2="#"+op2+"[.IX]";
			r = Integer.parseInt(res);
			if(r<0)res="[.R1]";else res="#"+res+"[.IX]";
			escribirLinea(linea+"CMP "+op1+" , "+op2);
			escribirLinea(linea+"BZ $5");
			escribirLinea(linea+"MOVE #0 , "+res);
			escribirLinea(linea+"BR $3");
			escribirLinea(linea+"MOVE #1 , "+res);
		} else
		if(inst.equals("DISTINTO")) {
			o1 = Integer.parseInt(op1);
			if(o1<0)op1="[.R1]";else op1="#"+op1+"[.IX]";
			o2 = Integer.parseInt(op2);
			if(o2<0)op2="[.R1]";else op2="#"+op2+"[.IX]";
			r = Integer.parseInt(res);
			if(r<0)res="[.R1]";else res="#"+res+"[.IX]";
			escribirLinea(linea+"CMP "+op1+" , "+op2);
			escribirLinea(linea+"BZ $5");
			escribirLinea(linea+"MOVE #1 , "+res);
			escribirLinea(linea+"BR $3");
			escribirLinea(linea+"MOVE #0 , "+res);
		} else
		if(inst.equals("ETIQUETA")) {
			String lin = res+":"+linea;
			escribirLinea(lin.substring(0,linea.length())+"NOP");
		} else
		if(inst.equals("SALTAR_CONDICION")) {
			o1 = Integer.parseInt(op1);
			if(o1<0)op1="[.R1]";else op1="#"+op1+"[.IX]";
			escribirLinea(linea+"CMP #0 , "+op1);
			escribirLinea(linea+"BZ /"+res);
		} else
		if(inst.equals("SALTAR_ETIQUETA")) {
			escribirLinea(linea+"BR /"+res);
		} else
		if(inst.equals("IMPRIMIR_ENTERO")) {
			o1 = Integer.parseInt(op1);
			if(o1<0)op1="[.R1]";else op1="#"+op1+"[.IX]";
			escribirLinea(linea+"WRINT "+op1);
		} else
		if(inst.equals("IMPRIMIR_CADENA")) {
			escribirLinea(linea+"WRSTR /"+op1);
		} else
		if(inst.equals("PONER_CADENA")) {
			String lin = op1+": DATA"+linea;
			escribirLinea(lin.substring(0,linea.length())+res);
		} else
		if(inst.equals("FIN")) {
			escribirLinea(linea+"HALT");
		} else
		if(inst.equals("CARGAR_IX")) {
			escribirLinea(linea+"MOVE #"+op1+" , .IX");
		} else
		if(inst.equals("VECTOR")) {
			o1 = Integer.parseInt(op1);
			if(o1<0)op1="[.R1]";else op1="#"+op1+"[.IX]";
			escribirLinea(linea+"MOVE "+op1+" , .A");
			escribirLinea(linea+"ADD .A , #"+op2);
			escribirLinea(linea+"MOVE .A , .R1");
		} else
		if(inst.equals("FINLLAMADA1")) {
			escribirLinea(linea+"MOVE .IX , #"+op1+"[.IX]");
			escribirLinea(linea+"MOVE .IX , .A");
			escribirLinea(linea+"ADD #"+op2+" , .A");
			escribirLinea(linea+"MOVE .A , .IX");
		} else
		if(inst.equals("FINLLAMADA2")) {
			escribirLinea(linea+"MOVE #LLAMADA"+op2+" , #-2[.IX]");
			escribirLinea(linea+"BR /"+op1);
			escribirLinea("LLAMADA"+op2+":"+linea.substring(1,linea.length()-op2.length()-7)+"NOP");	
			escribirLinea(linea+"MOVE #-1[.IX] , .IX");
		} else
		if(inst.equals("PARAMETRO")) {
			o1 = Integer.parseInt(op1);
			if(o1<0)op1="[.R1]";else op1="#"+op1+"[.IX]";
			r = Integer.parseInt(res);
			if(r<0)res="[.R1]";else res="#"+res+"[.IX]";
			escribirLinea(linea+"MOVE "+op1+" , "+res);
		} else
		if(inst.equals("RETORNO")) {
			o1 = Integer.parseInt(op1);
			if(o1<direccion)op1="#"+op1+"[.IX]";
			if(o1>-1)escribirLinea(linea+"MOVE "+op1+" , #-3[.IX]");
			escribirLinea(linea+"MOVE #-2[.IX] , .A");
			escribirLinea(linea+"MOVE .A , .PC");
		} 
	}
}