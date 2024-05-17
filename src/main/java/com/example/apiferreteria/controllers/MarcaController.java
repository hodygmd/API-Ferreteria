package com.example.apiferreteria.controllers;

import com.example.apiferreteria.dto.MarcaDto;
import com.example.apiferreteria.entities.Marca;
import com.example.apiferreteria.services.MarcaService;
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
@RequestMapping("/marca")
@Tag(name = "Marca", description = "API de marcas")
public class MarcaController {
    @Autowired
    private MarcaService service;
    @Operation(summary = "Obtener todas las marcas por estado")
    @ApiResponse(responseCode = "200", description = "Marcas encontradas")
    @GetMapping
    public ResponseEntity<List<Marca>> getAllByStatus(){
        return new ResponseEntity<>(service.getAllByStatus(), HttpStatus.OK);
    }
    @Operation(summary = "Crear una marca")
    @ApiResponse(responseCode = "201", description = "Marca creada")
    @PostMapping("/create")
    public ResponseEntity<Marca> create(@RequestBody MarcaDto marcaDto){
        return new ResponseEntity<>(service.create(marcaDto),HttpStatus.CREATED);
    }
    @Operation(summary = "Actualizar una marca existente")
    @ApiResponse(responseCode = "200", description = "Marca actualizada")
    @PutMapping("/update/{id}")
    public ResponseEntity<Marca> update(@PathVariable("id")Integer id,@RequestBody MarcaDto marcaDto){
        return new ResponseEntity<>(service.update(id,marcaDto),HttpStatus.OK);
    }
    @Operation(summary = "Eliminar una marca")
    @ApiResponse(responseCode = "200", description = "Marca eliminada")
    @PutMapping("/delete/{id}")
    public ResponseEntity<Marca> delete(@PathVariable("id")Integer id){
        return new ResponseEntity<>(service.delete(id),HttpStatus.OK);
    }
}
