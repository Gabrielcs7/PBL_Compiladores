package token;

/**
 *
 * @author Gabriel
 */
public class Delimitadores {
    
    private boolean eDelimit; 
    
    public boolean eDelimitador (char c){
        
        int estadoAtual = 0;
        int i = 0;
                if (c == ';' || c == ',' || c == '(' || c == ')' || c == '{' || 
                       c == '}' || c == ']' || c == '[' || c == '.'){
                    return true;
                } else {
                    return false;
                }
        
    }
    
    
    
}
