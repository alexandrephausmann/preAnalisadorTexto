/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preanalisadortexto;



import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Alexandre
 */
public class PreAnalisadorTexto {

    /**
     * @param args the command line arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        
        // TODO code application logic here
        ArrayList retorno = new ArrayList();
        
        LeituraTxt teste = new LeituraTxt();
        
        //tem que colocar o nome do arquivo aki pra funcionar
       
        retorno = LeituraTxt.lerArquivo("D:\\Dados\\Documentos\\Alexandre\\Unicamp\\4 Semestre\\Poo\\Projeto 1\\parabens.txt");
        
        ArrayList<ArrayList<String>> textoCSV = new ArrayList<ArrayList<String>>();  
       // System.out.println(retorno);
       
        textoCSV = teste.multimap(retorno);
        System.out.println("teste" + textoCSV);
           
        ExportarCSV testarSaida = new ExportarCSV();
        
        testarSaida.Exportar(textoCSV);
        
        
        
       /* ArrayList saida = new ArrayList();
        saida.add("uma;");
        saida.add("duas;");
        saida.add("coisas;");*/
       
        //System.out.println("asfuasfhasufhas");

        //testarSaida.Exportar(retorno);
    }
     
}
