package br.com.sboot.colaboradores.representation;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioRepresentation {
	
	private Long id;
	private String login;
	private String email;
	private LocalDateTime dtCriacao;
	private LocalDateTime dtAlteracao;
	private Integer status;
	
}
