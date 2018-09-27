package token;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Comentario {
        
        boolean temAbreComent;
        boolean temFechaComent;
    
    public ArrayList <Token> removeComent (ArrayList <Token> listaTokens){
       
        int h = 0;
               
        int linhaAbre = 0, linhaFecha = 0, posAbre = 0, posFecha = 0;
        
        while (h < listaTokens.size()){
            if (listaTokens.get(h).getNome().equals("/*")){
                temAbreComent = true;
                linhaAbre = listaTokens.get(h).getLinha();
                posAbre = listaTokens.get(h).getPos();
                
            } else if (listaTokens.get(h).getNome().equals("*/")){
                temFechaComent = true;
                linhaFecha = listaTokens.get(h).getLinha();
                posFecha = listaTokens.get(h).getPos();
                
            }
            
            h++;
        }
        
        h = 0;
        if (linhaAbre < linhaFecha && temAbreComent == true && temFechaComent == true){
            while (h < listaTokens.size()){
                if (linhaAbre <= listaTokens.get(h).getLinha() && listaTokens.get(h).getLinha() <= linhaFecha){
                   if (listaTokens.get(h).getLinha() == linhaAbre){
                        if (listaTokens.get(h).getPos() > posAbre){
                            listaTokens.remove(h);
                        } 
                    } else if (listaTokens.get(h).getLinha() == linhaFecha){
                        if (listaTokens.get(h).getPos() < posFecha){
                            listaTokens.remove(h);
                        }
                    } else {
                        listaTokens.remove(h);
                    }
                }
                h++;
            }
            
            
        }
        
        
        return listaTokens;/* */
    }
    
    public boolean eComentario (){
        
        
        if (temAbreComent == true && temFechaComent == true){
            return true;
        } else {
            return false;
        }
        
        
    }
    
}
