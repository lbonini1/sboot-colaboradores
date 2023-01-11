package br.com.sboot.colaboradores.enums;

import lombok.Getter;

@Getter
public enum OperacaoEnum {
	
	CADASTRAR(1, "CADASTRAR"),
	ALTERAR(2, "ALTERAR"),
	INATIVAR(3, "INATIVAR"),
	LISTAR(4, "LISTAR");
	
	private Integer operacao;
	private String descricao;
	
	OperacaoEnum(Integer operacao, String descricao){
		this.operacao = operacao;
		this.descricao = descricao;
	}
	
}
