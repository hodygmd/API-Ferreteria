package com.example.ferreteriaa.repositories;

import com.example.ferreteriaa.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarcaRepository extends JpaRepository<Marca,Integer> {
    @Query("select Marca from Marca where status=1")
    public List<Marca> findAllByStatus();
    @Query("select nombre from Marca where status=1")
    public List<String> findNombresByStatus();
}