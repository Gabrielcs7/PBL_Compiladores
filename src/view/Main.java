package token;

import java.util.ArrayList;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Gabriel
 */
public class Main {
    public static void main(String[] args) {
       
       ArrayList <String> listaLinhas = new ArrayList ();
       
       String reg2 = "||";
       
       Scanner ler = new Scanner(System.in);
 
    System.out.printf("Informe o nome de arquivo:\n");
    String nome = ler.nextLine();
 
    try {
      FileReader arq = new FileReader(nome);
      BufferedReader lerArq = new BufferedReader(arq);
 
      String linha = lerArq.readLine(); 
      
      while (linha != null) {
        
        listaLinhas.add(linha);
                
        linha = lerArq.readLine(); // lê da segunda até a última linha
        
      }
 
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
        
        Separador s = new Separador ();
        ArrayList <Token> listaFinal;
        listaFinal = s.retornaListaTokens(listaLinhas);
        
        Classificador c = new Classificador();
        listaFinal = c.classificaToken(listaFinal);
        int i = 0;
        System.out.println("\n");
        while (i < listaFinal.size()){
            System.out.println("O token é " + listaFinal.get(i).getNome());
            System.out.println("O status é " + listaFinal.get(i).getTipo());
            System.out.println("\n");
            i++;
        }
    System.out.println();
        
        
    }
    
    
}
