package com.fatecrl.viagens.bean;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;



@Entity
@Table(name = "tb_viagem")

@NamedQueries({
    @NamedQuery(name = "Viagem.findByNmType", 
    query = "SELECT v FROM Viagem v WHERE v.type = Type.MULTI")
})

public class Viagem implements Serializable {

    private static Long nextId = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cd_orderNumber", nullable = false)
    @NotNull(message = "Order number is required")
    private String orderNumber;

    @Column(name = "vl_amount", nullable = false)
    @NotNull(message = "Amount is required")
    private String amount;
    
    @Column(name = "nm_source", nullable = false)
    @NotNull(message = "Source is required")
    private String source;

    @Column(name = "nm_destination", nullable = false)
    @NotNull(message = "Destination is required")
    private String destination;

    @Column(name = "cd_startDateTime", nullable = false, length = 20)
    @NotNull(message = "Start date and time is required")
    @FutureOrPresent(message = "The start date and time must be in the present or future")
    private LocalDateTime startDateTime;

    @Column(name = "cd_endDateTime", nullable = false, length = 20)
    @NotNull(message = "End date and time is required")
    @FutureOrPresent(message = "The end date and time must be in the present or future")
    private LocalDateTime endDateTime;
    
    @Column(name = "nm_Type", nullable = false)
    @NotNull(message = "Type is required")
    private Type type;

    public Viagem(){

    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }
    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }
    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }

    public Long generateNextId() {
        return nextId++;
    }
}
