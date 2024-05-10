package com.fatecrl.viagens.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_viagem")
public class Viagem implements Serializable {
    private static Long nextId = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cd_orderNumber", nullable = false)
    private String orderNumber;
    @Column(name = "vl_amount", nullable = false)
    private String amount;
    @Column(name = "nm_source", nullable = false)
    private String source;
    @Column(name = "nm_destination", nullable = false)
    private String destination;
    @Column(name = "cd_startDateTime", nullable = false, length = 20)
    private LocalDateTime startDateTime;
    @Column(name = "cd_endDateTime", nullable = false, length = 20)
    private LocalDateTime endDateTime;
    @Column(name = "nm_Type", nullable = false)
    private Type type;

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
