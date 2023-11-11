import java.sql.SQLException;

public class Principal {

    public static void main(String[] args) throws SQLException {
        // Cliente
        ClienteDAO clienteDao = new ClienteDAO();
        
        Cliente cliente = new Cliente(1, "Maria da Silva", "38464783267", "437268976", "1990-07-24", "987654321", "maria.silva@email.com");

        Cliente clienteCriado = clienteDao.create(cliente);

        System.out.println(clienteCriado.getId());

        Cliente clienteEncontrado = clienteDao.findById(1);

        System.out.println(clienteEncontrado.getNome());

    
        // Funcionário
        FuncionarioDAO funcionarioDao = new FuncionarioDAO();
        
        //Funcionario funcionario = new Funcionario(1, "Luiz Felipe", "11111111111", "111111111", "1998-10-28", "00000000000", "felipeluiz@example.com", "Vendedor", "22222222", "Rua Belchior - 58", "São Paulo", "Itaquera", "Casa 2");
        
        //Funcionario funcionarioCriado = funcionarioDao.create(funcionario);

        //System.out.println(funcionarioCriado.getId());

        Funcionario funcionarioEncontrado = funcionarioDao.findById(1);

        System.out.println(funcionarioEncontrado.getNome());


        // Tenis
        TenisDAO tenisDao = new TenisDAO();
        
        Tenis tenis = new Tenis(1, "Lakers Home", 749.00, 42, "Lebron XVII", 1);
        
        Tenis tenisCriado = tenisDao.create(tenis);
        
        System.out.println(tenisCriado.getId());

        Tenis tenisEncontrado = tenisDao.findById(1);

        System.out.println(tenisEncontrado.getColorway());


        // Venda
        VendaDAO vendaDao = new VendaDAO();
        
        Venda venda = new Venda(1, 1, 1, "2023-09-08");
        
        Venda vendaCriada = vendaDao.create(venda);

        System.out.println(vendaCriada.getId());

        Venda vendaEncontrada = vendaDao.findById(1);

        System.out.println(vendaEncontrada);


        // TenisVenda
        TenisVendaDAO tenisVendaDao = new TenisVendaDAO();
        
        TenisVenda tenisVenda = new TenisVenda(1, 1, 1, 2, 369.90);
        
        TenisVenda tenisVendaCriado = tenisVendaDao.create(tenisVenda);

        System.out.println(tenisVendaCriado.getIdTenisVenda());

        TenisVenda tenisVendaEncontrado = tenisVendaDao.findById(1);

        System.out.println(tenisVendaEncontrado);

    }
    
}