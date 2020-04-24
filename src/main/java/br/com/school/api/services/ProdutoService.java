package br.com.school.api.services;

import java.util.List;

import br.com.school.api.models.Produto;

public interface ProdutoService {
	
	public List<Produto> findAll();
	
	public Produto find(Long id);
	
	public Produto create(Produto produto);
	
	public Produto update(Long id, Produto produto);
	
	public void delete(Long id);
	

}
