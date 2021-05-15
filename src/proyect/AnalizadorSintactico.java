/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect;

import java.util.ArrayList;
import java.util.Stack;
import static proyect.Menu.arbolG;


/**
 *
 * @author pao_g
 */
public class AnalizadorSintactico {
    
    ArrayList<Token> listaSintactico;
    Stack pila = new Stack();
    Nodo padreTemporal;
    
    AnalizadorSintactico(ArrayList<Token> lista){
        this.listaSintactico = lista;
    }
    
    public void reccorrido(){
        
        //Inserta raiz al arbol
        if(this.listaSintactico.get(0).getToken().equals("main")){
           Nodo t = arbolG.Insertar(this.listaSintactico.get(0),null);
           padreTemporal = t;
        }
        else {
            error("Error: Iniciar con main",this.listaSintactico.get(0).getLinea());
            return;
        } 
        
        for(int i = 0; i< this.listaSintactico.size(); i++){
            
            
            String tipoT = this.listaSintactico.get(i).getTipoToken();
            String token = this.listaSintactico.get(i).getToken();
            
            switch(tipoT){
                case "Reservadas": 
                    if(token.equals("if")) sentenciaIf(this.listaSintactico.get(i));
                    break;
                
                    
                case "Igual": case "Suma": case "Resta" : case "Multiplicacion": case "Division":  
                    break; 
                    
                case "Identificador": 
                    break;
                    
                case "Numero": 
                    break;  
                    
                case "Salto": 
                    break;    
                    
            }
        }
    }
    
    public void sentenciaIf(Token token){
        
        if(pila.isEmpty()){
           arbolG.Insertar(token, null);
        }
       
    }
    
    public void error(String mensaje, int linea){
        System.out.println(mensaje+ "En linea: " + linea);
    }
    
    
}
