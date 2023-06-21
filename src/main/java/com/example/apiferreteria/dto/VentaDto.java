package com.example.apiferreteria.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VentaDto {
    private String folio;
    //private LocalDateTime fecha;
    private Float total;
    private String clave_empleado;
    private Byte status;
}
