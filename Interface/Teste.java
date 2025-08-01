package Exercícios.ArquivoInterface;

import java.util.Scanner;
import java.util.ArrayList;

public class Teste {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        ArrayList<Pessoa> pessoas = new ArrayList<>();
        
        System.out.print("Quantas profissionais deseja cadastrar? ");
        int quant = scan.nextInt(),cont = 0, op, dia, mes, ano;

        do{
            System.out.printf("\n%d°.\nProfissões: (1 - Professor; 2 - Médico; 3 - Engenheiro): ", (cont+1));
            op = scan.nextInt();
            scan.nextLine();

            switch(op){
            case 1:
                Pessoa professor = new Professor();
                do{
                    System.out.print("Informe seu nome: ");
                    professor.setNome(scan.nextLine());
                    System.out.println("\nInforme sua data de nascimento.");
                    System.out.print("Dia: ");
                    dia = scan.nextInt();
                    System.out.print("Mês: ");
                    mes = scan.nextInt();
                    System.out.print("Ano: ");
                    ano = scan.nextInt();
                    scan.nextLine();
                }while(professor.validarIdade(dia, mes, ano) != true);
                pessoas.add(professor);
                break;
            case 2:
                Pessoa medico = new Medico();
                do{
                    System.out.print("Informe seu nome: ");
                    medico.setNome(scan.nextLine());
                    System.out.println("\nInforme sua data de nascimento.");
                    System.out.print("Dia: ");
                    dia = scan.nextInt();
                    System.out.print("Mês: ");
                    mes = scan.nextInt();
                    System.out.print("Ano: ");
                    ano = scan.nextInt();
                    scan.nextLine();
                }while(medico.validarIdade(dia, mes, ano) != true);
                pessoas.add(medico);
                break;
            case 3:
                Pessoa engenheiro = new Engenheiro();
                do{
                    System.out.print("Informe seu nome: ");
                    engenheiro.setNome(scan.nextLine());
                    System.out.println("\nInforme sua data de nascimento.");
                    System.out.print("Dia: ");
                    dia = scan.nextInt();
                    System.out.print("Mês: ");
                    mes = scan.nextInt();
                    System.out.print("Ano: ");
                    ano = scan.nextInt();
                    scan.nextLine();
                }while(engenheiro.validarIdade(dia, mes, ano) != true);
                pessoas.add(engenheiro);
                break;
            default:
                System.out.println("Opção inválida...");
            }
            cont++;
        }while(cont < quant);

        for(Pessoa pessoa: pessoas){
            Arquivo.salvarArquivo(pessoa);
        }

        Arquivo.lerArquivo();
       
        scan.close();
    }
}