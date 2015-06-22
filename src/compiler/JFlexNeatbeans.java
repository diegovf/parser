/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.io.File;
import jasmin.parser;

/**
 *
 * @author diego
 */


public class JFlexNeatbeans {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String path = "src/compiler/Lexer.flex";
        
        generarLexer(path);
    }
    
    public static void generarLexer(String path){
        File file = new File(path);
        jflex.Main.generate(file);
    }
    
}
