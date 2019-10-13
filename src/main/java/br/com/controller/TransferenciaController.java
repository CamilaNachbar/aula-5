package br.com.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.service.TransferenciaService;

@RestController
public class TransferenciaController {

	@Autowired
	private TransferenciaService transferencia;
	
	// camila.nachbar@gmail.com
	
	@GetMapping(value = "/listar/transferencia/")
	public ResponseEntity<?> listar(){
		return new ResponseEntity<>(transferencia.listar(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/listar/transferencia/data")
	public ResponseEntity<?> listarPorData(@RequestBody Timestamp data){
		return new ResponseEntity<>(transferencia.listarPorData(data), HttpStatus.OK);
	}
	
	
	
}
