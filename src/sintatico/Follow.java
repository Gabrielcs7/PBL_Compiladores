/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sintatico;

import java.util.ArrayList;

/**
 *
 * @author Aloisio
 */
public class Follow {
    
    ArrayList<RegraD> regra = new ArrayList<>();

    public ArrayList<RegraD> getRegra() {
        return regra;
    }

    public void setRegra(ArrayList<RegraD> regra) {
        this.regra = regra;
    }

    public void pushRegra(RegraD regra) {
        this.regra.add(regra);
    }
    
}
