package br.com.A3.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.A3.models.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, String> {
	Categoria findByCodigo(long codigo);
}
