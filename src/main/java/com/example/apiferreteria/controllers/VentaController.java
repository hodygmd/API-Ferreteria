package com.example.apiferreteria.controllers;

import com.example.apiferreteria.dto.VentaDto;
import com.example.apiferreteria.entities.Venta;
import com.example.apiferreteria.services.VentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/venta")
@Tag(name = "Venta", description = "API de ventas")
public class VentaController {
    @Autowired
    private VentaService service;
    @Operation(summary = "Obtener todas las ventas por estado")
    @ApiResponse(responseCode = "200", description = "Ventas encontradas")
    @GetMapping
    public ResponseEntity<List<Venta>> getAllByStatus(){
        return new ResponseEntity<>(service.getAllByStatus(),HttpStatus.OK);
    }
    @Operation(summary = "Crear una venta")
    @ApiResponse(responseCode = "201", description = "Venta creada")
    @PostMapping("/create")
    public ResponseEntity<Venta> create(@RequestBody VentaDto ventaDto){
        return new ResponseEntity<>(service.create(ventaDto), HttpStatus.CREATED);
    }
    @Operation(summary = "Actualizar una venta existente")
    @ApiResponse(responseCode = "200", description = "Venta actualizada")
    @PutMapping("/delete/{folio}")
    public ResponseEntity<Venta> delete(@PathVariable("folio")String folio){
        return new ResponseEntity<>(service.delete(folio),HttpStatus.OK);
    }
}
