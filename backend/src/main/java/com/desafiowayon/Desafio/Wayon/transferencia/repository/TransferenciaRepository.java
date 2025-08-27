package com.desafiowayon.Desafio.Wayon.transferencia.repository;

import com.desafiowayon.Desafio.Wayon.transferencia.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
}
