package py.com.anski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import py.com.anski.model.Ruc;

/**
 * @author anski
 *
 */

@Repository
public interface RucRepository extends JpaRepository<Ruc, Integer> {

	@Query("select r from Ruc r where r.documento = ?1")
	Ruc findUserByDocumento(String documento);
}
