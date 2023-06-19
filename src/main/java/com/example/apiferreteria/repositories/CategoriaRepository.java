package com.example.ferreteriaa.repositories;

import com.example.ferreteriaa.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
    @Query("select Categoria from Categoria where status=1")
    public List<Categoria> findAllByStatus();
    @Query("select descripcion from Categoria where status=1")
    public List<String> findNombresByStatus();
}
