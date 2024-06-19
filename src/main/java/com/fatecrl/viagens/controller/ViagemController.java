package com.fatecrl.viagens.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatecrl.viagens.model.Viagem;
import com.fatecrl.viagens.service.ViagemService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/viagens")
@Tag(name="Viagem", description = "Gerenciar viagem")
public class ViagemController implements IController<Viagem> {

    @Autowired
    private ViagemService _viagemService;

    @Override
    @PostMapping("/")
    @Operation(summary = "Cria uma viagem", description = "Cria uma nova viagem com as informações informadas no body")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201"
                    , description = "Cria uma nova viagem"),
        @ApiResponse(responseCode = "400"
                    , description = "Request inválido"),
        @ApiResponse(responseCode = "422"
                    , description = "Request mal formatado"),
        @ApiResponse(responseCode = "500"
                    , description = "Erro no servidor"),
    })
    public ResponseEntity<Viagem> post(@Valid @RequestBody Viagem trip) {

        if(
            trip.getEndDateTime().isBefore(trip.getStartDateTime()) ||
            trip.getDestination().equals(trip.getSource())
            )
        {
            return ResponseEntity.unprocessableEntity().build();
        }

        Viagem newTrip = _viagemService.create(trip);

        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(newTrip.getId())
                        .toUri();
        return ResponseEntity.created(location).body(newTrip);
    }

    @Override
    @GetMapping("/")
    @Operation(summary = "Retorna a lista de viagens", description = "Ontem a lista completa de viagens com todos os seus dados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200"
                    , description = "Retorna todas as viagens cadastradas"
        ),
        @ApiResponse(responseCode = "500"
                    , description = "Erro interno do servidor"
        )
    })
    public ResponseEntity<List<Viagem>> getAll(){
		return ResponseEntity.ok(_viagemService.findAll());
	}

    @Operation(summary = "Retorna a lista de viagens, de forma paginada",
               description = "Obtem a lista de viagens com todos os seus dados, de forma paginada")
    @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                    description = "Retorna lista de viagens, de forma paginada"),
                @ApiResponse(responseCode = "404",
                    description = "Viagens não encontradas"),
            })
    @GetMapping(value="/page")
    public ResponseEntity<Page<Viagem>> getAll(Pageable pageable){
        return ResponseEntity.ok(_viagemService.findAll(pageable));
    }

    @Override
    @GetMapping(value="/{id}", produces="application/json")
    @Operation(summary = "Retorna uma viagem", description = "Retorna a viagem com o id correspondente ao indicado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",
            description = "Retorna a viagem indicada"),
        @ApiResponse(responseCode = "404",
            description = "Viagem não encontrada"),
    })
    public ResponseEntity<Viagem> get(@PathVariable ("id") Long id) {
        Viagem trip = _viagemService.findById(id);
        if( trip != null){
            return ResponseEntity.ok(trip);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value="/origem/{source}", produces="application/json")
    @Operation(summary = "Retorna lista de viagens", description = "Retorna as viagens com a origem correspondente ao indicado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",
            description = "Retorna as viagens com origem indicada"),
        @ApiResponse(responseCode = "404",
            description = "Viagens não encontradas"),
    })
    public ResponseEntity<List<Viagem>> getBySource(@PathVariable ("source") String source) {
        List<Viagem> trips = _viagemService.findBySource(source);
        if(trips != null && !trips.isEmpty()){
            return ResponseEntity.ok(trips);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value="/destino/{destination}", produces="application/json")
    @Operation(summary = "Retorna lista de viagens", description = "Retorna as viagens com o destino correspondente ao indicado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",
            description = "Retorna as viagens com destino indicado"),
        @ApiResponse(responseCode = "404",
            description = "Viagens não encontradas"),
    })
    public ResponseEntity<List<Viagem>> getByDestination(@PathVariable ("destination") String destination) {
        List<Viagem> trips = _viagemService.findByDestination(destination);
        if(trips != null && !trips.isEmpty()){
            return ResponseEntity.ok(trips);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    @PutMapping("/")
    @Operation(summary = "Atualiza uma viagem existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200"
                    , description = "Viagem atualizada"),
        @ApiResponse(responseCode = "400"
                    , description = "Request inválido"),
        @ApiResponse(responseCode = "404"
                    , description = "Viagem não encontrada"),
        @ApiResponse(responseCode = "422"
                    , description = "Request mal formatado"),
        @ApiResponse(responseCode = "500"
                    , description = "Erro no servidor"),
    })
    public ResponseEntity<Viagem> put(@Valid @RequestBody Viagem trip) {
        if(
            trip.getEndDateTime().isBefore(trip.getStartDateTime()) ||
            trip.getDestination().equals(trip.getSource())
            )
        {
            return ResponseEntity.unprocessableEntity().build();
        }

        if(_viagemService.update(trip)){
            return ResponseEntity.ok(trip);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    @PatchMapping("/")
    @Operation(summary = "Atualiza parcialmente uma viagem existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200"
                    , description = "Viagem atualizada"),
        @ApiResponse(responseCode = "400"
                    , description = "Request inválido"),
        @ApiResponse(responseCode = "404"
                    , description = "Viagem não encontrada"),
        @ApiResponse(responseCode = "422"
                    , description = "Request mal formatado"),
    })
    public ResponseEntity<Viagem> patch(@RequestBody Viagem trip) {
        if(_viagemService.update(trip)){
            return ResponseEntity.ok(trip);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Exclui uma viagem existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204"
                    , description = "Viagem excluída"),
        @ApiResponse(responseCode = "404"
                    , description = "Viagem não encontrada"),
    })
    public ResponseEntity<Viagem> delete(@PathVariable("id") Long id) {
        if(_viagemService.delete(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
