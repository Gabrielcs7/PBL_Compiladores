package sintatico;

import java.util.ArrayList;
import java.util.List;
import lexico.Token;

/**
 *
 * @author Gabriel
 */
public class Regras {
    
    public int [] ifStatement (List <Token> lista){
        List <Token> sublista;
        int array [] = new int[2];
        int retorno[] = new int [2];
        
        int estadoAtual = 1;
        for (int i = 0; i < lista.size(); i++){
            String aux = lista.get(i).getNome();
            
            if (estadoAtual == 1){
                if (aux.equals("if")){
                    estadoAtual = 2;
                }    
            } else if (estadoAtual == 2){
                if (aux.equals("("))
                    estadoAtual = 3;
            } else if (estadoAtual == 3){
                sublista = lista.subList(i, (lista.size()));
               array = this.expression(sublista);
                if (array[0] == 1){ //se leu um expression válido 
                    estadoAtual = 4;      
                } else {
                    System.out.println("não leu nem um expression válido");//TIRAR
                    return null;
                }
                 //onde parou na leitura do expressions
            } else if (estadoAtual == 4){
                if (aux.equals(")")){
                    estadoAtual = 5;
                }
            } else if (estadoAtual == 5){
               if (aux.equals("then"))
                    estadoAtual = 6;
            } else if (estadoAtual == 6){
                if (aux.equals("{"))
                    estadoAtual = 7; 
                
            } else if (estadoAtual == 7){
                sublista = lista.subList(i, (lista.size())); 
                
                array = commands(sublista);
                if (array[0] == 1){ //se leu um command válido
                    estadoAtual = 8;                    
                } else if (array[0] == 2){
                    retorno[0] = 1;
                    retorno[1] = i;
                    //System.out.println("LEU CORRETAMENTE a chave, não tem comando");//TIRAR
                    estadoAtual = 9;
                } else {
                    //System.out.println("deu erro aqui no cmandos");//TIRAR
                    estadoAtual = 8; 
                }
            } else if (estadoAtual == 8){
                if (aux.equals("}")){
                    estadoAtual = 9;
                    retorno[0] = 1;
                    retorno[1] = i;
                }
            } else if (estadoAtual == 9){
                sublista = lista.subList(i, (lista.size()));
                array = elseStatement(sublista);
                array[1] = array[1] + 2;
                
               if (array[0] == 1 || array[0] == 2){
                    retorno[0] = 1;
                    retorno[1] = i;
                    System.out.println("IF sintaticamente correto!");
                    return retorno;
                } else {
                   retorno[0] = 0;
                   retorno[1] = array[1] + i;
                   System.out.println("Indice do erro é " +  retorno[1]);
                   System.out.println("IF sintaticamente Incorreto!");
                   return retorno;
               } 
            }
        }
        
        return retorno;
    }
    
    public int [] expression (List <Token> lista){
        
        int retorno[] = new int [2];
        int estado  = 1;
        
        for (int i = 0; i < lista.size(); i++){
            Token aux = lista.get(i);
            if (estado == 1){
                if (aux.getTipo().equals("Identificador") || aux.getTipo().equals("Numero")){
                    estado = 2;
                } else if (aux.getNome().equals("!")){
                    estado = 3;
                }else {
                    retorno[0] = 0;
                    return retorno;
                }
            } else if (estado == 2){
                if (aux.getTipo().equals("Operador Relacional") || aux.getNome().equals("+")
                    || aux.getNome().equals("-")|| aux.getNome().equals("*") || aux.getNome().equals("/")
                        || aux.getNome().equals("&&") || aux.getNome().equals("||")){
                    estado = 3;
                } else if (aux.getNome().equals("++") || aux.getNome().equals("--")){
                    
                    retorno[0] = 1;
                    retorno[1] = i;
                    return retorno;
                }else {
                    
                    retorno[0] = 0;
                    return retorno;
                }
            } else if (estado == 3){
                if (aux.getTipo().equals("Identificador") || aux.getTipo().equals("Numero")){
                    estado = 4;
                    retorno[0] = 1;
                    retorno[1] = i;
                } else {
                    retorno[0] = 0;
                    return retorno;
                }
            } else if (estado == 4){
                if (aux.getTipo().equals("Operador Logico") || aux.getTipo().equals("Operador Aritmetico")){
                    estado = 3;
                }else if (aux.getTipo().equals("Operador Relacional")){
                    estado = 5;
                }else if (aux.getNome().equals(")")) {
                    return retorno;
                }else {
                    retorno[0] = 0;
                    return retorno;
                }
            } else if (estado == 5){
                if (aux.getTipo().equals("Identificador") || aux.getTipo().equals("Numero")){
                    estado = 6;
                    retorno[0] = 1;
                    retorno[1] = i;
                }else {
                    retorno[0] = 0;
                    return retorno;
                }
            } else if (estado == 6){
                if (aux.getTipo().equals("Operador Logico") || aux.getTipo().equals("Operador Aritmetico")){
                    estado = 5;
                } else if (aux.getNome().equals(")")) {
                    return retorno;
                } else {
                    retorno[0] = 0;
                    return retorno;
                }
            } 
        }
        
        return retorno;
    }
    
    public int [] commands (List <Token> lista){
        
        int array[] = new int [2];
        int arrayAux[] = new int [2];
        
        int estado = 1;
        
        for (int i = 0; i < lista.size(); i++){
            Token aux = lista.get(i);
            if (estado == 1){
                if (aux.getNome().equals("return")){
                    estado = 2;
                }else if (aux.getNome().equals("}")){
                    array[0] = 2;
                    array[1] = i;
                    return array;
                } else if (aux.getNome().equals("while")){
                    List<Token> sublista = lista.subList(i, (lista.size())); 
                    
                    arrayAux = whileStatement(sublista);
                    if (arrayAux[0] == 1){
                        array[0] = 1;
                        array[1] = i;
                        return array;
                    } else {
                        System.out.println("teve erro no if"); //ajustar para uma melhor forma de sinalizar erro
                        sublista = lista.subList(i+arrayAux[1], (lista.size())); 
                        this.commands(sublista);
                    }
                } else if (aux.getNome().equals("if")){
                    List<Token> sublista = lista.subList(i, (lista.size())); 
                    
                    arrayAux = ifStatement(sublista);
                    if (arrayAux[0] == 1){
                        array[0] = 1;
                        array[1] = i;
                        return array;
                    } else {
                        sublista = lista.subList(i+arrayAux[1], (lista.size())); 
                        this.commands(sublista);
                    }
                } else if (aux.getNome().equals("write")){
                     List<Token> sublista = lista.subList(i, (lista.size())); 
                    
                    arrayAux = write(sublista);
                    if (arrayAux[0] == 1){
                        array[0] = 1;
                        array[1] = i;
                        return array;
                    } else {
                        sublista = lista.subList(i+arrayAux[1], (lista.size())); 
                        this.commands(sublista);
                    }
                } else if (aux.getNome().equals("read")){
                    List<Token> sublista = lista.subList(i, (lista.size())); 
                    
                    arrayAux = read(sublista);
                    if (arrayAux[0] == 1){
                        array[0] = 1;
                        array[1] = i;
                        return array;
                    } else {
                        sublista = lista.subList(i+arrayAux[1], (lista.size())); 
                        this.commands(sublista);
                    }
                }else {
                    array[0] = 0;
                    array[1] = i;
                    return array;
                }
            } else if (estado == 2){
                if (aux.getTipo().equals("Identificador") || aux.getTipo().equals("Numero") || aux.getNome().equals("true") || 
                    aux.getNome().equals("false") ||  aux.getTipo().equals("Cadeia de caracteres")){
                    estado = 3;
                } else {
                    array[0] = 0;
                    array[1] = i;
                }
            } else if (estado == 3){
                if (aux.getNome().equals(";")){
                    array[0] = 1;
                    array[1] = i;
                } else {
                    return array;
                }
            }
        }
        
        return array;
        
    }

    public int[] elseStatement(List<Token> lista) {
        
        int retorno[] = new int [2];
        int array[] = new int [2];
        int estado = 1;
        
        for (int i = 0; i < lista.size(); i++){
            Token aux = lista.get(i);
            if (estado == 1){
                if (aux.getNome().equals("else")){
                    estado = 2;
                } else {
                    retorno[0] = 2;
                    retorno[1] = i;
                }
            } else if (estado == 2){
                if (aux.getNome().equals("{")){
                    estado = 3;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                }
            } else if (estado == 3){
                List<Token> sublista = lista.subList(i, (lista.size())); 
                array = commands(sublista);
                if (array[0] == 1){ //se leu um command válido
                    estado = 4;                    
                } else if (array[0] == 2){
                    retorno[0] = 1;
                    retorno[1] = i;
                    estado = 4;
                } else {
                    System.out.println("deu erro aqui no cmandos");//TIRAR
                    estado = 5; 
                    retorno[1] = i;
                }
            } else if (estado == 4){
                if (aux.getNome().equals("}")){
                    retorno[0] = 1;
                    retorno[1] = i;
                    return retorno;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                }
            } else if (estado == 5){
                if (aux.getNome().equals("}")){
                    retorno[0] = 0;
                    
                    return retorno;
                } 
            }
        }
        
        return retorno;
        
    }
    
    public int [] whileStatement (List <Token> lista){
        
        int retorno[] = new int[2];
        int array[] = new int[2];
        int estado = 1;
        
        for (int i = 0; i < lista.size(); i++){
            Token aux = lista.get(i);
            
            if (estado == 1){
                if (aux.getNome().equals("while")){
                    estado = 2;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 2){
                if (aux.getNome().equals("(")){
                    estado = 3;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 3){
                List<Token> sublista = lista.subList(i, (lista.size()));
               array = this.expression(sublista);
                if (array[0] == 1){ //se leu um expression válido 
                    estado = 4;      
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 4){
                if (aux.getNome().equals(")")){
                    estado = 5;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 5){
                if (aux.getNome().equals("{")){
                    estado = 6;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 6){
                List<Token> sublista = lista.subList(i, (lista.size())); 
                array = commands(sublista);
                if (array[0] == 1){ //se leu um command válido
                    estado = 7;                    
                } else if (array[0] == 2){
                    retorno[0] = 1;
                    retorno[1] = i;
                    estado = 7;
                } else {
                    estado = 8; 
                }
            } else if(estado == 7){
                if (aux.getNome().equals("}")){
                    retorno[0] = 1;
                    retorno[1] = i;
                    return retorno;
                } else{
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 8){ //estado de erro
                if (aux.getNome().equals("}")){
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                } else{
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            }
        }   
        return retorno;
        
    }
    public int [] write (List <Token> lista){
        
        int retorno[] = new int[2];
        
        int estado = 1;
        
        for (int i = 0; i < lista.size();i++){
            Token aux = lista.get(i);
            if (estado == 1){
                if (aux.getNome().equals("write")){
                    estado = 2;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 2){
                if (aux.getNome().equals("(")){
                    estado = 3;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 3){
                if (aux.getTipo().equals("Identificador")){
                    estado = 4;
                    retorno[0] = 1;
                    retorno[1] = i;
                } else if(aux.getTipo().equals("Cadeia de caracteres")){
                    estado = 6;
                    retorno[0] = 1;
                    retorno[1] = i;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 4){
                if (aux.getNome().equals(".")){
                    estado = 5;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 5){
                if (aux.getTipo().equals("Identificador")){
                    estado = 6;
                    retorno[0] = 1;
                    retorno[1] = i;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 6){
                if (aux.getNome().equals(",")){
                    estado = 3;
                } else if (aux.getNome().equals(")")){
                    estado = 7;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 7){
                if (aux.getNome().equals(";")){
                    retorno[0] = 1;
                    retorno[1] = i;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            }
        }
        return retorno;
    }
    
    
    public int [] read (List<Token> lista){
          int retorno[] = new int[2];
        
        int estado = 1;
        
        for (int i = 0; i < lista.size();i++){
            Token aux = lista.get(i);
            if (estado == 1){
                if (aux.getNome().equals("read")){
                    estado = 2;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 2){
                if (aux.getNome().equals("(")){
                    estado = 3;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 3){
                if (aux.getTipo().equals("Identificador")){
                    estado = 4;
                    retorno[0] = 1;
                    retorno[1] = i;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 4){
                if (aux.getNome().equals(".")){
                    estado = 5;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 5){
                if (aux.getTipo().equals("Identificador")){
                    estado = 6;
                    retorno[0] = 1;
                    retorno[1] = i;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 6){
                if (aux.getNome().equals(",")){
                    estado = 3;
                } else if (aux.getNome().equals(")")){
                    estado = 7;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    return retorno;
                }
            } else if (estado == 7){
                if (aux.getNome().equals(";")){
                    retorno[0] = 1;
                    retorno[1] = i;
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
