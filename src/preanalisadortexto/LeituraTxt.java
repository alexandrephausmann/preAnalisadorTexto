/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preanalisadortexto;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

/**
 * Realiza a leitura do arquivo(.txt)
 * Autor: Alexandre
 */
public class LeituraTxt {

    public static ArrayList LerArquivo(String nomeArquivo) {
            
        String linha = new String();
        
        File arq = new File(nomeArquivo);
        ArrayList texto = new ArrayList();
        if (arq.exists()) {
            try {
                
                //FileReader leitorArquivos = new FileReader(nomeArquivo);
                
                BufferedReader bufferArquivo = new BufferedReader(new InputStreamReader(new FileInputStream(nomeArquivo), "UTF-8"));

                while (true) {
                    linha = bufferArquivo.readLine().toLowerCase();
                    if (linha == null) {
                        break;
                    }
                    linha = linha.trim();
                    linha = linha.replace(".", ""); //tira ponto
                    linha = linha.replace("/", ""); //tira barra
                    linha = linha.replace("-", ""); //tira hifen 
                    //linha = linha.replace( " " , ""); //tira espaco em branco
                    linha = linha.replace(",", ""); //tira virgula
                    linha = linha.replace(";", ""); //tira ponto e virgula
                    linha = linha.replace(":", ""); //tira dois pontos
                    linha = linha.replace("!", ""); //tira ponto de exclamacao
                    linha = linha.replace("?", ""); //tira ponto de interrogacao

                    String[] textoSeparado = linha.split(" ");

                    for (String nome : textoSeparado) {
                        if (!linha.trim().equals("")) {
                            texto.add(nome.trim());
                        }
                    }
                }
            }catch (Exception e) {
                System.out.println(e);
            }
        }
        return texto;
    }
    
    /**
     * <p>
     * Uma descrição de como funciona a documentação do MultiMap.
     * <a href="https://docs.oracle.com/middleware/11119/jdev/api-reference-esdk/oracle/javatools/util/MultiMap.html">Clique
     * aqui!</a>
     * </p>
     */
    public static ArrayList<ArrayList<String>> Multimap(ArrayList texto) {

        ListMultimap<String, String> multimap = ArrayListMultimap.create();

        int j = 1;

        for (int i = 0; i < (texto.size() - 1); i++,j++) {
            List<String> Key = multimap.get(texto.get(i).toString().trim());

            if (!Key.contains(texto.get(j).toString().trim())) {
                multimap.put(texto.get(i).toString().trim(), texto.get(j).toString().trim());
            }
        }
        
        ArrayList<ArrayList<String>> matrizCSV = new ArrayList<ArrayList<String>>();

        List<String> textoCompleto = new ArrayList<>(multimap.keySet());
        Collections.sort(textoCompleto);
        String conteudos = new String();

        conteudos = "";

        for (String chavePrimaria : textoCompleto) {
            List<String> lastNames = multimap.get(chavePrimaria);

            for (int m = 0; m < lastNames.size(); m++) {

                if (m == (lastNames.size() - 1)) {
                    conteudos += lastNames.get(m);
                } else {
                    conteudos += lastNames.get(m) + ", ";
                }
            }   
            
            ArrayList<String> linhaCSV = new ArrayList<String>();

            linhaCSV.add(chavePrimaria + ", " + conteudos);

            matrizCSV.add(linhaCSV);

            conteudos = "";
        }
        
        return matrizCSV;

    }

}
