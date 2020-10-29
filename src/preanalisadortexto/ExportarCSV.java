/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preanalisadortexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import static preanalisadortexto.LeituraTxt.removerAcentos;

/**
 *
 * @author Alexandre
 */
class ExportarCSV {
    
    private String conteudo;
    
    
    public String getConteudo(){
       return this.conteudo;
    }
    
    public String setConteudo(){
       return this.conteudo;
    }
    
    
     public static ArrayList lerArquivo()
    {
        String linha = new String();
        String nomeArquivo2 = "D:\\Dados\\Documentos\\Alexandre\\Unicamp\\4 Semestre\\Poo\\Projeto 1\\Ex5_TresMotivosParaVacinarSeuPet.txt";
        String nomeArquivo = "D:\\Dados\\Documentos\\Alexandre\\Unicamp\\4 Semestre\\Poo\\Projeto 1\\Ex4_Parabens.txt";
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
                    linha = linha.replace(  "/" , ""); //tira barra
                    linha = linha.replace( "-" , ""); //tira hífen 
                    //linha = linha.replace( " " , ""); //tira espaço em branco
                    linha = linha.replace( "," , ""); //tira ponto
                    linha = linha.replace( ";" , ""); //tira ponto
                    linha = linha.replace( ":" , ""); //tira ponto
                    linha = linha.replace( "!" , ""); //tira ponto
                    linha = linha.replace( "?" , ""); //tira ponto
                    
                    
                   // System.out.println(linha);
                    ArrayList lista = new ArrayList();     
                    
                    lista.add(linha);
                    
                    String[] textoSeparado = linha.split(" ");
                    
                    //System.out.println(textoSeparado);
                   // System.out.println(Arrays.toString(textoSeparado));
                  //  System.out.println(textoSeparado.length);
                    
                    for(String nome : textoSeparado){
                        if(!linha.trim().equals("")){
                            texto.add(nome.trim());
                            
                        }
                    }
                //    System.out.println(texto);
/*
                    
                        texto.add(Arrays.toString(textoSeparado).replace("[","").replace("]",""));
                    }
                    */
                    
                    //System.out.println(texto);
                    //lista.trimToSize();

                    
                    if(linha != null){
                    } else {
                        
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
    
}
