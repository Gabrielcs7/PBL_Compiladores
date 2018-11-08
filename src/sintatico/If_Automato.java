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
public class If_Automato {
    
    public If_Automato(){
        
    }
    
    public boolean rodaAutomato (ArrayList <Token> listaTokens){
        
        int contador = 0;
        String aux;
        String estadoZ = "Z";
        String estadoA = "A";
        int estado = 0;
        int topoPilha = 0;
        ArrayList <String> pilha = new ArrayList ();
        pilha.add(topoPilha,estadoZ);
      
        while (contador < listaTokens.size()){
            aux = listaTokens.get(contador).getNome();
            if (aux =="if" && pilha.get(topoPilha)=="Z"){
                contador++;
                estado = 1;
                aux = listaTokens.get(contador).getNome();
                if (aux=="(" && pilha.get(topoPilha)=="Z"){
                    contador++;
                    estado = 2;
                    topoPilha++;
                    pilha.add(topoPilha,estadoA);
                    aux = listaTokens.get(contador).getNome();
                    if (expression.rodaAutomato(listaTokensExpression) && pilha.get(topoPilha)=="A"){
                        contador++;
                        estado = 3;
                        aux = listaTokens.get(contador).getNome();
                        //Resolver como pular a expressão e ir pro proximo token
                        if (aux==")" && pilha.get(topoPilha)=="A"){
                            contador++;
                            estado = 4;
                            aux = pilha.remove(topoPilha);
                            topoPilha--;
                            aux = listaTokens.get(contador).getNome();
                            if(aux=="then" && pilha.get(topoPilha)=="Z"){
                                contador++;
                                estado = 5;
                                aux = listaTokens.get(contador).getNome();
                                if (aux=="{" && pilha.get(topoPilha)=="Z"){
                                    contador++;
                                    estado = 6;
                                    topoPilha++;
                                    pilha.add(topoPilha,estadoA);
                                    aux = listaTokens.get(contador).getNome();
                                    if (bodyMethod.rodaAutomato(listaTokensExpression)) && pilha.get(topoPilha)=="A"){
                                       contador++;
                                       estado = 7;
                                       aux = listaTokens.get(contador).getNome();
                                       if (aux=="}" && pilha.get(topoPilha)=="A"){
                                            contador++;
                                            estado = 8; 
                                            aux = pilha.remove(topoPilha);
                                            topoPilha--;
                                            aux = listaTokens.get(contador).getNome();
                                            if (aux==null && pilha.get(topoPilha)=="Z"){
                                                return true;
                                            }
                                       }
                                       else {
                                           throw FaltaFechaChavesIfException;
                                       }
                                    }
                                }
                                else {
                                    throw FaltaAbreChavesIfException;
                                }
                            }
                            else {
                                throw FaltaThenIfException;
                            }
                        }
                        else{
                            throw FaltaFechaCochetesIfException;
                        }
                    }
                    else {
                    }
                }
                else {
                    throw FaltaAbreCochetesIfException;
                }
            }
        }
        return false;
    }

    
}
