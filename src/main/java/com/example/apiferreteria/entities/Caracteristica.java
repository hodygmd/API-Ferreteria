package com.example.ferreteriaa.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "caracteristica")
public class Caracteristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "id_unidad_medida")
    private UnidadMedida id_unidad_medida;
    @Column(name = "medida")
    private Float medida;
    @Column(name = "status")
    private Byte status;
}
