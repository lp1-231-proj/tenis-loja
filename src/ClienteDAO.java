import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// DAO = Data Access Object
public class ClienteDAO {
    public Cliente create(Cliente cliente) throws SQLException {
        String sql = """
            INSERT INTO Cliente VALUES (?, ?, ?, ?, ?, ?, ?);    
        """;
        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setInt(1, cliente.getId());
            statement.setString(2, cliente.getNome());
            statement.setString(3, cliente.getCpf());
            statement.setString(4, cliente.getRg());
            statement.setString(5, cliente.getDataNascimento());
            statement.setString(6, cliente.getTelefone());
            statement.setString(7, cliente.getEmail());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()) {
                cliente.setId(rs.getInt(1));
            }

            rs.close();

            return cliente;
        }
    }


    public Cliente update(Cliente cliente) throws SQLException {
        String sql = """
        UPDATE Cliente
        SET nome = ?, telefone = ?, email = ?
        WHERE id = ?;
        """;

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {

            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getTelefone());
            statement.setString(3, cliente.getEmail());
            statement.setInt(4, cliente.getId());
            int linhasAfetadas = statement.executeUpdate();

            if (linhasAfetadas > 0) {
            return cliente;
            }
            return null;

        } catch (SQLException e) {
            return null;
        }
    }


    public Cliente findById(Integer id) {
        String sql = "SELECT * FROM Cliente WHERE id = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
            return resultSetToCliente(rs);
            }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    public List<Cliente> findAll() {
        String sql = "SELECT * FROM Cliente;";
        List<Cliente> cliente = new ArrayList<>();

        try (
            Connection connection = Conexao.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ) {
            while(rs.next()) {
            cliente.add(resultSetToCliente(rs));
            }

            return cliente;

            } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    private Cliente resultSetToCliente(ResultSet rs) throws SQLException {
        return new Cliente(
        rs.getInt("id"),
        rs.getString("nome"),
        rs.getString("cpf"),
        rs.getString("rg"),
        rs.getString("data_nascimento"),
        rs.getString("telefone"),
        rs.getString("email")
        );
    }
}