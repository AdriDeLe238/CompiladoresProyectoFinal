/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect;

import java.io.File;

/**
 *
 * @author HP-PC
 */
public class Principal {
    public static void main(String[] args) {
        String ruta = "C:/Users/HP-PC/Documents/ISC 8A/Compiladores/Proyecto/CompiladoresProyectoFinal/src/Proyect/lexic.flex";
        generarLexer(ruta);
    }
    public static void generarLexer(String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
}
