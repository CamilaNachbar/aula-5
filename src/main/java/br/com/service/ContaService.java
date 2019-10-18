package br.com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.entity.Conta;
import br.com.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	public void salvar(Conta conta) {
		contaRepository.save(conta);
	}

	public void alterar(Conta conta) {
		if (conta.getIdConta() != null) {
			contaRepository.save(conta);
		} else {
			// tratar retorno
		}
	}

	public void delete(Long id) {
		try {
			contaRepository.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			// TRATAR EXCEPTIONS
		}
	}

	public Page<Conta> findAll(Pageable pageable) {
		return contaRepository.findAll(pageable);
	}
	
	public Optional<Conta> findbyId(Long id) {
	return contaRepository.findById(id);
		
	}

	public Page<Conta> findAll(Long numero, Pageable pageable) {
		return contaRepository.findByNumero(numero, pageable);
	}

}
