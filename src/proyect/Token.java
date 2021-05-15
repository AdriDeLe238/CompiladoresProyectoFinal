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
    String Token;
    String tipoToken;
    

    Token(int l, String t, String tipo){
        this.lineaToken = l;
        this.Token = t;
        this.tipoToken = tipo;
    }
    
    public void imprimir(){
        System.out.println(this.lineaToken + " " + this.Token + " " +this.tipoToken);
    }
    
    public String getTipoToken(){
        return this.tipoToken;
    }
    public String getToken(){
        return this.Token;
    }
    public int getLinea(){
        return this.lineaToken;
    }
}
