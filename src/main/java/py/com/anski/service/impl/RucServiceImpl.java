package py.com.anski.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import py.com.anski.model.Ruc;
import py.com.anski.repository.RucRepository;
import py.com.anski.service.RucService;

/**
 * @author anski
 *
 */

@Service
public class RucServiceImpl implements RucService {
	
	@Autowired
	private RucRepository repository;

	@Override
	public int registrar(Ruc ruc) {
		int response = 0;
		response = repository.save(ruc) != null ? ruc.getIdRuc(): 0;
		return response > 0 ? 1 : 0;
	}

	@Override
	public int modificar(Ruc ruc) {
		int response = 0;
		response = repository.save(ruc) != null ? ruc.getIdRuc(): 0;
		return response > 0 ? 1 : 0;
	}

	@Override
	public void eliminar(int idRuc) {
		repository.deleteById(idRuc);
	}

	@Override
	public List<Ruc> listarTodo() {
		return repository.findAll();
	}

	@Override
	public Ruc listarPorId(int idRuc) {
		return repository.getOne(idRuc);
	}

	@Override
	public Page<Ruc> listarPorPagina(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Ruc listarPorDocumento(String documento) {
		return repository.findUserByDocumento(documento);
	}
	
	

}
