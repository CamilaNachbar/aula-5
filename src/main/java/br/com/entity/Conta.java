package br.com.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "conta")
public class Conta extends Auditor<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idConta;

	@Column(name = "conta_numero")
	@Min(value = 8, message = "Numero conta deve ter no minino 8 digitos")
	private Long numero;

	@Column(name = "conta_agencia")
	@Min(value = 3, message = "Agencia deve ter no minino 3 digitos")
	private Long agencia;

	@Column(name = "conta_digito")
	@Min(value = 2, message = "Digito conta deve ter no minino 2 digitos")
	private Long digito;

	@Column(name = "conta_limite")
	private BigDecimal limite;

	@Column(name = "conta_saldo")
	private BigDecimal saldo;

	@Column(name = "conta_ativa")
	private Boolean ativa;

	@OneToOne(mappedBy = "conta")
	private Pessoa pessoa;

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Long getAgencia() {
		return agencia;
	}

	public void setAgencia(Long agencia) {
		this.agencia = agencia;
	}

	public Long getDigito() {
		return digito;
	}

	public void setDigito(Long digito) {
		this.digito = digito;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Boolean getAtiva() {
		return ativa;
	}

	public void setAtiva(Boolean ativa) {
		this.ativa = ativa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	

}
