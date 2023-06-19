package com.example.ferreteriaa.repositories;

import com.example.ferreteriaa.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,String > {
    @Query("select Producto from Producto where status=1")
    public List<Producto> findAllByStatus();
    @Query("select nombre from Producto where status=1")
    public List<String> findNombresByStatus();
}
