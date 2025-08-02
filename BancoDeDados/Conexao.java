package BancoDeDados;

import java.sql.*;

public class Conexao {

    public static final String URL = "jdbc:mysql://localhost:3306/empresa";
    public static final String USUARIO = "root";
    public static final String SENHA = "****";

    public static Connection conectar(){
        try{
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        }catch(SQLException e){
            System.out.println("Erro na conexão: " + e.getMessage());
            return null;
        }
    }
}
