package br.com.sboot.colaboradores.mapper;

import org.springframework.stereotype.Component;

import br.com.sboot.colaboradores.domain.Usuario;
import br.com.sboot.colaboradores.dto.UsuarioDTO;
import br.com.sboot.colaboradores.representation.UsuarioRepresentation;
import br.com.sboot.colaboradores.utils.StringUtils;

@Component
public class UsuarioMapper {
	
	public Usuario usuarioDTOToUsuario(UsuarioDTO dto) {
		return Usuario.builder()
				.id(dto.getId())
				.dtAlteracao(dto.getDtAlteracao())
				.dtAlteracao(dto.getDtAlteracao())
				.dtCriacao(dto.getDtCriacao())
				.email(dto.getEmail())
				.login(dto.getLogin())
				.status(dto.getStatus())
				.build();
	}
	
	
	public UsuarioRepresentation toUsuarioRepresentation(Usuario usuario){
		return UsuarioRepresentation.builder()
				.dtAlteracao(usuario.getDtAlteracao())
				.dtCriacao(usuario.getDtCriacao())
				.email(StringUtils.retornoTextoCaixaAlta(usuario.getEmail()))
				.id(usuario.getId())
				.login(StringUtils.retornoTextoCaixaAlta(usuario.getLogin()))
				.status(usuario.getStatus())
				.build();
	}
	
}
