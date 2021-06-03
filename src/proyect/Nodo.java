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
    //String name; //lexema ?
    
    Nodo(){
             this.hijos = new Nodo[3]; 
    }

     Nodo(Nodo [] hijos, Nodo hermano, int line, String val){
         this.hijos = hijos; 
         this.hermanos = hermano; 
         this.linea = line;
         this.val = val;
         //this.name = name; 
     }
}

/*typedef struct treeNode
   { struct treeNode * child[MAXCHILDREN];
     struct treeNode * sibling;
     int lineno;
     NodeKind nodekind;
     union { StmtKind stmt; ExpKind exp;} kind;
     union { TokenType op;
             int val;
             char * name; } attr;
     ExpType type; /* for type checking of exps */
 /*  } TreeNode;*/
