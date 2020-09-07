package py.com.anski.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import py.com.anski.model.ERol;
import py.com.anski.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {

  Optional<Rol> findByName(ERol name);
}
