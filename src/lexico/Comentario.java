package token;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Comentario {
        
        boolean temAbreComent = false;
        boolean temFechaComent = false;
        boolean comentLinha;
        
    
    public ArrayList <Token> removeComent (ArrayList <Token> listaTokens){
       
        int ah = 0;
        
        int linhaAbre = 0, linhaFecha = 0, posAbre = 0, posFecha = 0, linhaComent = 0, posComentLinha = 0;
        
        while (ah < listaTokens.size()){
            
            if (listaTokens.get(ah).getNome().equals("/*") || listaTokens.get(ah).getNome().contains("/*")){
                listaTokens.get(ah).setNome("/*");
                temAbreComent = true;
                linhaAbre = listaTokens.get(ah).getLinha();
                posAbre = listaTokens.get(ah).getPos();
                
            } else if (listaTokens.get(ah).getNome().equals("*/") || listaTokens.get(ah).getNome().contains("*/")){
                
                temFechaComent = true;
                linhaFecha = listaTokens.get(ah).getLinha();
                posFecha = listaTokens.get(ah).getPos();
                
                
            } else if (listaTokens.get(ah).getNome().equals("//") || listaTokens.get(ah).getNome().contains("//")){
                listaTokens.get(ah).setNome("//");
                comentLinha = true;
                linhaComent = listaTokens.get(ah).getLinha();
                posComentLinha = listaTokens.get(ah).getPos();
            }
            
            int h = 0;
        if (linhaAbre < linhaFecha && temAbreComent == true && temFechaComent == true){
            temAbreComent = false;
            temFechaComent = false;
            
            while (h < listaTokens.size()){
                
                if (linhaAbre <= listaTokens.get(h).getLinha() && listaTokens.get(h).getLinha() <= linhaFecha){
                   if (listaTokens.get(h).getLinha() == linhaAbre){
                        if (listaTokens.get(h).getPos() > posAbre){
                           listaTokens.get(h).setNome(" ");
                        } 
                    } else if (listaTokens.get(h).getLinha() == linhaFecha){
                        if (listaTokens.get(h).getPos() < posFecha){
                            listaTokens.get(h).setNome(" ");
                        }
                    } else {
                           //listaTokens.remove(h);
                           listaTokens.get(h).setNome(" ");
                    }
                } 
                h++;
            }
        } else if (comentLinha == true){
            comentLinha = false;
            h = 0;
            while (h < listaTokens.size()){
                if (listaTokens.get(h).getLinha() == linhaComent){
                    if (listaTokens.get(h).getPos() > posComentLinha){
                        listaTokens.get(h).setNome(" ");
                    }
                }
                h++;
            }
            
        }
            
            ah++;
        }
        
        
        int loop = 0;
        Token auxTok;
        ArrayList <Token> listaTokensFinal = new ArrayList<>();
        while (loop < listaTokens.size()){
            if (listaTokens.get(loop).getNome().equals(" ")){
                
            } else{
                if (listaTokens.get(loop).getNome().equals("/*")){
                    auxTok = listaTokens.get(loop);
                    auxTok.setNome("/* */");
                    listaTokensFinal.add(auxTok); 
                } else if (!listaTokens.get(loop).getNome().equals("*/")) {
                    listaTokensFinal.add(listaTokens.get(loop)); 
                }
            }
            loop++;
        }
        
        return listaTokensFinal;/* */
    }
    
    public boolean eComentario (){
        if (temAbreComent == true && temFechaComent == true){
            return true;
        } else {
            return false;
        }
        
        
    }
    
}
