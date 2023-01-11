package br.com.sboot.colaboradores.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.sboot.colaboradores.domain.FuncionarioRedis;

public interface FuncionarioRedisRepository extends CrudRepository<FuncionarioRedis, Long>{

}
