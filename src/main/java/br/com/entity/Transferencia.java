package br.com.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transferencia")
public class Transferencia extends Auditor<Long> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column
	private BigDecimal valor;

	@Column(name = "data_transferencia")
	private Date dataTransferencia;

	@Column(name = "id_autor_transferencia")
	private Long idAutorTransferencia;

	@Column(name = "id_beneficiario_transferencia")
	private Long idBeneficiarioTransferencia;

}
