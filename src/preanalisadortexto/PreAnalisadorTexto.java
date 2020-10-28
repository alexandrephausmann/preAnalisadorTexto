/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preanalisadortexto;



import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import java.util.ArrayList;


/**
 *
 * @author Alexandre
 */
public class PreAnalisadorTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        ArrayList retorno = new ArrayList();
        
        LeituraTxt teste = new LeituraTxt();
       
        retorno = LeituraTxt.lerArquivo();
        
        teste.multimap(retorno);
        
       // System.out.println(retorno);
        //assertEquals(1, map.size());
       
        /*
        
        
        for (President pres : US_PRESIDENTS_IN_ORDER) {
            
            
          multimap.put(pres.firstName(), pres.lastName());
        }
        for (String firstName : multimap.keySet()) {
          List<String> lastNames = multimap.get(firstName);
          out.println(firstName + ": " + lastNames);
        }*/
      
    }
     
}
