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
        
        System.out.println("O NÚMERO QUE EU BOTEI É " + in.iseValido()); //nesse teste, se false, não reconhece como número
    }
    
    
    
    
    
}
