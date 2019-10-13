package br.com.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.sun.istack.NotNull;

@Entity
@Table(name = "transferencia")
@Audited	
public class Transferencia  implements Serializable{

	private static final long serialVersionUID = 1L;

	public Transferencia() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "valor_transferencia")
	@NotNull
	private BigDecimal valor;

	@Column(name = "data_transferencia")
	@NotNull
	private Timestamp dataTransferencia;

	@Column(name = "id_autor_transferencia")
	@NotNull
	private Long idAutorTransferencia;

	@Column(name = "id_beneficiario_transferencia")
	@NotNull
	private Long idBeneficiarioTransferencia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Timestamp getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(Timestamp dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public Long getIdAutorTransferencia() {
		return idAutorTransferencia;
	}

	public void setIdAutorTransferencia(Long idAutorTransferencia) {
		this.idAutorTransferencia = idAutorTransferencia;
	}

	public Long getIdBeneficiarioTransferencia() {
		return idBeneficiarioTransferencia;
	}

	public void setIdBeneficiarioTransferencia(Long idBeneficiarioTransferencia) {
		this.idBeneficiarioTransferencia = idBeneficiarioTransferencia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataTransferencia == null) ? 0 : dataTransferencia.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idAutorTransferencia == null) ? 0 : idAutorTransferencia.hashCode());
		result = prime * result + ((idBeneficiarioTransferencia == null) ? 0 : idBeneficiarioTransferencia.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transferencia other = (Transferencia) obj;
		if (dataTransferencia == null) {
			if (other.dataTransferencia != null)
				return false;
		} else if (!dataTransferencia.equals(other.dataTransferencia))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idAutorTransferencia == null) {
			if (other.idAutorTransferencia != null)
				return false;
		} else if (!idAutorTransferencia.equals(other.idAutorTransferencia))
			return false;
		if (idBeneficiarioTransferencia == null) {
			if (other.idBeneficiarioTransferencia != null)
				return false;
		} else if (!idBeneficiarioTransferencia.equals(other.idBeneficiarioTransferencia))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

}
