package com.fatecrl.viagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatecrl.viagens.bean.Viagem;

@Repository
public interface ViagemRepository extends
                       JpaRepository<Viagem, Long> {
}

