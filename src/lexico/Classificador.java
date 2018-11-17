package lexico;
import java.util.ArrayList;
/**
 *
 * @author Gabriel
 */
public class Classificador {
     
    private PalavrasReservadas pr = new PalavrasReservadas();
    private Numero n = new Numero();
    private Operadores op = new Operadores();
    private Delimitadores delim = new Delimitadores();
    private Identificador id = new Identificador();
    private CadeiaCaracteres ccarac = new CadeiaCaracteres();
   // private String regString = "/[a-z]";
   // private String regNumero = "/[1-9]";
    private final String aspas = "\"";
    
    public ArrayList <Token> classificaToken (ArrayList <Token> listaTokens){
        
        int h = 0;
        String aux;
        Token tokenAux;
        char [] auxVector;
            
        while (h < listaTokens.size()){
            aux = listaTokens.get(h).getNome();
            tokenAux = listaTokens.get(h);
            auxVector = aux.toCharArray();
            
            if(Character.isLetter(auxVector[0])){
                if (pr.verifReservada(aux)){
                    tokenAux.setTipo("Palavra Reservada");
                } else if (id.verifIdentif(aux)){
                    tokenAux.setTipo("Identificador");
                } else {
                    tokenAux.setTipo("Identificador mal formado");
                    tokenAux.setTemErro(true);
                }
            } else if (Character.isDigit(auxVector[0]) || aux.startsWith("-1") || aux.startsWith("-2") || aux.startsWith("-3") || aux.startsWith("-4")
                    || aux.startsWith("-5") || aux.startsWith("-6") || aux.startsWith("-7") || aux.startsWith("-8") || aux.startsWith("-9")){
                if (n.verifNumero(aux)){
                    tokenAux.setTipo("Numero");
                } else {
                    tokenAux.setTipo("Numero mal formado");
                    tokenAux.setTemErro(true);
                }
            } else if (aux.startsWith(aspas)){
                if (ccarac.isCadeia(aux)){
                    tokenAux.setTipo("Cadeia de caracteres");
                } else {
                    tokenAux.setTipo("Cadeia de caracteres mal formada");
                    tokenAux.setTemErro(true);
                }
            }else if (aux.startsWith("/")) {
                    if (aux.equals("//")){
                       tokenAux.setTipo("Comentario de linha");
                    } else if (aux.equals("/* */")){
                        tokenAux.setTipo("Comentario de bloco");
                    } else {
                        tokenAux.setTipo("Comentario mal formado");
                        tokenAux.setTemErro(true);
                    }
                
            } else if (aux.startsWith("+") || aux.startsWith("-") || aux.startsWith("*") || aux.startsWith("/")){
                if (op.eOperadorAritmetico(aux)){
                    tokenAux.setTipo("Operador Aritmetico");
                } else {
                    tokenAux.setTipo("Operador Aritmetico mal formado");
                    tokenAux.setTemErro(true);
                }   
            } else if (aux.startsWith("!")){
                if (op.eOperadorRelacional(aux)){
                    tokenAux.setTipo("Operador Relacional");
                } else if (op.eOperadorLogico(aux)) {
                    tokenAux.setTipo("Operador Logico");
                } else {
                    tokenAux.setTipo("Operador Relacional mal formado");
                    tokenAux.setTemErro(true);
                }   
                    
            } else if (aux.startsWith("=") || aux.startsWith("<") || aux.startsWith(">")){
                if (op.eOperadorRelacional(aux)){
                    tokenAux.setTipo("Operador Relacional");
                } else {
                    tokenAux.setTipo("Operador Relacional mal formado");
                    tokenAux.setTemErro(true);
                }
            }else if (aux.startsWith("&") || aux.startsWith("|")){ //AQUI AQUI ==============
                if (op.eOperadorLogico(aux)){
                    tokenAux.setTipo("Operador Lógico");
                } else {
                    tokenAux.setTipo("Operador Lógico mal formado");
                    tokenAux.setTemErro(true);
                }
            } else if (aux.startsWith(";") || aux.startsWith(",") || aux.startsWith("(") || aux.startsWith(")") || aux.startsWith("[") || aux.startsWith("]")
                || aux.startsWith(".") || aux.startsWith("{") || aux.startsWith("}")){
                    if (delim.eDelimitador(aux)){
                     tokenAux.setTipo("Delimitador");
                    } else {
                        tokenAux.setTipo("Delimitador mal formado");
                        tokenAux.setTemErro(true);
                    }
            } else {
                tokenAux.setTipo("tipo desconhecido");
                tokenAux.setTemErro(true);
            }
            
            h++;
        }
        
        return listaTokens;
    }
    
}
