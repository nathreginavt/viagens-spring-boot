package com.fatecrl.viagens.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;



@Entity
@Table(name = "tb_viagem")

@NamedQueries({
    @NamedQuery(name = "Viagem.findByNmType", 
    query = "SELECT v FROM Viagem v WHERE v.type = Type.MULTI")
})

@Getter
@Setter

public class Viagem implements Serializable {

    private static Long nextId = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cd_orderNumber", nullable = false)
    @NotNull(message = "Número do pedido é obrigatório")
    private String orderNumber;

    @Column(name = "vl_amount", nullable = false)
    @NotNull(message = "Valor é obrigatório")
    private String amount;
    
    @Column(name = "nm_source", nullable = false)
    @NotNull(message = "Origem é obrigatória")
    private String source;

    @Column(name = "nm_destination", nullable = false)
    @NotNull(message = "Destino é obrigatório")
    private String destination;

    @Column(name = "cd_startDateTime", nullable = false, length = 20)
    @NotNull(message = "Data e hora de início são obrigatórias")
    @FutureOrPresent(message = "A data e hora de início devem estar no presente ou no futuro")
    private LocalDateTime startDateTime;

    @Column(name = "cd_endDateTime", nullable = false, length = 20)
    @NotNull(message = "Data e hora de término são obrigatórias")
    @FutureOrPresent(message = "A data e hora de término devem estar no presente ou no futuro")
    private LocalDateTime endDateTime;
    
    @Column(name = "nm_Type", nullable = false)
    @NotNull(message = "Tipo é obrigatório")
    private Type type;

    public Viagem() { }
}
