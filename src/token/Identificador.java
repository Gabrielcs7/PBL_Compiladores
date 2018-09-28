
package token;

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
    
    public boolean verifIdentif (String a){
        
        char [] caracteres = a.toCharArray();
        
        int i = 0;
        int j = 0;
        char [] letras = {'a','A','b','B','c','C','d','D','e','E','f','F','g','G','h','H','i','I','j','J','k','K','l','L','m','M','n','N','o','O','p','P','q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z'};
        
        eValido = false;
        
        int [] estado = {0,1,2,3}; //conjunto de estados do autômato
        int estadoAtual = 0;
        
        while (i < caracteres.length){
            
            if (estadoAtual == 0){
                if (caracteres[i] == 'a'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'A'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'b'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'B'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'c'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'C'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'd'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'D'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'e'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'E'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'f'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'F'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'g'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'G'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'h'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'H'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'i'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'I'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'j'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'J'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'k'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'K'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'l'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'L'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'm'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'M'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'n'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'N'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'o'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'O'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'p'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'P'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'q'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'Q'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'u'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'U'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'v'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'V'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'w'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'w'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'x'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'X'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'y'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'Y'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'z'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'Z'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == ' '){
                    eValido = true;
                    break;
                }else {
                    eValido = false;
                    break;
                }
            } else if (estadoAtual == 1){
                if (caracteres[i] == 'a'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'A'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'b'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'B'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'c'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'C'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'd'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'D'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'e'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'E'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'f'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'F'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'g'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'G'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'h'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'H'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'i'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'I'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'j'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'J'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'k'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'K'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'l'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'L'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'm'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'M'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'n'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'N'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'o'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'O'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'p'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'P'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'q'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'Q'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'u'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'U'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'v'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'V'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'w'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'w'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'x'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'X'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'y'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'Y'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'z'){
                    eValido = true;
                    
                } else if (caracteres[i] == 'Z'){
                    eValido = true;
                    
                } else if (caracteres[i] == '0'){
                    estadoAtual = 2;
                    eValido = true;
                    
                } else if (caracteres[i] == '1'){
                    estadoAtual = 2;
                    eValido = true;
                    
                } else if (caracteres[i] == '2'){
                    estadoAtual = 2;
                    eValido = true;
                    
                } else if (caracteres[i] == '3'){
                    estadoAtual = 2;
                    eValido = true;
                    
                } else if (caracteres[i] == '4'){
                    estadoAtual = 2;
                    eValido = true;
                    
                } else if (caracteres[i] == '5'){
                    estadoAtual = 2;
                    eValido = true;
                    
                } else if (caracteres[i] == '6'){
                    estadoAtual = 2;
                    eValido = true;
                    
                } else if (caracteres[i] == '7'){
                    estadoAtual = 2;
                    eValido = true;
                    
                } else if (caracteres[i] == '8'){
                    estadoAtual = 2;
                    eValido = true;
                    
                } else if (caracteres[i] == '9'){
                    estadoAtual = 2;
                    eValido = true;
                    
                } else if (caracteres[i] == '_'){
                    estadoAtual = 3;
                    eValido = true;
                    
                } else if (caracteres[i] == ' '){
                    eValido = true;
                    break;
                } else {
                    eValido = false;
                    break;
                }
            } else if (estadoAtual == 2){
                if (caracteres[i] == 'a'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'A'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'b'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'B'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'c'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'C'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'd'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'D'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'e'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'E'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'f'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'F'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'g'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'G'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'h'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'H'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'i'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'I'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'j'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'J'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'k'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'K'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'l'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'L'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'm'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'M'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'n'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'N'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'o'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'O'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'p'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'P'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'q'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'Q'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'u'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'U'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'v'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'V'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'w'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'w'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'x'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'X'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'y'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'Y'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'z'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'Z'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == '0'){
                    eValido = true;
                    
                } else if (caracteres[i] == '1'){
                    eValido = true;
                    
                } else if (caracteres[i] == '2'){
                    eValido = true;
                    
                } else if (caracteres[i] == '3'){
                    eValido = true;
                    
                } else if (caracteres[i] == '4'){
                    eValido = true;
                    
                } else if (caracteres[i] == '5'){
                    eValido = true;
                    
                } else if (caracteres[i] == '6'){
                    eValido = true;
                    
                } else if (caracteres[i] == '7'){
                    eValido = true;
                    
                } else if (caracteres[i] == '8'){
                    eValido = true;
                    
                } else if (caracteres[i] == '9'){
                    eValido = true;
                    
                } else if (caracteres[i] == '_'){
                    estadoAtual = 3;
                    eValido = true;
                    
                } else if (caracteres[i] == ' '){
                    eValido = true;
                    break;
                    
                } else {
                    eValido = false;
                    break;
                }
            } else if (estadoAtual == 3){
                if (caracteres[i] == 'a'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'A'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'b'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'B'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'c'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'C'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'd'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'D'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'e'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'E'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'f'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'F'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'g'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'G'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'h'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'H'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'i'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'I'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'j'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'J'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'k'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'K'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'l'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'L'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'm'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'M'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'n'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'N'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'o'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'O'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'p'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'P'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'q'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'Q'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'u'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'U'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'v'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'V'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'w'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'w'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'x'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'X'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'y'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'Y'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'z'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == 'Z'){
                    estadoAtual = 1;
                    eValido = true;
                    
                } else if (caracteres[i] == '0'){
                    estadoAtual = 2;
                    eValido = true;
                    
                } else if (caracteres[i] == '1'){
                    estadoAtual = 2;
                    eValido = true;
                    
                } else if (caracteres[i] == '2'){
                    estadoAtual = 2;
                    eValido = true;
                    
                } else if (caracteres[i] == '3'){
                    estadoAtual = 2;
                    eValido = true;
                    
                } else if (caracteres[i] == '4'){
                    estadoAtual = 2;
                    eValido = true;
                    
                } else if (caracteres[i] == '5'){
                    estadoAtual = 2;
                    eValido = true;
                    
                } else if (caracteres[i] == '6'){
                    estadoAtual = 2;
                    eValido = true;
                    
                } else if (caracteres[i] == '7'){
                    estadoAtual = 2;
                    eValido = true;
                    
                } else if (caracteres[i] == '8'){
                    estadoAtual = 2;
                    eValido = true;
                    
                } else if (caracteres[i] == '9'){
                    estadoAtual = 2;
                    eValido = true;
                    
                } else if (caracteres[i] == '_'){
                    eValido = true;
                    
                } else if (caracteres[i] == ' '){
                    eValido = true;
                    break;
                    
                } else {
                    eValido = false;
                    break;
                }
            } 
            i++;    
        }
        return eValido;
    }
    
    public boolean iseValido() {
        return eValido; // método só para teste
    }
}
