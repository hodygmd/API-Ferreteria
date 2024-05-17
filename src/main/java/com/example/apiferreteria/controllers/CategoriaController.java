package com.example.apiferreteria.controllers;

import com.example.apiferreteria.dto.CategoriaDto;
import com.example.apiferreteria.entities.Categoria;
import com.example.apiferreteria.services.CategoriaService;
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
@RequestMapping("/categoria")
@Tag(name = "Categoria", description = "API de categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService service;
    @Operation(summary = "Obtener todas las categorias por estado")
    @ApiResponse(responseCode = "200", description = "Categorias encontradas")
    @GetMapping
    public ResponseEntity<List<Categoria>> getAllByStatus(){
        return new ResponseEntity<>(service.getAllByStatus(), HttpStatus.OK);
    }
    @Operation(summary = "Crear una categoria")
    @ApiResponse(responseCode = "201", description = "Categoria creada")
    @PostMapping("/create")
    public ResponseEntity<Categoria> create(@RequestBody CategoriaDto categoriaDto){
        return new ResponseEntity<>(service.create(categoriaDto),HttpStatus.CREATED);
    }
    @Operation(summary = "Actualizar una categoria existente")
    @ApiResponse(responseCode = "200", description = "Categoria actualizada")
    @PutMapping("/update/{id}")
    public ResponseEntity<Categoria> update(@PathVariable("id")Integer id,@RequestBody CategoriaDto categoriaDto){
        return new ResponseEntity<>(service.update(id,categoriaDto),HttpStatus.OK);
    }
    @Operation(summary = "Eliminar una categoria")
    @ApiResponse(responseCode = "200", description = "Categoria eliminada")
    @PutMapping("/delete/{id}")
    public ResponseEntity<Categoria> delete(@PathVariable("id")Integer id){
        return new ResponseEntity<>(service.delete(id),HttpStatus.OK);
    }
}
