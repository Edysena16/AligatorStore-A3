package br.com.A3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.A3.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
