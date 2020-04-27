package br.com.school.api.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST - Modulo Produto")
@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;

	public ProdutoResource(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@ApiOperation(value = "Retorna uma lista de Produtos")
	@GetMapping
	@ResponseBody
	public ResponseEntity<?> findAll() {
		List<Produto> listaProduto = this.produtoService.findAll();
		return new ResponseEntity<List>(listaProduto, HttpStatus.OK);
	}

	@ApiOperation(value = "Retorno um único produdo pelo Id")
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		Produto produto = produtoService.find(id);
		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
	}

	@ApiOperation(value = "Cria um produto")
	@PostMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<?> create(@Valid @RequestBody Produto produto, Errors error) {
		if (!error.hasErrors()) {
			Produto produtoCriado = produtoService.create(produto);
			return new ResponseEntity<Produto>(produtoCriado, HttpStatus.CREATED);
		}

		return ResponseEntity.badRequest().body(error.getAllErrors().stream()
				.map(mensagem -> mensagem.getDefaultMessage()).collect(Collectors.joining(",")));
	}

	@ApiOperation("Atualiza um produto")
	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> update(@Valid @PathVariable("id") Long id, @RequestBody Produto produto, Errors error) {
		if (!error.hasErrors()) {
			Produto produtoAtualizado = produtoService.update(id, produto);
			return new ResponseEntity<Produto>(produtoAtualizado, HttpStatus.OK);
		}
		return ResponseEntity.badRequest().body(error.getAllErrors().stream()
				.map(mensagem -> mensagem.getDefaultMessage()).collect(Collectors.joining(",")));
	}

	@ApiOperation(value = "Remove um produto pelo Id")
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		this.produtoService.delete(id);
	}

}
