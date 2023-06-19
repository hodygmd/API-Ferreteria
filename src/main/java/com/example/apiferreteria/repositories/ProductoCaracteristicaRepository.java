package com.example.apiferreteria.repositories;

import com.example.apiferreteria.embeddable.ProductoCaracteristicaPk;
import com.example.apiferreteria.entities.ProductoCaracteristica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoCaracteristicaRepository extends JpaRepository<ProductoCaracteristica, ProductoCaracteristicaPk> {
    @Query("select pc from ProductoCaracteristica pc where pc.clave_producto.clave=?1")
    public List<ProductoCaracteristica> findByClave_producto(String clave);
}
