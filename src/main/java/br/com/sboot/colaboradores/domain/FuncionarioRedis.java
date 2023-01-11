package br.com.sboot.colaboradores.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@RedisHash("funcionario")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FuncionarioRedis {
	
	@Id @Indexed
	private Long idFuncionario;
	private String nomeFuncionario;
	private LocalDate dtNascimento;
	private String cpf;	
	private Integer matricula;
	private String cargo;
	private Usuario usuario;
	private LocalDateTime dtInclusao;
	private LocalDateTime dtAlteracao;
	private Integer status;
	
}
