
package lexico;

/**
 *
 * @author Gabriel
 */
public class Identificador {
    
    private boolean eValido;
    
    public Identificador (){
        
    }
    
    public void alteraEValidoTrue (){
        
        eValido = true;
    }
    
    public void alteraEValidoFalse (){
        
        eValido = false;
    }
    
    public boolean getEValido (){
        return eValido;
    }
    
    public boolean verifIdentif1 (String a){
        
        char [] caracteres = a.toCharArray();
        
        int i = 0;
        
        alteraEValidoFalse();
        
        int estadoAtual = 0;
        
        while (i < caracteres.length){
            
            if (estadoAtual == 0){
                if (caracteres[i] == 'a'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'A'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'b'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'B'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'c'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'C'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'd'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'D'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'e'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'E'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'f'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'F'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'g'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'G'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'h'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'H'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'i'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'I'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'j'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'J'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'k'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'K'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'l'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'L'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'm'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'M'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'n'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'N'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'o'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'O'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'p'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'P'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'q'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'Q'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'u'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'U'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'v'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'V'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'w'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'w'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'x'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'X'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'y'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'Y'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'z'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'Z'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else {
                    alteraEValidoFalse();
                    break;
                }
            } else if (estadoAtual == 1){
                if (caracteres[i] == 'a'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'A'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'b'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'B'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'c'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'C'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'd'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'D'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'e'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'E'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'f'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'F'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'g'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'G'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'h'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'H'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'i'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'I'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'j'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'J'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'k'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'K'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'l'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'L'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'm'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'M'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'n'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'N'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'o'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'O'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'p'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'P'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'q'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'Q'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'u'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'U'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'v'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'V'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'w'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'w'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'x'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'X'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'y'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'Y'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'z'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'Z'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '0'){
                    estadoAtual = 2;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '1'){
                    estadoAtual = 2;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '2'){
                    estadoAtual = 2;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '3'){
                    estadoAtual = 2;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '4'){
                    estadoAtual = 2;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '5'){
                    estadoAtual = 2;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '6'){
                    estadoAtual = 2;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '7'){
                    estadoAtual = 2;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '8'){
                    estadoAtual = 2;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '9'){
                    estadoAtual = 2;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '_'){
                    estadoAtual = 3;
                    alteraEValidoTrue();
                    
                } else {
                    alteraEValidoFalse();
                    break;
                }
            } else if (estadoAtual == 2){
                if (caracteres[i] == 'a'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'A'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'b'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'B'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'c'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'C'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'd'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'D'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'e'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'E'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'f'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'F'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'g'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'G'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'h'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'H'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'i'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'I'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'j'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'J'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'k'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'K'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'l'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'L'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'm'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'M'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'n'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'N'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'o'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'O'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'p'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'P'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'q'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'Q'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'u'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'U'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'v'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'V'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'w'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'w'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'x'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'X'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'y'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'Y'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'z'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'Z'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '0'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '1'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '2'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '3'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '4'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '5'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '6'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '7'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '8'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '9'){
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '_'){
                    estadoAtual = 3;
                    alteraEValidoTrue();
                    
                } else {
                    alteraEValidoFalse();
                    break;
                }
            } else if (estadoAtual == 3){
                if (caracteres[i] == 'a'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'A'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'b'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'B'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'c'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'C'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'd'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'D'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'e'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'E'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'f'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'F'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'g'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'G'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'h'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'H'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'i'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'I'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'j'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'J'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'k'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'K'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'l'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'L'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'm'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'M'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'n'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'N'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'o'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'O'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'p'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'P'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'q'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'Q'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'u'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'U'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'v'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'V'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'w'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'w'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'x'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'X'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'y'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'Y'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'z'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == 'Z'){
                    estadoAtual = 1;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '0'){
                    estadoAtual = 2;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '1'){
                    estadoAtual = 2;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '2'){
                    estadoAtual = 2;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '3'){
                    estadoAtual = 2;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '4'){
                    estadoAtual = 2;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '5'){
                    estadoAtual = 2;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '6'){
                    estadoAtual = 2;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '7'){
                    estadoAtual = 2;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '8'){
                    estadoAtual = 2;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '9'){
                    estadoAtual = 2;
                    alteraEValidoTrue();
                    
                } else if (caracteres[i] == '_'){
                    alteraEValidoTrue();
                    
                } else {
                    alteraEValidoFalse();
                    break;
                }
            } 
            i++;    
        }
        return getEValido();
    }
    
    public boolean iseValido() {
        return eValido; // método só para teste
    }
    
    public boolean verifIdentif (String s){
        
        char []car  = s.toCharArray();
        int h = 0;
        int estado = 0;
                
        while (h < car.length){
            if (estado == 0){
                if (Character.isLetter(car[h])){
                    eValido = true;
                    estado = 1;
                } else {
                    eValido = false;
                    break;
                }
            } else if (estado == 1){
                if (Character.isLetter(car[h]) || Character.isDigit(car[h]) || car[h] == '_'){
                    estado = 1;
                    eValido = true;
                } 
                else {
                    eValido = false;
                    break;
                }
            } else {
                eValido = false;
                break;
            }
            h++;
        }
        
     return eValido;   
    }
    
    
}
