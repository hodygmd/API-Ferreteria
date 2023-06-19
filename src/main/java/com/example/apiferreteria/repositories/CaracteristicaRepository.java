package com.example.apiferreteria.repositories;

import com.example.apiferreteria.entities.Caracteristica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaracteristicaRepository extends JpaRepository<Caracteristica,Integer> {
    @Query("select c from Caracteristica c where c.status=1")
    public List<Caracteristica> findAllByStatus();
    @Query("select c.descripcion from Caracteristica c where c.status=1")
    public List<String> findNombresByStatus();
}
