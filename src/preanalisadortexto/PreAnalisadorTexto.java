/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preanalisadortexto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import static preanalisadortexto.Manipulador.getProp;

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
        LeituraTxt leituraTXT = new LeituraTxt();
        Properties prop = getProp();
        ExportarCSV exportar = new ExportarCSV();
        ArrayList<ArrayList<String>> textoCSV = new ArrayList<ArrayList<String>>();
        String path;
        try {
            path = prop.getProperty("Path");

            //Faz a leitura do arquivo
            retorno = LeituraTxt.LerArquivo(path);

            //MultiMap do arquivo.
            textoCSV = leituraTXT.Multimap(retorno);

            //Exporta o arquivo
            exportar.Exportar(textoCSV);
        } 
        catch (NullPointerException e) 
        {
           System.out.println("O valor da propriedade 'Path' está nulo, verifique o arquivo dados.properties!");
        }
        finally
        {
            System.out.println("O arquivo foi exportado com sucesso!");
        }
        //Procura o arquivo de configuração, onde posso alterar de onde quero ler o .txt
        //Nao deixando o caminho hardedcode e dificultando o acesso

    }

}
