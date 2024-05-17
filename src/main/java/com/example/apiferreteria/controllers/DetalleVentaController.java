package com.example.apiferreteria.controllers;

import com.example.apiferreteria.dto.DetalleVentaDto;
import com.example.apiferreteria.entities.DetalleVenta;
import com.example.apiferreteria.services.DetalleVentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/dv")
@Tag(name = "Detalle de Venta", description = "API de detalles de venta")
public class DetalleVentaController {
    @Autowired
    private DetalleVentaService service;
    @Operation(summary = "Crear detalles de venta")
    @ApiResponse(responseCode = "201", description = "Detalles de venta creados")
    @PostMapping("/create")
    public ResponseEntity<DetalleVenta[]> create(@RequestBody DetalleVentaDto[] dto){
        return new ResponseEntity<>(service.create(dto),HttpStatus.CREATED);
    }
    @Operation(summary = "Obtener todos los detalles de venta por folio")
    @ApiResponse(responseCode = "200", description = "Detalles de venta encontrados")
    @GetMapping("/{folio}")
    public ResponseEntity<DetalleVenta[]> getAllByFolio(@PathVariable("folio")String folio){
        return new ResponseEntity<>(service.getAllByFolio(folio),HttpStatus.OK);
    }
    @Operation(summary = "Eliminar un detalle de venta")
    @ApiResponse(responseCode = "200", description = "Detalle de venta eliminado")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id")Integer id){
        service.delete(id);
    }
}
