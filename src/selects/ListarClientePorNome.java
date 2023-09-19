package selects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class ListarClientePorNome {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSl=true";
        Connection conn = DriverManager.getConnection(url);

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome");
        String nome1 = sc.nextLine();
        
        String sql = "SELECT * FROM Cliente WHERE nome = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, nome1);

        ResultSet rs = pstm.executeQuery();
        
        while (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String rg = rs.getString("rg");
            String cpf = rs.getString("cpf");
            String data_nascimento = rs.getString("data_nascimento");
            String telefone = rs.getString("telefone");
            String email = rs.getString("email");
            
            System.out.println(id);
            System.out.println(nome);
            System.out.println(rg);
            System.out.println(cpf);
            System.out.println(telefone); 
            System.out.println(data_nascimento);
            System.out.println(email);
        }

        rs.close();
        pstm.close();
        conn.close();
        sc.close();
    } 
}