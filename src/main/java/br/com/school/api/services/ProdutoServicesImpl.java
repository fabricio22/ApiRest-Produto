package br.com.school.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.school.api.models.Produto;
import br.com.school.api.repository.ProdutoRepository;

@Service
public class ProdutoServicesImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public ProdutoServicesImpl(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	@Override
	public List<Produto> findAll() {
		return this.produtoRepository.findAll();
	}

	@Override
	public Produto find(Long id) {
		Optional<Produto> optionalProduto = this.produtoRepository.findById(id);
		return optionalProduto.isPresent() ? optionalProduto.get() : null;
	}

	@Override
	public Produto create(Produto produto) {
		this.produtoRepository.save(produto);
		return produto;
	}

	@Override
	public Produto update(Long id, Produto produto) {
		Optional<Produto> optionalProduto = this.produtoRepository.findById(id);
		
		if (optionalProduto.isPresent()) {
			Produto prod = optionalProduto.get();
			prod.setNome(produto.getNome());
			prod.setQuantidade(produto.getQuantidade());
			return this.produtoRepository.save(prod);
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		this.produtoRepository.deleteById(id);
	}

}
