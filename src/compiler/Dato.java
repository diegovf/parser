/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compiler;

import java.util.ArrayList;

/**
 *
 * @author Pablo Mora
 */
public class Dato {
    String lexeme;
    Token token;
    ArrayList<Linea> lineas = new ArrayList();

    public Dato(String lexeme, Token token, int linea) {
        this.lexeme = lexeme;
        this.token = token;
        this.lineas.add(new Linea(linea, 1));
    }
   
}
