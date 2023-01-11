package br.com.sboot.colaboradores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sboot.colaboradores.domain.Usuario;
import br.com.sboot.colaboradores.dto.UsuarioDTO;
import br.com.sboot.colaboradores.mapper.UsuarioMapper;
import br.com.sboot.colaboradores.representation.UsuarioRepresentation;
import br.com.sboot.colaboradores.representation.UsuariosRepresentation;
import br.com.sboot.colaboradores.service.UsuariosService;

@RestController
@RequestMapping(path = "/v1/usuario")
public class UsuarioApi {
	
	@Autowired
	private UsuariosService usuariosService;
	
	@Autowired
	private UsuarioMapper mapper;
	
	@GetMapping
	public ResponseEntity<UsuariosRepresentation> listarUsuarios(){
		List<Usuario> usuarios = usuariosService.listarUsuarios();
		return ResponseEntity.ok(UsuariosRepresentation.builder()
				.msg(usuarios.size() + " usuário(s) encontrado(s)")
				.usuarios(usuarios)
				.build());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioRepresentation> listarUsuarioPorId(@PathVariable Long id){
		return ResponseEntity.ok(mapper.toUsuarioRepresentation(
				usuariosService.listarUsuarioPorId(id)));
	}
	
	@GetMapping("/filtrar-ativos")
	public ResponseEntity<UsuariosRepresentation> listarUsuariosAtivos(){
		List<Usuario> usuariosAtivos = usuariosService.filtrarUsuariosAtivos();
		return ResponseEntity.ok(UsuariosRepresentation.builder()
				.msg(usuariosAtivos.size() + " usuário(s) encontrado(s)")
				.usuarios(usuariosAtivos)
				.build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioRepresentation> cadastrarUsuario(@RequestBody UsuarioDTO dto){
		return ResponseEntity.ok(mapper.toUsuarioRepresentation(
				usuariosService.salvar(mapper.usuarioDTOToUsuario(dto))));
	}
	
	@PutMapping("/alterar")
	public ResponseEntity<UsuarioRepresentation> alterarUsuario(@RequestBody UsuarioDTO dto){
		return ResponseEntity.ok(mapper.toUsuarioRepresentation(
				usuariosService.alterar(mapper.usuarioDTOToUsuario(dto))));
	}
	
	@PutMapping("/inativar")
	public ResponseEntity<Void> inativarUsuario(Long id){
		usuariosService.inativar(id);
		return ResponseEntity.ok().build();
	}
	
	
}
