package Exercícios.ArquivoInterface;

public class Professor extends Pessoa implements Trabalhavel{
    
    public void trabalhar(){
        System.out.println("Professor preparando aulas...");
    }
}