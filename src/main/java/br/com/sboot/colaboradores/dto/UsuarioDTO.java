package br.com.sboot.colaboradores.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
	
	private Long id;
	private String login;
	private String email;
	private LocalDateTime dtCriacao;
	private LocalDateTime dtAlteracao;
	private Integer status;
	
}
