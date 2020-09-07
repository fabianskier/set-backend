package py.com.anski.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.com.anski.model.Ruc;
import py.com.anski.service.RucService;

/**
 * @author anski
 *
 */

@RestController
@RequestMapping("/api/ruc")
public class RucController {

	@Autowired
	private RucService service;

	@GetMapping(value = "/listarTodo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Ruc>> listar() {
		List<Ruc> rucs = new ArrayList<>();
		try {
			rucs = service.listarTodo();
		} catch (Exception e) {
			return new ResponseEntity<List<Ruc>>(rucs, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Ruc>>(rucs, HttpStatus.OK);
	}

	@GetMapping(value = "/listarPorPagina", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Ruc>> listar(Pageable pageable) {
		Page<Ruc> rucs = null;
		try {
			rucs = service.listarPorPagina(pageable);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Page<Ruc>>(rucs, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Page<Ruc>>(rucs, HttpStatus.OK);
	}

	@GetMapping(value = "/listarPorId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ruc> listarPorId(@PathVariable("id") Integer id) {
		Ruc ruc = new Ruc();
		try {
			ruc = service.listarPorId(id);
		} catch (Exception e) {
			return new ResponseEntity<Ruc>(ruc, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Ruc>(ruc, HttpStatus.OK);
	}

	@GetMapping(value = "/listarPorDocumento/{documento}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ruc> listarPorDocumento(@PathVariable("documento") String documento) {
		Ruc ruc = new Ruc();
		try {
			ruc = service.listarPorDocumento(documento);
		} catch (Exception e) {
			return new ResponseEntity<Ruc>(ruc, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Ruc>(ruc, HttpStatus.OK);
	}

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> registrar(@RequestBody Ruc ruc) {
		int resultado = 0;
		try {
			service.registrar(ruc);
			resultado = 1;
		} catch (Exception e) {
			resultado = 0;
		}
		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}

	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody Ruc ruc) {
		int resultado = 0;
		try {
			service.modificar(ruc);
			resultado = 1;
		} catch (Exception e) {
			resultado = 0;
		}
		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}

	@DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> eliminar(@PathVariable Integer id) {
		int resultado = 0;
		try {
			service.eliminar(id);
			resultado = 1;
		} catch (Exception e) {
			resultado = 0;
		}
		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}
}
