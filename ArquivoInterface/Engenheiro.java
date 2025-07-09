package Exercícios.ArquivoInterface;

public class Engenheiro extends Pessoa implements Trabalhavel{
    
    @Override
    public void trabalhar(){
        System.out.println("Engenheiro projetando estruturas...");
    }
    
}