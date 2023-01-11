package br.com.sboot.colaboradores.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sboot.colaboradores.domain.Funcionario;
import br.com.sboot.colaboradores.domain.FuncionarioRedis;
import br.com.sboot.colaboradores.mapper.FuncionarioRedisMapper;
import br.com.sboot.colaboradores.repository.FuncionarioRedisRepository;

@Service
public class FuncionarioRedisService {
	
	@Autowired
	private FuncionarioRedisRepository funcionarioRedisRepository;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private FuncionarioRedisMapper mapper;
	
	public List<FuncionarioRedis> carregarFuncionariosListadosEmCache(){
		atualizarListaDeFuncionarios();
		return (List<FuncionarioRedis>) funcionarioRedisRepository.findAll();
	}
	
	public FuncionarioRedis salvarFuncionario(FuncionarioRedis funcionario) {
		return funcionarioRedisRepository.save(funcionario);
	}
	
	public void atualizarListaDeFuncionarios() {
		List<Funcionario> funcionarios = funcionarioService.listarFuncionarios();
		if(!funcionarios.isEmpty()) {
			funcionarios.stream().forEach(f -> salvarFuncionario(mapper.toFuncionarioRedis(f)));
		}
	}
	
}
