package br.com.A3.models;

import java.io.Serializable;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
/* @Table(name = "tb_categoria") */
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Gerar automaticamente
	private long codigo;

	@NotEmpty
	private String nome;

	@OneToMany
	private List<Produto> produtos;

	/*
	 * public Categoria(long codigo, String nome) { super(); this.codigo = codigo;
	 * this.nome = nome; }
	 */
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
