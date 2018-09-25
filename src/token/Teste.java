/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package token;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gabriel
 */

//CLASSE DE TESTE PARA VERIFICAR SE TÁ PASSANDO NOS AUTÔMATOS
public class Teste {
    public static void main(String[] args) {
        
         ArrayList <String> listaNumeros = new ArrayList ();
        Scanner ler = new Scanner (System.in);
        System.out.println("DIGITE UM OPERADOR: ");
        String nome = ler.nextLine();
        
        Delimitadores o = new Delimitadores ();
        
       // System.out.println(o.eDelimitador(nome));
        
    }
}
