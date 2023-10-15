import java.sql.SQLException;

public class Principal {

    public static void main(String[] args) throws SQLException {
        ClienteDAO clienteDao = new ClienteDAO();
        
        // Cliente cliente = new Cliente(1, "Maria da Silva", "38464783267", "437268976", "1990-07-24", "987654321", "maria.silva@email.com");

        // Cliente clienteCriado = clienteDao.create(cliente);

        // System.out.println(clienteCriado.getId());

        Cliente clienteEncontrado = clienteDao.findById(1);

        System.out.println(clienteEncontrado.getNome());
    }
    
}