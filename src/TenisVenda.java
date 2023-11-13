public class TenisVenda {

	private static Integer IdTenisVenda;
	private static Integer tenis_id;
	private static Integer venda_id;
	private int quantidade;
	private Double valorUnitario;
	

	public TenisVenda(Integer IdTenisVenda, Integer tenis_id, Integer venda_id, int quantidade, Double valorUnitario) {
		TenisVenda.IdTenisVenda = IdTenisVenda;
		TenisVenda.tenis_id = Tenis.id;
		TenisVenda.venda_id = Venda.id;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		
	} 
	
	public TenisVenda() {
		
	}

	public static Integer getIdTenisVenda() {
		return IdTenisVenda;
	}

	public void setIdTenisVenda(Integer IdTenisVenda) {
		TenisVenda.IdTenisVenda = IdTenisVenda ;
	}

	public static Integer getTenisId() {
		return tenis_id;
	}

	public void setTenisId(Integer tenis_id) {
		TenisVenda.tenis_id = tenis_id;
	}

	public static Integer getVendaId() {
		return venda_id;
	}

	public void setVendaId(Integer venda_id) {
		TenisVenda.venda_id = venda_id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double preco) {
		this.valorUnitario = preco;
	}

}
