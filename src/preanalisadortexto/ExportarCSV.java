/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preanalisadortexto;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Classe que realiza a exportação para .csv
 * Autor:Samantha
 */
public class ExportarCSV {

    public void Exportar(ArrayList<ArrayList<String>> conteudo) throws IOException {
        Writer writer = Files.newBufferedWriter(Paths.get("saida.csv"));
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        String aux;

        try {
            for (int i = 0; i < conteudo.size(); i++) {
                /**
                 * Percorre as sublistas utilizando expressão Lambda (Java 8)
                 * Caso não utilize Java 8, substitua por um `for`
                 */
                for (int a = 0; a < conteudo.get(i).size(); a++) {
                    bufferedWriter.write(conteudo.get(i).get(a));
                    bufferedWriter.newLine();
                }

            }
            bufferedWriter.close();
        } catch (IOException er) {
            System.out.println("Não foi possível exportar arquivo csv" + er.getMessage());
        }
    }
}
