package br.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.entity.Conta;
import br.com.service.ContaService;

@RestController
public class ContaController {

	@Autowired
	private ContaService contaService;

	@PostMapping(value = "/salvar/conta")
	public ResponseEntity<?> salvarConta(@RequestBody Conta conta) {
		try {
			contaService.salvar(conta);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
