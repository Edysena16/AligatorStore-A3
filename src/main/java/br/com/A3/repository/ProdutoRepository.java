package br.com.A3.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.A3.models.Categoria;
import br.com.A3.models.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, String> {
	Iterable<Produto> findByCategoria(Categoria categoria);

	Produto findByProduto1(String produto1);
}
