package br.com.sboot.colaboradores.representation;

import java.util.List;

import br.com.sboot.colaboradores.domain.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FuncionariosRepresentation {
	
	private String msg;
	private List<Funcionario> funcionarios;
	
}
