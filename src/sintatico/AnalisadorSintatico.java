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
public class AnalisadorSintatico {
    
    Gramatica gramatica;
    First first = new First();
    Follow follow = new Follow();
    
    public AnalisadorSintatico (Gramatica gramatica) {

        this.gramatica = gramatica;

        iniciaFirst(this.gramatica.regrasDeProducao);

        iniciaFollow(this.gramatica.regrasDeProducao);

        printFirst();

        System.out.print("\n");

        printFollow();

    }
    
    public void iniciaFirst (ArrayList<RegraD> regrasDeProducao){
        
        int indexSimboloAtual;
        int indexContadorCorpoDaRegraAtual;
        ArrayList<String> terminais = new ArrayList<>();
        
        for (int i = 0; i < regrasDeProducao.size(); i++) {
            
            indexContadorCorpoDaRegraAtual = 0;
            
            for (int j = 0; j < regrasDeProducao.get(i).corpo.size(); j++) {
                indexSimboloAtual = getIndexSimbolo(regrasDeProducao.get(i).simbolo);
                
                while (true){
                    
                    PiecesBody corpoDaRegra = regrasDeProducao.get(indexSimboloAtual).corpo.get(indexContadorCorpoDaRegraAtual);
                    String token = corpoDaRegra.getParte(0);
                    
                    if (isNaoTerminal(token)) {

                        indexSimboloAtual = getIndexSimbolo(token);
                        indexContadorCorpoDaRegraAtual = 0;

                    } else {
                        for (int k = 0; k < regrasDeProducao.get(indexSimboloAtual).corpo.size(); k++) {
                            
                            PiecesBody tokenAtual = regrasDeProducao.get(indexSimboloAtual).corpo.get(k);
                            
                            String itemToken = tokenAtual.getParte(0);
                            
                            if (!isNaoTerminal(itemToken)) {
                                if (terminais.indexOf(itemToken) < 0) {
                                    terminais.add(itemToken);
                                }
                            }
                        }
                        indexContadorCorpoDaRegraAtual++;
                        break;
                    }
                }
            }
            String simboloRegra = regrasDeProducao.get(i).simbolo;
            
            RegraD obgRegra = new RegraD();
            obgRegra.setSimbolo(simboloRegra);
            obgRegra.setFirstRegra(terminais);
            
            first.pushRegra(obgRegra);
            
            regrasDeProducao.get(i).setFirstRegra(terminais);

            terminais = new ArrayList<>();

        }
    }
    
    public void iniciaFollow (ArrayList<RegraD> regrasDeProducao){
        
    }
    
    public void printFirst() {
        System.out.print(first.toString());
    }

    public void printFollow() {
        System.out.print(follow.toString());
    }

    public int getIndexSimbolo(String simbolo) {

        int index = -1;
        for (int i = 0; i < gramatica.regrasDeProducao.size(); i++) {

            if (simbolo.equals(gramatica.regrasDeProducao.get(i).simbolo)) {
                return i;
            }
        }
        return index;
    }

    public boolean isNaoTerminal(String token) {

        for (int k = 0; k < gramatica.naoTerminal.size(); k++) {

            if (token.equals(gramatica.naoTerminal.get(k))) {
                return true;
            }
        }
        return  false;
    }

    public boolean isTerminal(String token) {

        for (int k = 0; k < gramatica.terminal.size(); k++) {

            if (token.equals(gramatica.terminal.get(k))) {
                return true;
            }
        }
        return  false;
    }
}
