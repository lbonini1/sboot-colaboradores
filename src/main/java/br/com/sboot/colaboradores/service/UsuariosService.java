package br.com.sboot.colaboradores.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sboot.colaboradores.domain.Usuario;
import br.com.sboot.colaboradores.enums.SituacaoEnum;
import br.com.sboot.colaboradores.repository.UsuarioRepository;

@Service
public class UsuariosService {
	
	@Autowired
	private UsuarioRepository usuariosRepository;
	
	public List<Usuario> listarUsuarios() {
		return usuariosRepository.findAll();
	}
	
	public Usuario listarUsuarioPorId(Long id) {
		Optional<Usuario> usuario = usuariosRepository.findById(id);
		return usuario.orElse(Usuario.builder().build());
	}
	
	public List<Usuario> filtrarUsuariosAtivos() {
		return listarUsuarios().stream()
				.filter(u -> u.getStatus().equals(SituacaoEnum.ATIVO.getStatus())).collect(Collectors.toList());
	}
	
	public Usuario salvar(Usuario novoUsuario) {
		return usuariosRepository.save(novoUsuario);
	}
	
	public Usuario alterar(Usuario usuario) {
		setarDataAlteracaoRegistroUsuario(usuario);
		return usuariosRepository.saveAndFlush(usuario);
	}
	
	public Usuario inativar(Long id) {
		Usuario usuario = listarUsuarioPorId(id);
		usuariosRepository.saveAndFlush(inativarUsuario(usuario));
		return usuario;
	}
	
	public void excluir(Long id) {
		usuariosRepository.deleteById(id);
	}
	
	private Usuario inativarUsuario(Usuario usuario) {
		return Usuario.builder()
				.id(usuario.getId())
				.dtCriacao(usuario.getDtCriacao())
				.dtAlteracao(LocalDateTime.now())
				.status(SituacaoEnum.INATIVO.getStatus())
				.email(usuario.getEmail())
				.login(usuario.getLogin())
				.build();
	}
	
	private void setarDataAlteracaoRegistroUsuario(Usuario usuario) {
		usuario.setDtAlteracao(LocalDateTime.now());
	}
}
