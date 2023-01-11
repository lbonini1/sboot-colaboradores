package br.com.sboot.colaboradores.representation;

import java.util.List;

import br.com.sboot.colaboradores.domain.Usuario;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuariosRepresentation {
	
	private String msg;
	private List<Usuario> usuarios;
}
