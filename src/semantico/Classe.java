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
public class Classe {
    
    private ArrayList<Variavel> variaveis;
    private ArrayList<Metodo> metodos;
    private Classe heranca;
    
    public Classe (){
        this.variaveis = new ArrayList();
        this.metodos =  new ArrayList();
    }
    
    public boolean verificaSeVariavelExiste (String nomeVariavel){
        boolean retorno =  false;
        int i;
        
        for (i=0; i<getVariaveis().size(); i++){
            if (getVariaveis().get(i).getNome().equals(nomeVariavel)){
                retorno = true;
                break;
            }
        }
        return retorno;
    }
    
    public boolean verificaSeMetodoExiste (String nomeMetodo){
        boolean retorno =  false;
        int i;
        
        for (i=0; i<getVariaveis().size(); i++){
            if (getMetodos().get(i).getNome().equals(nomeMetodo)){
                retorno = true;
                break;
            }
        }
        return retorno;
    }

    /**
     * @return the variaveis
     */
    public ArrayList<Variavel> getVariaveis() {
        return variaveis;
    }

    /**
     * @param variaveis the variaveis to set
     */
    public void setVariaveis(ArrayList<Variavel> variaveis) {
        this.variaveis = variaveis;
    }

    /**
     * @return the metodos
     */
    public ArrayList<Metodo> getMetodos() {
        return metodos;
    }

    /**
     * @param metodos the metodos to set
     */
    public void setMetodos(ArrayList<Metodo> metodos) {
        this.metodos = metodos;
    }

    /**
     * @return the heranca
     */
    public Classe getHeranca() {
        return heranca;
    }

    /**
     * @param heranca the heranca to set
     */
    public void setHeranca(Classe heranca) {
        this.heranca = heranca;
    }
    
}
