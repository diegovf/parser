package compiler;

import java_cup.runtime.Symbol;
%%
%cup
%%
";" { //RECONOCE EL SIMBOLO PUNTO Y COMA
return new Symbol(sym.SEMI); }
"+" { System.out.print("SIGNO DE SUMA ");//RECONOCE EL SIMBOLO MAS
return new Symbol(sym.PLUS); }
"*" { System.out.print("SIGNO POR ");//RECONOCE EL SIMBOLO POR
return new Symbol(sym.TIMES); }
"-" { System.out.print("SIGNO MENOS ");//RECONOCE EL SIMBOLO MENOS
return new Symbol(sym.MENOS); }
"/" { System.out.print("SIGNO DIVIDIDO ");//RECONOCE EL SIMBOLO DIVIDIDO
return new Symbol(sym.DIVI); }
"(" { return new Symbol(sym.LPAREN); } //RECONOCE EL PARENTESIS DE APERTURA
")" { return new Symbol(sym.RPAREN); }//RECONOCE EL SIMBOLO PARENTESIS DE CIERRE
[0-9]+ { System.out.print(" numero ");//RECONOCE LOS NUMEROS
return new Symbol(sym.NUMBER, new Integer(yytext())); }
[ \t\r\n\f] { /* ignore white space. */ }
. { System.err.println("Illegal character: "+yytext()); } 