package com.fatecrl.viagens.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fatecrl.viagens.bean.Viagem;

@Service
public class ViagemService {
    public static List<Viagem> viagens = new ArrayList<Viagem>();

    public ViagemService(){
        fakeTrip();
    }

    private void fakeTrip(){
        Viagem viagem1 = new Viagem();
        viagem1.setSource("Brazil");
        viagem1.setDestination("USA");
        //viagem1.setType(RETURN);
        viagem1.setId(1L);
        viagens.add(viagem1);
    }

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

}
