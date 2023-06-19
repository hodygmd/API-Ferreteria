package com.example.apiferreteria.embeddable;

import com.example.apiferreteria.entities.Caracteristica;
import com.example.apiferreteria.entities.Producto;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Embeddable
public class ProductoCaracteristicaPk implements Serializable {
    @ManyToOne
    @JoinColumn(name = "clave_producto")
    private Producto clave_producto;

    @ManyToOne
    @JoinColumn(name = "id_caracteristica")
    private Caracteristica id_caracteristica;
}
