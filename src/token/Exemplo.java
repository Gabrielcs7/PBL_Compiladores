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
public class Exemplo {
    public static void main(String[] args) {
       
       ArrayList <String> listaLinhas = new ArrayList ();
       
       String reg2 = "||";
       
       Scanner ler = new Scanner(System.in);
 
    System.out.printf("Informe o nome de arquivo texto:\n");
    String nome = ler.nextLine();
 
    System.out.printf("\nConteúdo do arquivo texto:\n");
    try {
      FileReader arq = new FileReader(nome);
      BufferedReader lerArq = new BufferedReader(arq);
 
      String linha = lerArq.readLine(); 
      
      while (linha != null) {
        
        //System.out.printf("%s\n", linha);
        listaLinhas.add(linha);
                
        linha = lerArq.readLine(); // lê da segunda até a última linha
        
      }
 
      arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
    
        Separador s = new Separador ();
        s.retornaListaTokens(listaLinhas);
        
        System.out.print(listaLinhas);
    System.out.println();
        
        
    }
    
    
}
