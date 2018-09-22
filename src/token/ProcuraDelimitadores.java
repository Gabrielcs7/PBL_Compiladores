package token;
/**
 *
 * @author Gabriel
 */
public class ProcuraDelimitadores {
    
    public boolean procuraDelimi(String s){
        //compara com todos os operadores do alfabeto
        if (s.equals(",") || s.equals(";") || s.equals("+") || s.equals("-")|| s.equals("*")|| 
             s.equals("<")|| s.equals(">")||  s.equals("=")|| s.equals("!")||
               s.equals("(")|| s.equals(")")|| s.equals("{")|| s.equals("}")||
                s.equals("]")|| s.equals("[")){
            return true;
        } else{
            return false;
        }
            
    }
    
}
