import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    public Funcionario create(Funcionario funcionario) throws SQLException {
        String sql = """
            INSERT INTO Funcionario VALUES (?, ?, ?, ?, ?, ?, ?);    
        """;
        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setInt(1, Funcionario.getId());
			statement.setString(2, funcionario.getNome());
			statement.setString(3, funcionario.getRg());
			statement.setString(4, funcionario.getCpf());
			statement.setString(5, funcionario.getDataNascimento());
			statement.setString(6, funcionario.getTelefone());
			statement.setString(7, funcionario.getCargo());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()) {
                funcionario.setId(rs.getInt(1));
            }
            
            rs.close();
            
            return funcionario;
        }
    }
    
    
    public Funcionario update(Funcionario funcionario) throws SQLException {
        String sql = """
        UPDATE Funcionario
        SET nome = ?, telefone = ?, cargo = ?
        WHERE id = ?;
        """;

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {

            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getTelefone());
            statement.setString(3, funcionario.getTelefone());
            statement.setInt(4, Funcionario.getId());
            int linhasAfetadas = statement.executeUpdate();

            if (linhasAfetadas > 0) {
            return funcionario;
            }
            return null;

        } catch (SQLException e) {
            return null;
        }
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM Funcionario WHERE id = ?;";

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

    public void delete(Funcionario funcionario) {
        delete(Funcionario.getId());
    }
    
    public Funcionario findById(Integer id) {
        String sql = "SELECT * FROM Funcionario WHERE id = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
            return resultSetToFuncionario(rs);
        }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    public List<Funcionario> findAll() {
        String sql = "SELECT * FROM Funcionario;";
        List<Funcionario> funcionario = new ArrayList<>();

        try (
            Connection connection = Conexao.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ) {
            while(rs.next()) {
            funcionario.add(resultSetToFuncionario(rs));
        }
        
            return funcionario;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

    }

    private Funcionario resultSetToFuncionario(ResultSet rs) throws SQLException {
        return new Funcionario(
            rs.getInt("id"),
            rs.getString("nome"),
            rs.getString("rg"),
            rs.getString("cpf"),
            rs.getString("dataNascimento"),
            rs.getString("telefone"),
            rs.getString("cargo")
        );
    }
}