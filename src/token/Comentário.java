package token;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Comentário {
    
    
    
    public boolean verifComent (ArrayList <String> listaTokens){
       
        int h = 0;
        int temComent = 0;
        boolean comentMalFormado = false;
        while (h < listaTokens.size()){
            if (temComent == 0){
                if (listaTokens.get(h).equals("/*")){
                    temComent = 1;
                }
            } else if (temComent == 1){
                if (listaTokens.get(h).equals("*/")){
                    comentMalFormado = true;
                }
            }
            h++;
        }
        
        
        h = 0;
        while (h < listaTokens.size()){
          if (comentMalFormado){
              if (listaTokens.get(h).equals("/*")){
                  
              }
          }
            
        }
        
        
        
        
        
        return false;
    }
}
