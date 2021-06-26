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
    String error; 
    Token actual; 
    AnalizadorSintactico(){}
    
    AnalizadorSintactico(List<Token> a, int i){
        this.TAll = a; 
        this.i = 0; 
        this.actual = this.TAll.get(this.i);
    }
    
    public void match(String expected){
         System.out.println("tipotoken" + this.actual.tipoToken);
         System.out.println("TOKEN " + this.actual.getToken());
         System.out.println("expected " + expected);
         if(expected.equals(this.actual.getTipoToken())){
            this.i++; 
        if(this.i < this.TAll.size()){
            this.actual = this.TAll.get(this.i);
            }
        }else if(expected.equals(this.actual.getToken())){
              this.i++; 
              if(this.i < this.TAll.size()){ 
                this.actual = this.TAll.get(this.i);
                System.out.println("i dentro del if "+this.i);
              }
        }else{
            syntaxError("Hubo un error"); 
        }
    }
   
    public Nodo program(){
        //System.out.println("Si entre al program");
        Nodo n = new Nodo(this.actual);
        match("program");
        match("{");
        n.hijos[0] = lista_declaracion(); 
        n.hijos[1] = lista_sentencia();
        match("}");
        return n; 
    }
    
     public Nodo lista_declaracion(){
         Nodo n = null; 
         Nodo sig = null; 
         while("int".equals(this.actual.tipoToken) || "float".equals(this.actual.tipoToken) || "bool".equals(this.actual.tipoToken)){
            if( n == null){
                n = declaracion();
                sig = n; 
            }else{
               Nodo nn = new Nodo(); 
               nn = declaracion(); 
               sig.hermanos = nn;
               sig = nn; 
            }
         }
         return n; 
     }
    
    public Nodo declaracion(){
        System.out.println("tipotoken" + this.actual.tipoToken);
        Nodo n = new Nodo(); 
        n = tipo(); 
        n.hijos[0] = lista_id(); 
        return n ; 
    }
    
    public Nodo tipo(){
        System.out.println("tipotoken en tipo " + this.actual.tipoToken);
        Nodo n = new Nodo(this.actual); 
        System.out.println("tipotoken" + this.actual.tipoToken);
        //String t = this.actual.tipoToken;
        switch(this.actual.tipoToken){
            case "int" : match("int"); break; 
            case "float": match("float"); break; 
            case "bool": match("bool"); break; 
            default: 
                syntaxError("Hubo un error en tipo "); break; 
        }
        return n; 
    }
    
    public Nodo lista_id (){
        Nodo n = new Nodo(this.actual);
        Nodo sig = n; 
        match("Identificador"); 
        while(",".equals(this.actual.tipoToken)){
            match(","); 
            Nodo nn = new Nodo(this.actual); 
            match("Identificador"); 
            sig.hermanos = nn; 
            sig = nn; 
        }
        match(";");
        return n; 
    }
    
     public Nodo lista_sentencia(){
         Nodo n = new Nodo(); 
         Nodo sig = new Nodo(); 
         while("if".equals(this.actual.tipoToken) || "while".equals(this.actual.tipoToken) || "do".equals(this.actual.tipoToken) ||
                 "read".equals(this.actual.tipoToken) || "write".equals(this.actual.tipoToken) || "{".equals(this.actual.tipoToken) ||
                 "Identificador".equals(this.actual.tipoToken)){
            if( n == null){
                n = sentencia();
                sig = n; 
            }else{
               Nodo nn = new Nodo(); 
               nn = sentencia(); 
               sig.hermanos = nn;
               sig = nn; 
            }
         }
         return n; 
     }
     
    public Nodo sentencia(){
        Nodo n = new Nodo(); 
        switch(this.actual.tipoToken){
            case "if": n = seleccion();  break; 
            case "while":  n = iteracion(); break; 
            case "do":  n = repeticion(); break; 
            case "read": n = sent_read(); break; 
            case "write": n = sent_write();  break; 
            case "{": n =  bloque();  break; 
            case "Identificador": n = asignacion();  break; 
            default:  
                syntaxError("Hubo un error ");
        }
        return n; 
    }
    
    public Nodo seleccion(){
        Nodo n = new Nodo(this.actual);
        match("if");
        match("("); 
        n.hijos[0] = b_expresion(); 
        match(")"); 
        match("then"); 
        n.hijos[1] = bloque(); 
        if("else".equals(this.actual.tipoToken)){
            match("else"); 
            n.hijos[2] = bloque(); 
        }
        match("fi"); 
        return n;
    }
    
    public Nodo iteracion(){
        Nodo n = new Nodo(this.actual);
        match("while"); 
        match("("); 
        n.hijos[0] = b_expresion(); 
        match(")");
        n.hijos[1] = bloque(); 
        return n;
    }
    
    public Nodo repeticion(){
        Nodo n = new Nodo(this.actual);
        match("do");
        n.hijos[0] = bloque(); 
        match("until");
        match("(");
        n.hijos[1] = b_expresion();
        match(")"); 
        match(";"); 
        return n;
    }
    
    public Nodo sent_read(){
        Nodo n = new Nodo(this.actual); 
        match("read"); 
        n.hijos[0] = new Nodo(this.actual); 
        match("Identificador"); 
        match(";");
        return n; 
    }
    
    public Nodo sent_write(){
        Nodo n = new Nodo(this.actual); 
        match("write"); 
        n.hijos[0] = b_expresion(); 
        match(";");
        return n; 
    }
    
    public Nodo bloque(){
        Nodo n = new Nodo(); 
        match("{");
        n = lista_sentencia(); 
        match("}");
        return n;
    }
    
    public Nodo asignacion(){
        Nodo n = new Nodo();
        n.val = "asignacion";
        n.hijos[0] = new Nodo(this.actual);
        match("Identificador"); 
        match("="); 
        n.hijos[1] = b_expresion(); 
        match(";");
        return n;
    }
    
    public Nodo b_expresion(){
    Nodo n = btermino();
    while("OR".equals(this.actual.tipoToken)){
        Nodo temp = new Nodo(this.actual); 
        match("OR"); 
        temp.hijos[0] = n;
        temp.hijos[1] = btermino(); 
        n = temp; 
    }
        return n;
    }
    
    public Nodo btermino(){
    Nodo n = notfactor();
    while("AND".equals(this.actual.tipoToken)){
        Nodo temp = new Nodo(this.actual); 
        match("AND"); 
        temp.hijos[0] = n;
        temp.hijos[1] = notfactor(); 
        n = temp; 
    }
        return n;
    }
    
    public Nodo notfactor(){
       Nodo n = null; 
       if("NOT".equals(this.actual.tipoToken)){
           n = new Nodo(this.actual); 
               match("NOT");
               n.hijos[0] = bfactor(); 
       }else{
          n = bfactor(); 
       }
       return n; 
    }
    
    public Nodo bfactor(){
       Nodo n = null; 
       if("true".equals(this.actual.tipoToken) || "false".equals(this.actual.tipoToken)){
           n = new Nodo(this.actual); 
           if("true".equals(this.actual.tipoToken)){
               match("true");
           }else if("false".equals(this.actual.tipoToken)){
               match("false");
           }
       }else{
          n = relacion(); 
       }
       return n; 
    }
    
    public Nodo relacion(){
        Nodo n = expresion();
        if("<=".equals(this.actual.tipoToken) || "<".equals(this.actual.tipoToken) || ">".equals(this.actual.tipoToken) || ">=".equals(this.actual.tipoToken)
           || "==".equals(this.actual.tipoToken) || "!=".equals(this.actual.tipoToken)){
            Nodo temp = new Nodo();
            temp = relop(); 
            n.hijos[0] = temp; 
            n.hijos[1] = expresion();
            n = temp; 
        }
        return n; 
    }
    
    public Nodo relop(){
        Nodo n = new Nodo(this.actual); 
        switch(this.actual.tipoToken){
            case "<=": match("<="); break;
            case "<": match("<"); break; 
            case ">": match(">"); break; 
            case ">=": match(">="); break; 
            case "==": match("=="); break;
            case "!=": match("!="); break; 
            default: syntaxError("Hubo un error ");  break; 
        }
        return n; 
    }
    
    public Nodo expresion(){
      Nodo n =  termino();
       while("+".equals(this.actual.tipoToken) || "-".equals(this.actual.tipoToken)){
        Nodo temp = new Nodo();
        temp = sumaop();
        n.hijos[0] = temp;
        n.hijos[1] = termino();
        n = temp; 
      }
      return n; 
    }
    
    public Nodo sumaop(){
      Nodo n = new Nodo(this.actual);
      if("+".equals(this.actual.tipoToken)){
          match("+");
      }else if("-".equals(this.actual.tipoToken)){
          match("-");
      }else{
          syntaxError("Hubo un error ");  
      }
      return n; 
    }
    
    public Nodo termino(){
       Nodo n = SignoFactor();
       while("*".equals(this.actual.tipoToken) || "/".equals(this.actual.tipoToken)){
           Nodo temp = new Nodo();
           temp = multop();
           n.hijos[0] = temp;
           n.hijos[1] = SignoFactor();
           n = temp; 
       }
       return n;
    }
    
    public Nodo multop(){
      Nodo n = new Nodo(this.actual);
      if("*".equals(this.actual.tipoToken)){
          match("*");
      }else if("/".equals(this.actual.tipoToken)){
          match("/");
      }else{
          syntaxError("Hubo un error ");  
      }
      return n; 
    }
    
    public Nodo SignoFactor(){
        Nodo n = new Nodo();
        if("+".equals(this.actual.tipoToken) || "-".equals(this.actual.tipoToken)){
            n=sumaop();
            n.hijos[0] = factor(); 
        }else{
           n = factor();  
        }
        return n;
    }
    
    public Nodo factor(){
        //gramatica: factor → ”(” b-expresión ”)” | numero | identificador 
        Nodo n = new Nodo();
        switch(this.actual.Token){
            case abreparentesis: 
             match("(");
             n = b_expresion(); 
             match(")");
             break; 
            case Numero: 
             n = new Nodo(this.actual);
             match("Numero"); 
            break; 
            case Identificador: 
            n = new Nodo(this.actual);    
            break;
            default: 
            syntaxError("Hubo un error ");  
        }
        return n;
    }
    
    
        
    public void syntaxError(String mensaje){
         this.error = mensaje+" en la linea "+this.actual.lineaToken; 
    }
}

