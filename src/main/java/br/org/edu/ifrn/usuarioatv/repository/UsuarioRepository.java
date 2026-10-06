package br.org.edu.ifrn.usuarioatv.repository;

import br.org.edu.ifrn.usuarioatv.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}