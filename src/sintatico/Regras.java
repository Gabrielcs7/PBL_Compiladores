package sintatico;

import java.util.ArrayList;
import java.util.List;
import lexico.Token;

/**
 *
 * @author Gabriel
 */
public class Regras {
   
    public int contador = 0; 
    public List <Token[]> erros = new ArrayList(); 
    
    public int [] ifStatement (List <Token> lista, ArrayList <Token> errosSintaticos){
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
                    errosSintaticos.add(lista.get(i));
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
                    errosSintaticos.add(lista.get(i));
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
    
    public int [] expression (List <Token> lista, ArrayList <Token> errosSintaticos){
        
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
                    errosSintaticos.add(lista.get(i));
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
                    errosSintaticos.add(lista.get(i));
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
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 5){
                if (aux.getTipo().equals("Identificador") || aux.getTipo().equals("Numero")){
                    estado = 6;
                    retorno[0] = 1;
                    retorno[1] = i;
                }else {
                    retorno[0] = 0;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 6){
                if (aux.getTipo().equals("Operador Logico") || aux.getTipo().equals("Operador Aritmetico")){
                    estado = 5;
                } else if (aux.getNome().equals(")")) {
                    return retorno;
                } else {
                    retorno[0] = 0;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } 
        }
        
        return retorno;
    }
    
    public int [] commands (List <Token> lista, ArrayList <Token> errosSintaticos){
        
        int array[] = new int [2];
        int arrayAux[] = new int [2];
        
        int estado = 1;
        
        for (; contador < lista.size(); contador++){
            Token aux = lista.get(contador);
            if (estado == 1){
                if (aux.getNome().equals("return")){
                    estado = 2;
                }else if (aux.getNome().equals("}")){
                    array[0] = 2;
                    array[1] = contador;
                    return array;
                } else if (aux.getNome().equals("while")){
                    //List<Token> sublista = lista.subList(i, (lista.size())); 
                    
                    arrayAux = whileStatement(lista);
                    if (arrayAux[0] == 1){
                        array[0] = 1;
                        array[1] = contador;
                        
                        this.commands(lista);
                    } 
                } else if (aux.getNome().equals("if")){
                    List<Token> sublista = lista.subList(contador, (lista.size())); 
                    
                    arrayAux = ifStatement(sublista);
                    if (arrayAux[0] == 1){
                        array[0] = 1;
                        array[1] = contador;
                        sublista = lista.subList(contador+arrayAux[1], (lista.size())); 
                        this.commands(sublista);
                    } 
                } else if (aux.getNome().equals("write")){
                     List<Token> sublista = lista.subList(contador, (lista.size())); 
                    
                    arrayAux = write(sublista);
                    if (arrayAux[0] == 1){
                        array[0] = 1;
                        array[1] = contador;
                        sublista = lista.subList(contador+arrayAux[1], (lista.size())); 
                        this.commands(sublista);
                    }
                } else if (aux.getNome().equals("read")){
                    List<Token> sublista = lista.subList(contador, (lista.size())); 
                    
                    arrayAux = read(sublista);
                    if (arrayAux[0] == 1){
                        array[0] = 1;
                        array[1] = contador;
                        sublista = lista.subList(contador+arrayAux[1], (lista.size())); 
                        this.commands(sublista);
                        
                    } 
                } else if (aux.getTipo().equals("Identificador")){
                    List<Token> sublista = lista.subList(contador, (lista.size()));
                    arrayAux = this.atribuition(sublista);
                    if (arrayAux[0] == 1){
                        array[0] = 1;
                        array[1] = contador;
                        sublista = lista.subList(contador+arrayAux[1], (lista.size())); 
                        this.commands(sublista);
                    }
                    
                }else {
                    contador--;
                    array[0] = 0;
                    array[1] = contador;
                    return array;
                }
            } else if (estado == 2){
                if (aux.getTipo().equals("Numero") || aux.getNome().equals("true") || 
                    aux.getNome().equals("false") ||  aux.getTipo().equals("Cadeia de caracteres")){
                    estado = 3;
                } else if (aux.getTipo().equals("Identificador")){
                    estado = 4;
                    
                }else {
                    array[0] = 0;
                    array[1] = contador;
                }
            } else if (estado == 3){
                if (aux.getNome().equals(";")){
                    array[0] = 1;
                    array[1] = contador;
                } else {
                    return array;
                }
            } else if (estado == 4){
                if (aux.getNome().equals("[")){
                    //List<Token> sublista = lista.subList(i, (lista.size()));
                    arrayAux = this.arrayVerification(lista);
                    if (arrayAux[0] == 1){
                        estado = 3;
                    }
                    
                } else {
                    array[0] = 0;
                    array[1] = contador;
                }
                
                    
            }
        }
        
        return array;
        
    }

    public int[] elseStatement(List<Token> lista, ArrayList <Token> errosSintaticos) {
        
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
                    errosSintaticos.add(lista.get(i));
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
                    errosSintaticos.add(lista.get(i));
                }
            } else if (estado == 5){
                if (aux.getNome().equals("}")){
                    retorno[0] = 0;
                    errosSintaticos.add(lista.get(i));
                    
                    return retorno;
                } 
            }
        }
        
        return retorno;
        
    }
    
    public int [] whileStatement (List <Token> lista, ArrayList <Token> errosSintaticos){
        
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
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 2){
                if (aux.getNome().equals("(")){
                    estado = 3;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
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
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 4){
                if (aux.getNome().equals(")")){
                    estado = 5;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 5){
                if (aux.getNome().equals("{")){
                    estado = 6;
                } else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
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
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } 
        }   
        return retorno;
        
    }
    public int [] write (List <Token> lista, ArrayList <Token> errosSintaticos){
        
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
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 2){
                if (aux.getNome().equals("(")){
                    estado = 3;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
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
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 4){
                if (aux.getNome().equals(".")){
                    estado = 5;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
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
                    errosSintaticos.add(lista.get(i));
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
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 7){
                if (aux.getNome().equals(";")){
                    retorno[0] = 1;
                    retorno[1] = i;
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
    
    
    public int [] read (List<Token> lista, ArrayList <Token> errosSintaticos){
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
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 2){
                if (aux.getNome().equals("(")){
                    estado = 3;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
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
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 4){
                if (aux.getNome().equals(".")){
                    estado = 5;
                }else {
                    retorno[0] = 0;
                    retorno[1] = i;
                    errosSintaticos.add(lista.get(i));
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
                    errosSintaticos.add(lista.get(i));
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
                    errosSintaticos.add(lista.get(i));
                    return retorno;
                }
            } else if (estado == 7){
                if (aux.getNome().equals(";")){
                    retorno[0] = 1;
                    retorno[1] = i;
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
                int numero = this.expression(sublista)[0];
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
    
    public int [] expMethod (List <Token> , ArrayList <Token> errosSintaticos){
        
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
    
    public int expMethod2(List <Token> lista, ArrayList <Token> errosSintaticos){
        int retorno = 1;
        int estado = 1;
        
        for (; contador < lista.size(); contador++){
            Token aux = lista.get(contador);
            if (estado == 1){
                if (aux.getNome().equals("int") || aux.getNome().equals("float") || aux.getNome().equals("bool") || aux.getNome().equals("string")){
                    estado = 2;
                } else {
                    Token [] erro = new Token [2];
                    erro[0] = aux; //token errado
                    erro[1] = new Token("int, float, bool, string ou void", aux.getPos(), aux.getLinha()); //esperava
                    erros.add(erro);
                    estado = 2;
                }
            }else if (estado == 2){
                if (aux.getTipo().equals("Identificador")){
                    estado = 3;
                }else {
                    Token [] erro = new Token [2];
                    erro[0] = aux; //token errado
                    erro[1] = new Token("Identificador", aux.getPos(), aux.getLinha()); //esperava
                    erros.add(erro);
                    estado = 3;
                }
            }else if (estado == 3){
                if (aux.getNome().equals("[")){
                    int aux1 [] = new int[2];
                    aux1 = this.arrayVerification(lista);
                    estado = 3;    
                   
                } else if(aux.getNome().equals(",")){
                    estado = 1;
                }else {
                    contador--;
                    return 1;
                }
            }
        }
        
        return retorno;
    }
    
    public int method (List <Token> lista, ArrayList <Token> errosSintaticos){
         int retorno = 0;
        int estado = 1;
        
        for (; contador < lista.size(); contador++){
            Token aux = lista.get(contador);
            if (estado == 1){
                if (aux.getNome().equals("method")){
                    estado = 2;
                }else {
                    Token [] erro = new Token [2];
                    erro[0] = aux; //token errado
                    erro[1] = new Token("method", aux.getPos(), aux.getLinha()); //esperava
                    erros.add(erro);
                    estado = 2;
                }
            } else if (estado == 2){
                if (aux.getNome().equals("int") || aux.getNome().equals("bool") || aux.getNome().equals("float") || aux.getNome().equals("string")
                        || aux.getNome().equals("void")){
                    estado = 3;
                } else {
                    Token [] erro = new Token [2];
                    erro[0] = aux;
                    erro[1] = new Token("int ou bool ou float ou void ou string", aux.getPos(), aux.getLinha());
                    erros.add(erro);
                    estado = 3;
                }
            } else if (estado == 3){
                if (aux.getTipo().equals("Identificador")){
                    estado = 4;
                }else {
                    Token [] erro = new Token [2];
                    erro[0] = aux;
                    erro[1] = new Token("Identificador", aux.getPos(), aux.getLinha());
                    erros.add(erro);
                    estado = 4;
                }
            } else if (estado == 4){
                if (aux.getNome().equals("(")){
                    estado = 5;
                }else {
                   Token [] erro = new Token [2];
                    erro[0] = aux;
                    erro[1] = new Token("(", aux.getPos(), aux.getLinha());
                    erros.add(erro);
                    estado = 5;
                }
            } else if (estado == 5){
                this.expMethod2(lista);
                estado = 6;       
                
            } else if (estado == 6){
                 if (aux.getNome().equals(")")){
                    estado = 7;
                }else {
                    Token [] erro = new Token [2];
                    erro[0] = aux;
                    erro[1] = new Token(")", aux.getPos(), aux.getLinha());
                    erros.add(erro);
                    estado = 7;
                }
            }else if (estado == 7){
                if (aux.getNome().equals("{")){
                    estado = 8;
                }else {
                    Token [] erro = new Token [2];
                    erro[0] = aux;
                    erro[1] = new Token("{", aux.getPos(), aux.getLinha());
                    erros.add(erro);
                    estado = 8;
                }
            }else if (estado == 8){

                if (aux.getNome().equals("}")){
                    return 1;
                } else if (aux.getNome().equals("variables")){
                    int aux1 [] = new int[2];
                    aux1 = this.variable(lista);
                    estado = 10;
                }
                    int aux2 [] = new int[2];
                    aux2 = this.commands(lista);
                    estado = 10;
                
                
            }else if (estado == 9){
                int aux1 [] = new int[2];
                aux1 = this.commands(lista);
                if (aux1[0] == 1){
                    
                } 
                estado = 10;
            } else if (estado == 10){
                if (aux.getNome().equals("}")){
                    return 1;
                }else {
                    contador--;
                    return 1;
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
     
     
    public int classBlock (List <Token> lista, ArrayList <Token> errosSintaticos){
     
        int retorno = 1;
        int estado = 1;
        for (; contador < lista.size(); contador++){
            Token aux = lista.get(contador);
            
            if (estado == 1){
                if (aux.getNome().equals("class")){
                    estado = 2;
                } else {
                    Token [] erro = new Token [2];
                    erro[0] = aux; //token errado
                    erro[1] = new Token("class", aux.getPos(), aux.getLinha()); //esperava
                    erros.add(erro);
                    estado = 2;
                }
            } else if (estado == 2){
                if (aux.getTipo().equals("Identificador")){
                    estado = 3;
                }else {
                    Token [] erro = new Token [2];
                    erro[0] = aux; //token errado
                    erro[1] = new Token("Identificador", aux.getPos(), aux.getLinha()); //esperava
                    erros.add(erro);
                    estado = 3;
                }
            } else if (estado == 3){
                if (aux.getNome().equals("{")){
                    estado = 5;
                } else if (aux.getNome().equals("extends")){
                    estado = 4;
                } else {
                    Token [] erro = new Token [2];
                    erro[0] = aux; //token errado
                    erro[1] = new Token("{ ou extends", aux.getPos(), aux.getLinha()); //esperava
                    erros.add(erro);
                    estado = 5;
                }
            } else if (estado == 4){
                if (aux.getTipo().equals("Identificador")){
                    estado = 3;
                }else {
                     Token [] erro = new Token [2];
                    erro[0] = aux; //token errado
                    erro[1] = new Token("Identificador", aux.getPos(), aux.getLinha()); //esperava
                    erros.add(erro);
                    estado = 2;
                }
            } else if (estado == 5){
                    int aux1 [] = new int[2];
                   if (aux.getNome().equals("variables")){
                        aux1 = this.variable(lista);    
                    } else if (aux.getNome().equals("method")){
                      this.method(lista);
                    }
                    estado = 6;
            }else if (estado == 6){
                    int aux1 [] = new int[2];
                if (aux.getNome().equals("method")){
                     this.method(lista);
                } else if (aux.getNome().equals("}")){
                    return 1;
                }
                estado = 6;
            }
        }
        
        return retorno;
    } 
    
    public int globalBlock (List <Token> lista, ArrayList <Token> errosSintaticos){
         int retorno = 1;
        int estado = 1;
        for (; contador < lista.size(); contador++){
            Token aux = lista.get(contador);
            
            if (estado == 1){
                if (aux.getNome().equals("const")){
                   //  List<Token> sublista = lista.subList(contador, (lista.size())); 
                    int aux1 [] = new int[2];
                    aux1 = this.constBlock(lista);
                     
                    if (aux1[0] == 1){
                        estado = 2;
                    }
                   
                } else if (aux.getNome().equals("class")){
                     this.classBlock(lista);
                     estado = 2;                     
                } 
            } else if (estado == 2){
                if (aux.getNome().equals("class")){
                    this.classBlock(lista);
                    estado = 2;
                } else {
                    return 1;
                } 
            }
            
        }
        return retorno;
    }
    
}
