package com.fatecrl.viagens.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.fatecrl.viagens.dto.ViagemDTO;
import com.fatecrl.viagens.model.Viagem;

public class ViagemMapper {

    public Viagem toEntity(ViagemDTO viagemDTO) {
        Viagem viagem = new Viagem();
        viagem.setId(viagemDTO.getId());
        viagem.setOrderNumber(viagemDTO.getOrderNumber());
        viagem.setAmount(viagemDTO.getAmount());
        viagem.setSource(viagemDTO.getSource());
        viagem.setDestination(viagemDTO.getDestination());
        viagem.setStartDateTime(viagemDTO.getStartDateTime());
        viagem.setEndDateTime(viagemDTO.getEndDateTime());
        viagem.setType(viagemDTO.getType());
        
        return viagem;
    }

    public ViagemDTO toDTO(Viagem viagem) {
        ViagemDTO viagemDTO = new ViagemDTO();
        viagemDTO.setId(viagem.getId());
        viagemDTO.setOrderNumber(viagem.getOrderNumber());
        viagemDTO.setAmount(viagem.getAmount());
        viagemDTO.setSource(viagem.getSource());
        viagemDTO.setDestination(viagem.getDestination());
        viagemDTO.setStartDateTime(viagem.getStartDateTime());
        viagemDTO.setEndDateTime(viagem.getEndDateTime());
        viagemDTO.setType(viagem.getType());
        
        return viagemDTO;
    }

    public List<Viagem> toEntity(List<ViagemDTO> viagensDTO) {
        return viagensDTO.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
    
    public List<ViagemDTO> toDTO(List<Viagem> viagens) {
        return viagens.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }  
}
