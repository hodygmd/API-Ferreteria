package com.example.apiferreteria.repositories;

import com.example.apiferreteria.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,String > {
    @Query("select e from Empleado e where e.username=?1")
    public Empleado findEmpleadoByUsername(String username);
    @Query("select e from Empleado e where e.status=1")
    public List<Empleado> findAllByStatus();
    @Query("select e.nombre from Empleado e where e.status=1")
    public List<String> findNombresByStatus();
}
