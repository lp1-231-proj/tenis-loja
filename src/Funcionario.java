public class Funcionario {

	private static Integer id;
	private String nome;
	private String cpf;
	private String rg;
	private String dataNascimento;
	private String telefone;
	private String email;
	private String cargo;
	private String cep;
	private String endereco;
	private String cidade;
	private String bairro;
	private String complemento;

	public Funcionario(Integer id, String nome, String cpf, String rg, String dataNascimento, String telefone, String email, String cargo, String cep, String endereco, String cidade, String bairro, String complemento) {
		Funcionario.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
		this.cargo = cargo;
		this.cep = cep;
		this.endereco = endereco;
		this.cidade = cidade;
		this.bairro = bairro;
		this.complemento = complemento; 
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}