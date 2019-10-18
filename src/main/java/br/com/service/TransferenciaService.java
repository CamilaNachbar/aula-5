package br.com.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.entity.Conta;
import br.com.entity.Transferencia;
import br.com.exception.ResourceNotFoundException;
import br.com.repository.ContaRepository;
import br.com.repository.TransferenciaRepository;
import br.com.serviceImpl.InterfaceService;
import br.com.serviceImpl.InterfaceTransferencia;
import br.com.utils.EnumValidationException;

@Service
public class TransferenciaService implements InterfaceTransferencia, InterfaceService {

	@Autowired
	private TransferenciaRepository transferenciaRepository;

	@Autowired
	private ContaRepository contaRepository;

	@Override
	public void salvar(Transferencia transferencia) throws ResourceNotFoundException {
		// autor da transferencia tem saldo + limite, conta esta habilitada,
		// beneficiario com conta habilitada
		// transferencia maior que 100k
		if (validarTransferencia(transferencia)) {
			transferenciaRepository.save(transferencia);
		} else {
			throw new ResourceNotFoundException(EnumValidationException.ERROR_SALVAR_TRANSFERENCIA.getDescricao());
		}
	}

	private Boolean validarTransferencia(Transferencia transferencia) {
		Conta autor = contaRepository.findByIdConta(transferencia.getIdAutorTransferencia());
		Conta beneficiario = contaRepository.findByIdConta(transferencia.getIdBeneficiarioTransferencia());

		if (autor != null && beneficiario != null && autor.getAtiva() && beneficiario.getAtiva())
			if (transferencia.getValor().compareTo(BigDecimal.valueOf(100000)) >= 0
					&& autor.getSaldo().add(autor.getLimite()).compareTo(transferencia.getValor()) >= 0) {
				return true;
			}
		return false;

	}

	@Override
	public List<Object> listar() {
		List<Object> obj = new ArrayList<>();
		obj.addAll(transferenciaRepository.findAll());
		return obj;
	}

	@Override
	public List<Transferencia> listarPorData(Timestamp data) {
		return transferenciaRepository.findByDataTransferencia(data);
	}

}
