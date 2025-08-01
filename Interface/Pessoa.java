package Exercícios.ArquivoInterface;

import java.time.*;

public class Pessoa {
    
    private String nome;
    private int idade;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean validarIdade(int dia, int mes, int ano){
        
        try{

            LocalDate dataNasc = LocalDate.of(ano, mes, dia);
            setIdade(Period.between(dataNasc, LocalDate.now()).getYears());
            return true;
        }catch(DateTimeException e){

            System.out.println("Data inválida... " + e.getMessage());
            return false;
        }
    }

    @Override
    public String toString(){
        return "\nNome: " + getNome() + "\nIdade: " + getIdade() + "\nProfissão: " + this.getClass().getSimpleName();
    }
    
}