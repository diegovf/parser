/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

/**
 *
 * @author diego
 */

public class MCup{
    public static void main(String[] args){
        String opciones[] = new String[5];
        //Seleccionamos la opción de dirección de destino
        opciones[0] = "-destdir";
        //Le damos la dirección
        opciones[1] = "src\\compiler\\";
        //Seleccionamos la opciónde nombre de archivo
        opciones[2] = "-parser";
        //Le damos el nombre que queremos que tenga
        opciones[3] = "Analizador";
        //Le decimos donde se encuentra el archivo .cup
        opciones[4] = "src\\compiler\\ejemplo.cup";
        try {
            java_cup.Main.main(opciones);
        } catch (Exception e) {
        System.out.print(e);
        }
    }
}