package com.example.ferreteriaa.repositories;

import com.example.ferreteriaa.entities.Caracteristica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaracteristicaRepository extends JpaRepository<Caracteristica,Integer> {
    @Query("select Caracteristica from Caracteristica where status=1")
    public List<Caracteristica> findAllByStatus();
    @Query("select descripcion from Caracteristica where status=1")
    public List<String> findNombresByStatus();
}
