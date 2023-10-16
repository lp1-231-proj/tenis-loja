public class Venda {

	private static Integer id;
	private String data_venda;

	public Venda(Integer id, String data_venda) {
		Venda.id = id;
		this.data_venda = data_venda;
	} 
	
	public Venda() {
		
	}

	public static Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		Venda.id = id;
	}

	public String getdata_venda() {
		return data_venda;
	}

	public void setdata_venda(String data_venda) {
		this.data_venda = data_venda;
	}

}

/*package model;

import java.sql.Date;
import model.ClienteModel;
import model.FuncionarioModel;

public class VendaModel {

	private long idVenda;
	private Date dataVenda;

	public VendaModel(long idVenda, Date dataVenda) {

		this.idVenda = idVenda;
		this.dataVenda = dataVenda;
	}

	public VendaModel() {
		
	}
	
	public long getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(long idVenda) {
		this.idVenda = idVenda;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

} */