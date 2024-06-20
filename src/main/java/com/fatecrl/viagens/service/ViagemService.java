package com.fatecrl.viagens.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fatecrl.viagens.model.Viagem;
import com.fatecrl.viagens.repository.ViagemRepository;

import lombok.val;

@Service
public class ViagemService implements IService<Viagem> {

    @Autowired
    private ViagemRepository repository;

    public ViagemService() {
    }

    public Viagem create(Viagem trip) {
        repository.save(trip);
        return trip;
    }

    public Viagem findById(Long id) {
        Optional<Viagem> trip = repository.findById(id);
        return trip.orElse(null);
    }

    public List<Viagem> findAll() {
        return repository.findAll();
    }

    public Page<Viagem> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Viagem> findByDestination(String destination) {
        List<Viagem> viagens = repository.findByDestination(destination);

        if (viagens.size() > 0) {
            return viagens;
        }

        return null;
    }

    public List<Viagem> findBySource(String source) {
        return repository.findBySource(source);
    }

    public boolean update(Viagem trip) {
        if (repository.existsById(trip.getId())) {
            repository.save(trip);
            return true;
        }
        return false;
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
