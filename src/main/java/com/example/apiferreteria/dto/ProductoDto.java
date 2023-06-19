package com.example.ferreteriaa.dto;

import lombok.Data;

@Data
public class ProductoDto {
    private String clave;
    private String nombre;
    private Float precio;
    private String descripcion;
    private Integer stock_max;
    private Integer stock_min;
    private Integer existencias;
    private Integer id_categoria;
    private Integer id_marca;
    private Byte status;
}
