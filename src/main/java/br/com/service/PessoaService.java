package br.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.entity.Pessoa;
import br.com.exception.ValidationException;
import br.com.repository.PessoaRepository;
import br.com.serviceImpl.InterfaceService;
import br.com.utils.TratarRetorno;
import br.com.utils.ValidaCPF;

@Service
public class PessoaService implements InterfaceService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public void salvar(Pessoa pessoa) throws ValidationException {
		if (pessoa.getTipoPessoa().equals("PF")) {
			if (ValidaCPF.isCPF(pessoa.getDocumento())) {
				pessoaRepository.save(pessoa);
			} else {
				throw new ValidationException("cpf invalido");
			}
		} else {
			// validacao cnpj
		}
	}

	@Override
	public List<Object> listar() {
		List<Object> obj = new ArrayList<>();
		obj.addAll(TratarRetorno.retornoPessoa(pessoaRepository.findAll()));
		return obj;
	}

}
