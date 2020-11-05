/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preanalisadortexto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import static preanalisadortexto.LeituraTxt.removerAcentos;

/**
 *
 * @author Alexandre
 */
class ExportarCSV {
    
   public void Exportar(ArrayList<ArrayList<String>> conteudo) throws IOException {
	   Writer writer = Files.newBufferedWriter(Paths.get("saida.csv"));
	   BufferedWriter bufferedWriter = new BufferedWriter(writer);
	   String aux;
	   /* String saida[] = {"a; ","b;","borboleta;","outro"} ; 
	   writer.write(saida[0]);
	   writer.flush();
	   writer.write(saida[1]);
	   writer.close(); */
           
           System.out.println("teste conteudo: " + conteudo);
           
           
          
           for (int i = 0; i < conteudo.size(); i++) {
              // System.out.println("alo");
            /**
             * Percorre as sublistas utilizando expressão Lambda (Java 8)
             * Caso não utilize Java 8, substitua por um `for`
             */
             for(int a=0; a<conteudo.get(i).size();a++){
                    
                 //System.out.println( conteudo.get(i).get(a) );
                 bufferedWriter.write(conteudo.get(i).get(a));
                 bufferedWriter.newLine();
                    
                }
   
           // conteudo.get(i).forEach( x -> {
              //  String aux = (String) conteudo.get(i).get(i);
                //String aux = "";
                
               // aux = x;
                //bufferedWriter.write(aux);
		//bufferedWriter.newLine();
                //System.out.println( x );
            //});
        }
	   /*
	   for(int a=0; a<conteudo.size();a++){
		   
                for(int a=0; a<conteudo.get(a).size();a++){
                    
                    
                }
		   String aux = (String) conteudo.get(a);
		   
	   }
	   */
	   bufferedWriter.close();
   }
}
