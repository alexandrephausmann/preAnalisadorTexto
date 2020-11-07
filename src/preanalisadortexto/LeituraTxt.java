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
import java.io.FileReader;
import java.text.Normalizer;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

/**
 * Realiza a leitura do arquivo(.txt)
 */
public class LeituraTxt {

    public static ArrayList LerArquivo(String nomeArquivo) {
        String linha = new String();

        File arq = new File(nomeArquivo);
        ArrayList texto = new ArrayList();
        if (arq.exists()) {
            try {
                FileReader leitorArquivos = new FileReader(nomeArquivo);
                BufferedReader bufferArquivo = new BufferedReader(leitorArquivos);

                while (true) {
                    linha = removerAcentos(bufferArquivo.readLine().toLowerCase());
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
                    if (linha == null) {
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return texto;
    }

    public static String removerAcentos(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    /**
    * <p>Uma descrição de como funciona a documentação do MultiMap.
    * <a href="https://docs.oracle.com/middleware/11119/jdev/api-reference-esdk/oracle/javatools/util/MultiMap.html">Clique aqui!</a>
    * </p>     
    */
    
    public static ArrayList<ArrayList<String>> Multimap(ArrayList texto) {

        ArrayList textoCsv = new ArrayList< ArrayList>();
        ListMultimap<String, String> multimap = ArrayListMultimap.create();

        int j = 1;

        for (int i = 0; i < (texto.size() - 1); i++, j++) {
            List<String> Key = multimap.get(texto.get(i).toString().trim());

            if (!Key.contains(texto.get(j).toString().trim())) {
                multimap.put(texto.get(i).toString().trim(), texto.get(j).toString().trim());
            }
        }

        //then
        System.out.println(multimap);
        System.out.println(multimap.keySet());

        //ArrayList<String> matriz = new ArrayList<String>(); 
        ArrayList<ArrayList<String>> matriz = new ArrayList<ArrayList<String>>();

        List<String> textoCompleto = new ArrayList<>(multimap.keySet());
        Collections.sort(textoCompleto);

        //System.out.println(testao);
        String conteudos = new String();

        conteudos = "";

        for (String testes : textoCompleto) {
            List<String> lastNames = multimap.get(testes);

            for (int m = 0; m < lastNames.size(); m++) {

                if (m == (lastNames.size() - 1)) {
                    conteudos += lastNames.get(m);
                } else {
                    conteudos += lastNames.get(m) + ", ";
                }
            }
            System.out.println(testes + ", " + conteudos);
            ArrayList<String> retornoCSV = new ArrayList<String>();

            retornoCSV.add(testes + ", " + conteudos);

            matriz.add(retornoCSV);

            conteudos = "";
        }

        System.out.println(matriz);

        //System.out.println(textoCsv);
        return matriz;

    }

}
