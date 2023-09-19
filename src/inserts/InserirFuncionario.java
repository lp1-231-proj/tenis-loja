package inserts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirFuncionario {
    
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSL=true";
        Connection conn = DriverManager.getConnection(url);

        int id = 1; 
        String nome = "Luiz Felipe";
        String rg  = "111111111";
        String cpf  = "11111111111"; 
        String data_nascimento = "1998-10-28";
        String telefone = "000000000"; 
        String email = "felipeluiz@example.com";
        String cep = "22222222";
        String endereco = "Rua Belchior - 58"; String bairro = "Itaquera";
        String cidade = "São Paulo";
        String complemento = "Casa 2";
        String cargo = "vendedor";

       
        String sql = "INSERT INTO Clientes VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.setString(2, nome);
        pstm.setString(3, rg);
        pstm.setString(4, cpf);
        pstm.setString(5, data_nascimento);
        pstm.setString(6, telefone);
        pstm.setString(7, email);
        pstm.setString(8, cep);
        pstm.setString(9, endereco);
        pstm.setString(10, bairro);
        pstm.setString(11, cidade);
        pstm.setString(12, complemento);
        pstm.setString(13, cargo);

        pstm.executeUpdate();

        pstm.close();
        conn.close();
    }
}