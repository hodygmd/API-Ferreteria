package com.example.apiferreteria.controllers;

import com.example.apiferreteria.dto.VentaDto;
import com.example.apiferreteria.entities.Venta;
import com.example.apiferreteria.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/venta")
public class VentaController {
    @Autowired
    private VentaService service;
    @PostMapping("/create")
    public ResponseEntity<Venta> create(@RequestBody VentaDto ventaDto){
        return new ResponseEntity<>(service.create(ventaDto), HttpStatus.CREATED);
    }
}
