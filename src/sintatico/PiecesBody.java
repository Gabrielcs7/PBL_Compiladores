/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sintatico;

import java.util.ArrayList;

/**
 *
 * @author Aloisio
 */
public class PiecesBody {
    
    ArrayList<String> partes = new ArrayList<>();
    
    public PiecesBody (String corpo){
        
        String aux, aux3="";
        char aux2;
        for (int i=0; i<corpo.length(); i++){
            aux = null;
            aux2 = corpo.charAt(i);
            if (aux2 =='<'){
                if (aux3!=""){
                    partes.add(aux3);
                    aux3="";
                } else {
                    aux3 = "" + aux2;
                    for (int j=i+1;j<corpo.length();j++){
                        aux2 = corpo.charAt(j);
                        if (aux2 =='>'){
                            aux3 += aux2;
                            partes.add(aux3);
                        } else {
                            aux3 += aux2;
                        }
                    }
                }
            }
            else {
                aux3+=aux2;
            }
        }
    }
    
    public String getParte (int cont){
        
        String aux = partes.get(cont);
        return aux;
    }
    
}
