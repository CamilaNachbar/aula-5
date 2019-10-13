package br.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.entity.Pessoa;
import br.com.service.PessoaService;

@RestController
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@PostMapping(value = "/salvar/pessoa")
	public ResponseEntity<?> salvarPessoa(@RequestBody Pessoa pessoa) {
		try {
			pessoaService.salvar(pessoa);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/listar/pessoa")
	public ResponseEntity<?> listarPessoas() {
		return new ResponseEntity<Object>(pessoaService.listar(), HttpStatus.OK);
	}
}
