public class Tenis {

    static Integer id;
    private int modelo_id;
    private double preco;
    private int quantidadeTotal;

    public Tenis(Integer id, int modelo_id, double preco, int quantidadeTotal) {
        Tenis.id = id;
        this.modelo = modelo_id;
        this.preco = preco;
        this.quantidadeTotal = quantidadeTotal;
    }
    public Tenis () {
    }

    public static Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Tenis.id = id;
    }

    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public int getModeloId(){
        return modelo_id;
    }

    public void setModeloId(int modelo_id){
        this.modelo_id = modelo_id;
    }

    public int getQuantidadeTotal(){
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal){
        this.quantidadeTotal = quantidadeTotal;
    }

}