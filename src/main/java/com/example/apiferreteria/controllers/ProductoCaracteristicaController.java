package com.example.apiferreteria.controllers;

import com.example.apiferreteria.dto.ProductoCaracteristicaDto;
import com.example.apiferreteria.entities.Producto;
import com.example.apiferreteria.entities.ProductoCaracteristica;
import com.example.apiferreteria.services.ProductoCaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pc")
public class ProductoCaracteristicaController {
    @Autowired
    private ProductoCaracteristicaService service;
    @GetMapping
    public ResponseEntity<List<ProductoCaracteristica>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<List<ProductoCaracteristica>> create(@RequestBody ProductoCaracteristicaDto[] dto){
        return new ResponseEntity<>(service.create(dto),HttpStatus.CREATED);
    }
    @GetMapping("/{clave}")
    public ResponseEntity<List<ProductoCaracteristica>> getAllByClave(@PathVariable("clave")String clave){
        return new ResponseEntity<>(service.getAllByClave(clave),HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody ProductoCaracteristicaDto dto){
        service.delete(dto);
    }
}
