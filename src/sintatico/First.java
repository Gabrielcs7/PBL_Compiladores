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
public class First {
    
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
    
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < regra.size(); i++) {
            str += "\nFirst(" + regra.get(i).getSimbolo() + ") = " + regra.get(i).getFirstRegra().toString();
        }
        return str;
    }
}
