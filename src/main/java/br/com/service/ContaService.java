package br.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.entity.Conta;
import br.com.repository.ContaRepository;
import br.com.serviceImpl.InterfaceService;


@Service
public class ContaService implements InterfaceService  {

	@Autowired
	private ContaRepository contaRepository; 
	
	public void salvar(Conta conta) {
		contaRepository.save(conta);
	}
	
	@Override
	public List<Object> listar() {
		List<Object> obj = new ArrayList<>();
		obj.addAll(contaRepository.findAll());
		return obj;
	}

}
