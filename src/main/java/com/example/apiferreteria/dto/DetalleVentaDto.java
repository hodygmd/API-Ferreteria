package com.example.apiferreteria.dto;

import lombok.Data;

@Data
public class DetalleVentaDto {
    private String folio_v;
    private String clave_producto;
    private Integer cantidad;
    private Float precio;
}
