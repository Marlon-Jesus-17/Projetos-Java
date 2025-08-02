package BancoDeDados;

import java.util.List;
import java.util.Scanner;

public class Menus {

    public static void menuProdutos(Scanner scan, ProdutoDAO produtoDAO){

        int op, id;
        String nome, nomeAtualizado;
        float preco, precoAtualizado;
        Produto produto = null;

        do{
            System.out.println("\n1 - Cadastrar novo produto\n2 - Listar todos os produtos\n3 - Buscar produto por ID\n4 - Atualizar nome/preço do produto\n5 - Excluir produto\n0 - Voltar\n");
            op = scan.nextInt();
            scan.nextLine();

            switch(op){
                case 0:
                    System.out.println("\n\nVoltando...");
                    break;

                case 1:
                    System.out.print("Nome do produto: ");
                    nome = scan.nextLine();
                    System.out.print("Preço do produto: ");
                    preco = scan.nextFloat();
                    produto = new Produto(nome, preco);
                    produtoDAO.inserirProduto(produto);
                    break;

                case 2:
                    List<Produto> produtos = produtoDAO.listarProdutos();
                    for(Produto produto1 : produtos){
                        System.out.println(produto1.getId() + " - " + produto1.getNome() + " - " + produto1.getPreco());
                    }
                    break;

                case 3:
                    System.out.print("Id do produto: ");
                    id = scan.nextInt();
                    scan.nextLine();

                    produto = produtoDAO.buscarProdutoPorID(id);
                    if(produto == null){
                        System.out.println("Produto não encontrado!");
                    }else{
                        System.out.println(produto);
                    }
                    break;

                case 4:
                    System.out.print("Id: ");
                    id = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Nome do produto: ");
                    nomeAtualizado = scan.nextLine();
                    System.out.print("Preço do produto: ");
                    precoAtualizado = scan.nextFloat();
                    Produto produtoAtualizado = new Produto(id, nomeAtualizado, precoAtualizado);
                    produtoDAO.atualizarProduto(produtoAtualizado);
                    break;

                case 5:
                    System.out.print("Id: ");
                    id = scan.nextInt();
                    scan.nextLine();
                    produtoDAO.removerProduto(id);
                    break;

                default:
                    System.out.println("\n\nOpção inválida...");

            }
        }while(op != 0);
    }

    public static void menuClientes(Scanner scan, ClienteDAO clienteDAO){

        int op, id;
        String nome, email, nomeAtualizado, emailAtualizado;
        Cliente cliente = null;

        do{
            System.out.println("\n1 - Cadastrar novo cliente\n2 - Listar todos os clientes\n3 - Buscar cliente por ID\n4 - Atualizar nome/email do cliente\n5 - Excluir cliente\n0 - Voltar\n");
            op = scan.nextInt();
            scan.nextLine();

            switch(op){
                case 0:
                    System.out.println("\n\nVoltando...");
                    break;

                case 1:
                    System.out.print("Nome do cliente: ");
                    nome = scan.nextLine();
                    System.out.print("Email do cliente: ");
                    email = scan.nextLine();
                    cliente = new Cliente(nome, email);
                    clienteDAO.inserirCliente(cliente);
                    break;

                case 2:
                    List<Cliente> clientes = clienteDAO.listarClientes();
                    for(Cliente cliente1 : clientes){
                        System.out.println(cliente1.getId() + " - " + cliente1.getNome() + " - " + cliente1.getEmail());
                    }
                    break;

                case 3:
                    System.out.print("Id do cliente: ");
                    id = scan.nextInt();
                    scan.nextLine();

                    cliente = clienteDAO.buscarClientePorID(id);
                    if(cliente == null){
                        System.out.println("Cliente não encontrado!");
                    }else{
                        System.out.println(cliente);
                    }
                    break;

                case 4:
                    System.out.print("Id: ");
                    id = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Nome do cliente: ");
                    nomeAtualizado = scan.nextLine();
                    System.out.print("Email do cliente: ");
                    emailAtualizado = scan.nextLine();
                    Cliente clienteAtualizado = new Cliente(id, nomeAtualizado, emailAtualizado);
                    clienteDAO.atualizarCliente(clienteAtualizado);
                    break;

                case 5:
                    System.out.print("Id: ");
                    id = scan.nextInt();
                    scan.nextLine();
                    clienteDAO.removerCliente(id);
                    break;

                default:
                    System.out.println("\n\nOpção inválida...");
            }

        }while(op != 0);
    }
}
