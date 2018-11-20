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
public class Principal {
    
    String EPSILON = "ε";
    
    public Principal (){
        
        ArrayList<String> terminais = new ArrayList<>();
        ArrayList<String> naoTerminais = new ArrayList<>();
        ArrayList<RegraD> regrasDeProducao = new ArrayList<>();
        
        //Adiciona os simbolos terminais
        
        terminais.add(EPSILON);
        terminais.add("(");
        terminais.add(")");
        terminais.add("\");
        terminais.add("/");
        terminais.add("{");
        terminais.add("}");
        terminais.add("[");
        terminais.add("]");
        terminais.add("Identifier");
        terminais.add("Number");
        terminais.add("CadeCaracters");
        terminais.add("Type");
        terminais.add("RelationalOperator");
        terminais.add("class");
        terminais.add("extends");
        terminais.add("const");
        terminais.add(",");
        terminais.add(";");
        terminais.add("true");
        terminais.add("false");
        terminais.add("variables");
        terminais.add("method");
        terminais.add("return");
        terminais.add("if");
        terminais.add("then");
        terminais.add("else");
        terminais.add("while");
        terminais.add("++");
        terminais.add("--");
        terminais.add("=");
        terminais.add("||");
        terminais.add("&&");
        terminais.add("+");
        terminais.add("-");
        terminais.add("*");
        terminais.add("!");
        terminais.add("read");
        terminais.add("write");
        
        //Adiciona os simbolos não terminais
        naoTerminais.add("<Global>");
        naoTerminais.add("<More Classes>");
        naoTerminais.add("<Class Declaration>");
        naoTerminais.add("<Class Identification>");
        naoTerminais.add("<Class Heritage>");
        naoTerminais.add("<Class Body>");
        naoTerminais.add("<Class Attributes>");
        naoTerminais.add("<Class Methods>");
        naoTerminais.add("<Constant Declaration>");
        naoTerminais.add("<Constants>");
        
        
        //Adiciona as regras de produção
        
    }
    
}
