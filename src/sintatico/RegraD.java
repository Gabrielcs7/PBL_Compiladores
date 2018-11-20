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
public class RegraD {
    
    String simbolo;

    ArrayList<PiecesBody> corpo = new ArrayList<>();
    
    private ArrayList<String> firstRegra;
    
    private ArrayList<String> followRegra;
    
    public RegraD (String simbolo, String corpo){
        
        this.simbolo = simbolo;
        String aux = corpo;
        
        String str = "";
        for (int i = 0; i < aux.length(); i++) {

            String token = "" + aux.charAt(i);

            if (token.equals("|")) {
                PiecesBody partes = new PiecesBody(str);
                this.corpo.add(partes);
                str = "";
            } else {
                str += token;
            }

        }
        PiecesBody partesAux = new PiecesBody(str);
        this.corpo.add(partesAux);
    }
    
    public RegraD() {
    }
    
    public String getSimbolo() {
        return simbolo;
    }
    
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public ArrayList<PiecesBody> getCorpo() {
        return corpo;
    }

    public void setCorpo(ArrayList<PiecesBody> corpo) {
        this.corpo = corpo;
    }

    public void pushCorpo(ArrayList<PiecesBody> corpo) {
        this.corpo.addAll(corpo);
    }

    /**
     * @return the firstRegra
     */
    public ArrayList<String> getFirstRegra() {
        return firstRegra;
    }

    /**
     * @param firstRegra the firstRegra to set
     */
    public void setFirstRegra(ArrayList<String> firstRegra) {
        this.firstRegra = firstRegra;
    }

    /**
     * @return the followRegra
     */
    public ArrayList<String> getFollowRegra() {
        return followRegra;
    }

    /**
     * @param followRegra the followRegra to set
     */
    public void setFollowRegra(ArrayList<String> followRegra) {
        this.followRegra = followRegra;
    }
    
}
