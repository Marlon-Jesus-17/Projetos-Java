package EX20;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ClienteDAO clienteDAO = new ClienteDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        Cliente cliente = new Cliente("Marlon", "Marlon@gmail.com");
        Produto produto = new Produto("Ar-condicionado", 1.950f);
        Produto produtoAtualizado = new Produto(1, "Ar-condicionado", 1950.99f);

        //clienteDAO.inserirCliente(cliente);
        //produtoDAO.inserirProduto(produto);

        //produtoDAO.atualizarProduto(produtoAtualizado);

        List<Cliente> clientes = clienteDAO.listarClientes();
        for(Cliente cliente1 : clientes){
            System.out.println(cliente1.getId() + " - " + cliente1.getNome() + " - " + cliente1.getEmail());
        }

        List<Produto> produtos = produtoDAO.listarProdutos();
        for(Produto produto1 : produtos){
            System.out.println(produto1.getId() + " - " + produto1.getNome() + " - " + produto1.getPreco());
        }
    }
}
