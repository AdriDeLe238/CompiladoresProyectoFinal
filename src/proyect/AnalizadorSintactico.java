/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect;

import java.util.List;

/**
 *
 * @author Adriana
 */
public class AnalizadorSintactico {
    List<Token> TAll;  
    int i;
    AnalizadorSintactico(){}
    
    AnalizadorSintactico(List<Token> a, int i){
        this.TAll = a; 
        this.i = 0; 
    }
    
    public void match(String expected){
      System.out.println("Si entre al match");
      List<Token> to = this.TAll;
      System.out.println(expected);
      System.out.println(to.get(i).tipoToken);
      System.out.println("i fuera del if"+this.i);
        if(expected.equals(to.get(i).tipoToken)){
            this.i++; 
            System.out.println("i dentro del if "+this.i);

        }else{
            syntaxError("Hubo un error en la sintaxis");
        }
    }
    
    public Nodo parse(){
              System.out.println("Si entre al parse");
        Nodo n = new Nodo();
        n = program();
        /*if ( .val != "FIN"){
           System.out.println("Code ends before file\n");
        }*/
        return n;
    }
    
    public Nodo program(){
        System.out.println("Si entre al program");
        Nodo temp = new Nodo();
        match("program");
        match("{");
        return temp; 
    }
    
    public Nodo SecSentencias(Nodo nodo){
        Nodo n = new Nodo();
        n = Statement(nodo);
        return nodo; 
    }
    
    public Nodo Statement(Nodo nodo){
        Nodo n = new Nodo(); 
        switch(nodo.val){
            case "if": System.out.print("si entro al IF"); break; 
            case "while": System.out.println("si entro al WHILE"); break; 
            case "do": System.out.println("si entro al DO"); break; 
            case "read": System.out.println("si entro al READ"); break; 
            case "write": System.out.println("si entro al WRITE"); break; 
        }
        return n; 
    }
    
    public Nodo if_stmt(){
    //aqui entra si es if
        return null;
    }
    
    public Nodo repeat_stmt(){
    //aqui entra si es repeat
        return null; 
    }
    
    public Nodo assign_stmt(){
    //aqui entra si es asignacion
        return null;
    }
    
    public Nodo read_stmt(){
    //aqui entra si es read
        return null;
    }
    
    public Nodo write_stmt(){
    //aqui entra si es write
        return null;
    }
    
    public Nodo exp(){
    //aqui entra si es expresion
        return null;
    }
    
    public Nodo simple_exp(){
    //aqui entra si es simple expresion
        return null;
    }
    
    public Nodo term(){
    //aqui entra si es termino
        return null;
    }
    
    public Nodo factor(){
    //aqui entra si es factor
        return null;
    }
    
    
        
    public void syntaxError(String mensaje){
         System.out.println(mensaje+" en la linea "+this.TAll.get(i).lineaToken);
    }
}

