package br.com.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.entity.Conta;
import br.com.exception.ResourceNotFoundException;
import br.com.service.ContaService;

@RestController
@RequestMapping("conta")
public class ContaController {

	@Autowired
	private ContaService contaService;

	@PostMapping(value = "/salvar")
	public ResponseEntity<?> salvarConta(@Valid @RequestBody Conta conta) {
		try {
			contaService.salvar(conta);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "/alterar")
	public ResponseEntity<?> alterarConta(@Valid @RequestBody Conta conta) {
		try {
			contaService.salvar(conta);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping
	// localhost:8181/conta?page=0
	// localhost:8181/conta?numero={{numero}}?page=0
	public ResponseEntity<Page> findAll(@PathParam("numero") Long numero, Pageable pageable) {
		if (numero != null) {
			return new ResponseEntity<Page>(this.contaService.findAll(numero, pageable), HttpStatus.OK);
		}
		return new ResponseEntity<>(this.contaService.findAll(pageable), HttpStatus.OK);
	}

	@GetMapping(value = "/find/{id}")
	// localhost:8181/conta?page=0
	public ResponseEntity<?> findAllConta(@PathVariable("id") Long id) throws ResourceNotFoundException {
		return new ResponseEntity<>(this.contaService.findbyId(id).orElseThrow(() -> new ResourceNotFoundException()),
				HttpStatus.OK);
	}

	@DeleteMapping
	// localhost:8181/conta?id={{id}}
	// LEVANTAR PONTOS DESSE DELETE
	public ResponseEntity<?> delete(@PathParam("id") Long id) {
		this.contaService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}

}
