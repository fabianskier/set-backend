package py.com.anski.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import py.com.anski.model.Ruc;

/**
 * @author anski
 *
 */

public interface RucService {

	int registrar(Ruc ruc);

	int modificar(Ruc ruc);

	void eliminar(int idRuc);

	List<Ruc> listarTodo();

	Ruc listarPorId(int idRuc);
	
	Ruc listarPorDocumento(String documento);

	Page<Ruc> listarPorPagina(Pageable pageable);
}
