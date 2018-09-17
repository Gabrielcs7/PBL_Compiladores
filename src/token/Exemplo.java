package token;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
/**
 *
 * @author Gabriel
 */
public class Exemplo {
    public static void main(String[] args) {
       
        System.out.println("Digita alguma coisa ");
        Scanner ler = new Scanner (System.in);
        String a = ler.next();
        
        ArrayList <String> listaA = new ArrayList <>();
        
        Numero in = new Numero (listaA);
        in.verifNumero(a);
        
        if (in.getListaNumeros().size() > 0){
            System.out.println("TEM NUMERO");
            
                System.out.println(in.getListaNumeros());
            
        } else{
            System.out.println("NÃO TEM NÚMERO");
            
        }
        
        
    }
    
    
    
    
    
}
