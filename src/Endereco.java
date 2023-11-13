public class Endereco {

    static Integer id;
    private static int funcionario_id;
    private static String cidade;
    private static String bairro;
    private static String complemento;
    private static String cep;

    public Endereco(Integer id, int funcionario_id, String cidade, String bairro, String complemento, String cep) {
        Modelo.id = id;
        Endereco.funcionario_id = funcionario_id;
        Endereco.cidade = cidade;
        Endereco.bairro = bairro;
        Endereco.complemento = complemento;
        Endereco.cep = cep;
    }
    public Endereco () {
    }

    public static Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Endereco.id = id;
    }

    public static int getFuncionarioId(){
        return funcionario_id;
    }

    public void setFuncionarioId(int funcionario_id){
        Endereco.funcionario_id = funcionario_id;
    }

    public static String getCidade(){
        return cidade;
    }

    public void setCidade(String cidade){
        Endereco.cidade = cidade;
    }

    public static String getBairro(){
        return bairro;
    }

    public void setBairro(String bairro){
        Endereco.bairro = bairro;
    }
    
    public static String getComplemento(){
        return complemento;
    }

    public void setComplemento(String complemento){
        Endereco.complemento = complemento;
    }

    public static String getCep(){
        return cep;
    }

    public void setCep(String cep){
        Endereco.cep = cep;
    }
    
}