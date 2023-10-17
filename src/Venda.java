public class Venda {

	static Integer id;
	private static Integer cliente_id;
	private static Integer funcionario_id;
	private String data_venda;

	public Venda(Integer id, Integer cliente_id, Integer funcionario_id, String data_venda) {
		Venda.id = id;
		Venda.cliente_id = Cliente.id;
		Venda.funcionario_id = Funcionario.id;
		this.data_venda = data_venda;
	} 
	
	public Venda() {
		
	}

	public static Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		Venda.id = id;
	}

	public static Integer getClienteId() {
		return cliente_id;
	}

	public void setClienteId(Integer cliente_id) {
		Venda.cliente_id = cliente_id;
	}

	public static Integer getFuncionarioId() {
		return funcionario_id;
	}

	public void setFuncionarioId(Integer funcionario_id) {
		Venda.funcionario_id = funcionario_id;
	}

	public String getdata_venda() {
		return data_venda;
	}

	public void setdata_venda(String data_venda) {
		this.data_venda = data_venda;
	}

}