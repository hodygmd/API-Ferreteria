package com.example.apiferreteria.dto;

import lombok.Data;

@Data
public class EmpleadoDto {
    private String clave;
    private String nombre;
    private Byte status;
}
