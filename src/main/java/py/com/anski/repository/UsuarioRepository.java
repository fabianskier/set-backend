package py.com.anski.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.anski.model.Usuario;

/**
 * @author anski
 *
 */

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  
  Optional<Usuario> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
