package com.fatecrl.viagens.service;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatecrl.viagens.bean.Viagem;
import com.fatecrl.viagens.repository.ViagemRepository;

@Service
public class ViagemService implements IService<Viagem>{
    //public static List<Viagem> viagens = new ArrayList<Viagem>();

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
    public List<Viagem> findAll() {
        return repository.findAll();
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

    /*
    public Viagem getViagemById(Long id){
        for (Viagem viagem : viagens){
            if(viagem.getId().equals(id)){
                return viagem;
            }
        }
        return null;
    }

    public List<Viagem> getViagens(){
        List<Viagem> tripsList = new ArrayList<Viagem>(viagens);
        return tripsList;
    }

    public Viagem postViagem(Viagem viagem){
        Viagem trip = new Viagem();

        trip.setId(viagem.generateNextId());
        trip.setOrderNumber(viagem.getOrderNumber());
        trip.setAmount(viagem.getAmount());
        trip.setSource(viagem.getSource());
        trip.setDestination(viagem.getDestination());
        trip.setStartDateTime(viagem.getStartDateTime());
        trip.setEndDateTime(viagem.getEndDateTime());
        trip.setType(viagem.getType());

        viagens.add(trip);

        return trip;
    }

    public Viagem putViagem(Viagem viagem){

        for(Viagem trip : viagens){
            if(trip.getId().equals(viagem.getId()))
            {
                trip.setOrderNumber(viagem.getOrderNumber());
                trip.setAmount(viagem.getAmount());
                trip.setSource(viagem.getSource());
                trip.setDestination(viagem.getDestination());
                trip.setStartDateTime(viagem.getStartDateTime());
                trip.setEndDateTime(viagem.getEndDateTime());
                trip.setType(viagem.getType());

                return trip;
            }
        }

        return null;
    } */

}
