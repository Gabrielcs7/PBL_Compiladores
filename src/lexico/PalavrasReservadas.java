/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexico;

/**
 *
 * @author Gabriel
 */
public class PalavrasReservadas {
    
    private boolean eValido;
    
    public PalavrasReservadas (){
        
    }
    
    public void alteraEValidoTrue (){
        
        eValido = true;
    }
    
    public void alteraEValidoFalse (){
        
        eValido = false;
    }
    
    public boolean getEValido (){
        return eValido;
    }
    
    public boolean verificaReservada (String a){
        
        char [] lista = a.toCharArray();
        int i = 0;
        
        alteraEValidoFalse();
                
        // Verifica se trata-se da palavra reservada "extends"
        while (i < lista.length){
            if (lista[i] == 'e'){
                i++;
                if (lista[i] == 'x'){
                    i++;
                    if (lista[i] == 't'){
                        i++;
                        if (lista[i] == 'e'){
                            i++;
                            if (lista[i] == 'n'){
                                i++;
                                if (lista[i] == 'd'){
                                    i++;
                                    if (lista[i] == 's'){
                                        alteraEValidoTrue();
                                        break;
                                    }
                                    else {
                                    }
                                }
                                else {
                                }
                            }
                            else {
                            }
                        }
                        else {
                        }
                    }
                    else {
                    }
                }
                else {
                }
            }
            else {
            }
        }
        
        // Verifica se trata-se da palavra reservada "false"
        i=0; // Zera o contador
        while (i < lista.length){
            if (lista[i] == 'f'){
                i++;
                if (lista[i] == 'a'){
                    i++;
                    if (lista[i] == 'l'){
                        i++;
                        if (lista[i] == 's'){
                            i++;
                            if (lista[i] == 'e'){
                                alteraEValidoTrue();
                                break;
                                
                            }
                            else {
                            }
                        }
                        else {
                        }
                    }
                    else {
                    }
                }
                else {
                }
            }
            else {
            }
        }
        
        // Verifica se trata-se da palavra reservada "class"
        i=0; // Zera o contador
        while (i < lista.length){
            if (lista[i] == 'c'){
                i++;
                if (lista[i] == 'l'){
                    i++;
                    if (lista[i] == 'a'){
                        i++;
                        if (lista[i] == 's'){
                            i++;
                            if (lista[i] == 's'){
                                alteraEValidoTrue();
                                break;
                            }
                            else {
                            }
                        }
                        else {
                        }
                    }
                    else {
                    }
                }
                else {
                }
            }
            else {
            }
        }
        
        // Verifica se trata-se da palavra reservada "const"
        i=0; // Zera o contador
        while (i < lista.length){
            if (lista[i] == 'c'){
                i++;
                if (lista[i] == 'o'){
                    i++;
                    if (lista[i] == 'n'){
                        i++;
                        if (lista[i] == 's'){
                            i++;
                            if (lista[i] == 't'){
                                alteraEValidoTrue();
                                break;
                            }
                            else {
                            }
                        }
                        else {
                        }
                    }
                    else {
                    }
                }
                else {
                }
            }
            else {
            }
        }
        
        // Verifica se trata-se da palavra reservada "variables"
        i=0; // Zera o contador
        while (i < lista.length){
            if (lista[i] == 'v'){
                i++;
                if (lista[i] == 'a'){
                    i++;
                    if (lista[i] == 'r'){
                        i++;
                        if (lista[i] == 'i'){
                            i++;
                            if (lista[i] == 'a'){
                                i++;
                                if (lista[i] == 'b'){
                                    i++;
                                    if (lista[i] == 'l'){
                                        i++;
                                        if (lista[i] == 'e'){
                                            i++;
                                            if (lista[i] == 's'){
                                                alteraEValidoTrue();
                                                break;
                                            }
                                            else {
                                            }
                                        }
                                        else {
                                        }
                                    }
                                    else {
                                    }
                                }
                                else {
                                }
                            }
                            else {
                            }
                        }
                        else {
                        }
                    }
                    else {
                    }
                }
                else {
                }
            }
            else {
            }
        }
        
        // Verifica se trata-se da palavra reservada "method"
        i=0; // Zera o contador
        while (i < lista.length){
            if (lista[i] == 'm'){
                i++;
                if (lista[i] == 'e'){
                    i++;
                    if (lista[i] == 't'){
                        i++;
                        if (lista[i] == 'h'){
                            i++;
                            if (lista[i] == 'o'){
                                i++;
                                if (lista[i] == 'd'){
                                    alteraEValidoTrue();
                                    break;
                                }
                                else {
                                }
                            }
                            else {
                            }
                        }
                        else {
                        }
                    }
                    else {
                    }
                }
                else {
                }
            }
            else {
            }
        }
        
        // Verifica se trata-se da palavra reservada "return"
        i=0; // Zera o contador
        while (i < lista.length){
            if (lista[i] == 'r'){
                i++;
                if (lista[i] == 'e'){
                    i++;
                    if (lista[i] == 't'){
                        i++;
                        if (lista[i] == 'u'){
                            i++;
                            if (lista[i] == 'r'){
                                i++;
                                if (lista[i] == 'n'){
                                    alteraEValidoTrue();
                                    break;
                                }
                                else {
                                }
                            }
                            else {
                            }
                        }
                        else {
                        }
                    }
                    else {
                    }
                }
                else {
                }
            }
            else {
            }
        }
        
        // Verifica se trata-se da palavra reservada "main"
        i=0; // Zera o contador
        while (i < lista.length){
            if (lista[i] == 'm'){
                i++;
                if (lista[i] == 'a'){
                    i++;
                    if (lista[i] == 'i'){
                        i++;
                        if (lista[i] == 'n'){
                            alteraEValidoTrue();
                            break;
                        }
                        else {
                        }
                    }
                    else {
                    }
                }
                else {
                }
            }
            else {
            }
        }
        
        // Verifica se trata-se da palavra reservada "if"
        i=0; // Zera o contador
        while (i < lista.length){
            if (lista[i] == 'i'){
                i++;
                if (lista[i] == 'f'){
                    alteraEValidoTrue();
                    break;
                }
                else {
                }
            }
            else {
            }
        }
        
        // Verifica se trata-se da palavra reservada "then"
        i=0; // Zera o contador
        while (i < lista.length){
            if (lista[i] == 't'){
                i++;
                if (lista[i] == 'h'){
                    i++;
                    if (lista[i] == 'e'){
                        i++;
                        if (lista[i] == 'n'){
                            alteraEValidoTrue();
                            break;
                        }
                        else {
                        }
                    }
                    else {
                    }
                }
                else {
                }
            }
            else {
            }
        }
        
        // Verifica se trata-se da palavra reservada "else"
        i=0; // Zera o contador
        while (i < lista.length){
            if (lista[i] == 'e'){
                i++;
                if (lista[i] == 'l'){
                    i++;
                    if (lista[i] == 's'){
                        i++;
                        if (lista[i] == 'e'){
                            alteraEValidoTrue();
                            break;
                        }
                        else {
                        }
                    }
                    else {
                    }
                }
                else {
                }
            }
            else {
            }
        }
        
        // Verifica se trata-se da palavra reservada "while"
        i=0; // Zera o contador
        while (i < lista.length){
            if (lista[i] == 'w'){
                i++;
                if (lista[i] == 'h'){
                    i++;
                    if (lista[i] == 'i'){
                        i++;
                        if (lista[i] == 'l'){
                            i++;
                            if (lista[i] == 'e'){
                                alteraEValidoTrue();
                                break;
                            }
                            else {
                            }
                            
                        }
                        else {
                        }
                    }
                    else {
                    }
                }
                else {
                }
            }
            else {
            }
        }
        
        // Verifica se trata-se da palavra reservada "read"
        i=0; // Zera o contador
        while (i < lista.length){
            if (lista[i] == 'r'){
                i++;
                if (lista[i] == 'e'){
                    i++;
                    if (lista[i] == 'a'){
                        i++;
                        if (lista[i] == 'd'){
                            alteraEValidoTrue();
                            break;
                        }
                        else {
                        }
                    }
                    else {
                    }
                }
                else {
                }
            }
            else {
            }
        }
        
        // Verifica se trata-se da palavra reservada "write"
        i=0; // Zera o contador
        while (i < lista.length){
            if (lista[i] == 'w'){
                i++;
                if (lista[i] == 'r'){
                    i++;
                    if (lista[i] == 'i'){
                        i++;
                        if (lista[i] == 't'){
                            i++;
                            if (lista[i] == 'e'){
                                alteraEValidoTrue();
                                break;
                            }
                            else {
                            }
                            
                        }
                        else {
                        }
                    }
                    else {
                    }
                }
                else {
                }
            }
            else {
            }
        }
        
        // Verifica se trata-se da palavra reservada "void"
        i=0; // Zera o contador
        while (i < lista.length){
            if (lista[i] == 'v'){
                i++;
                if (lista[i] == 'o'){
                    i++;
                    if (lista[i] == 'i'){
                        i++;
                        if (lista[i] == 'd'){
                            alteraEValidoTrue();
                            break;
                        }
                        else {
                        }
                    }
                    else {
                    }
                }
                else {
                }
            }
            else {
            }
        }
        
        // Verifica se trata-se da palavra reservada "float"
        i=0; // Zera o contador
        while (i < lista.length){
            if (lista[i] == 'f'){
                i++;
                if (lista[i] == 'l'){
                    i++;
                    if (lista[i] == 'o'){
                        i++;
                        if (lista[i] == 'a'){
                            i++;
                            if (lista[i] == 't'){
                                alteraEValidoTrue();
                                break;
                            }
                            else {
                            }
                            
                        }
                        else {
                        }
                    }
                    else {
                    }
                }
                else {
                }
            }
            else {
            }
        }
        
        // Verifica se trata-se da palavra reservada "void"
        i=0; // Zera o contador
        while (i < lista.length){
            if (lista[i] == 'b'){
                i++;
                if (lista[i] == 'o'){
                    i++;
                    if (lista[i] == 'o'){
                        i++;
                        if (lista[i] == 'l'){
                            alteraEValidoTrue();
                            break;
                        }
                        else {
                        }
                    }
                    else {
                    }
                }
                else {
                }
            }
            else {
            }
        }
        
        // Verifica se trata-se da palavra reservada "string"
        i=0; // Zera o contador
        while (i < lista.length){
            if (lista[i] == 's'){
                i++;
                if (lista[i] == 't'){
                    i++;
                    if (lista[i] == 'r'){
                        i++;
                        if (lista[i] == 'i'){
                            i++;
                            if (lista[i] == 'n'){
                                i++;
                                if (lista[i] == 'g'){
                                    alteraEValidoTrue();
                                    break;
                                }
                                else {
                                }
                            }
                            else {
                            }
                        }
                        else {
                        }
                    }
                    else {
                    }
                }
                else {
                }
            }
            else {
            }
        }
        
        // Verifica se trata-se da palavra reservada "true"
        i=0; // Zera o contador
        while (i < lista.length){
            if (lista[i] == 't'){
                i++;
                if (lista[i] == 'r'){
                    i++;
                    if (lista[i] == 'u'){
                        i++;
                        if (lista[i] == 'e'){
                            alteraEValidoTrue();
                            break;
                        }
                        else {
                        }
                    }
                    else {
                    }
                }
                else {
                }
            }
            else {
            }
        }
        return getEValido();
    }
    
    public boolean verifReservada (String a){
        if (a.equals("const") || a.equals("variables") || a.equals("class") || a.equals("method") || a.equals("return") || a.equals("main")
               || a.equals("if") || a.equals ("then") || a.equals ("else") || a.equals ("while") || a.equals ("read") 
                || a.equals ("void") || a.equals ("int") || a.equals ("float") || a.equals ("bool") || a.equals ("string") || a.equals ("true")
                || a.equals ("false") || a.equals ("extends")){
            return true;
        } else {
            return false;
        }
    }
}
