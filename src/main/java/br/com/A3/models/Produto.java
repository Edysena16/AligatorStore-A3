package br.com.A3.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
 



/* @Table(name = "tb_produto") */
@Entity
public class Produto {
	
	@Id
	@NotEmpty
	private String produto1;
	
	@NotEmpty
	private String tipo;
	
	@NotEmpty
	private String nomeProduto;
	
	//private String tamanho;
	
	//private String cor;
	
	
	@ManyToOne
	private Categoria categoria;



	public String getProduto1() {
		return produto1;
	}

	public void setProduto1(String produto1) {
		this.produto1 = produto1;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	/*
	 * public Produto () { }
	 */
		


	/*
	 * public Produto(Long id, String tipo, String nomeProduto, String tamanho,
	 * String cor) { super(); this.id = id; this.tipo = tipo; this.nomeProduto =
	 * nomeProduto; this.tamanho = tamanho; this.cor = cor; }
	 */
	 

	

}
