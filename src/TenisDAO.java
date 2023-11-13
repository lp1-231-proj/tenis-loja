import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TenisDAO {
    public Tenis create(Tenis tenis) throws SQLException {
        String sql = """
            INSERT INTO Tenis VALUES (?, ?, ?, ?);    
        """;
        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setInt(1, Tenis.getId());
            statement.setInt(2, Tenis.getModeloId());
            statement.setDouble(3, tenis.getPreco());
            statement.setInt(4, tenis.getQuantidadeTotal());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()) {
                tenis.setId(rs.getInt(1));
            }
            
            rs.close();
            
            return tenis;
        }
    }
    
    
    public Tenis update(Tenis tenis) throws SQLException {
        String sql = """
        UPDATE Tenis
        SET preco = ?, quantidadeTotal = ?
        WHERE id = ?;
        """;

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, Tenis.getId());
            statement.setDouble(2, tenis.getPreco());
            statement.setInt(3, tenis.getQuantidadeTotal());
            statement.setInt(4, Tenis.getModeloId());
            int linhasAfetadas = statement.executeUpdate();

            if (linhasAfetadas > 0) {
            return tenis;
            }
            return null;

        } catch (SQLException e) {
            return null;
        }
    }

    public Tenis findById(Integer id) {
        String sql = "SELECT * FROM Tenis WHERE id = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
            return resultSetToTenis(rs);
        }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    public List<Tenis> findAll() {
        String sql = "SELECT * FROM Tenis;";
        List<Tenis> tenis = new ArrayList<>();

        try (
            Connection connection = Conexao.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ) {
            while(rs.next()) {
            tenis.add(resultSetToTenis(rs));
        }
        
            return tenis;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

    }

    private Tenis resultSetToTenis(ResultSet rs) throws SQLException {
        return new Tenis(
            rs.getInt("id"),
            rs.getInt("modelo_id"),
            rs.getDouble("preco"),
            rs.getInt("quantidadeTotal")
        );
    }
}