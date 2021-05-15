/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect;

/**
 *
 * @author pao_g
 */
public class Nodo {
     Token datos;
     Nodo hijo;
     Nodo hermano;
     
     Nodo(){}
     Nodo(Token dat){this.datos = dat;}
}
