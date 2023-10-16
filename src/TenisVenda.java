public class TenisVenda {

	private static Integer IdTenisVenda;
	private int quantidade;
	private Double preco;
	

	public TenisVenda(Integer IdTenisVenda, int quantidade, Double preco) {
		TenisVenda.IdTenisVenda = IdTenisVenda;
		this.quantidade = quantidade;
		this.preco = preco;
		
	} 
	
	public TenisVenda() {
		
	}

	public static Integer getIdTenisVenda() {
		return IdTenisVenda;
	}

	public void setIdTenisVenda(Integer IdTenisVenda) {
		TenisVenda.IdTenisVenda = IdTenisVenda ;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidadei(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
