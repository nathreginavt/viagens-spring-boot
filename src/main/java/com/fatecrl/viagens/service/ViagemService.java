package com.fatecrl.viagens.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fatecrl.viagens.model.Viagem;
import com.fatecrl.viagens.repository.ViagemRepository;

@Service
public class ViagemService implements IService<Viagem>{

    @Autowired
    private ViagemRepository repository;

    public ViagemService(){  }

    @Override
    public Viagem create(Viagem trip) {
        repository.save(trip);
        return trip;
    }

    @Override
    public Viagem findById(Long id) {
        Optional<Viagem> trip = repository.findById(id);
        return trip.orElse(null);
    }

    @Override
    public List<Viagem> findAll(){
        return repository.findAll();
    }

    public Page<Viagem> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    //queries
    public List<Viagem> findByDestination(String destination) {
        return repository.findByDestination(destination);
    }
    public List<Viagem> findBySource(String source) {
        return repository.findBySource(source);
    }

    @Override
    public boolean update(Viagem trip) {
        if(repository.existsById(trip.getId())){
            repository.save(trip);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
