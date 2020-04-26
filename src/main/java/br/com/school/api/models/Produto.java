package br.com.school.api.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "Chave nome não pode ser nulo.")
	@NotBlank(message = "valor nome não pode estar em branco.")
	private String nome;
	@Min(value = 0, message = "quantidade tem que ser maior ou igual a zero.")
	private Integer quantidade;
	private Date dataCriacao;

	public Produto() {

	}

	public Produto(String nome, Integer quantidade) {
		this.nome = nome;
		this.quantidade = quantidade;
	}

	@PrePersist
	public void validaAntes() {
		if (this.dataCriacao == null) {
			this.dataCriacao = new Date();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public String toString() {
		return "{ id: " + this.id + " nome: " + this.nome + " quantidade: " + this.quantidade + " dataCriacao: "
				+ this.dataCriacao + "}";
	}

}
