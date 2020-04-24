package br.com.school.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.school.api.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
