package br.com.sboot.colaboradores.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.sboot.colaboradores.domain.Funcionario;

@Repository
public interface UsuarioCrudRepository extends CrudRepository<Funcionario, Long>{

}
