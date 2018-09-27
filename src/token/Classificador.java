package token;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Classificador {
     
    private PalavrasReservadas pr;
    private Numero n;
    private Operadores op;
    private ProcuraDelimitadores delim;
    private Identificador id;
    private CadeiaCaracteres ccarac;
    private String regString = "[A-Z]|[a-z]";
    private String regNumero = "[1-9]";
    private final String aspas = "\"\"";
    
    public ArrayList <Token> classificaToken (ArrayList <Token> listaTokens){
        
        int h = 0;
        String aux;
        Token tokenAux;
            
        while (h < listaTokens.size()){
            aux = listaTokens.get(h).getNome();
            tokenAux = listaTokens.get(h);
            
            if (aux.startsWith(regString)){
                if (){//palavras reservadas

                } else if (id.verifIdentif(aux)){
                    tokenAux.setTipo("Identificador");
                } else {
                    tokenAux.setTipo("Identificador mal formado");
                }
            } else if (aux.startsWith(regNumero)){
                if (n.verifNumero(aux)){
                    tokenAux.setTipo("Numero");
                } else {
                    tokenAux.setTipo("Numero mal formado");
                }
            } else if (aux.startsWith(aspas)){
                if (ccarac.isCadeia(aux)){
                    tokenAux.setTipo("Cadeia de caracteres");
                } else {
                    tokenAux.setTipo("Cadeia de caracteres mal formada");
                }
            } else if (aux.equals("//")){
                tokenAux.setTipo("Comentario de linha");
            } else if (aux.equals("/* */")){
                tokenAux.setTipo("Comentario de bloco");
            } else {
                if (op.eOperadorAritmetico(aux)){
                    tokenAux.setTipo("Operador Aritmetico");
                } else if (op.eOperadorLogico(aux)){
                    tokenAux.setTipo("Operador Logico");
                } else if (op.eOperadorRelacional(aux)){
                    tokenAux.setTipo("Operador Relacional");
                }
            }
        }
        
        return listaTokens;
    }
    
}
