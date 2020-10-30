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
    
   public void Exportar(ArrayList conteudo) throws IOException {
	   Writer writer = Files.newBufferedWriter(Paths.get("saida.csv"));
	   BufferedWriter bufferedWriter = new BufferedWriter(writer);
	   
	   /* String saida[] = {"a; ","b;","borboleta;","outro"} ; 
	   writer.write(saida[0]);
	   writer.flush();
	   writer.write(saida[1]);
	   writer.close(); */
	   
	   for(int a=0; conteudo.size()>a;a++){
		   
		   String aux = (String) conteudo.get(a);
		   bufferedWriter.write(aux);
		   bufferedWriter.newLine();
	   }
	   
	   bufferedWriter.close();
   }
}
