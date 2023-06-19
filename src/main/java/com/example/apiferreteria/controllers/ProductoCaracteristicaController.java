package com.example.ferreteriaa.controllers;

import com.example.ferreteriaa.entities.ProductoCaracteristica;
import com.example.ferreteriaa.services.ProductoCaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
