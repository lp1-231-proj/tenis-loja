public class Funcionario {

	static Integer id;
	private String nome;
	private String cpf;
	private String rg;
	private String dataNascimento;
	private String telefone;
	private String cargo;

	public Funcionario(Integer id, String nome, String cpf, String rg, String dataNascimento, String telefone, String cargo) {
		Funcionario.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.cargo = cargo;
	
	} 
	
	public Funcionario() {
		
	}

	public static Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		Funcionario.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}