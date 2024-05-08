package com.fatecrl.viagens.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fatecrl.viagens.bean.Viagem;

@Service
public class ViagemService {
    public static List<Viagem> viagens = new ArrayList<Viagem>();

    public ViagemService(){

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

    public Viagem putViagem(Viagem viagem){

        for(Viagem trip : viagens){
            if(trip.getId().equals(viagem.getId()))
            {
                trip.setId(viagem.generateNextId());
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
    }

}
