package com.fatecrl.viagens.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.fatecrl.viagens.dto.ViagemDTO;

public interface IController<T> {
   ResponseEntity<List<T>> getAll();
   ResponseEntity<?> get(Long id);
   ResponseEntity<T> post(ViagemDTO obj);
   ResponseEntity<?> put(T obj);
   ResponseEntity<?> patch(T obj);
   ResponseEntity<?> delete(Long id);
}
