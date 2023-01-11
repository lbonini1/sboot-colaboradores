package br.com.sboot.colaboradores.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sboot.colaboradores.domain.Funcionario;
import br.com.sboot.colaboradores.enums.SituacaoEnum;
import br.com.sboot.colaboradores.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private UsuariosService usuarioService;
	
	public Funcionario cadastrarFuncionario(Funcionario funcionario) {
		Funcionario funcSalvo = funcionarioRepository.save(funcionario);
		persistirMatriculaFuncionario(funcSalvo);
		return funcSalvo;
	}
	
	public List<Funcionario> listarFuncionarios(){
		return funcionarioRepository.findAll();
	}
	
	public Funcionario listarFuncionarioPorId(Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		return funcionario.orElse(new Funcionario());
	}
	
	public List<Funcionario> listarFuncionariosAtivos(){
		List<Funcionario> funcionarios = listarFuncionarios();
		return funcionarios.stream()
				.filter(f -> f.getStatus().equals(SituacaoEnum.ATIVO.getStatus())).collect(Collectors.toList());
	}
	
	public Funcionario inativar(Long id) {
		Funcionario funcionario = listarFuncionarioPorId(id);
		return funcionarioRepository.saveAndFlush(inativarFuncionario(funcionario));
	}
	
	private void persistirMatriculaFuncionario(Funcionario funcionario) {
		funcionario.setMatricula(funcionario.getIdFuncionario().intValue());
		funcionarioRepository.saveAndFlush(funcionario);
	} 
	
	private Funcionario inativarFuncionario(Funcionario funcionario) {
		return Funcionario.builder()
				.cargo(funcionario.getCargo())
				.cpf(funcionario.getCpf())
				.dtAlteracao(LocalDateTime.now())
				.dtInclusao(funcionario.getDtInclusao())
				.dtNascimento(funcionario.getDtNascimento())
				.idFuncionario(funcionario.getIdFuncionario())
				.matricula(funcionario.getMatricula())
				.nomeFuncionario(funcionario.getNomeFuncionario())
				.status(SituacaoEnum.INATIVO.getStatus())
				.usuario(funcionario.getUsuario() != null ?
						usuarioService.inativar(funcionario.getUsuario().getId()) : null)
				.build();
	}
	
}
