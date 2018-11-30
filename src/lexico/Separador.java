package lexico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
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
                       tok = new Token (auxND, i, h+1);
                       listaTokens.add(tok);
                       auxND = "";
                   } else if (!delim.procuraDelimi(caracteres[i])){
                       auxND = auxND.concat (Character.toString(caracteres[i]));
                       estado = 0;
                       if (i == caracteres.length - 1){
                            tok = new Token (auxND, i, h+1);
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
                            tok = new Token (auxND, (i+1), h+1);
                            listaTokens.add(tok);
                        }
                   }
               }
                i++;
            }
            
           
            i = 0;
            estado = 1;
            
            //.matches("[/(]|[/)]|[/{]|[/}]")
            while (i < caracteres.length){
                if (caracteres[i] == '(' || caracteres[i] == ')' || caracteres[i] == '{'|| caracteres[i] == '}' ||
                       caracteres[i] ==  ',' || caracteres[i] ==  ';' ||  
                        caracteres[i] ==  ']'|| caracteres[i] ==  '[' || caracteres[i] ==  '!' ){
                    String a = Character.toString(caracteres[i]);
                    tok = new Token (a, i, h+1);
                    listaTokens.add(tok);
                } 
//               if (estado == 0){
//                    if (!delim.procuraNaoDelimi(caracteres[i])){
//                       estado = 1;
//                       tok = new Token (auxD, i, h);
//                       listaTokens.add(tok);
//                       auxD = "";
//                   } else if (delim.procuraNaoDelimi(caracteres[i])){
//                       auxD = auxD.concat (Character.toString(caracteres[i]));
//                       estado = 0;
//                       if (i == caracteres.length - 1){
//                            tok = new Token (auxD, i, h);
//                            listaTokens.add(tok);
//                        }
//                   }
//               } else if (estado == 1){
//                   if (!delim.procuraNaoDelimi(caracteres[i])){
//                       estado = 1;
//                   } else if (delim.procuraNaoDelimi(caracteres[i])){
//                       estado = 0;
//                       auxD = auxD.concat(Character.toString(caracteres[i]));
//                       if (i == caracteres.length - 1){
//                            tok = new Token (auxD, i+1, h);
//                            listaTokens.add(tok);
//                        }
//                   }
//               }
                i++;

            }
             i = 0;
            estado = 1;
            String a = "";
            String ab  = "";
            while (i < caracteres.length){
                if (i < caracteres.length - 1){
                    if (caracteres[i] == '=' || caracteres[i] == '<' || caracteres[i] == '>'){
                        if (caracteres[i+1] == '='){
                            a = Character.toString(caracteres[i]);
                            ab = Character.toString(caracteres[i+1]);
                            a = a.concat(ab);
                            tok = new Token (a, i, h+1);
                            listaTokens.add(tok);
                            i++;
                        } else {
                            a = Character.toString(caracteres[i]);
                            tok = new Token (a, i, h+1);
                            listaTokens.add(tok);
                        }    
                    } else if (caracteres[i] == '|'){
                        if (caracteres[i+1] == '|'){
                            a = Character.toString(caracteres[i]);
                            ab = Character.toString(caracteres[i+1]);
                            a = a.concat(ab);
                            tok = new Token (a, i, h+1);
                            listaTokens.add(tok);
                            i++;
                        } else {
                            a = Character.toString(caracteres[i]);
                            tok = new Token (a, i, h+1);
                            listaTokens.add(tok);
                        }    
                    }else if (caracteres[i] == '&'){
                        if (caracteres[i+1] == '&'){
                            a = Character.toString(caracteres[i]);
                            ab = Character.toString(caracteres[i+1]);
                            a = a.concat(ab);
                            tok = new Token (a, i, h+1);
                            listaTokens.add(tok);
                            i++;
                        } else {
                            a = Character.toString(caracteres[i]);
                            tok = new Token (a, i, h+1);
                            listaTokens.add(tok);
                        }    
                    }else if (caracteres[i] == '/'){
                       if (caracteres[i+1] == '*' || caracteres[i+1] == '/'){
                            a = Character.toString(caracteres[i]);
                            ab = Character.toString(caracteres[i+1]);
                            a = a.concat(ab);
                            tok = new Token (a, i, h+1);
                            listaTokens.add(tok);
                            i++;
                        } else {
                            a = Character.toString(caracteres[i]);
                            tok = new Token (a, i, h+1);
                            listaTokens.add(tok);
                        }    
                    }  else if (caracteres[i] == '*'){
                       if (caracteres[i+1] == '/' ){
                            a = Character.toString(caracteres[i]);
                            ab = Character.toString(caracteres[i+1]);
                            a = a.concat(ab);
                            tok = new Token (a, i, h+1);
                            listaTokens.add(tok);
                            i++;
                        } else {
                            a = Character.toString(caracteres[i]);
                            tok = new Token (a, i, h+1);
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
        
       ArrayList <Token> listaTokens2 = listaNova;
       for (int ind = 0; ind < listaNova.size();ind++){
           String auxString = listaNova.get(ind).getNome();
           Token auxToken = listaNova.get(ind);
           String ar[];
           
           if (auxString.contains(".") && !auxString.startsWith("1") && !auxString.startsWith("2") && !auxString.startsWith("3") && !auxString.startsWith("4")
                   && !auxString.startsWith("5") && !auxString.startsWith("6") && !auxString.startsWith("7")
                   && !auxString.startsWith("8") && !auxString.startsWith("9")){
               
                ar = auxString.split(Pattern.quote("."));
                for (int ind1 = 0; ind1 < ar.length; ind1++){
                    
                    Token newTok = new Token (ar[ind1], auxToken.getPos(), auxToken.getLinha());
                    listaTokens2.add(newTok);
                    if (ind1 < ar.length - 1)
                        listaTokens2.add(new Token ("ponto", auxToken.getPos(), auxToken.getLinha()));
                }
                listaTokens2.remove(ind);
           }
       }
       
        listaNova = listaTokens2;
        
        for (int ind12 = 0; ind12 < listaNova.size(); ind12++){
            if (listaNova.get(ind12).getNome().equals("ponto")){
                listaNova.get(ind12).setNome(".");
            }
        }
        
      return listaNova;
        
    }
    
    
    
}
