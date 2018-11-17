/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sintatico;

import java.util.ArrayList;
import lexico.Token;

/**
 *
 * @author Gabriel
 */
public class Expressoes {
    
    int estadoAtual = 1;
    
    boolean verifRelacional (ArrayList <Token> lista){
        
       for (int i = 0; i < lista.size(); i++){
           
           String aux = lista.get(i).getNome();
           String auxTipo = lista.get(i).getTipo();
           
            if(estadoAtual == 1){
                if (auxTipo.equals("Numero") || auxTipo.equals("Identificador")){
                    estadoAtual = 2;
                }
            } else if (estadoAtual == 2){
                if (auxTipo.equals("Operador Relacional")){
                    estadoAtual = 3;
                }
            } else if (estadoAtual == 3){
                if (auxTipo.equals("Numero") || auxTipo.equals("Identificador")){
                    estadoAtual = 4;
                }
            } else if (estadoAtual == 4){
                if (aux.equals(";")){
                    return true;
                }
            }
           
       } 
        
        return false;
        
        
    }
    
    void verifLogico (ArrayList <Token> lista){
        
        estadoAtual = 1;
        for (int i = 0; i < lista.size(); i++){
            String aux = lista.get(i).getNome();
            String auxTipo = lista.get(i).getTipo();
            
            if (estadoAtual == 1){
                
                
            } else if (estadoAtual == 2){
                
            } else if (estadoAtual == 3){
                
            } else if (estadoAtual == 4){
                
            }
           
            
            
        }
        
        
    }
    
}
