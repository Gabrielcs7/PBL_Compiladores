package lexico;
/**
 *
 * @author Gabriel
 */
public class Operadores {
    
        private boolean eLogico;
        private boolean eAritmetico;

    public boolean iseLogico() {
        return eLogico;
    }

    public boolean iseAritmetico() {
        return eAritmetico;
    }

    public boolean iseRelacional() {
        return eRelacional;
    }
        private boolean eRelacional;
    
    public boolean eOperadorAritmetico (String s){
        
        int estadoAtual = 0;
        char [] caracteres = s.toCharArray();
        int i = 0;
        
        
        while(i < caracteres.length){
            if (estadoAtual == 0){
                if (caracteres[i] == '+'){
                    estadoAtual = 1;
                    eAritmetico = true;
                } else if (caracteres[i] == '*') {
                    estadoAtual = 3;
                    eAritmetico = true;
                } else if (caracteres[i] == '-'){
                    estadoAtual = 4;
                    eAritmetico = true;
                } else if (caracteres[i] == '/'){
                    estadoAtual = 6;
                    eAritmetico = true;
                } else {   
                    eAritmetico = false;
                    return eAritmetico;
                }
            } else if (estadoAtual == 1){
                if (caracteres[i] == '+'){
                    estadoAtual = 2;
                    eAritmetico = true;
                } else {
                    eAritmetico = false;
                    return eAritmetico;
                }
            } else if (estadoAtual == 4){
                estadoAtual = 5;
            } else {
                eAritmetico = false;
                return eAritmetico;
            } 
            
            
            i++;    
        }
        return eAritmetico;
    }
    
    
    public boolean eOperadorLogico (String s){
        
        int estadoAtual = 0;
        char [] caracteres = s.toCharArray();
        int i = 0;
        
        while (i < caracteres.length){
            if (estadoAtual == 0){
                if (caracteres[i] == '!'){
                    estadoAtual = 1;
                    eLogico = true;
                } else if (caracteres[i] == '&'){
                    estadoAtual = 2;
                    eLogico = false;
                } else if (caracteres[i] == '|'){
                    estadoAtual = 4;
                    eLogico = false;
                } else {
                    return false;
                }
            } else if (estadoAtual == 2){
                if (caracteres[i] == '&'){
                    estadoAtual = 3;
                    eLogico = true;
                } else {
                    return false;
                }
            } else if(estadoAtual == 4){
                if (caracteres[i] == '|'){
                    estadoAtual = 5;
                    eLogico = true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
            
           i++; 
        }
        
        
        return eLogico;
    }
    
    
    public boolean eOperadorRelacional (String s){
        int estadoAtual = 0;
        char [] caracteres = s.toCharArray();
        int i = 0;
        while (i < caracteres.length){
            if (estadoAtual == 0){
                if (caracteres[i] == '!'){
                    estadoAtual = 1;
                    eRelacional = false;
                } else if (caracteres[i] == '='){
                    estadoAtual = 3;
                    eRelacional = true;
                } else if (caracteres[i] == '>'){
                    estadoAtual = 5;
                    eRelacional = true;
                } else if (caracteres[i] == '<'){
                    estadoAtual = 7;
                    eRelacional = true;
                } else {
                    return false;
                }
            } else if (estadoAtual == 3){
               if (caracteres[i] == '=') {
                estadoAtual = 4;
                eRelacional = true;
               } else {
                   return false;
               } 
            } else if (estadoAtual == 5){
                if (caracteres[i] == '='){
                    estadoAtual = 6;
                    eRelacional = true;
                } else {
                    return false;
                }   
                 
            } else if (estadoAtual == 7){
               if (caracteres[i] == '='){ 
                 estadoAtual = 8;
                 eRelacional = true;
               }else {
                   return false;
               }
                 
            } else if (estadoAtual == 1){
                if (caracteres[i] == '='){
                    estadoAtual = 2;
                    eRelacional = true;
                } else {
                    return false;
                }        
            } else {
                return false;
            }
             
             i++;
             
         }
        
        return eRelacional;
    }
    
    
}
