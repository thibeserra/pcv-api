package br.com.pcv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pcv.domain.Contato;

public interface ContatosRepository extends JpaRepository<Contato, Long>{

}
