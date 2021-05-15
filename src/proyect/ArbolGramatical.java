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
public class ArbolGramatical {

    public Nodo raiz;
    private Nodo trabajo;
    private int i = 0;

    public ArbolGramatical() {
        raiz = new Nodo();
    }
    

    public Nodo Insertar(Token pDato, Nodo pNodo) {
        //si no hay nodo donde insertar , tomamos como si fuera en la raiz
        
        if (pNodo == null) {
            raiz = new Nodo();
            raiz.datos = pDato;
            //no hay hijo
            raiz.hijo = null;

            raiz.hermano = null;
            return raiz;
        }
        if (pNodo.hijo == null) {
            Nodo temp = new Nodo();
            temp.datos = pDato;
            //conectamos el nuevo nodo como hijo
            pNodo.hijo = temp;
            return temp;
        } else {//si ya tiene hijos se pone como hermano
            trabajo = pNodo.hijo;
            while (trabajo.hermano != null) {
                trabajo = trabajo.hermano;
            }
            Nodo temp = new Nodo();
            temp.datos = pDato;
            trabajo.hermano = temp;
            return temp;

        }

    }

   public void imprimir(Nodo pNodo) {
        
        if (pNodo == null) {
            return;
        }
        for (int n = 0; n < i; n++) {
            System.out.print("            ");
        }

        pNodo.datos.imprimir();
        //luego proceso a mi hijo
        if (pNodo.hijo != null) {
            i++;
            imprimir(pNodo.hijo);
            i--;
        }
        if (pNodo.hermano != null) {
            imprimir(pNodo.hermano);
        }
    }
}
