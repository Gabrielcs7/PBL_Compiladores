
package sintatico;

import java.util.ArrayList;
import java.util.List;
import lexico.Token;

public class Regras2 {
    Regras regras = new Regras();
    
    public int [] atrib (List <Token> lista, ArrayList <Token> errosSintaticos){
        
        int [] retorno = new int [2];
        int estado = 1;
        
        for (int i = 0; i < lista.size(); i++){
            Token aux = lista.get(i);
            if (estado == 1){
                if (aux.getTipo().equals("Identificador")){
                    estado = 2;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
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
                    errosSintaticos.add(lista.get(i));
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
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 4){
                List<Token> sublista = lista.subList(i, (lista.size())); 
                int aux1 [] = new int[2];
                aux1 = this.expMethod(sublista);
                if (aux1[0] == 1){
                    estado = 5;
                    
                    
                } 
                i = aux1[1] + i;
            } else if (estado == 5){
                if (aux.getNome().equals(")")){
                    estado = 6;
                    retorno[0] = 1;
                    retorno[1] = i;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
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
    
    public int [] increment (List <Token> lista, ArrayList <Token> errosSintaticos){
        
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
                    errosSintaticos.add(lista.get(i));
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
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } 
        }
        
        return retorno;
    }
    
    public int [] atribuition (List <Token> lista, ArrayList <Token> errosSintaticos){
        
        int retorno[] = new int [2];
        int estado = 2;
        
        for (int i = 0; i < lista.size(); i++){
            Token aux = lista.get(i);
             if (estado == 2){
                if (aux.getTipo().equals("Identificador")){
                    estado = 3;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 3){
                if (aux.getNome().equals("=")){
                    estado = 4;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
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
                    errosSintaticos.add(lista.get(i));
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
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            }
        }
        return retorno;
    }
    
    public int [] expMethod (List <Token> lista, ArrayList <Token> errosSintaticos){
        
        int retorno[] = new int [2];
        int estado = 1;
        
        for (int i = 0; i < lista.size(); i++){
            Token aux = lista.get(i);
            if (estado == 1){
                List<Token> sublista = lista.subList(i, (lista.size())); 
                int aux1 [] = new int[2];
                aux1 = this.atrib(sublista);
                if (aux1[0] == 1){
                    estado = 2;
                    retorno[0] = 1;
                    retorno[1] = i;
                   
                 
                }
                 i = aux1[1] + i;
            } else if (estado == 2){
                if (aux.getNome().equals(",")){
                    estado = 1;
                } else {
                    retorno[0] = 1;
                    retorno[1] = i;
                    return retorno;
                }
            }
        }
        
        return retorno;
    }
    
    public int [] expMethod2(List <Token> lista, ArrayList <Token> errosSintaticos){
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
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            }else if (estado == 2){
                if (aux.getTipo().equals("Identificador")){
                    estado = 3;
                    retorno[0] = 1;
                    retorno[1] = i;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            }else if (estado == 3){
                if (aux.getNome().equals("[")){
                    List<Token> sublista = lista.subList(i, (lista.size())); 
                    int aux1 [] = new int[2];
                    aux1 = this.arrayVerification(sublista);
                    if (aux1[0] == 1){
                        estado = 3;
                        
                        
                    }
                    i = aux1[1] + i;
                } else if(aux.getNome().equals(",")){
                    estado = 1;
                }else {
                    retorno[0] = 1;
                    retorno[1] = i;
                    return retorno;
                }
            }
        }
        
        return retorno;
    }
    
    public int [] method (List <Token> lista, ArrayList <Token> errosSintaticos){
         int retorno[] = new int [2];
        int estado = 1;
        
        for (int i = 0; i < lista.size(); i++){
            Token aux = lista.get(i);
            if (estado == 1){
                if (aux.getNome().equals("method")){
                    estado = 2;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 2){
                if (aux.getNome().equals("int") || aux.getNome().equals("bool") || aux.getNome().equals("float") || aux.getNome().equals("string")
                        || aux.getNome().equals("void")){
                    estado = 3;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 3){
                if (aux.getTipo().equals("Identificador")){
                    estado = 4;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 4){
                if (aux.getNome().equals("(")){
                    estado = 2;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 5){
                List<Token> sublista = lista.subList(i, (lista.size())); 
                int aux1 [] = new int[2];
                aux1 = this.expMethod2(sublista);
                if (aux1[0] == 1){
                    estado = 6;
                    
                  
                } 
                i = aux1[1] + i;
            } else if (estado == 6){
                 if (aux.getNome().equals(")")){
                    estado = 7;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            }else if (estado == 7){
                if (aux.getNome().equals("{")){
                    estado = 8;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            }else if (estado == 8){
                List<Token> sublista = lista.subList(i, (lista.size())); 
                int aux1 [] = new int[2];
                aux1 = this.variable(sublista);
                if (aux1[0] == 1){
                    estado = 9;
                    
                } 
                i = aux1[1] + i;
            }else if (estado == 9){
                List<Token> sublista = lista.subList(i, (lista.size())); 
                int aux1 [] = new int[2];
                aux1 = regras.commands(sublista);
                if (aux1[0] == 1){
                    estado = 10;
                    
                } 
                i = aux1[1] + i;
            } else if (estado == 10){
                if (aux.getNome().equals("}")){
                    retorno[0] = 1;
                    retorno[1] = i;
                    return retorno;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            }
        }
        
        return retorno;
    }
    
    public int [] variablesDeclaration (List <Token> lista, ArrayList <Token> errosSintaticos){
     
        int retorno[] = new int [2];
        int estado = 1;
        
        for (int i = 0; i < lista.size();i++){
            Token aux = lista.get(i);
            
            if (estado == 1){
                if (aux.getNome().equals("int") || aux.getNome().equals("bool") || aux.getNome().equals("float") || aux.getNome().equals("string") || aux.getTipo().equals("Identificador")){
                    estado = 2;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 2){
                if (aux.getTipo().equals("Identificador")){
                    estado = 3;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 3){
                if (aux.getNome().equals(",")){
                    estado = 2;
                } else if (aux.getNome().equals("[")){
                    estado = 4;
                } else if (aux.getNome().equals(";")){
                    retorno[0] = 1;
                    retorno[1] = i;
                    return retorno;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 4){
                List<Token> sublista = lista.subList(i, (lista.size())); 
                    int aux1 [] = new int[2];
                    aux1 = this.arrayVerification(sublista);
                    if (aux1[0] == 1){
                        estado = 3;
                    }
                    i = aux1[1] + i;
            } 
        }
        
        return retorno;
    }
    
    public int [] variable (List <Token> lista, ArrayList <Token> errosSintaticos){
     
        int retorno[] = new int [2];
        int estado = 1;
        for (int i = 0; i < lista.size(); i++){
            Token aux = lista.get(i);
            if (estado == 1){
                if (aux.getNome().equals("variables")){
                    estado = 2;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 2){
                if (aux.getNome().equals("{")){
                    estado = 3;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            }else if (estado == 3){
                if (aux.getNome().equals("int") || aux.getNome().equals("float") || aux.getNome().equals("bool") || aux.getNome().equals("string")){
                    List<Token> sublista = lista.subList(i, (lista.size())); 
                    int aux1 [] = new int[2];
                    aux1 = this.variablesDeclaration(sublista);
                    if (aux1[0] == 1){
                         estado = 3;
                    } 
                    i = aux1[1] + i;
                }else if (aux.getNome().equals("}")){
                    retorno[0] = 1;
                    retorno[1] = i;
                    return retorno;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
                
            } 
        }
        return retorno;
    }
    
    public int [] arrayVerification (List <Token> lista, ArrayList <Token> errosSintaticos){
     
        int retorno[] = new int [2];
        int estado = 1;
        for (int i = 0; i < lista.size(); i++){
            Token aux = lista.get(i);
            
            if (estado == 1){
                if (aux.getNome().equals("[")){
                    estado = 2;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 2){
                
                    List<Token> sublista = lista.subList(i, (lista.size())); 
                    int aux1 [] = new int[2];
                    
                    if (aux.getNome().equals("++") || aux.getNome().equals("--")){
                        aux1 = this.increment(sublista);
                    } else{
                        aux1 = this.addExp(sublista);
                    }
                    i = aux1[1] + i;
                    
                    if (aux1[0] == 1){
                        estado = 3;
                    } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 3){
                if (aux.getNome().equals("]")){
                    estado = 4;
                    retorno[0] = 1;
                    retorno[1] = i;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 4){
                if (aux.getNome().equals("[")){
                    estado = 2;
                } else {
                    retorno[0] = 1;
                    retorno[1] = i;
                    return retorno;
                }
            }
            
            
        }
        
        
        return retorno;
    }
    
    
    public int [] constAttr (List <Token> lista, ArrayList <Token> errosSintaticos){
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
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 2){
                if (aux.getTipo().equals("Identificador")){
                    estado = 3;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 3){
                if (aux.getNome().equals("=")){
                    estado = 4;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 4){
                if (aux.getTipo().equals("Cadeia de caracteres") || aux.getNome().equals("true") || aux.getNome().equals("false") 
                       || aux.getTipo().equals("Numero")){
                    estado = 5;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if(estado == 5){
                if (aux.getNome().equals(";")){
                    retorno[0] = 1;
                    retorno[1] = i;
                    return retorno;
                } else if (aux.getNome().equals(",")){
                    estado = 2;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            }
        }
        
        return retorno;
    }
    
     public int [] constBlock (List <Token> lista, ArrayList <Token> errosSintaticos){
        int retorno[] = new int [2];
        int estado = 1;
        
        for (int i = 0; i < lista.size(); i++){
            Token aux = lista.get(i);
            if (estado == 1){
                if (aux.getNome().equals("const")){
                    estado = 2;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 2){
                if (aux.getNome().equals("{")){
                    estado = 3;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            }else if (estado == 3){
                if (aux.getNome().equals("int") || aux.getNome().equals("float") || aux.getNome().equals("bool") || aux.getNome().equals("string")){
                    List<Token> sublista = lista.subList(i, (lista.size())); 
                    int aux1 [] = new int[2];
                    aux1 = this.constAttr(sublista);
                    if (aux1[0] == 1){
                         estado = 3;
                        
                    } 
                    i = aux1[1] + i;
                }else if (aux.getNome().equals("}")){
                    retorno[0] = 1;
                    retorno[1] = i;
                    return retorno;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
                
            } 
        }
        
        return retorno;
    }
    
     public int [] addExp (List <Token> lista, ArrayList <Token> errosSintaticos){
     
        int retorno[] = new int [2];
        int estado = 1;
        for (int i = 0; i < lista.size(); i++){
            Token aux = lista.get(i);
            
            if (estado == 1){
                if (aux.getTipo().equals("Identificador") || aux.getTipo().equals("Numero")){
                    estado = 2;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 2){
                if (aux.getNome().equals("+") || aux.getNome().equals("-") || aux.getNome().equals("*") || aux.getNome().equals("/")){
                    estado = 3;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 3){
                if (aux.getTipo().equals("Identificador") || aux.getTipo().equals("Numero")){
                    estado = 4;
                    retorno[0] = 1;
                    retorno[1] = i;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 4){
                if (aux.getNome().equals("+") || aux.getNome().equals("-") || aux.getNome().equals("*") || aux.getNome().equals("/")){
                    estado = 3;
                } else{
                    retorno[0] = 1;
                    retorno[1] = i;
                    return retorno;
                }
            }   
        }
        return retorno;
    }
     
     
    public int [] classBlock (List <Token> lista, ArrayList <Token> errosSintaticos){
     
        int retorno[] = new int [2];
        int estado = 1;
        for (int i = 0; i < lista.size(); i++){
            Token aux = lista.get(i);
            
            if (estado == 1){
                if (aux.getNome().equals("class")){
                    estado = 2;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 2){
                if (aux.getTipo().equals("Identificador")){
                    estado = 3;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 3){
                if (aux.getNome().equals("{")){
                    estado = 5;
                } else if (aux.getNome().equals("extends")){
                    estado = 4;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 4){
                if (aux.getTipo().equals("Identificador")){
                    estado = 3;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 5){
                
                List<Token> sublista = lista.subList(i, (lista.size())); 
                    int aux1 [] = new int[2];
                    
                    if (aux.getNome().equals("variables")){
                        aux1 = this.variable(sublista);    
                    } else if (aux.getNome().equals("method")){
                        aux1 = this.method(sublista);
                    }
                    i = aux1[1] + i;
                    if (aux1[0] == 1){
                        estado = 6;
                    } else {
                        retorno[0] = 0;
                        retorno[1] = i;
                        errosSintaticos.add(lista.get(i));
                        return retorno;
                    }
                
            }else if (estado == 6){
                List<Token> sublista = lista.subList(i, (lista.size())); 
                    int aux1 [] = new int[2];
                if (aux.getNome().equals("method")){
                    
                    aux1 = this.method(sublista);
                    i = aux1[1] + i;
                    if (aux1[0] == 1){
                        estado = 6;
                    }
                } else if (aux.getNome().equals("}")){
                    retorno[0] = 1;
                    retorno[1] = i;
                    return retorno;
                }
            }
        }
        
        return retorno;
    } 
    
    public int [] globalBlock (List <Token> lista, ArrayList <Token> errosSintaticos){
        int retorno[] = new int [2];
        int estado = 1;
        for (int i = 0; i < lista.size(); i++){
            Token aux = lista.get(i);
            
            if (estado == 1){
                if (aux.getNome().equals("const")){
                     List<Token> sublista = lista.subList(i, (lista.size())); 
                    int aux1 [] = new int[2];
                    this.constBlock(sublista);
                     i = i + aux1[1];
                    if (aux1[0] == 1){
                        estado = 2;
                    }
                   
                } else if (aux.getNome().equals("class")){
                     List<Token> sublista = lista.subList(i, (lista.size())); 
                    int aux1 [] = new int[2];
                    this.classBlock(sublista);
                     i = i + aux1[1];
                      if (aux1[0] == 1){
                        estado = 2;
                    }
                } 
            } else if (estado == 2){
                if (aux.getNome().equals("class")){
                 List<Token> sublista = lista.subList(i, (lista.size())); 
                    int aux1 [] = new int[2];
                    this.classBlock(sublista);
                    i = i + aux1[1];
                      if (aux1[0] == 1){
                        estado = 2;
                    }
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                } 
            }
            
        }
        
        return retorno;
    }
}
