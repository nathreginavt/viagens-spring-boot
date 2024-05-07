package com.fatecrl.viagens.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatecrl.viagens.bean.Viagem;
import com.fatecrl.viagens.service.ViagemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/viagens")

public class ViagemController {

    @Autowired
    private ViagemService _viagemService;

    @GetMapping("/{id}")
    public ResponseEntity<Viagem> getViagemById(@PathVariable Long id) {
        if (id == null) {
            // status 400
            return ResponseEntity.badRequest().build();
        }

        Viagem trip = _viagemService.getViagemById(id);

        if (trip == null) {
            // status 404
            return ResponseEntity.notFound().build();
        }

        // status 200
        return ResponseEntity.ok(trip);
    }

    @PostMapping("/")
    public ResponseEntity<Viagem> postViagem(
        @RequestBody Viagem viagem) {

        // request invalido
        if (viagem.getOrderNumber() == null ||
                viagem.getAmount() == null ||
                viagem.getSource() == null ||
                viagem.getDestination() == null ||
                viagem.getStartDateTime() == null ||
                viagem.getEndDateTime() == null ||
                viagem.getType() == null) {

            // status 400
            return ResponseEntity.badRequest().build();
        }

        // inconsistencias

        if (viagem.getStartDateTime().isAfter(viagem.getEndDateTime())) {

            // status 422
            return ResponseEntity.unprocessableEntity().build();
        }

        String source = viagem.getSource();
        String destination = viagem.getDestination();
        if(source.equalsIgnoreCase(destination)){
            // status 422
            return ResponseEntity.unprocessableEntity().build();
        }

        Viagem trip = _viagemService
        .postViagem(viagem);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(trip.getId())
                .toUri();

        // status 201
       return ResponseEntity.status(HttpStatus.CREATED).header("Location", location.toString()).body(trip);
    }

}
