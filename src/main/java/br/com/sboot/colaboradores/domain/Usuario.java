package br.com.sboot.colaboradores.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBUSUARIO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 6264740168107322119L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="IDUSUARIO")
	private Long id;
	
	@Column(name="LOGINUSUARIO")
	private String login;
	
	@Column(name="EMAILUSUARIO")
	private String email;
	
	@Column(name="DTCRIACAO")
	private LocalDateTime dtCriacao;
	
	@Column(name="DTALTERACAO")
	private LocalDateTime dtAlteracao;
	
	@Column(name="SITUACAOUSUARIO")
	private Integer status;
}
