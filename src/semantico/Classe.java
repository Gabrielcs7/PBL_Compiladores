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
    
    private String nome;
    private ArrayList<Variavel> variaveis;
    private ArrayList<Metodo> metodos;
    private String herancaString;
    private int linhaNoCodigo;
    
    public Classe (){
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
    public String getHeranca() {
        return herancaString;
    }

    /**
     * @param heranca the heranca to set
     */
    public void setHeranca(String heranca) {
        this.herancaString = heranca;
    }

    /**
     * @return the linhaNoCodigo
     */
    public int getLinhaNoCodigo() {
        return linhaNoCodigo;
    }

    /**
     * @param linhaNoCodigo the linhaNoCodigo to set
     */
    public void setLinhaNoCodigo(int linhaNoCodigo) {
        this.linhaNoCodigo = linhaNoCodigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
