package br.com.sboot.colaboradores.representation;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioRepresentation {
	
	private String msg;
	private Long idFuncionario;
	private String nomeFuncionario;
	private LocalDate dtNascimento;
	private String cpf;
	private Integer matricula;
	private String cargo;
	private LocalDateTime dtInclusao;
	private LocalDateTime dtAlteracao;
	private Integer status;
	private UsuarioRepresentation usuario;
	
}
