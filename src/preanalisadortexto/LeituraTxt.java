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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alexandre
 */
public class LeituraTxt {
    /*
    public String modelo;
    public String cor;
    private float ponta;
    protected int carga;
    protected boolean tampada;
   
    public void status()
    {
            System.out.println("Modelo: " +this.modelo);
            System.out.println("Uma caneta " + this.cor);
            System.out.println("Ponta: " + this.ponta);
            System.out.println("Carga: " + this.carga);
            System.out.println("Está tampada? " + this.tampada);
    }*/

  

    public static ArrayList lerArquivo()
    {
        String linha = new String();
        String nomeArquivo = "D:\\Dados\\Documentos\\Alexandre\\Unicamp\\4 Semestre\\Poo\\Projeto 1\\Ex5_TresMotivosParaVacinarSeuPet.txt";
        String nomeArquivo2 = "D:\\Dados\\Documentos\\Alexandre\\Unicamp\\4 Semestre\\Poo\\Projeto 1\\Ex4_Parabens.txt";
        File arq = new File(nomeArquivo);
        ArrayList texto = new ArrayList();
        if(arq.exists()){
                   
            try{
                
                FileReader leitorArquivos = new FileReader(nomeArquivo);
                BufferedReader bufferArquivo = new BufferedReader(leitorArquivos);
                    
                while(true){
                    
                   
                    linha = removerAcentos(bufferArquivo.readLine().toLowerCase());
                    linha = linha.trim();
                    linha = linha.replace( "." , ""); //tira ponto
                    linha = linha.replace( "/" , ""); //tira barra
                    linha = linha.replace( "-" , ""); //tira hífen 
                    //linha = linha.replace( " " , ""); //tira espaço em branco
                    linha = linha.replace( "," , ""); //tira virgula
                    linha = linha.replace( ";" , ""); //tira ponto
                    linha = linha.replace( ":" , ""); //tira ponto
                    linha = linha.replace( "!" , ""); //tira ponto
                    linha = linha.replace( "?" , ""); //tira ponto
                    
                    
                   // System.out.println(linha);
                   // ArrayList lista = new ArrayList();     
                    
                   // lista.add(linha);
                    
                    String[] textoSeparado = linha.split(" ");
                   // System.out.println(textoSeparado);
                    //System.out.println(textoSeparado);
                  //  System.out.println(Arrays.toString(textoSeparado));
                  //  System.out.println(textoSeparado.length);
                    
                    for(String nome : textoSeparado){
                        if(!linha.trim().equals("")){
                            texto.add(nome.trim());
                           // System.out.println(nome.trim());
                            
                        }
                    }
                //    System.out.println(texto);
/*
                    
                        texto.add(Arrays.toString(textoSeparado).replace("[","").replace("]",""));
                    }
                    */
                    
                    //System.out.println(texto);
                    //lista.trimToSize();

                    
                    if(linha == null){
                         break;
                    } 
                        
                       
     
                    
                } 
                
                
            }catch(Exception e){
                
                
            }
        
        //System.out.println(texto);

        }
      /*  
        Map m = new HashMap();

        m.put(objetoChave, objetoValor);*/
           
        return texto;

    }
    public static String removerAcentos(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
    
    public static void multimap(ArrayList texto)
    {
      /*  String para = "para";
        String parabens = "parabens";
        String voce = "voce";*/
        
        
        ArrayList textoCsv = new ArrayList< ArrayList>();
        
        ListMultimap<String, String> multimap = ArrayListMultimap.create();

        //when
       /*
        multimap.put(para, "voce");
        multimap.put(voce, "nesta");
        multimap.put(para, "voce");
        multimap.put(voce, "quer");
        multimap.put("queijo", "minas");
        */
        int j=1;

        for(int i=0;i<(texto.size()-1);i++,j++){ 
             
           List<String> Key = multimap.get(texto.get(i).toString().trim());
         //   System.out.println("Teste " + multimap.get(texto.get(i).toString().trim()));
           if(!Key.contains(texto.get(j).toString().trim()))
           {
    
               multimap.put(texto.get(i).toString().trim(), texto.get(j).toString().trim());
           }

           //System.out.println(multimap.keySet());
           //System.out.println(texto.get(i) + "," +texto.get(j) );
        
         }
            
        //then
        System.out.println(multimap);
        System.out.println(multimap.keySet());
        
        List<String> testao = new ArrayList<>(multimap.keySet()); 
        Collections.sort(testao);
        
        System.out.println(testao);
        
        String conteudos = new String();
        
        conteudos = "";
                
        for (String testes : testao) {
             List<String> lastNames = multimap.get(testes);
            //System.out.println(lastNames);
   
           // System.out.println(testes +arrayDeNomes );
            for(int m=0;m< lastNames.size();m++){
                
                if(m == (lastNames.size() - 1)){
                    conteudos += lastNames.get(m);
                }else{
                    conteudos += lastNames.get(m) + ", ";
                }
                
                
//System.out.println("");
                //  System.out.println(testes + ", " + lastNames.get(m));
            }
            
            System.out.println(testes + ", " + conteudos);
            
           // textoCsv.add(testes + ", " + conteudos);
            conteudos = "";
        }   
        
        System.out.println(textoCsv);
        
    }
    
}

