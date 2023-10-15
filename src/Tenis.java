public class Tenis {

    private Integer id;
    private String colorway;
    private double preco;
    private int tamanho;
    private String modelo;
    private int quantidade;

    public Tenis(Integer id, String colorway, double preco, int tamanho, String modelo, int quantidade) {
        this.id = id;
        this.colorway = colorway;
        this.preco = preco;
        this.tamanho = tamanho;
        this.modelo = modelo;
        this.quantidade = quantidade;
    }
    public Tenis () {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColorway() {
        return colorway;
    }

    public void setColorway(String colorway) {
        this.colorway = colorway;
    }

    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public int getTamanho(){
        return tamanho;
    }

    public void setTamanho(int tamanho){
        this.tamanho = tamanho;
    }

    public String getModelo(){
        return modelo;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

}