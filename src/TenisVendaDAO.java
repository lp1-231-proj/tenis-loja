import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TenisVendaDAO {
    public TenisVenda create(TenisVenda tenisVenda) throws SQLException {
        String sql = """
            INSERT INTO TenisVenda VALUES (?, ?, ?, ?, ?);    
        """;
        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setInt(1, TenisVenda.getIdTenisVenda());
            statement.setInt(2, Tenis.getId());
            statement.setInt(3, Venda.getId());
            statement.setInt(4, tenisVenda.getQuantidade());
            statement.setDouble(5, tenisVenda.getPreco());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()) {
                tenisVenda.setIdTenisVenda(rs.getInt(1));
            }

            rs.close();

            return tenisVenda;
        }
    }


    public TenisVenda update(TenisVenda tenisVenda) throws SQLException {
        String sql = """
        UPDATE TenisVenda
        SET quantidade = ?, preco = ?
        WHERE id = ?;
        """;

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
 
            statement.setInt(1, tenisVenda.getQuantidade());
            statement.setDouble(2, tenisVenda.getPreco());
            statement.setInt(3, TenisVenda.getIdTenisVenda());
            int linhasAfetadas = statement.executeUpdate();

            if (linhasAfetadas > 0) {
            return tenisVenda;
            }
            return null;

        } catch (SQLException e) {
            return null;
        }
    }


    public TenisVenda findById(Integer IdTenisVenda) {
        String sql = "SELECT * FROM TenisVenda WHERE id = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, IdTenisVenda);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
            return resultSetToTenisVenda(rs);
            }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    public List<TenisVenda> findAll() {
        String sql = "SELECT * FROM TenisVenda;";
        List<TenisVenda> tenisVenda = new ArrayList<>();

        try (
            Connection connection = Conexao.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ) {
            while(rs.next()) {
            tenisVenda.add(resultSetToTenisVenda(rs));
            }

            return tenisVenda;

            } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void delete(Integer IdTenisVenda) {
        String sql = "DELETE FROM TenisVenda WHERE id = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, IdTenisVenda);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(TenisVenda tenisVenda) {
        delete(TenisVenda.getIdTenisVenda());
    }

    private TenisVenda resultSetToTenisVenda(ResultSet rs) throws SQLException {
        return new TenisVenda(
        rs.getInt("id"),
        rs.getInt("quantidade"),
        rs.getDouble("preco")
        );
    }
} 
