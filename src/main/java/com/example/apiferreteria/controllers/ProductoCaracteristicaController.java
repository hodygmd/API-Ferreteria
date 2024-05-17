package com.example.apiferreteria.controllers;

import com.example.apiferreteria.dto.ProductoCaracteristicaDto;
import com.example.apiferreteria.entities.Producto;
import com.example.apiferreteria.entities.ProductoCaracteristica;
import com.example.apiferreteria.services.ProductoCaracteristicaService;
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
@RequestMapping("/pc")
@Tag(name = "Producto-Caracteristica", description = "API de caracteristicas de productos")
public class ProductoCaracteristicaController {
    @Autowired
    private ProductoCaracteristicaService service;
    @Operation(summary = "Obtener todas las caracteristicas de productos")
    @ApiResponse(responseCode = "200", description = "Caracteristicas de productos encontradas")
    @GetMapping
    public ResponseEntity<List<ProductoCaracteristica>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @Operation(summary = "Crear una caracteristica de producto")
    @ApiResponse(responseCode = "201", description = "Caracteristica de producto creada")
    @PostMapping("/create")
    public ResponseEntity<ProductoCaracteristica[]> create(@RequestBody ProductoCaracteristicaDto[] dto){
        return new ResponseEntity<>(service.create(dto),HttpStatus.CREATED);
    }
    @Operation(summary = "Actualizar una caracteristica de producto existente")
    @ApiResponse(responseCode = "200", description = "Caracteristica de producto actualizada")
    @GetMapping("/{clave}")
    public ResponseEntity<ProductoCaracteristica[]> getAllByClave(@PathVariable("clave")String clave){
        return new ResponseEntity<>(service.getAllByClave(clave),HttpStatus.OK);
    }
    @Operation(summary = "Eliminar una caracteristica de producto")
    @ApiResponse(responseCode = "200", description = "Caracteristica de producto eliminada")
    @PostMapping("/delete")
    public void delete(@RequestBody ProductoCaracteristicaDto dto){
        service.delete(dto);
    }
}
