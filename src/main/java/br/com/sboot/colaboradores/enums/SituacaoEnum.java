package br.com.sboot.colaboradores.enums;

import lombok.Getter;

@Getter
public enum SituacaoEnum {
	
	ATIVO(1, "ATIVO"),
	INATIVO(2, "INATIVO");

	private final Integer status;
	private final String descricao;	
	
	SituacaoEnum(Integer status, String descricao){
		this.status = status;
		this.descricao = descricao;
	}
	
}
