package com.example.ferreteriaa.embeddable;

import com.example.ferreteriaa.entities.Caracteristica;
import com.example.ferreteriaa.entities.Producto;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
@Embeddable
public class ProductoCaracteristicaPk implements Serializable {
    @ManyToOne
    @JoinColumn(name = "clave_producto")
    private Producto clave_producto;

    @ManyToOne
    @JoinColumn(name = "id_caracteristica")
    private Caracteristica id_caracteristica;
}
