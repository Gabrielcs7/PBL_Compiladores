package lexico;
/**
 *
 * @author Gabriel
 */
public class ProcuraDelimitadores {
    
    public boolean procuraDelimi(char s){
        //compara com todos os operadores do alfabeto
        if (s == ',' || s == ';' || s == '+' || s == '*' || s == '-' || 
             s == '<' || s == '>' ||  s == '='|| s == '!'||
               s == '('|| s == ')'|| s == '{'|| s == '}'||
                s == ']'|| s == '[' || s == '|' || s == ' ' || s == '!' || s== '/' ){
            return true;
        } else {
            return false;
        }
            
    }
    
    
    public boolean procuraNaoDelimi(char s){
        //compara com todos os operadores do alfabeto
        if (s == ',' || s == ';' || s == '+' || s == '*' || s == '-' || 
             s == '<' || s == '>' ||  s == '='|| s == '!'||
               s == '('|| s == ')'|| s == '{'|| s == '}'||
                s == ']'|| s == '[' || s == '|' || s == ' ' || s == '!' || s== '/' || s == '.' ){
            return true;
        } else {
            return false;
        }
            
    }
    
}
