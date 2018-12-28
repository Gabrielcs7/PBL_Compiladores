/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantico;

import java.util.ArrayList;
import lexico.Token;

/**
 *
 * @author Aloisio
 */
public class Expressao {
    
    private ArrayList<Token> tokensExpressao = new ArrayList();
    private String tipoDaExpressao;

    /**
     * @return the tokensExpressao
     */
    public ArrayList<Token> getTokensExpressao() {
        return tokensExpressao;
    }

    /**
     * @param tokensExpressao the tokensExpressao to set
     */
    public void setTokensExpressao(ArrayList<Token> tokensExpressao) {
        this.tokensExpressao = tokensExpressao;
    }

    /**
     * @return the tipoDaExpressao
     */
    public String getTipoDaExpressao() {
        return tipoDaExpressao;
    }

    /**
     * @param tipoDaExpressao the tipoDaExpressao to set
     */
    public void setTipoDaExpressao(String tipoDaExpressao) {
        this.tipoDaExpressao = tipoDaExpressao;
    }
    
}
