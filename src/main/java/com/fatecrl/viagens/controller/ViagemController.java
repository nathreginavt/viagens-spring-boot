package com.fatecrl.viagens.controller;

import java.net.URI;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.List;

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

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/viagens")
public class ViagemController implements IController<Viagem> {

    @Autowired
    private ViagemService _viagemService;

    @Override
    @GetMapping("/{id}")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200"
                    , description = "Resultado com sucesso"
        ),
        @ApiResponse(responseCode = "500"
                    , description = "Erro interno do servidor"
        )
    })
    //retorna todos
    public ResponseEntity<List<Viagem>> getAll(){
		return ResponseEntity.ok(_viagemService.findAll());
	}

    //retorna pesquisa por id
    public ResponseEntity<Viagem> get(@PathVariable ("id") Long id) {
        Viagem trip = _viagemService.findById(id);
        if( trip != null){
            //status 200
            return ResponseEntity.ok(trip);
        }
        return ResponseEntity.notFound().build();
    }

    
    @Override
    public ResponseEntity<Viagem> post(Viagem obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'post'");
    }

    @Override
    public ResponseEntity<?> put(Viagem obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'put'");
    }

    @Override
    public ResponseEntity<?> patch(Viagem obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patch'");
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    /*
     * @PostMapping("/")
    public ResponseEntity<Viagem> postViagem(
            @RequestBody Viagem viagem) {

        // request invalido
        if (haParametroNulo(viagem)) {
            // status 400
            return ResponseEntity.badRequest().build();
        }

        
        // inconsistencias
        //if (haInconsistencias(viagem) || !saoParseaveis(viagem))
        if (haInconsistencias(viagem)) {
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

    @PutMapping("/")
    public ResponseEntity<Viagem> putViagem(@RequestBody Viagem viagem) {

        // request invalido
        if (haParametroNulo(viagem)) {
            // status 400
            return ResponseEntity.badRequest().build();
        }

        //campo nao parseavel
        // if (!saoParseaveis(viagem)) {
        //     // status 422 
        //     return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        // }

        Viagem trip = _viagemService.putViagem(viagem);

        if (trip == null) {
            // status 404
            return ResponseEntity.notFound().build();
        }

        // status 200
        return ResponseEntity.ok().body(trip);
    }

    private boolean haParametroNulo(Viagem viagem) {
        if (viagem.getOrderNumber() == null ||
                viagem.getAmount() == null ||
                viagem.getSource() == null ||
                viagem.getDestination() == null ||
                viagem.getStartDateTime() == null ||
                viagem.getEndDateTime() == null ||
                viagem.getType() == null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean haInconsistencias(Viagem viagem) {
        // inconsistencias
        if (viagem.getStartDateTime().isAfter(viagem.getEndDateTime())) {
            return true;
        }

        String source = viagem.getSource();
        String destination = viagem.getDestination();
        if (source.equalsIgnoreCase(destination)) {
            return true;
        }

        return false;
    }
     */

}
