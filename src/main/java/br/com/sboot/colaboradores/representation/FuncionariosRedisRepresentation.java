package br.com.sboot.colaboradores.representation;

import java.util.List;

import br.com.sboot.colaboradores.domain.FuncionarioRedis;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FuncionariosRedisRepresentation {
	
	private String msg;
	private List<FuncionarioRedis> funcionarios;
	
}
