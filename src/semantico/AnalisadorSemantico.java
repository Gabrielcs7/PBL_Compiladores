/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantico;

import java.util.ArrayList;


/**
 *
 * @author Aloisio
 */
public class AnalisadorSemantico {
    
    private ArrayList <Classe> classes;
    private ArrayList <Constante> constantes;
    
    
    
    
    public AnalisadorSemantico (){
        this.classes = new ArrayList();
        this.constantes = new ArrayList();
    }
    
    public void classificaEstruturas (){
        
    }
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
                    }   if (auxInt!=0){
                        variaveis.get(i).setValorIsCorrect(true);
                    }   break;
                    
                case "float":
                    aux = variaveis.get(i).getValor();
                    auxFloat=0;
                    try {
                        auxFloat = Float.parseFloat(aux);
                    } catch (NumberFormatException e){
                        variaveis.get(i).setValorIsCorrect(false);
                    }   if (auxFloat!=0){
                        variaveis.get(i).setValorIsCorrect(true);
                    }
                    break;
                    
                case "bool":
                    aux = variaveis.get(i).getValor();
                    if (aux == "false" || aux == "true"){
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
                    }   if (auxInt!=0){
                        getConstantes().get(i).setIsCorrectValue(true);
                    }   break;
                    
                case "float":
                    aux = getConstantes().get(i).getValor();
                    auxFloat=0;
                    try {
                        auxFloat = Float.parseFloat(aux);
                    } catch (NumberFormatException e){
                        getConstantes().get(i).setIsCorrectValue(false);
                    }   if (auxFloat!=0){
                        getConstantes().get(i).setIsCorrectValue(true);
                    }
                    break;
                    
                case "bool":
                    aux = getConstantes().get(i).getValor();
                    if (aux == "false" || aux == "true"){
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
