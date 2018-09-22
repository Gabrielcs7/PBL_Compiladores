package token;

import java.util.ArrayList;
/**
 *
 * @author Gabriel
 */
public class Separador {
    
    String tok [] = null;
    String tok2 [] = null;
    ArrayList <String> listaTokens = new ArrayList ();
    String reg = "\\s|,|;|\\+|-|\\*|\\++|--|!=|==|<|<=|>|>=|=|!|&&|"
               + "\\Q||\\E|//|\\{|\\/\\*|\\}|\\[|\\]"; //tá indo até operadores lógicos 
               //|//|/*|\\Q()[]{}\\E
    Delimitadores delim = new Delimitadores();
     
    public ArrayList <String> retornaListaTokens (ArrayList <String> listaLinhas){
      
      int h = 0;
        while (h < listaLinhas.size()){
            System.out.println("elementos da lista: " + listaLinhas.get(h));
            
            tok = listaLinhas.get(h).split(reg);
            tok2 = listaLinhas.get(h).split("|");
            
            for (int a = 0; a < tok.length; a++){
                listaTokens.add(tok[a]);
            }
            
            for (int a = 0; a < tok2.length; a++){
                if (delim.procuraDelimi(tok2[a])){
                    listaTokens.add(tok2[a]);
                } 
                //tratamento das strings com duas ocorrências: //, ||, ++, --, ==,<=,>=, /*
                if(tok2[a].equals("|")){ 
                    if (a+1 < tok2.length){
                        if (tok2[a+1].equals("|")){
                            listaTokens.add(tok2[a].concat("|"));
                        }
                    }
                } else if (tok2[a].equals("/")){
                    if (a+1 < tok2.length){
                        if (tok2[a+1].equals("/")){
                            listaTokens.add(tok2[a].concat("/"));
                        } else if (tok2[a+1].equals("*")){
                            listaTokens.add(tok2[a].concat("*"));
                            tok2[a+1] = " ";
                        }
                    } else{
                        listaTokens.add(tok2[a]);
                    }
                } else if (tok2[a].equals("+")){
                    if (a+1 < tok2.length){
                        if (tok2[a+1].equals("+")){
                            listaTokens.add(tok2[a].concat("+"));
                        }
                    }
                } else if (tok2[a].equals("-")){
                    if (a+1 < tok2.length){
                        if (tok2[a+1].equals("-")){
                            listaTokens.add(tok2[a].concat("-"));
                        }
                    }
                } else if (tok2[a].equals("=")){
                    if (a+1 < tok2.length){
                        if (tok2[a+1].equals("=")){
                            listaTokens.add(tok2[a].concat("="));
                        }
                    }
                } else if (tok2[a].equals("<")){
                    if (a+1 < tok2.length){
                        if (tok2[a+1].equals("=")){
                            listaTokens.add(tok2[a].concat("="));
                        }
                    }
                } else if (tok2[a].equals(">")){
                    if (a+1 < tok2.length){
                        if (tok2[a+1].equals("=")){
                            listaTokens.add(tok2[a].concat("="));
                        }
                    } 
                } 
            }
            
            h++;
        }    
        h = 0;
        System.out.println("\n\n Lista de TOkens:\n");
        while (h < listaTokens.size()){
            System.out.println(listaTokens.get(h));
            h++;
        }
        System.out.println("O tamanho é " + listaTokens.size());
      return listaTokens;
        
    }
}
