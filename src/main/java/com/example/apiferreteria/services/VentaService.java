package com.example.apiferreteria.services;

import com.example.apiferreteria.dto.VentaDto;
import com.example.apiferreteria.entities.Venta;
import com.example.apiferreteria.entities.Venta2;
import com.example.apiferreteria.repositories.EmpleadoRepository;
import com.example.apiferreteria.repositories.VentaRepository;
import com.example.apiferreteria.repositories.VentaRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VentaService {
    @Autowired
    private VentaRepository repository;
    @Autowired
    private VentaRepository2 repository2;
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Venta> getAllByStatus(){
        return repository.findAllByStatus();
    }
    public Venta create(VentaDto ventaDto){
        Venta venta=new Venta();
        Venta2 venta2=new Venta2();
        return getVenta(ventaDto,venta,venta2);
    }
    public Venta delete(String folio){
        Venta venta=repository.getReferenceById(folio);
        venta.setStatus((byte)0);
        Venta2 venta2=repository2.getReferenceById(folio);
        venta2.setStatus((byte)0);
        repository2.save(venta2);
        return repository.save(venta);
    }
    private Venta getVenta(VentaDto ventaDto,Venta venta,Venta2 venta2){
        venta2.setFolio(ventaDto.getFolio());
        venta2.setFecha(LocalDateTime.now());
        venta2.setTotal(ventaDto.getTotal());
        venta2.setClave_empleado(empleadoRepository.findById(ventaDto.getClave_empleado()).get());
        venta2.setStatus(ventaDto.getStatus());
        repository2.save(venta2);

        venta.setFolio(ventaDto.getFolio());
        venta.setFecha(LocalDateTime.now());
        venta.setTotal(ventaDto.getTotal());
        venta.setClave_empleado(empleadoRepository.findById(ventaDto.getClave_empleado()).get());
        venta.setStatus(ventaDto.getStatus());
        return repository.save(venta);
    }
}
