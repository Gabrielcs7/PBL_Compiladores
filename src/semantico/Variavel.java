/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantico;

/**
 *
 * @author Aloisio
 */
public class Variavel {

    private String nome;
    private String tipo;
    private String valor;
    private boolean valorIsCorrect;
    private int linhaNoCodigo;
    
    
    public Variavel (){
        
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
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the valorIsCorrect
     */
    public boolean isValorIsCorrect() {
        return valorIsCorrect;
    }

    /**
     * @param valorIsCorrect the valorIsCorrect to set
     */
    public void setValorIsCorrect(boolean valorIsCorrect) {
        this.valorIsCorrect = valorIsCorrect;
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
