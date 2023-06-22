package com.example.apiferreteria.repositories;

import com.example.apiferreteria.entities.Venta;
import com.example.apiferreteria.entities.Venta2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository2 extends JpaRepository<Venta2,String> {
    @Query("select v from Venta v where v.status=1")
    public List<Venta> findAllByStatus();
}
