package token;

/**
 *
 * @author Gabriel
 */
public class Delimitadores {
    
    private boolean eDelimit; 
    
    public boolean eDelimitador (String s){
        
        int estadoAtual = 0;
        char [] caracteres = s.toCharArray();
        int i = 0;
        
        
        while (i < caracteres.length){
            if (estadoAtual == 0){
                if (caracteres[i] == ';' || caracteres[i] == ',' || caracteres[i] == '(' || caracteres[i] == ')' || caracteres[i] == '{' || 
                       caracteres[i] == '}' || caracteres[i] == ']' || caracteres[i] == '[' || caracteres[i] == '.'){
                    eDelimit = true;
                    estadoAtual = 1;
                } else {
                    return false;
                }
                i++;    
           } else {
                return false;
            } 
        }
        
        return eDelimit;
    }
    
    
    
}
