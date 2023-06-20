package com.example.apiferreteria.dto;

import lombok.Data;

@Data
public class ProductoCaracteristicaDto {
    private String clave_producto;
    private Integer id_caracteristica;
    private Integer id_unidad_medida;
    private Float medida;
}
