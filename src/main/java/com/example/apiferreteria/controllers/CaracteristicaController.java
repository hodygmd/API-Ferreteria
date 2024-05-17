package com.example.apiferreteria.controllers;

import com.example.apiferreteria.dto.CaracteristicaDto;
import com.example.apiferreteria.entities.Caracteristica;
import com.example.apiferreteria.services.CaracteristicaService;
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
@RequestMapping("/caracteristica")
@Tag(name = "Caracteristica", description = "API de caracteristicas")
public class CaracteristicaController {
    @Autowired
    private CaracteristicaService service;
    @Operation(summary = "Obtener todas las caracteristicas por estado")
    @ApiResponse(responseCode = "200", description = "Caracteristicas encontradas")
    @GetMapping
    public ResponseEntity<List<Caracteristica>> getAllByStatus(){
        return new ResponseEntity<>(service.getAllByStatus(), HttpStatus.OK);
    }
    @Operation(summary = "Crear una caracteristica")
    @ApiResponse(responseCode = "201", description = "Caracteristica creada")
    @PostMapping("/create")
    public ResponseEntity<Caracteristica> create(@RequestBody CaracteristicaDto caracteristicaDto){
        return new ResponseEntity<>(service.create(caracteristicaDto),HttpStatus.CREATED);
    }
    @Operation(summary = "Actualizar una caracteristica existente")
    @ApiResponse(responseCode = "200", description = "Caracteristica actualizada")
    @PutMapping("/update/{id}")
    public ResponseEntity<Caracteristica> update(@PathVariable("id")Integer id,@RequestBody CaracteristicaDto caracteristicaDto){
        return new ResponseEntity<>(service.update(id,caracteristicaDto),HttpStatus.OK);
    }
    @Operation(summary = "Eliminar una caracteristica")
    @ApiResponse(responseCode = "200", description = "Caracteristica eliminada")
    @PutMapping("/delete/{id}")
    public ResponseEntity<Caracteristica> delete(@PathVariable("id")Integer id){
        return new ResponseEntity<>(service.delete(id),HttpStatus.OK);
    }
}
