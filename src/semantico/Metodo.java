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
public class Metodo {
    
    private String nome;
    private String tipoRetorno;
    private boolean retornoIsCorrect;
    private int linhaNoCodigo;
    private ArrayList<Variavel> variaveis;
    private ArrayList parametros;
    private ArrayList <Funcao> funcoes;
    
    public Metodo (){
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

    /**
     * @return the tipoRetorno
     */
    public String getTipoRetorno() {
        return tipoRetorno;
    }

    /**
     * @param tipoRetorno the tipoRetorno to set
     */
    public void setTipoRetorno(String tipoRetorno) {
        this.tipoRetorno = tipoRetorno;
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
     * @return the parametros
     */
    public ArrayList getParametros() {
        return parametros;
    }

    /**
     * @param parametros the parametros to set
     */
    public void setParametros(ArrayList parametros) {
        this.parametros = parametros;
    }

    /**
     * @return the funcoes
     */
    public ArrayList <Funcao> getFuncoes() {
        return funcoes;
    }

    /**
     * @param funcoes the funcoes to set
     */
    public void setFuncoes(ArrayList <Funcao> funcoes) {
        this.funcoes = funcoes;
    }

    /**
     * @return the retornoIsCorrect
     */
    public boolean isRetornoIsCorrect() {
        return retornoIsCorrect;
    }

    /**
     * @param retornoIsCorrect the retornoIsCorrect to set
     */
    public void setRetornoIsCorrect(boolean retornoIsCorrect) {
        this.retornoIsCorrect = retornoIsCorrect;
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
    
}
