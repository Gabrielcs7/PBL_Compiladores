package token;

/**
 *
 * @author Gabriel
 */
public class Delimitadores {
    
    private boolean eDelimit; 
    
    public boolean eDelimitador (String c){
        
        int estadoAtual = 0;
        int i = 0;
                if (c.equals (";") || c.equals (",") || c.equals ("(")|| c.equals (")")|| c.equals ("{") || 
                       c.equals ("}") || c.equals ("]") || c.equals ("[") || c.equals (".")){
                    return true;
                } else {
                    return false;
                }
        
    }
    
    
    
}
