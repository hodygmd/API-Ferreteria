package com.example.ferreteriaa.entities;

import com.example.ferreteriaa.embeddable.ProductoCaracteristicaPk;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@IdClass(ProductoCaracteristicaPk.class)
@Table(name = "producto_caracteristica")
public class ProductoCaracteristica {
    @Id
    @ManyToOne
    @JoinColumn(name = "clave_producto")
    private Producto clave_producto;
    @Id
    @ManyToOne
    @JoinColumn(name = "id_caracteristica")
    private Caracteristica id_caracteristica;
}
