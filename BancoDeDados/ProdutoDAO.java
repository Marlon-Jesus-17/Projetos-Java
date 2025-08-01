package EX20;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void inserirProduto(Produto produto){
        String sql = "INSERT INTO produtos (nome, preco) values (?, ?)";

        try(Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, produto.getNome());
            stmt.setFloat(2, produto.getPreco());
            stmt.executeUpdate();
            System.out.println("Produto inserido com sucesso!");

        }catch(SQLException e){
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        }
    }

    public void removerProduto(int id){
        String sql = "DELETE FROM produtos WHERE id = ?";

        try(Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Produto removido com sucesso!");

        }catch(SQLException e){
            System.out.println("Erro ao remover produto: " + e.getMessage());
        }
    }

    public void atualizarProduto(Produto produto){
        String sql = "UPDATE produtos SET nome = ?, preco = ? WHERE id = ?";

        try(Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, produto.getNome());
            stmt.setFloat(2, produto.getPreco());
            stmt.setInt(3, produto.getId());
            stmt.executeUpdate();
            System.out.println("Produto atualizado com sucesso!");

        }catch(SQLException e){
            System.out.println("Erro ao atualizar o produto: " + e.getMessage());
        }
    }

    public List<Produto> listarProdutos(){
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try(Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery(sql)){

            while(rs.next()){
                Produto produto = new Produto();
                produto.setId(rs.getInt("Id"));
                produto.setNome(rs.getString("Nome"));
                produto.setPreco(rs.getFloat("Preco"));
                lista.add(produto);
            }

        }catch(SQLException e){
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }

        return lista;
    }

}
