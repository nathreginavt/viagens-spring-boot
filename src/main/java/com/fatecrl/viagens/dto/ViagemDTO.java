package com.fatecrl.viagens.dto;

import java.time.LocalDateTime;

import com.fatecrl.viagens.model.Type;

import lombok.*;

@Getter
@Setter

public class ViagemDTO {
    
    private String orderNumber;

    private String amount;

    private String source;

    private String destination;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    private Type type;
}
