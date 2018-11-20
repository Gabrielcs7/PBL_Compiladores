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
        naoTerminais.add("<More Constants>");
        naoTerminais.add("<Constant>");
        naoTerminais.add("<More Attributions>");
        naoTerminais.add("<ConstAttribution>");
        naoTerminais.add("<Value>");
        naoTerminais.add("<Variable Declaration>");
        naoTerminais.add("<Variable>");
        naoTerminais.add("<Variable2>");
        naoTerminais.add("<More Variables>");
        naoTerminais.add("<Name>");
        naoTerminais.add("<More Names>");
        naoTerminais.add("<Method Declaration>");
        naoTerminais.add("<More Methods>");
        naoTerminais.add("<Parameter Declaration>");
        naoTerminais.add("Parameter Declaration2");
        naoTerminais.add("<Type>");
        naoTerminais.add("<More Parameters>");
        naoTerminais.add("<Array Verification>");
        naoTerminais.add("<DoubleArray>");
        naoTerminais.add("<Array Index>");
        naoTerminais.add("<Return>");
        naoTerminais.add("<Return1>");
        naoTerminais.add("<Commands>");
        naoTerminais.add("<If Statement>");
        naoTerminais.add("<Else Statement>");
        naoTerminais.add("<While Statement>");
        naoTerminais.add("<Attribution>");
        naoTerminais.add("<Verif>");
        naoTerminais.add("<Increment>");
        naoTerminais.add("<Normal Attribution2>");
        naoTerminais.add("<Normal Attribution3>");
        naoTerminais.add("<Expression>");
        naoTerminais.add("<A>");
        naoTerminais.add("<And Exp>");
        naoTerminais.add("<B>");
        naoTerminais.add("<Rel Exp>");
        naoTerminais.add("<C>");
        naoTerminais.add("<Add Exp>");
        naoTerminais.add("<D>");
        naoTerminais.add("<Mult Exp>");
        naoTerminais.add("<E>");
        naoTerminais.add("<Neg Exp>");
        naoTerminais.add("<F>");
        naoTerminais.add("<G>");
        naoTerminais.add("<H>");
        naoTerminais.add("<Exp Value>");
        naoTerminais.add("<Param2>");
        naoTerminais.add("<Complement>");
        naoTerminais.add("<Param>");
        naoTerminais.add("<MoreParam>");
        naoTerminais.add("<ObrigatoryParam>");
        naoTerminais.add("<Read Statement>");
        naoTerminais.add("<Reading_1>");
        naoTerminais.add("<More Readings>");
        naoTerminais.add("<Write Statement>");
        naoTerminais.add("<Writing_1>");
        naoTerminais.add("<More Writings>");
        naoTerminais.add("<Attr>");
        
        
        //Adiciona as regras de produção
        regrasDeProducao.add(new RegraD("<Global>","<Constant Declaration><Class Declaration><More Classes>"));
        regrasDeProducao.add(new RegraD("<More Classes>","<Class Declaration><More Classes>|ε"));
        regrasDeProducao.add(new RegraD("<Class Declaration>","'class'<Class Identification>"));
        regrasDeProducao.add(new RegraD("<Class Identification>","Identifier<Class Heritage>'{'<Class Body>'}'"));
        regrasDeProducao.add(new RegraD("<Class Heritage>","'extends'Identifier|ε"));
        regrasDeProducao.add(new RegraD("<Class Body>","<Class Attributes><Class Methods>"));
        regrasDeProducao.add(new RegraD("<Class Attributes>","<Variable Declaration>"));
        regrasDeProducao.add(new RegraD("<Class Methods>","<Method Declaration>|ε"));
        regrasDeProducao.add(new RegraD("<Constant Declaration>","'const''{'<Constants>'}'|ε"));
        regrasDeProducao.add(new RegraD("<Constants>","<Constant><More Constants>"));
        regrasDeProducao.add(new RegraD("<More Constants>","ε|<Constants>"));
        regrasDeProducao.add(new RegraD("<Constant>","Type<ConstAttribution>|<More Attributions>"));
        regrasDeProducao.add(new RegraD("<More Attributions>","','<ConstAttribution>|';'"));
        regrasDeProducao.add(new RegraD("<ConstAttribution>","Identifier'='<Value>"));
        regrasDeProducao.add(new RegraD("<Value>","Number|'true'|'false'|CadeCaracters"));
        regrasDeProducao.add(new RegraD("<Variable Declaration>","'variables''{'<Variable>'}'|ε"));
        regrasDeProducao.add(new RegraD("<Variable>","Type<Variable2>|Identifier<Variable2>"));
        regrasDeProducao.add(new RegraD("<Variable2>","<Name><More Variables>"));
        regrasDeProducao.add(new RegraD("<More Variables>","<Variable>|ε"));
        regrasDeProducao.add(new RegraD("<Name>","Identifier<Array Verification><More Names>"));
        regrasDeProducao.add(new RegraD("<More Names>","','<Name>|';'"));
        regrasDeProducao.add(new RegraD("<Method Declaration>","'method'<Type>Identifier'('<Parameter Declaration>')''{'<Variable Declaration><Commands>'}'<More Methods>"));
        regrasDeProducao.add(new RegraD("<More Methods>","<Method Declaration>|ε"));
        regrasDeProducao.add(new RegraD("<Parameter Declaration>","<Parameter Declaration2>|ε"));
        regrasDeProducao.add(new RegraD("<Parameter Declaration2>","<Type>Identifier<Array Verification><More Parameters>"));
        regrasDeProducao.add(new RegraD("<Type>","Type|Identifier"));
        regrasDeProducao.add(new RegraD("<More Parameters>","','<Parameter Declaration2>|ε"));
        regrasDeProducao.add(new RegraD("<Array Verification>","'['<Array Index>']'<DoubleArray>|ε"));
        regrasDeProducao.add(new RegraD("<DoubleArray>","'['<Array Index>']'|ε"));
        regrasDeProducao.add(new RegraD("<Array Index>","<Add Exp>"));
        regrasDeProducao.add(new RegraD("<Return>","'return'<Return1>"));
        regrasDeProducao.add(new RegraD("<Return1>","Identifier<Array Verification>|<Value>"));
        regrasDeProducao.add(new RegraD("<Commands>","<If Statement><Commands>|ε|<While Statement><Commands>|<Read Statement><Commands>|<Attribution>';'<Commands>|<Write Statement><Commands>|<Return>';'"));
        regrasDeProducao.add(new RegraD("<If Statement>","'if''('<Expression>')''then''{'<Commands>'}'<Else Statement>"));
        regrasDeProducao.add(new RegraD("<Else Statement>","'else''{'<Commands>'}'|ε"));
        regrasDeProducao.add(new RegraD("<While Statement>","'while''('<Expression>')''{'<Commands>'}'"));
        regrasDeProducao.add(new RegraD("<Attribution>","<Increment>Identifier<Array Verification><Attr>|Identifier<Array Verification><Attr><Verif>"));
        regrasDeProducao.add(new RegraD("<Verif>","<Normal Attribution2>|<Complement>"));
        regrasDeProducao.add(new RegraD("<Increment>","'++'|'--'"));
        regrasDeProducao.add(new RegraD("<Normal Attribution2>","'='<Normal Attribution3>|<Increment>"));
        regrasDeProducao.add(new RegraD("<Normal Attribution3>","<Expression>|CadeCaracters"));
        regrasDeProducao.add(new RegraD("<Expression>","<And Exp><A>"));
        regrasDeProducao.add(new RegraD("<A>","'||'<Expression>|ε"));
        regrasDeProducao.add(new RegraD("<And Exp>","<Rel Exp><B>"));
        regrasDeProducao.add(new RegraD("<B>","'&&'<And Exp>|ε"));
        regrasDeProducao.add(new RegraD("<Rel Exp>","<Add Exp><C>"));
        regrasDeProducao.add(new RegraD("<C>","RelationalOperator<Rel Exp>|ε"));
        regrasDeProducao.add(new RegraD("<D>","'+'<Add Exp>|'-'<Add Exp>|ε"));
        regrasDeProducao.add(new RegraD("<Mult Exp>","<Neg Exp><E>"));
        regrasDeProducao.add(new RegraD("<E>","'*'<Mult Exp>|'/'<Mult Exp>|ε"));
        regrasDeProducao.add(new RegraD("<Neg Exp>","'-'<F>|<Exp Value><G>|'!'<H><Exp Value>|'++'<Exp Value>|'--'<Exp Value>"));
        regrasDeProducao.add(new RegraD("<F>","'-'<Exp Value>|<Exp Value>"));
        regrasDeProducao.add(new RegraD("<G>","'--'|'++'|ε"));
        regrasDeProducao.add(new RegraD("<H>","'!'<H>|ε"));
        regrasDeProducao.add(new RegraD("<Exp Value>","Number|'('<Expression>')'| Identifier<Array Verification><Attr><Param2>|'true'|'false'"));
        regrasDeProducao.add(new RegraD("<Param2>","<Complement>|ε"));
        regrasDeProducao.add(new RegraD("<Complement>","'('<Param>')'"));
        regrasDeProducao.add(new RegraD("<Param>","ε|<Expression><MoreParam>|CadeCaracters<MoreParam>"));
        regrasDeProducao.add(new RegraD("<MoreParam>","','<ObrigatoryParam>|ε"));
        regrasDeProducao.add(new RegraD("<ObrigatoryParam>","<Expression><MoreParam>|CadeCaracters<MoreParam>"));
        regrasDeProducao.add(new RegraD("<Read Statement>","'read''('<Reading_1>')'';'"));
        regrasDeProducao.add(new RegraD("<Reading_1>","Identifier<Array Verification><Attr><More Readings>"));
        regrasDeProducao.add(new RegraD("<More Readings>","','<Reading_1>|ε"));
        regrasDeProducao.add(new RegraD("<Write Statement>","'write''('<Writing_1>')'';'"));
        regrasDeProducao.add(new RegraD("<Writing_1>","Identifier<Array Verification><Attr><More Writings>|CadeCaracters<More Writings>"));
        regrasDeProducao.add(new RegraD("<More Writings>","','<Writing_1>|ε"));
        regrasDeProducao.add(new RegraD("<Attr>","'.'Identifier<Array Verification><Attr>|ε"));
        
        
        String simboloInicial = "<Global>";
        
        Gramatica gramatica = new Gramatica(terminais, naoTerminais, regrasDeProducao, simboloInicial);
        
        AnalisadorSintatico analisador = new AnalisadorSintatico(gramatica);
        
        
    }
    
    public static void main(String[] args) {
        Principal initProg = new Principal();
    }
    
}
