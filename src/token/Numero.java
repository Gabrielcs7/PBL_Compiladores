package token;
import java.util.*;
/**
 *
 * @author Gabriel e Aloisio
 */
public class Numero {
    
    private ArrayList <String> listaNumeros;
    private boolean eValido;
    
    public Numero() {
   
        
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
    
    public ArrayList<String> getListaNumeros() {
        return listaNumeros;
    }
    
     
    public boolean verifNumero (String a){
        
        char [] caracteres = a.toCharArray(); //quebra em um char de arrays
               
        int i = 0;
        
        alteraEValidoTrue(); //variável para verificar se a string é válida
        
         //conjunto de estados do autômato
        int estadoAtual = 0;
                
        while (i < caracteres.length){
            if (estadoAtual == 0){ //se estado 0 
                if (caracteres[i] == '-'){ //se estado 0 e entrada "-"
                    estadoAtual = 1;
                } else if (caracteres[i] == ' '){
                    estadoAtual = 2;
                } else if (Character.isDigit(caracteres[i])){
                    estadoAtual = 3;
                } else{
                    alteraEValidoFalse();
                    break;
                }   
            } else if (estadoAtual == 1){
                
                if (caracteres[i] == ' '){ 
                    estadoAtual = 2;
                } else if (Character.isDigit(caracteres[i])){
                    estadoAtual = 3;
                } else{
                    alteraEValidoFalse();
                    break;
                }   
                
            } else if (estadoAtual == 2){
                if (caracteres[i] == ' '){
                    estadoAtual = 2;
                } else if (Character.isDigit(caracteres[i])){
                    estadoAtual = 3;
                }else{
                    alteraEValidoFalse();
                    break;
                }   
            } else if(estadoAtual == 3){
                if (Character.isDigit(caracteres[i])){
                    estadoAtual = 3;
                } else if (caracteres[i] == '.'){
                    estadoAtual = 4;
                }else{
                    alteraEValidoFalse();
                    break;
                }   
            }else if(estadoAtual == 4){
                if (Character.isDigit(caracteres[i])){
                    estadoAtual = 5;
                }else {
                    alteraEValidoFalse();
                    break;
                }
            } else if (estadoAtual == 5){
                if (Character.isDigit(caracteres[i])){
                    estadoAtual = 5;
                }else{
                    alteraEValidoFalse();
                    break;
                }   
            }  
        i++;        
        }
        //se houve um break, já é falso
        if (estadoAtual == 1 || estadoAtual == 2 || estadoAtual == 4){ //se um desses estados (os não-finais) é verdadeiro, seta como falso
           alteraEValidoFalse();
        }
        //os estados só serão verdadeiros se forem os estados atuais da leitura
        return getEValido();
    }

    
    
}
