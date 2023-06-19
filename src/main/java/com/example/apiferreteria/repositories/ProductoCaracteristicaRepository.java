package com.example.ferreteriaa.repositories;

import com.example.ferreteriaa.embeddable.ProductoCaracteristicaPk;
import com.example.ferreteriaa.entities.ProductoCaracteristica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoCaracteristicaRepository extends JpaRepository<ProductoCaracteristica, ProductoCaracteristicaPk> {
}
