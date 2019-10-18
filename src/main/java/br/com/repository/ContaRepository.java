package br.com.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.entity.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

	public Conta findByIdConta(Long id);
	
	public Page<Conta> findByNumero(Long numero, Pageable pageable);
	
	


}
