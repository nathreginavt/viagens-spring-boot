package com.fatecrl.viagens.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fatecrl.viagens.bean.Viagem;

@Service
public class ViagemService {
    List<Viagem> viagens = new ArrayList<Viagem>();

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

    /* 
    public List<Viagem> getViagens(){
        List<Viagem> tripsList = new ArrayList<Viagem>(viagens);
        return tripsList;
    }
    */
    

    
}
