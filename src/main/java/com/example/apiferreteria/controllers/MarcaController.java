package com.example.apiferreteria.controllers;

import com.example.apiferreteria.dto.MarcaDto;
import com.example.apiferreteria.entities.Marca;
import com.example.apiferreteria.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/marca")
public class MarcaController {
    @Autowired
    private MarcaService service;
    @GetMapping
    public ResponseEntity<List<Marca>> getAllByStatus(){
        return new ResponseEntity<>(service.getAllByStatus(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Marca> create(@RequestBody MarcaDto marcaDto){
        return new ResponseEntity<>(service.create(marcaDto),HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Marca> update(@PathVariable("id")Integer id,@RequestBody MarcaDto marcaDto){
        return new ResponseEntity<>(service.update(id,marcaDto),HttpStatus.OK);
    }
    @PutMapping("/delete/{id}")
    public ResponseEntity<Marca> delete(@PathVariable("id")Integer id){
        return new ResponseEntity<>(service.delete(id),HttpStatus.OK);
    }
}
