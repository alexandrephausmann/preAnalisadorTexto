/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preanalisadortexto;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Classe responsável por manipulação do arquivo .properties (arquivo de configuração)
 */
public class Manipulador {

    public static Properties getProp() throws IOException {
        try {
            Properties props = new Properties();
            FileInputStream file = new FileInputStream(
                    "dados.properties");
            props.load(file);
            return props;
        } catch (IOException er) {
            System.out.println("Ocorreu um IOException ao executar o metodo getProp()");
            return null;
        }
    }
}
