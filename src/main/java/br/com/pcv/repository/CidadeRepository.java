package br.com.pcv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pcv.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}
