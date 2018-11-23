
package sintatico;

import java.util.List;
import lexico.Token;

public class Regras2 {
    Regras regras = new Regras();
    public int [] atrib (List <Token> lista){
        
        int [] retorno = new int [2];
        int estado = 1;
        
        for (int i = 0; i < lista.size(); i++){
            Token aux = lista.get(i);
            if (estado == 1){
                if (aux.getNome().equals("id")){
                    estado = 2;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 2){
                if (aux.getNome().equals(".")){
                    estado = 3;
                } else if (aux.getNome().equals("(")){
                    estado = 4;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 3){
                if (aux.getNome().equals("id")){
                    estado = 6;
                    retorno[0] = 1;
                    retorno[1] = i;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 4){
                if (regras.expression(lista)[0] == 1){
                    estado = 5;
                }  else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 5){
                if (aux.getNome().equals(")")){
                    estado = 6;
                    retorno[0] = 1;
                    retorno[1] = i;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 6){
                if (aux.getNome().equals("(")){
                    estado = 4;
                } else {
                    retorno[0] = 1;
                    retorno[1] = i;
                    return retorno;
                }
            }
            
        }
        return retorno;
    }
    
    public int [] increment (List <Token> lista){
        
        int retorno [] = new int[2];
        int estado = 1;
        
        for (int i = 0; i < lista.size(); i++){
            Token aux = lista.get(i);
            if (estado == 1){
                if (aux.getTipo().equals("Identificador") || aux.getTipo().equals("Numero")){
                    estado = 2;
                    retorno[0] = 1;
                    retorno[1] = i;
                }else if (aux.getNome().equals("++")|| aux.getNome().equals("--")){
                    estado = 3;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 2){
                if (aux.getNome().equals("++")|| aux.getNome().equals("--")){
                    estado = 4;
                    retorno[0] = 1;
                    retorno[1] = i;
                    return retorno;
                } else {
                    retorno[0] = 1;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 3){
                if (aux.getTipo().equals("Identificador") || aux.getTipo().equals("Numero")){
                    estado = 4;
                    retorno[0] = 1;
                    retorno[1] = i;
                    return retorno;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } 
        }
        
        return retorno;
    }
    
    public int [] atribuition (List <Token> lista){
        
        int retorno[] = new int [2];
        int estado = 1;
        
        for (int i = 0; i < lista.size(); i++){
            Token aux = lista.get(i);
            if (estado == 1){
                if (aux.getNome().equals("int") || aux.getNome().equals("float") || aux.getNome().equals("bool") || aux.getNome().equals("string")){
                    estado = 2;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 2){
                if (aux.getTipo().equals("Identificador")){
                    estado = 3;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 3){
                if (aux.getNome().equals("=")){
                    estado = 4;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 4){
                List<Token> sublista = lista.subList(i, (lista.size())); 
                int numero = regras.expression(sublista)[0];
                int numero1 = this.atrib(sublista)[0];
                int numero2 = this.increment(sublista)[0];
                
                if (aux.getTipo().equals("Cadeia de caracteres") || aux.getNome().equals("true") || aux.getNome().equals("false") 
                       || numero == 1 || numero1 == 1 || numero2 == 1){
                    estado = 5;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if(estado == 5){
                if (aux.getNome().equals(";")){
                    retorno[0] = 1;
                    retorno[1] = i;
                    return retorno;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            }
        }
        return retorno;
    }
    
        
}
