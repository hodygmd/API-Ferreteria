package com.example.apiferreteria.dto;

import lombok.Data;

@Data
public class CaracteristicaDto {
    private String descripcion;
    private Integer id_unidad_medida;
    private Float medida;
    private Byte status;
}
