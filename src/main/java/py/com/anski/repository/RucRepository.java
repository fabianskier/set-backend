package py.com.anski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import py.com.anski.model.Ruc;

/**
 * @author anski
 *
 */

@Repository
public interface RucRepository extends JpaRepository<Ruc, Integer> {

}
