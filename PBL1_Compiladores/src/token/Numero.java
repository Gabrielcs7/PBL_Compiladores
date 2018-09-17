
package token;
import java.util.*;
/**
 *
 * @author Gabriel
 */
public class Numero {

    
    private ArrayList <String> listaNumeros;

    public Numero(ArrayList<String> listaNumeros) {
   
        this.listaNumeros = listaNumeros;
    }
    
    public ArrayList<String> getListaNumeros() {
        return listaNumeros;
    }
    
       
    public void verifNumero (String a){
        
        char [] lista = a.toCharArray(); //quebra em um char de arrays
               
        for (int i = 0; i < lista.length; i++){
                                                
            if (lista[i] == '-'){ //q1 do autômato; Passa se tem simbolo de menos
                if (lista[i] == ' '){ //q2
                    if (Character.isDigit(lista[i])){ //q3
                        listaNumeros.add(Character.toString(lista[i]));
                        
                    } 
                } else if (Character.isDigit(lista[i])){ //q2
                    listaNumeros.add("-".concat(Character.toString(lista[i])));
                    
                } 
            } else if (lista[i] == ' ') { //com espaço no primeiro q1
                if (Character.isDigit(lista[i])){ //q3
                        listaNumeros.add(Character.toString(lista[i]));
                        
                } 
            } else if(Character.isDigit(lista[i])){ //com digito q1
                listaNumeros.add(Character.toString(lista[i]));
                
            } else if (Character.isLetter(lista[i])){ //tem letra, apaga tudo da lista e retorna que não é um número válido
                listaNumeros.clear();
            } 
        }
                
        
    }
    
    
    
    
}
