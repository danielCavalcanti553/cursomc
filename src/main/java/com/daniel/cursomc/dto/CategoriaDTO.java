package com.daniel.cursomc.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.daniel.cursomc.domain.Categoria;

public class CategoriaDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="Preencimento obrigatório")
	@Length(min=5,max=80,message = "O tamanho deve ser entre 5 e 80 caracteres!")
	private String nome;
	
	public CategoriaDTO() {
	}
	
	// Para não retornar todos os produtos de cada categoria (DTO)
	public CategoriaDTO(Categoria obj) {
		id = obj.getId();
		nome = obj.getNome();
	}	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
}
