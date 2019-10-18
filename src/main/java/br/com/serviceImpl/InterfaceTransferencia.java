package br.com.serviceImpl;

import java.sql.Timestamp;
import java.util.List;

import br.com.entity.Transferencia;
import br.com.exception.ResourceNotFoundException;

public interface InterfaceTransferencia {

	public void salvar(Transferencia object) throws ResourceNotFoundException;

	public List<Transferencia> listarPorData(Timestamp data);
}
