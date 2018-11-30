package view;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lexico.Classificador;
import lexico.Separador;
import lexico.Token;

import sintatico.Regras;
import sintatico.Regras2;

/**
 * @author Gabriel
 */
public class Main {
    ArrayList <Token> listaFinal;
    public static void main(String[] args) {
       
       ArrayList <String> listaLinhas = new ArrayList ();
       ArrayList <Token> listaFinal = null;
       File arqs[];
       File diretorio = new File("teste");
       arqs = diretorio.listFiles();
       int i = 0;
       if (arqs.length == 0)
            System.out.println("Ei, você esqueceu de criar um arquivo na pasta teste");
       
    for (int ir = 0; ir < arqs.length; ir++){    
      if (!arqs[ir].getName().startsWith("saida")){
        try {
      FileReader arq = new FileReader("teste\\" + arqs[ir].getName());
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
        
        listaFinal = s.retornaListaTokens(listaLinhas);
        
        Classificador c = new Classificador();
        
        listaFinal = c.classificaToken(listaFinal);
       
        Collections.sort(listaFinal);
       
        System.out.println();
        ArrayList <Token> listacopy;
    listacopy = listaFinal;
    
    if (!listaFinal.isEmpty()){
        for (int u = 0; u < listaFinal.size(); u++){
            Token a = listaFinal.get(u);
            if (a.getNome().equals(" "))
                listacopy.remove(u); 
        }
    }
        listaFinal = listacopy;
        
           try {
               
               File file = new File ("teste\\saida_" +  arqs[ir].getName());
               
               //OutputStream os = new FileOutputStream(file);
                              
               //OutputStreamWriter osw = new OutputStreamWriter(os);
               FileWriter arqWriter;
            arqWriter = new FileWriter(file, false);
               BufferedWriter escreveArq = new BufferedWriter(arqWriter);
               boolean temErros = false;
               //escreveArq.write("LISTA DE TOKENS \n");
               while (i < listaFinal.size()){
                   
                   if (listaFinal.get(i).isTemErro())
                       temErros = true;
                       
                   escreveArq.newLine();
                   //escreveArq.newLine();
                   //escreveArq.write("Token: " + listaFinal.get(i).getNome());
                   escreveArq.write(listaFinal.get(i).getNome());
                   escreveArq.newLine();
                   escreveArq.write(listaFinal.get(i).getPos());
                    
                   // escreveArq.write("   Tipo: " + listaFinal.get(i).getTipo() + "\n");
                    escreveArq.newLine();
                    
                    escreveArq.flush();
                    i++;
                    
               }
               escreveArq.newLine();
               escreveArq.newLine();
               i = listaFinal.size();
               //if (!temErros)
                  // escreveArq.write("PARABÉNS! Seu arquivo não contém nenhum erro! ");
                   
               escreveArq.flush();
//               osw.close();
               escreveArq.close();
               arqWriter.close();
               
           } catch (IOException ex) {
               System.err.printf("Erro na escrita no arquivo: %s.\n",
               ex.getMessage());
           }
        
     }   
       
    }
    
        //CÓDIGO DO SINTÁTICO, CHAMAR OS AUTÔMATOS E TAL
    
//    Regras r = new Regras ();
//    
//     r.globalBlock(listaFinal);
//     System.out.println(r.contador);
//        
//    for (int as = 0; as < r.erros.size(); as++){
//        
//        System.out.println("\nO token esperado era: " + r.erros.get(as)[1].getNome() + " na linha " + r.erros.get(as)[1].getLinha());
//    }
//    
}
    
}
