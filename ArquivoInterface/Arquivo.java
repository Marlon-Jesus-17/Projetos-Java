package Exercícios.ArquivoInterface;

import java.io.*;

public class Arquivo {
    
    public static void salvarArquivo(Pessoa p){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("cadastro2.txt", true));
            bw.write(p.toString());
            bw.newLine();
            bw.close();
            System.out.println("\nArquivo Salvo com sucesso!");
        }catch(IOException e){
            System.out.println("Erro ao criar arquivo: " + e.getMessage());
        }
    }

    public static void lerArquivo(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("cadastro2.txt"));
            String texto;
            while((texto = br.readLine()) != null){
                System.out.println(texto);
            }
            br.close();
            System.out.println("\nArquivo lido com sucesso!");
        }catch(IOException e){
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }
}