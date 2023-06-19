package com.example.apiferreteria.controllers;

import com.example.apiferreteria.dto.CaracteristicaDto;
import com.example.apiferreteria.entities.Caracteristica;
import com.example.apiferreteria.services.CaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/caracteristica")
public class CaracteristicaController {
    @Autowired
    private CaracteristicaService service;
    @GetMapping
    public ResponseEntity<List<Caracteristica>> getAllByStatus(){
        return new ResponseEntity<>(service.getAllByStatus(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Caracteristica> create(@RequestBody CaracteristicaDto caracteristicaDto){
        return new ResponseEntity<>(service.create(caracteristicaDto),HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Caracteristica> update(@PathVariable("id")Integer id,@RequestBody CaracteristicaDto caracteristicaDto){
        return new ResponseEntity<>(service.update(id,caracteristicaDto),HttpStatus.OK);
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<Caracteristica> delete(@PathVariable("id")Integer id){
        return new ResponseEntity<>(service.delete(id),HttpStatus.OK);
    }
}
