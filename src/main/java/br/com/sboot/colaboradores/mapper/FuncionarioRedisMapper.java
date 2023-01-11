package br.com.sboot.colaboradores.mapper;

import org.springframework.stereotype.Component;

import br.com.sboot.colaboradores.domain.Funcionario;
import br.com.sboot.colaboradores.domain.FuncionarioRedis;

@Component
public class FuncionarioRedisMapper {
	
	public FuncionarioRedis toFuncionarioRedis(Funcionario funcionario) {
		return FuncionarioRedis.builder()
				.cargo(funcionario.getCargo())
				.cpf(funcionario.getCpf())
				.dtAlteracao(funcionario.getDtAlteracao())
				.dtInclusao(funcionario.getDtInclusao())
				.dtNascimento(funcionario.getDtNascimento())
				.idFuncionario(funcionario.getIdFuncionario())
				.matricula(funcionario.getMatricula())
				.nomeFuncionario(funcionario.getNomeFuncionario())
				.status(funcionario.getStatus())
				.usuario(funcionario.getUsuario())
				.build();
	}
	
}
