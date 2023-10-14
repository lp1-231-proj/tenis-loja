package main.inserts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirCliente {
    
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSL=true";
        Connection conn = DriverManager.getConnection(url);

        int id = 1; 
        String nome = "Leonardo Souza";
        String rg  = "111111111";
        String cpf  = "11111111111"; 
        String data_nascimento = "2001-09-05";
        String telefone = "000000000"; 
        String email = "leonardo1@example.com";

       
        String sql = "INSERT INTO Clientes VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.setString(2, nome);
        pstm.setString(3, rg);
        pstm.setString(4, cpf);
        pstm.setString(5, data_nascimento);
        pstm.setString(6, telefone);
        pstm.setString(7, email);
        

        pstm.executeUpdate();

        pstm.close();
        conn.close();
    }
}