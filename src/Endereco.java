public class Endereco {

    static Integer id;
    private int funcionario_id;
    private string cidade;
    private string bairro;
    private string complemento;
    private char cep;

    public Endereco(Integer id, int funcionario_id, string cidade, string bairro, string complemento, char cep) {
        Modelo.id = id;
        this.funcionario_id = funcionario_id;
        this.cidade = cidade;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cep = cep;
    }
    public Endereco () {
    }

    public static Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Endereco.id = id;
    }

    public string getFuncionarioId(){
        return funcionario_id;
    }

    public void setFuncionarioId(string funcionario_id){
        this.funcionario_id = funcionario_id;
    }

    public string getCidade(){
        return cidade;
    }

    public void setCidade(string cidade){
        this.cidade = cidade;
    }

    public string getBairro(){
        return bairro;
    }

    public void setBairro(string bairro){
        this.bairro = bairro;
    }
    
    public string getComplemento(){
        return bairro;
    }

    public void setComplemento(string complemento){
        this.complemento = complemento;
    }

    public char getCep(){
        return cep;
    }

    public void setCep(char cep){
        this.cep = cep;
    }
    
}