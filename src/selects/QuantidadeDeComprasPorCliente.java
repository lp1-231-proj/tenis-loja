package selects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuantidadeDeComprasPorCliente {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSl=true";
        Connection conn = DriverManager.getConnection(url);
        
        String sql = "SELECT cliente_id, count(id) as compras FROM Venda GROUP BY cliente_id;";
        Statement stm = conn.createStatement();

        ResultSet rs = stm.executeQuery(sql);
        
        while (rs.next()) {

            int id = rs.getInt("id");
            int cliente_id = rs.getInt("cliente_id");
            int funcionario_id = rs.getInt("funcionario_id");
            String data_venda = rs.getString("data_venda");
            
            System.out.println(id);
            System.out.println(cliente_id);
            System.out.println(funcionario_id);
            System.out.println(data_venda);
        }

        rs.close();
        stm.close();
        conn.close();
    }
}
