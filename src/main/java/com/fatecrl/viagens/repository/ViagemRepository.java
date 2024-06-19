package com.fatecrl.viagens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatecrl.viagens.model.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {

    List<Viagem> findByDestination(String destination);

    List<Viagem> findBySource(String source);
}
