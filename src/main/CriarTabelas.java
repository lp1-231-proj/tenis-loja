import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class CriarTabelas {

    public static void main(String[] args) throws SQLException{
        
        String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSL=true";
        Connection conn = DriverManager.getConnection(url);

        String sql = "CREATE TABLE Funcionario(id INT PRIMARY KEY, nome VARCHAR(100), rg CHAR(9), cpf CHAR(11), data_nascimento DATE, telefone CHAR(9), email VARCHAR (200), cep STRING, endereço VARCHAR (100), bairro VARCHAR (100), cidade VARCHAR(100), complemento VARCHAR(100), cargo VARCHAR(100);";
        Statement stm = conn.createStatement();
        stm.execute(sql);

        sql = "CREATE TABLE Cliente(id INT PRIMARY KEY, nome VARCHAR(100), rg CHAR (9), cpf CHAR (11), data_nascimento DATE, telefone CHAR (11), email VARCHAR (200);";
        stm = conn.createStatement();
        stm.execute(sql);

        sql = "CREATE TABLE Tenis(id INT PRIMARY KEY, preco NUMERIC (10,2), tamanho INT, modelo VARCHAR(200), colorway VARCHAR(100), quantidade INT);";
        stm = conn.createStatement();
        stm.execute(sql);


        sql = "CREATE TABLE Venda(id INT PRIMARY KEY, cliente_id INT, funcionario_id INT, data_venda DATETIME, FOREIGN KEY (cliente_id) REFERENCES Cliente(id), FOREIGN KEY (funcionario_id) REFERENCES Funcionario(id) );";
        stm = conn.createStatement();
        stm.execute(sql);
        
        sql = "CREATE TABLE Tenis_venda(id INT PRIMARY KEY, tenis_id INT, venda_id INT, quantidade INT, valor_unitario NUMERIC (10.2), FOREIGN KEY (tenis_id) REFERENCES Tenis(id), FOREIGN KEY (venda_id) REFERENCES Venda(id));";
        stm = conn.createStatement();
        stm.execute(sql);
        
        stm.close();
        conn.close();
    }
}