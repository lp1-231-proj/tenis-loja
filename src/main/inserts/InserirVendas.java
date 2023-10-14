package main.inserts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirVendas {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSL=true";
        Connection conn = DriverManager.getConnection(url);
        int id = 1;
        int cliente_id = 1;
        int funcionario_id = 1;
        String data_venda = "2023-09-09 16:33:20";

        String sql = "INSERT INTO Settings VALUES (?, ?, ?, ?)";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.setInt(2, cliente_id);
        pstm.setInt(3, funcionario_id);
        pstm.setString(4, data_venda);
        

        pstm.executeUpdate();

        pstm.close();
        conn.close();
    }
}