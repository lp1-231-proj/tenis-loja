import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {
    public Venda create(Venda venda) throws SQLException {
        String sql = """
            INSERT INTO Venda VALUES (?, ?, ?, ?);    
        """;
        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setInt(1, Venda.getId());
            statement.setInt(2, Venda.getClienteId());
            statement.setInt(3, Venda.getFuncionarioId());
            statement.setString(4, venda.getdata_venda());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()) {
                venda.setId(rs.getInt(1));
            }

            rs.close();

            return venda;
        }
    }


    public Venda update(Venda venda) throws SQLException {
        String sql = """
        UPDATE Venda
        SET data_venda = ?
        WHERE id = ?;
        """;

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {

            statement.setString(1, venda.getdata_venda());
            statement.setInt(2, Venda.getId());
            int linhasAfetadas = statement.executeUpdate();

            if (linhasAfetadas > 0) {
            return venda;
            }
            return null;

        } catch (SQLException e) {
            return null;
        }
    }


    public Venda findById(Integer id) {
        String sql = "SELECT * FROM Venda WHERE id = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
            return resultSetToVenda(rs);
            }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    public List<Venda> findAll() {
        String sql = "SELECT * FROM Venda;";
        List<Venda> venda = new ArrayList<>();

        try (
            Connection connection = Conexao.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ) {
            while(rs.next()) {
            venda.add(resultSetToVenda(rs));
            }

            return venda;

            } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    private Venda resultSetToVenda(ResultSet rs) throws SQLException {
        return new Venda(
        rs.getInt("id"),
        rs.getInt("cliente_id"),
        rs.getInt("funcionario_id"),
        rs.getString("data_venda")
        );
    }
} 