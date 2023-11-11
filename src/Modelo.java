public class Modelo {

    static Integer id;
    private String nome;
    private String colorway;
    private String tamanho;
    private int quantidade;

    public Tenis(Integer id, string nome, string colorway, string tamanho, int quantidade) {
        Modelo.id = id;
        this.nome = nome;
        this.colorway = colorway;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
    }
    public Tenis () {
    }

    public static Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Tenis.id = id;
    }

    public string getNome(){
        return nome;
    }

    public void setNome(string nome){
        this.nome = nome;
    }

    public string getColorway(){
        return colorway;
    }

    public void setColorway(int colorway){
        this.colorway = colorway;
    }

    public string getTamanho(){
        return tamanho;
    }

    public void setTamanho(int tamanho){
        this.tamanho = tamanho;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
}
