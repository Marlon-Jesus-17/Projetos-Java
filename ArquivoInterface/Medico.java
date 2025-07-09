package Exercícios.ArquivoInterface;

public class Medico extends Pessoa implements Trabalhavel{
    
    @Override
    public void trabalhar(){
        System.out.println("Médoco consultando...");
    }
}