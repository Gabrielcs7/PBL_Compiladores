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
public class Funcao {
    
    private String nomeFuncao;
    private ArrayList<Variavel> variaveis;

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
     * @return the nomeFuncao
     */
    public String getNomeFuncao() {
        return nomeFuncao;
    }

    /**
     * @param nomeFuncao the nomeFuncao to set
     */
    public void setNomeFuncao(String nomeFuncao) {
        this.nomeFuncao = nomeFuncao;
    }
    
}
