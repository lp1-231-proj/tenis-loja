public class Venda {

	private Integer id;
	private String data_venda;
	private String cliente_id;
	private String funcionario_id;

	public Venda(Integer id, String data_venda, String cliente_id, String cliente_id, String cliente_id, funcionario_id) {
		this.id = id;
		this.data_venda = DataVenda;
		this.cliente_id = IdCliente;
		this.funcionario_id = IdFuncionario ;
		
	} 
	
	public Venda() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getdata_venda() {
		return data_venda;
	}

	public void setdata_venda(String data_venda) {
		this.data_venda = data_venda;
	}

	public String getcliente_id() {
		return IdCliente;
	}

	public void setcliente_id(String cliente_id) {
		this.cliente_id = IdCliente;
	}

	public String getfuncionario_id() {
		return IdFuncionario;
	}

	public void setfuncionario_id(String rg) {
		this.rg = IdFuncionario;
	}

}