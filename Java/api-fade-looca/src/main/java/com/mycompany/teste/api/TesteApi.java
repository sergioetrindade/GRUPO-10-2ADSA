/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teste.api;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;


/**
 *
 * @author Sérgio
 */
public class TesteApi {
    public static void main(String[] args) {
       Looca looca = new Looca();
       Sistema sistema = looca.getSistema();
       System.out.println(sistema);
       
       Memoria memoria = looca.getMemoria();
       System.out.println(memoria);
       
       Processador processador = looca.getProcessador();
       System.out.println(processador);
       
     
       
       
    }   
}
