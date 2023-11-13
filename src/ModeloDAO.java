
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModeloDAO {
    public Modelo create(Modelo modelo) throws SQLException {
        String sql = """
            INSERT INTO Modelo VALUES (?, ?, ?, ?, ?);    
        """;
        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setInt(1, Modelo.getId());
			statement.setString(2, modelo.getNome());
			statement.setString(3, modelo.getColorway());
			statement.setString(4, modelo.getTamanho());
			statement.setInt(5, modelo.getQuantidade());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()) {
                modelo.setId(rs.getInt(1));
            }
            
            rs.close();
            
            return modelo;
        }
    }
    
    
    public Modelo update(Modelo modelo) throws SQLException {
        String sql = """
        UPDATE Funcionario
        SET tamanho = ?, colorway = ?, quantidade = ?
        WHERE id = ?;
        """;

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {

            statement.setString(1, modelo.getNome());
            statement.setString(2, modelo.getColorway());
            statement.setString(3, modelo.getTamanho());
            statement.setInt(4, modelo.getQuantidade());
            statement.setInt(5, Modelo.getId());
            int linhasAfetadas = statement.executeUpdate();

            if (linhasAfetadas > 0) {
            return modelo;
            }
            return null;

        } catch (SQLException e) {
            return null;
        }
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM Modelo WHERE id = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Modelo modelo) {
        delete(Modelo.getId());
    }
    
    public Modelo findById(Integer id) {
        String sql = "SELECT * FROM Modelo WHERE id = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
            return resultSetToModelo(rs);
        }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    public List<Modelo> findAll() {
        String sql = "SELECT * FROM Modelo;";
        List<Modelo> modelo = new ArrayList<>();

        try (
            Connection connection = Conexao.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ) {
            while(rs.next()) {
            modelo.add(resultSetToModelo(rs));
        }
        
            return modelo;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

    }

    private Modelo resultSetToModelo(ResultSet rs) throws SQLException {
        return new Modelo(
            rs.getInt("id"),
            rs.getString("nome"),
            rs.getString("colorway"),
            rs.getString("tamanho"),
            rs.getInt("quantidade")
        );
    }
}
    
