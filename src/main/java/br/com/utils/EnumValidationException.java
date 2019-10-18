package br.com.utils;

public enum EnumValidationException{

	ERROR_SALVAR_TRANSFERENCIA("Erro ao salvar transferencia"),
	ERROR_SALVAR_CONTA("Erro ao salvar a conta");
	
	private String descricao;

	private EnumValidationException(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
