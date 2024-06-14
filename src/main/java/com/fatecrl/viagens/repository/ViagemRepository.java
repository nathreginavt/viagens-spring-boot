package com.fatecrl.viagens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fatecrl.viagens.model.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {

    @Query(value = "SELECT v FROM Viagem v WHERE v.source = ?1 ")
    List<Viagem> findByOrigem(String origem);

    @Query(value = "SELECT v FROM Viagem v WHERE v.source = ?1 AND v.destination = ?2")
    List<Viagem> findByOrigemAndDestino(String origem, String destino);

    List<Viagem> findByDestination(String destino);
}
