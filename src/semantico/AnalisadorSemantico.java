/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantico;

import java.util.ArrayList;
import java.util.Stack;
import lexico.Token;


/**
 *
 * @author Aloisio
 */
public class AnalisadorSemantico {
    
    private ArrayList <Classe> classes = new ArrayList();
    private ArrayList <Constante> constantes = new ArrayList();
    
    
    
    
    public AnalisadorSemantico (){
        
    }
    
    public void classificaEstruturas (ArrayList <Token> listaFinal){
        
    }
    
    // Metodo responsável por fazer a sepação dos termos para a classificação semântica
    public void classificaClasse (ArrayList <Token> listaFinal){
        
        int i, numClasses = 0;
        
        for (i=0; i<listaFinal.size(); i++){
            if (listaFinal.get(i).getTipo().equals("Palavra Reservada") && listaFinal.get(i).getNome().equals("class")){
                i++;
                if (listaFinal.get(i).getTipo().equals("Identificador") && listaFinal.get(i).isTemErro() == false){
                    Classe classe = new Classe();
                    classe.setNome(listaFinal.get(i).getNome());
                    ArrayList<Token> auxList = new ArrayList ();

                    i++;
                    
                    if (listaFinal.get(i).getNome().equals("extends")){
                        i++;
                        if (listaFinal.get(i).isTemErro() == false && listaFinal.get(i).getTipo().equals("Identificador")){
                            classe.setHeranca(listaFinal.get(i).getNome());
                            i++;
                        }
                    }
                    
                    if (listaFinal.get(i).getNome().equals("{")){
                        i++;
                    } else {
                        break;
                    }

                    while (listaFinal.get(i).getNome().equals("class")){
                        auxList.add(listaFinal.get(i));
                        i++;
                    }
                    
                    ArrayList <Variavel> variaveisClasse = new ArrayList ();
                    
                    classificaVariavel(auxList, variaveisClasse);
                    
                    
                    //int j = i+1;
                    /*
                    int auxInt = 0;
                    boolean auxFor = false;
                    Stack pilha = new Stack();
                    String auxString;
       
                    for (int k = j; k<listaFinal.size(); k++){
                        if (listaFinal.get(k).getNome().equals("(") && listaFinal.get(k).isTemErro() == false){
                            auxString = (String)pilha.push(listaFinal.get(k).getNome());
                            auxInt++;
                        } else {
                            break;
                        }
                        
                        if (listaFinal.get(k).getNome().equals(")") && listaFinal.get(k).isTemErro() == false){
                            auxString = (String)pilha.pop();
                            auxInt--;
                        } else {
                            break;
                        }
                    }
                    */
                    getClasses().add(numClasses, classe);
                    numClasses++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        
    }
    
    public void classificaConstante(int i){
    }
    
    public void classificaVariavel(ArrayList <Token> listaAux ,ArrayList <Variavel> variaveis){
    }
    
    public void classificaMetodo(ArrayList <Token> listaAux ,ArrayList <Metodo> metodos){
    }
    
    public void classificaFuncao(int i){
    }
    
    public void classificaExpressao(int i){
    }
    
    public void putMetodosVariaveisPaiFilho (int i){
    }
    
    // Método responsável por fazer a verificação se existe uma constante declarada com o nome recebido em parâmetro
    public boolean verificaSeConstExiste (String nomeConst){
        boolean retorno = false;
        int i;
        //Varre a lista de constantes e verifica um a um
        for (i=0; i<getConstantes().size(); i++){
            if (getConstantes().get(i).getNome().equals(nomeConst)){ // Se a constante em análise for igual ao nome da string recebida como parametro, retorna true
                retorno = true;
                break;
            }
        }
        return retorno;
    }
    
    // Verifica o tipo das variáveis e e se o valor delas está de acordo com o tipo
    public void verificaTiposVariaveis(ArrayList <Variavel> variaveis){
        
        int i;
        int auxInt;
        float auxFloat;
        boolean auxBool;
        String auxString;
        String aux;
        for (i=0; i<variaveis.size(); i++){
            switch (variaveis.get(i).getTipo()) {
                
                case "int":
                    aux = variaveis.get(i).getValor();
                    auxInt = 0;
                    try {
                        auxInt = Integer.parseInt(aux);
                    } catch (NumberFormatException e){
                        variaveis.get(i).setValorIsCorrect(false);
                    } finally {
                        if (auxInt!=0){
                            variaveis.get(i).setValorIsCorrect(true);
                        }
                    } break;
                    
                case "float":
                    aux = variaveis.get(i).getValor();
                    auxFloat=0;
                    try {
                        auxFloat = Float.parseFloat(aux);
                    } catch (NumberFormatException e){
                        variaveis.get(i).setValorIsCorrect(false);
                    } finally {
                        if (auxFloat!=0){
                            variaveis.get(i).setValorIsCorrect(true);
                        }
                    } break;
                    
                case "bool":
                    aux = variaveis.get(i).getValor();
                    if (aux.equals("false") || aux.equals("true")){
                        variaveis.get(i).setValorIsCorrect(true);
                    } else {
                        variaveis.get(i).setValorIsCorrect(false);
                    }
                    break;
                    
                case "string":
                    break;
                    
                default:
                    break;
            }
        }
        
    }
    
    public void verificaTiposConstante(){
        int i;
        int auxInt;
        float auxFloat;
        boolean auxBool;
        String auxString;
        String aux;
        for (i=0; i<getConstantes().size(); i++){
            switch (getConstantes().get(i).getTipo()) {
                
                case "int":
                    aux = getConstantes().get(i).getValor();
                    auxInt = 0;
                    try {
                        auxInt = Integer.parseInt(aux);
                    } catch (NumberFormatException e){
                        getConstantes().get(i).setIsCorrectValue(false);
                    } finally {
                        if (auxInt!=0){
                            getConstantes().get(i).setIsCorrectValue(true);
                        }
                    } break;
                    
                case "float":
                    aux = getConstantes().get(i).getValor();
                    auxFloat=0;
                    try {
                        auxFloat = Float.parseFloat(aux);
                    } catch (NumberFormatException e){
                        getConstantes().get(i).setIsCorrectValue(false);
                    }finally {
                        if (auxFloat!=0){
                            getConstantes().get(i).setIsCorrectValue(true);
                        }
                    } break;
                    
                case "bool":
                    aux = getConstantes().get(i).getValor();
                    if (aux.equals("false")|| aux.equals("true")){
                        getConstantes().get(i).setIsCorrectValue(true);
                    } else {
                        getConstantes().get(i).setIsCorrectValue(false);
                    }
                    break;
                    
                case "string":
                    break;
                    
                default:
                    break;
            }
        }
    }

    public void printConstIncorrectValue (){
        int i;
        boolean aux;
        ArrayList<Constante> constantesIncorretas = new ArrayList();
        for (i=0; i<getConstantes().size(); i++){
            aux = false;
            if (getConstantes().get(i).isIsCorrectValue() == false){
                aux = constantesIncorretas.add(getConstantes().get(i));
                if (aux==false){
                    break;
                }
            }
        }
        
        for (i=0; i<constantesIncorretas.size(); i++){
            System.out.print("A constante '"+constantesIncorretas.get(i).getNome()+"'[LINHA:"+constantesIncorretas.get(i).getLinhaNoCodigo()+"] recebeu um valor diferente do tipo '"+constantesIncorretas.get(i).getTipo()+"'.");
        }
        constantesIncorretas.clear();
    }
    /**
     * @return the classes
     */
    public ArrayList <Classe> getClasses() {
        return classes;
    }

    /**
     * @param classes the classes to set
     */
    public void setClasses(ArrayList <Classe> classes) {
        this.classes = classes;
    }

    /**
     * @return the constantes
     */
    public ArrayList <Constante> getConstantes() {
        return constantes;
    }

    /**
     * @param constantes the constantes to set
     */
    public void setConstantes(ArrayList <Constante> constantes) {
        this.constantes = constantes;
    }
    
}
