package br.com.pcv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pcv.domain.Endereco;

public interface EnderecosRepository extends JpaRepository<Endereco, Long> {

}
