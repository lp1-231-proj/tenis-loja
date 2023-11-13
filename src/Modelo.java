public class Modelo {

    static Integer id;
    private String nome;
    private String colorway;
    private String tamanho;
    private int quantidade;

    public Modelo(Integer id, String nome, String colorway, String tamanho, int quantidade) {
        Modelo.id = id;
        this.nome = nome;
        this.colorway = colorway;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
    }
    public Modelo () {
    }

    public static Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Tenis.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getColorway(){
        return colorway;
    }

    public void setColorway(String colorway){
        this.colorway = colorway;
    }

    public String getTamanho(){
        return tamanho;
    }

    public void setTamanho(String tamanho){
        this.tamanho = tamanho;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
}
