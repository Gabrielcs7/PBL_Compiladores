/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package token;

/**
 *
 * @author Aloisio Junior
 */
public class CadeiaCaracteres {
    
    private boolean eValido;
    
    
    public CadeiaCaracteres (){
        
}
    
    public void alteraEValidoTrue (){
        
        eValido = true;
    }
    
    public void alteraEValidoFalse (){
        
        eValido = false;
    }
    
    public boolean getEValido (){
        return eValido;
    }
    
    public boolean isCadeia (String a){
        
        char [] caracteres = a.toCharArray();
        
        alteraEValidoFalse();
        
        int i = 0;
        int estadoAtual = 0;
        
        while (i < caracteres.length){
            
            switch (estadoAtual) {
                case 0:
                    if (caracteres[i] == '"'){
                        estadoAtual = 1;
                    }
                    break;
                case 1:
                    if (caracteres[i] == '"'){
                        estadoAtual = 2;
                        alteraEValidoTrue();
                    }
                    break;
                case 2:
                    alteraEValidoFalse();
                    break;
                default:
                    alteraEValidoFalse();
                    break;
            }
            
            i++;
        }
        return getEValido();
    }
    
    public boolean iseValido() {
        return eValido; // método só para teste
    }
    
}
