package token;

import java.util.ArrayList;
/**
 *
 * @author Gabriel
 */
public class Separador {
    
    char[] caracteres = null;
    char tok2 [] = null;
    ArrayList <Token> listaTokens = new ArrayList ();
    String reg = "\\s|,|;|\\+|-|\\*|\\++|--|!=|==|<|<=|>|>=|=|!|&&|"
               + "\\Q||\\E|//|\\{|\\/\\*|\\}|\\[|\\]"; 
               //|//|/*|\\Q()[]{}\\E
    ProcuraDelimitadores delim = new ProcuraDelimitadores();
     
    public ArrayList <Token> retornaListaTokens (ArrayList <String> listaLinhas){
      
      int h = 0;
      int i = 0;
      String aux = "";
      String auxD = "";
      String auxND = "";
      Token tok;
      int estado = 0;
      
        while (h < listaLinhas.size()){
            
            estado = 1;
            auxD = "";
            auxND = "";
            i = 0;
            caracteres = listaLinhas.get(h).toCharArray();
            
            while (i < caracteres.length){
               if (estado == 0){
                    if (delim.procuraDelimi(caracteres[i])){
                       estado = 1;
                       tok = new Token (auxND, i, h);
                       listaTokens.add(tok);
                       auxND = "";
                   } else if (!delim.procuraDelimi(caracteres[i])){
                       auxND = auxND.concat (Character.toString(caracteres[i]));
                       estado = 0;
                       if (i == caracteres.length - 1){
                            tok = new Token (auxND, i, h);
                            listaTokens.add(tok);
                        }
                   }
               } else if (estado == 1){
                   if (delim.procuraDelimi(caracteres[i])){
                       estado = 1;
                   } else if (!delim.procuraDelimi(caracteres[i])){
                       estado = 0;
                       auxND = auxND.concat(Character.toString(caracteres[i]));
                       if (i == caracteres.length - 1){
                            tok = new Token (auxND, (i+1), h);
                            listaTokens.add(tok);
                        }
                   }
               }
                i++;
            }
            
            i = 0;
            estado = 1;
            while (i < caracteres.length){
               if (estado == 0){
                    if (!delim.procuraNaoDelimi(caracteres[i])){
                       estado = 1;
                       tok = new Token (auxD, i, h);
                       listaTokens.add(tok);
                       auxD = "";
                   } else if (delim.procuraNaoDelimi(caracteres[i])){
                       auxD = auxD.concat (Character.toString(caracteres[i]));
                       estado = 0;
                       if (i == caracteres.length - 1){
                            tok = new Token (auxD, i, h);
                            listaTokens.add(tok);
                        }
                   }
               } else if (estado == 1){
                   if (!delim.procuraNaoDelimi(caracteres[i])){
                       estado = 1;
                   } else if (delim.procuraNaoDelimi(caracteres[i])){
                       estado = 0;
                       auxD = auxD.concat(Character.toString(caracteres[i]));
                       if (i == caracteres.length - 1){
                            tok = new Token (auxD, i+1, h);
                            listaTokens.add(tok);
                        }
                   }
               }
                i++;
            }
            
            h++;
        }
        
        
        h = 0;
        /*System.out.println("\n\n Lista de TOkens:\n");
        while (h < listaTokens.size()){
            System.out.println(listaTokens.get(h).getNome());
            /*System.out.println(listaTokens.get(h).getPos());
            System.out.println(listaTokens.get(h).getLinha());
            h++;
        }*/
        
        //System.out.println("AGORA VOU PASSAR PELO PROCURADOR DE COMENT\n");
        
        Comentario c = new Comentario ();
        h = 0;
        ArrayList <Token> listaNova;
        listaNova = c.removeComent(listaTokens);
       /* while (h < listaNova.size()){
            System.out.println(listaNova.get(h).getNome());
            h++;
        }*/
        
        
      return listaNova;
        
    }
    
    
    
}
