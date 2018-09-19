
package token;
import java.util.*;
/**
 *
 * @author Gabriel e Aloisio
 */
public class Numero {
    
    private ArrayList <String> listaNumeros;
    private boolean eValido;
    
    public Numero(ArrayList<String> listaNumeros) {
   
        this.listaNumeros = listaNumeros;
    }
    
    public ArrayList<String> getListaNumeros() {
        return listaNumeros;
    }
    
     //NÃO TESTA COM ESPAÇO, PQ ELE BUGA. SÓ DÁ PRA TESTAR ESPAÇO COM O ARQUIVO MESMO
    public void verifNumero (String a){
        
        char [] caracteres = a.toCharArray(); //quebra em um char de arrays
               
        int i = 0;
        
        eValido = true; //variável para verificar se a string é válida
        
        int [] estado = {0,1,2,4,5,6}; //conjunto de estados do autômato
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
                    eValido = false;
                    break;
                }   
            } else if (estadoAtual == 1){
                //espaço tá bugado pq o java considera espaço como delimitador de strings, aí tem que ver como será
                if (caracteres[i] == ' '){ //aqui eu verifico espaço, mas tá bugado, então deixa aí para depois mudar
                    estadoAtual = 2;
                } else if (Character.isDigit(caracteres[i])){
                    estadoAtual = 3;
                } else{
                    eValido = false;
                    break;
                }   
                
            } else if (estadoAtual == 2){
                if (caracteres[i] == ' '){
                    estadoAtual = 2;
                } else if (Character.isDigit(caracteres[i])){
                    estadoAtual = 3;
                }else{
                    eValido = false;
                    break;
                }   
            } else if(estadoAtual == 3){
                if (Character.isDigit(caracteres[i])){
                    estadoAtual = 3;
                } else if (caracteres[i] == '.'){
                    estadoAtual = 4;
                }else{
                    eValido = false;
                    break;
                }   
            }else if(estadoAtual == 4){
                if (Character.isDigit(caracteres[i])){
                    estadoAtual = 5;
                }else {
                    eValido = false;
                    break;
                }
            } else if (estadoAtual == 5){
                if (Character.isDigit(caracteres[i])){
                    estadoAtual = 5;
                }else{
                    eValido = false;
                    break;
                }   
            }  
        i++;        
        }
        //se houve um break, já é falso
        if (estadoAtual == 1 || estadoAtual == 2 || estadoAtual == 4){ //se um desses estados (os não-finais) é verdadeiro, seta como falso
           eValido = false;
        }
        //os estados só serão verdadeiros se forem os estados atuais da leitura
        
    }

    public boolean iseValido() {
        return eValido; // método só para teste
    }
    
    
    
    
}
