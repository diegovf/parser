/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compiler;

/**
 *
 * @author Pablo Mora
 */
public class Linea {
    int linea;
    int cantidad;

    public Linea(int linea, int cantidad) {
        this.linea = linea;
        this.cantidad = cantidad;
    }
    
    public void aumentarCantidad() {
        this.cantidad++;
    }
    
}
