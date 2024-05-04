package com.fatecrl.viagens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatecrl.viagens.bean.Viagem;
import com.fatecrl.viagens.service.ViagemService;

@RestController
@RequestMapping("/viagens")

public class ViagemController {
    
    @Autowired
    private ViagemService _viagemService;

    @GetMapping("/{id}")
    public ResponseEntity<Viagem> getViagemById(@PathVariable Long id){
        if(id == null){
            return ResponseEntity.badRequest().build();
        } 

        Viagem trip = _viagemService.getViagemById(id);
        
        if(trip == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(trip);
    }
}
