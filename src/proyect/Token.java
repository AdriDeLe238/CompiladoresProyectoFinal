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
public class Token {
    int lineaToken;
    Tokens Token;
    String tipoToken;
    

    Token(int l, Tokens t, String tipo){
        this.lineaToken = l; //linea del token
        this.Token = t; //tipo del token reservada etc 
        this.tipoToken = tipo; //valor del token
    }
    
  /*  public void imprimir(){
        System.out.println(this.lineaToken + " " + this.Token + " " +this.tipoToken);
    }*/
    
    public String getTipoToken(){
        return this.tipoToken;
    }
    public String getToken(){
        return this.Token.toString();
    }
    public int getLinea(){
        return this.lineaToken;
    }
}
