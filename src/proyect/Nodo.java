/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect;

/**
 *
 * @author Adriana
 */

public class Nodo {
    Nodo [] hijos = new Nodo[3]; //partes del token
    Nodo hermanos; //hermano
    int linea; //linea en el que esta el token
    String val; //valor del token ? 
    
    Nodo( Token t ){
        this.hijos = new Nodo[3];
        this.hermanos = null; 
        this.val = t.tipoToken; 
        this.linea = t.lineaToken; 
    }

     Nodo(){ 
        this.hijos = new Nodo[3];
        this.hermanos = null; 
        this.val = null; 
        this.linea = 0;
     }
}
