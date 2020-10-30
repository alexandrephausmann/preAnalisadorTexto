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
       
        retorno = LeituraTxt.lerArquivo("C:\\Users\\PaschoaliniS2\\Desktop\\Entrada.txt");
        
       // System.out.println(retorno);
        teste.multimap(retorno);
        
        ExportarCSV testarSaida = new ExportarCSV();
        
       /* ArrayList saida = new ArrayList();
        saida.add("uma;");
        saida.add("duas;");
        saida.add("coisas;");*/

        testarSaida.Exportar(retorno);
    }
     
}
