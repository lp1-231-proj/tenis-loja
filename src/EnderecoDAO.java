
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {
    public Endereco create(Endereco endereco) throws SQLException {
        String sql = """
            INSERT INTO Endereco VALUES (?, ?, ?, ?, ?, ?);    
        """;
        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setInt(1, Endereco.getId());
			statement.setInt(2, Endereco.getFuncionarioId());
			statement.setString(3, Endereco.getCidade());
			statement.setString(4, Endereco.getBairro());
			statement.setString(5, Endereco.getComplemento());
            statement.setString(6, Endereco.getCep());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()) {
                endereco.setId(rs.getInt(1));
            }
            
            rs.close();
            
            return endereco;
        }
    }
    
    
    public Endereco update(Endereco endereco) throws SQLException {
        String sql = """
        UPDATE Endereco
        SET cidade = ?, bairro = ?, complemento = ?, cep = ?
        WHERE id = ?;
        """;

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {

            statement.setString(1, Endereco.getCidade());
            statement.setString(2, Endereco.getBairro());
            statement.setString(3, Endereco.getComplemento());
            statement.setString(4, Endereco.getCep());
            statement.setInt(5, Endereco.getId());
            int linhasAfetadas = statement.executeUpdate();

            if (linhasAfetadas > 0) {
            return endereco;
            }
            return null;

        } catch (SQLException e) {
            return null;
        }
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM Endereco WHERE id = ?;";

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

    public void delete(Endereco endereco) {
        delete(Endereco.getId());
    }
    
    public Endereco findById(Integer id) {
        String sql = "SELECT * FROM Endereco WHERE id = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
            return resultSetToEndereco(rs);
        }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    public List<Endereco> findAll() {
        String sql = "SELECT * FROM Endereco;";
        List<Endereco> endereco = new ArrayList<>();

        try (
            Connection connection = Conexao.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ) {
            while(rs.next()) {
            endereco.add(resultSetToEndereco(rs));
        }
        
            return endereco;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

    }

    private Endereco resultSetToEndereco(ResultSet rs) throws SQLException {
        return new Endereco(
            rs.getInt("id"),
            rs.getInt("funcionario_id"),
            rs.getString("cidade"),
            rs.getString("bairro"),
            rs.getString("complemento"),
            rs.getString("cep")
        );
    }
}