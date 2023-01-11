package br.com.sboot.colaboradores.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBFUNCIONARIO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario implements Serializable{
	
	private static final long serialVersionUID = 2980652837210616449L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="IDFUNC")
	private Long idFuncionario;
	
	@Column(name="NMFUNC")
	private String nomeFuncionario;
	
	@Column(name="DTNASC")
	private LocalDate dtNascimento;
	
	@Column(name="CPFFUNC")
	private String cpf;
	
	@Column(name="MATFUNC")
	private Integer matricula;
	
	@Column(name="FNFUNC")
	private String cargo;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;
	
	@Column(name="DTINCLUSAO")
	private LocalDateTime dtInclusao;
	
	@Column(name="DTALTERACAO")
	private LocalDateTime dtAlteracao;
	
	@Column(name="SITUACAOFUNC")
	private Integer status;
	
}
