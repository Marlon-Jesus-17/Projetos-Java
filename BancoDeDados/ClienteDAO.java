package BancoDeDados;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void inserirCliente(Cliente cliente){
        String sql = "INSERT INTO clientes (nome, email) values (?, ?)";

        try(Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.executeUpdate();
            System.out.println("Cliente inserido com sucesso!");

        }catch(SQLException e){
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
        }
    }

    public void removerCliente(int id){
        String sql = "DELETE FROM clientes WHERE id = ?";

        try(Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Cliente removido com sucesso!");

        }catch(SQLException e){
            System.out.println("Erro ao remover cliente: " + e.getMessage());
        }
    }

    public void atualizarCliente(Cliente cliente){
        String sql = "UPDATE clientes SET nome = ?, email = ? WHERE id = ?";

        try(Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setInt(3, cliente.getId());
            stmt.executeUpdate();
            System.out.println("Cliente atualizado com sucesso!");

        }catch(SQLException e){
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    public Cliente buscarClientePorID(int id){
        Cliente cliente = null;
        String sql = "SELECT * FROM clientes WHERE id = ?";

        try(Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, id);

            try(ResultSet rs = stmt.executeQuery()){

                if(rs.next()){
                    cliente = new Cliente();
                    cliente.setId(rs.getInt("id"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEmail(rs.getString("email"));
                }
            }
        }catch(SQLException e){
            System.out.println("Erro ao buscar cliente: " + e.getMessage());
        }

        return cliente;
    }

    public List<Cliente> listarClientes(){
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try(Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()){

            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                lista.add(cliente);
            }
        }catch(SQLException e){
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        }
        return lista;
    }
}
