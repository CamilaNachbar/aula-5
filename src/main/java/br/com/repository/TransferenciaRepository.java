package br.com.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.entity.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

	//@Query(value ="SELECT t from transferencia t WHERE DATA_TRANSFERENCIA =:data")
	public List<Transferencia> findByDataTransferencia(@Param("data") Date data);

}
