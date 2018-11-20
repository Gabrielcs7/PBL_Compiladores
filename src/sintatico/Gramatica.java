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
public class Gramatica {
    
    ArrayList<String> terminal;

    ArrayList<String> naoTerminal;

    ArrayList<RegraD> regrasDeProducao;

    String simboloInicial;
    
    public Gramatica(ArrayList<String> terminal, ArrayList<String> naoTerminal, ArrayList<RegraD> regrasDeProducao, String simboloInicial) {
        this.terminal = terminal;
        this.naoTerminal = naoTerminal;
        this.regrasDeProducao = regrasDeProducao;
        this.simboloInicial = simboloInicial;
    }
}
