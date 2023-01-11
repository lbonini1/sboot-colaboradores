package br.com.sboot.colaboradores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sboot.colaboradores.domain.Funcionario;
import br.com.sboot.colaboradores.domain.FuncionarioRedis;
import br.com.sboot.colaboradores.dto.FuncionarioDTO;
import br.com.sboot.colaboradores.enums.OperacaoEnum;
import br.com.sboot.colaboradores.mapper.FuncionarioMapper;
import br.com.sboot.colaboradores.representation.FuncionarioRepresentation;
import br.com.sboot.colaboradores.representation.FuncionariosRedisRepresentation;
import br.com.sboot.colaboradores.representation.FuncionariosRepresentation;
import br.com.sboot.colaboradores.service.FuncionarioRedisService;
import br.com.sboot.colaboradores.service.FuncionarioService;
import lombok.extern.slf4j.Slf4j;

@EnableScheduling
@RestController
@RequestMapping("/v1/funcionario")
@Slf4j
public class FuncionarioApi {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private FuncionarioRedisService funcionarioRedisService;
	
	@Autowired
	private FuncionarioMapper mapper;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<FuncionarioRepresentation> cadastrarFuncionario(@RequestBody FuncionarioDTO dto){
		return ResponseEntity.ok(mapper.toFuncionarioRepresentation(
				funcionarioService.cadastrarFuncionario(mapper.funcionarioDTOToFuncionario(dto)),
				OperacaoEnum.CADASTRAR.getOperacao()));
	}
	
	@GetMapping("/listar")
	public ResponseEntity<FuncionariosRepresentation> listarFuncionarios(){
		List<Funcionario> funcionarios = funcionarioService.listarFuncionarios();
		return ResponseEntity.ok(FuncionariosRepresentation.builder()
					.msg(funcionarios.size() + " Funcionario(s) Encontrado(s)")
					.funcionarios(funcionarios)
					.build());
	}
	
	@GetMapping("/listar-carregadados") @Scheduled(fixedDelay = 60000)
	public ResponseEntity<FuncionariosRedisRepresentation> carregarFuncionariosListadosCache(){
		List<FuncionarioRedis> funcionarios = funcionarioRedisService.carregarFuncionariosListadosEmCache();
		log.info("Funcionarios= " + funcionarios);
		return ResponseEntity.ok(FuncionariosRedisRepresentation.builder()
				.msg(funcionarios.size() + " Funcionario(s) Encontrado(s)")
				.funcionarios(funcionarios)
				.build());
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<FuncionarioRepresentation> listarFuncionarioPorId(@PathVariable Long id){
		return ResponseEntity.ok(mapper.toFuncionarioRepresentation(
				funcionarioService.listarFuncionarioPorId(id),
				OperacaoEnum.LISTAR.getOperacao()));
	}
	
	@GetMapping("/filtrar-ativos")
	public ResponseEntity<FuncionariosRepresentation> listarFuncionariosAtivos(){
		List<Funcionario> funcionarios = funcionarioService.listarFuncionariosAtivos();
		return ResponseEntity.ok(FuncionariosRepresentation.builder()
					.msg(funcionarios.size() + " Funcionario(s) Encontrado(s)")
					.funcionarios(funcionarios)
					.build());
	}
	
	@PutMapping("/inativar")
	public ResponseEntity<FuncionarioRepresentation> inativarFuncionario(Long id){
		return ResponseEntity.ok(mapper.toFuncionarioRepresentation(funcionarioService.inativar(id),
				OperacaoEnum.INATIVAR.getOperacao()));
	}
}
