package BancoDeDados;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ProdutoDAO produtoDAO = new ProdutoDAO();
        ClienteDAO clienteDAO = new ClienteDAO();

        int op;

        do{
            System.out.println("\n\n1 - Menu de produtos\n2 - Menu de clientes\n0 - Sair");
            op = scan.nextInt();
            scan.nextLine();

            switch(op){
                case 0:
                    System.out.println("\n\nSaindo...");
                    break;
                case 1:
                    Menus.menuProdutos(scan, produtoDAO);
                    break;
                case 2:
                    Menus.menuClientes(scan, clienteDAO);
                    break;
                default:
                    System.out.println("\n\nOpção inválida...");
            }
        }while(op != 0);

        scan.close();
    }
}
