package br.com.school.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.school.api.models.Produto;
import br.com.school.api.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;

	public ProdutoResource(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping
	@ResponseBody
	public List<Produto> findAll() {
		return this.produtoService.findAll();
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Produto findById(@PathVariable("id") Long id) {
		return produtoService.find(id);
	}

	@PostMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public Produto create(@RequestBody Produto produto) {
		return produtoService.create(produto);
	}

	@PutMapping("/{id}")
	@ResponseBody
	public Produto update(@PathVariable("id") Long id, @RequestBody Produto produto) {
		return produtoService.update(id, produto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		this.produtoService.delete(id);
	}

}
