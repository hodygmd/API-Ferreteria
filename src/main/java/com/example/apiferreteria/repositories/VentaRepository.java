package com.example.apiferreteria.repositories;

import com.example.apiferreteria.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta,String> {
    @Query("select v from Venta v where v.status=1")
    public List<Venta> findAllByStatus();
}
