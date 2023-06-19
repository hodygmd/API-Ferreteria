package com.example.ferreteriaa.repositories;

import com.example.ferreteriaa.entities.UnidadMedida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnidadMedidaRepository extends JpaRepository<UnidadMedida,Integer> {
    @Query("select UnidadMedida from UnidadMedida where status=1")
    public List<UnidadMedida> findAllByStatus();
    @Query("select unidad from UnidadMedida where status=1")
    public List<String> findNombresByStatus();
}
