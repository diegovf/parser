package compiler;

import java_cup.runtime.Symbol;
%%

%public
%type Token

%unicode

%cup
%full
%line
%char
%ignorecase
%type Symbol


%eofval{
	return new Symbol(sym.EOF,new String("Fin del archivo"));
%eofval}

%{
    public String lexeme;
    public int linea;
    public int columna;
    public String lineaIdentificador = "";
    
    //Variables contadoras
    public int contErrores = 0;
    public int contSeparadores = 0;
    public int contOperadores = 0;
    public int contLiteralesBooleanos = 0;
    public int contLiteralesString = 0;
    public int contLiteralesHexadecimales = 0;
    public int contLiteralesOctales = 0;
    public int contLiteralesDecimales = 0;
    public int contLiteralesPtoFlotantes = 0;
    public int contLiteralesNull = 0;
    public int contIdentificadores = 0;
    public int contReservadas = 0;


    public StringBuilder string = new StringBuilder();
%}

/* SALTO DE LINEA Y CUALQUIER CARACTER */
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

WhiteSpace = {LineTerminator} | [ \t\f]

/* COMENTARIOS*/
Comment = {TraditionalComment} | {EndOfLineComment}

TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?

/* IDENTIFICADORES */
Identifier = [a-zA-Z][:jletterdigit:]*

/* LITERALES ENTEROS */
DecLiteral = 0 | [1-9][0-9]*
DecLongLiteral    = {DecLiteral} [lL]

HexLiteral = 0 [xX] 0* {HexDigit}
HexDigit          = [0-9a-fA-F]+
HexLongLiteral    = 0 [xX] 0* {HexDigit} [lL]

OctLiteral = 0+ [1-3]? {OctDigit}
OctDigit          = [0-7]+
OctLongLiteral    = 0+ 1? {OctDigit} {1,21} [lL]
    
/* LITERALES PUNTO FLOTANTE */        
FloatLiteral  = ({FLit1}|{FLit2}) {Exponent}? [fF]
DoubleLiteral = ({FLit1}|{FLit2}) {Exponent}?

FLit1    = [0-9]+ \. [0-9]* 
FLit2    = \. [0-9]+ 
Exponent = [eE] [+-]? [0-9]+

/* LITERALES STRING */
StringCharacter = [^\r\n\"\\]
SingleCharacter = [^\r\n\'\\]


/* PALABRAS RESERVADAS */
PR = auto|break|bool|char|const|continue|default|do|double|else|enum|extern|float|for|
goto|if|int|long|register|return|short|signed|sizeof|static|struct|switch|typedef|
union|unsigned|void|volatile|while

/* SEPARADORES */
SEPARADOR = "("|")"|"{"|"}"|"["|"]"|","|"."

/* OPERADORES */
OPERADORES = =|"=="|"+"|"*"|"-"|"/"|"<"|"<="|">"|">="|"!="|"!"|"||"|"&&"|"<<"|"<<="|
">>"|">>="|"~"|"&"|"&="|"|"|"|="|"("|")"|"["|"]"|"{"|"}"|"."|"->"|"++"|"--"|
"(type)"|"*"|"&"|"new"|"true"|"false"|"%"|"#include"|"delete"|"#define"|"-="
|"+="|"#import"|"?:"|"#ifdef"|"#else"|"#endif"|"#pragma"|"#undef"|"#error"

LISTABOOLEANOS =  "=="|">="|">"|"<="|"<"|"!="|"||"|"&&"

INC_DEC = "++"|"--"

OPERADORCOMBINADO = "+="|"-="|"*="|"/="

OPERADORSIMPLE = "+"|"-"|"*"|"/"|"%"

%state STRING, CHARLITERAL

%%

<YYINITIAL> {
    "for"   {return new Symbol(sym.FOR, yychar, yyline, yytext());}
    "("   {return new Symbol(sym.PARIZQ, yychar, yyline, yytext());}
    ")"   {return new Symbol(sym.PARDER, yychar, yyline, yytext());}
    "{"   {return new Symbol(sym.LLAVEIZQ, yychar, yyline, yytext());}
    "}"   {return new Symbol(sym.LLAVEDER, yychar, yyline, yytext());}
    "int"   {return new Symbol(sym.INT, yychar, yyline, yytext());}
    "char"   {return new Symbol(sym.CHAR, yychar, yyline, yytext());}
    "long"   {return new Symbol(sym.LONG, yychar, yyline, yytext());}
    "short"   {return new Symbol(sym.SHORT, yychar, yyline, yytext());}
    "void"   {return new Symbol(sym.VOID, yychar, yyline, yytext());}
    "package"   {return new Symbol(sym.PACKAGE, yychar, yyline, yytext());}
    "import"   {return new Symbol(sym.IMPORT, yychar, yyline, yytext());}
    "while"   {return new Symbol(sym.WHILE, yychar, yyline, yytext());}
    "if"      {return new Symbol(sym.IF, yychar, yyline, yytext());}
    "else"      {return new Symbol(sym.ELSE, yychar, yyline, yytext());}
    "'"   {return new Symbol(sym.COMILLA, yychar, yyline, yytext());}
    "!"   {return new Symbol(sym.NEGADO, yychar, yyline, yytext());}
    "switch" {return new Symbol(sym.SWITCH, yychar, yyline, yytext());}
    "case"   {return new Symbol(sym.CASE, yychar, yyline, yytext());}
    "default" {return new Symbol(sym.DEFAULT, yychar, yyline, yytext());}
    ":"       {return new Symbol(sym.DOSPUNTOS, yychar, yyline, yytext());}
    "const"    {return new Symbol(sym.CONST, yychar, yyline, yytext());}
    "return"   {return new Symbol(sym.RETURN, yychar, yyline, yytext());}
    "read"     {return new Symbol(sym.READ, yychar, yyline, yytext());}
    "write"    {return new Symbol(sym.WRITE, yychar, yyline, yytext());}
    "break"    {return new Symbol(sym.BREAK, yychar, yyline, yytext());}
    "return"    {return new Symbol(sym.RETURN, yychar, yyline, yytext());}
    "do"    {return new Symbol(sym.DO, yychar, yyline, yytext());}
    
  /* OPERADORES SIMPLE */
  {OPERADORSIMPLE}              {return new Symbol(sym.OPERADORCOMBINADO, yychar, yyline, yytext());}

  /* OPERADORES COMBINADOS */
  {OPERADORCOMBINADO}           {return new Symbol(sym.OPERADORCOMBINADO, yychar, yyline, yytext());}

  /* INCREMENTAR DECREMENTAR */
  {INC_DEC}                     {return new Symbol(sym.INC_DEC, yychar, yyline, yytext());}

  /* PALABRAS RESERVADAS */
  {PR}                           {return new Symbol(sym.RESERVADA, yychar, yyline, yytext());}
  
    {LISTABOOLEANOS}            {return new Symbol(sym.LISTABOOLEANOS, yychar, yyline, yytext());}
  /* LITERALES BOOLEANOS */
  "true"                         {return new Symbol(sym.LITERALBOOLEANO, yychar, yyline, yytext());}
  "false"                        {return new Symbol(sym.LITERALBOOLEANO, yychar, yyline, yytext());}
  
  ";"                            {return new Symbol(sym.PYCOMA, yychar, yyline, yytext());}
  ","                            {return new Symbol(sym.COMA, yychar, yyline, yytext());}
    "="                          {return new Symbol(sym.IGUAL, yychar, yyline, yytext());}

  /*LITERAL NULL*/
  "null"                         {return new Symbol(sym.LITERALNULL, yychar, yyline, yytext());}

  /* SEPARADORES */
  {SEPARADOR}                    {return new Symbol(sym.SEPARADOR, yychar, yyline, yytext());}
  
    /* OPERADORES */
  {OPERADORES}                   {return new Symbol(sym.OPERADOR, yychar, yyline, yytext());}
  
/* string literal */
  \"                             { yybegin(STRING); string.setLength(0); }


  {DecLiteral}                   {return new Symbol(sym.LITERALDECIMAL, yychar, yyline, yytext());}}
  {DecLongLiteral}               {return new Symbol(sym.LITERALDECIMAL, yychar, yyline, yytext());}

  {HexLiteral}                   {return new Symbol(sym.LITERALHEXADECIMAL, yychar, yyline, yytext());}
  {HexLongLiteral}               {return new Symbol(sym.LITERALHEXADECIMAL, yychar, yyline, yytext());}
 
  {OctLiteral}                   {return new Symbol(sym.LITERALOCTAL, yychar, yyline, yytext());}
  {OctLongLiteral}               {return new Symbol(sym.LITERALOCTAL, yychar, yyline, yytext());}
  
  {FloatLiteral}                 {return new Symbol(sym.LITERALPTOFLOTANTE, yychar, yyline, yytext());}
  {DoubleLiteral}                {return new Symbol(sym.LITERALPTOFLOTANTE, yychar, yyline, yytext());}

  /* COMENTARIOS */
  {Comment}                      { /* ignorar */ }

  /* ESPACIO EN BLANCO */
  {WhiteSpace}                   { /* ignorar */ }

  /* IDENTIFICADORES */ 
  {Identifier}                   {return new Symbol(sym.IDENTIFICADOR, yychar, yyline, yytext());}  

<STRING> {
  \"                             {return new Symbol(sym.LITERALSTRING, yychar, yyline, yytext());}
  
  {StringCharacter}+             { string.append( yytext() ); }
  
  /* escape sequences */
  "\\b"                          { string.append( '\b' ); }
  "\\t"                          { string.append( '\t' ); }
  "\\n"                          { string.append( '\n' ); }
  "\\f"                          { string.append( '\f' ); }
  "\\r"                          { string.append( '\r' ); }
  "\\\""                         { string.append( '\"' ); }
  "\\'"                          { string.append( '\'' ); }
  "\\\\"                         { string.append( '\\' ); }
  \\[0-3]?{OctDigit}?{OctDigit}  { char val = (char) Integer.parseInt(yytext().substring(1),8);
                        				   string.append( val ); }
  
  /* error cases */
  \\.                            { linea = yyline+1; System.out.println("Caracter ilegal: " + yytext() + " Linea: " + linea); }
  {LineTerminator}               { linea = yyline+1; System.out.println("Caracter ilegal: " + yytext() + " Linea: " + linea); }
}

. { linea = yyline+1; System.out.println("Caracter ilegal: " + yytext() + " Linea: " + linea);}    
