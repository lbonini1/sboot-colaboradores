package br.com.sboot.colaboradores.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sboot.colaboradores.domain.Funcionario;
import br.com.sboot.colaboradores.dto.FuncionarioDTO;
import br.com.sboot.colaboradores.enums.OperacaoEnum;
import br.com.sboot.colaboradores.representation.FuncionarioRepresentation;
import br.com.sboot.colaboradores.utils.StringUtils;

@Component
public class FuncionarioMapper {
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	public Funcionario funcionarioDTOToFuncionario(FuncionarioDTO dto) {
		return Funcionario.builder()
				.cpf(dto.getCpf())
				.dtAlteracao(dto.getDtAlteracao())
				.dtInclusao(dto.getDtInclusao())
				.dtNascimento(dto.getDtNascimento())
				.idFuncionario(dto.getIdFuncionario())
				.matricula(dto.getMatricula())
				.cargo(dto.getCargo())
				.nomeFuncionario(dto.getNomeFuncionario())
				.status(dto.getStatus())
				.usuario(usuarioMapper.usuarioDTOToUsuario(dto.getUsuarioDto()))
				.build();
	}
	
	public FuncionarioRepresentation toFuncionarioRepresentation(Funcionario funcionario, Integer operacao) {
		return FuncionarioRepresentation.builder()
				.msg(retornoOperacaoPorTipo(operacao, funcionario))
				.cpf(funcionario.getCpf())
				.dtAlteracao(funcionario.getDtAlteracao())
				.dtInclusao(funcionario.getDtInclusao())
				.dtNascimento(funcionario.getDtNascimento())
				.idFuncionario(funcionario.getIdFuncionario())
				.matricula(funcionario.getMatricula())
				.cargo(StringUtils.retornoTextoCaixaAlta(funcionario.getCargo()))
				.nomeFuncionario(StringUtils.retornoTextoCaixaAlta(funcionario.getNomeFuncionario()))
				.status(funcionario.getStatus())
				.usuario(funcionario.getUsuario() != null ? usuarioMapper.toUsuarioRepresentation(funcionario.getUsuario()) : null)
				.build();
	}
	
	
	private String retornoOperacaoPorTipo(Integer operacao, Funcionario funcionario) {
		return retornoCadastro(operacao, funcionario);
	}
	
	private String retornoCadastro(Integer operacao, Funcionario funcionario) {
		if(operacao != null && OperacaoEnum.CADASTRAR.getOperacao().equals(operacao)) {
			return (funcionario.getIdFuncionario() == null && funcionario.getDtInclusao() == null) ? 
					null : "Novo(a) Funcionário(a) Cadastrado(a)";
		}
		return retornoAlteracao(operacao, funcionario);
	}
	
	private String retornoAlteracao(Integer operacao, Funcionario funcionario) {
		if(operacao != null && OperacaoEnum.ALTERAR.getOperacao().equals(operacao)) {
			return (funcionario.getIdFuncionario() != null && funcionario.getDtInclusao() != null) ? 
					"Funcionário(a) " +funcionario.getNomeFuncionario()+ " Alterado(a)" : null;
		}
		return retornoInativacao(operacao, funcionario);
	}
	
	private String retornoInativacao(Integer operacao, Funcionario funcionario) {
		if(operacao != null && OperacaoEnum.INATIVAR.getOperacao().equals(operacao)) {
			return (funcionario.getIdFuncionario() != null && funcionario.getDtInclusao() != null) ? 
					"Funcionário(a) " +funcionario.getNomeFuncionario()+ " Inativado(a)" : null;
		}
		return retornoListagemPorId(operacao, funcionario);
	}
	
	private String retornoListagemPorId(Integer operacao, Funcionario funcionario) {
		if(operacao != null && OperacaoEnum.LISTAR.getOperacao().equals(operacao)) {
			return (funcionario.getIdFuncionario() != null) ? 
					"Funcionário(a) com a matricula " +funcionario.getMatricula()+ " Encontrado(a)" : null;
		}
		return null;
	}
	
	
	
	
}
