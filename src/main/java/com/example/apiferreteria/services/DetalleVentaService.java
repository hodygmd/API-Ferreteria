package com.example.apiferreteria.services;

import com.example.apiferreteria.dto.DetalleVentaDto;
import com.example.apiferreteria.entities.DetalleVenta;
import com.example.apiferreteria.entities.Venta;
import com.example.apiferreteria.repositories.DetalleVentaRepository;
import com.example.apiferreteria.repositories.ProductoRepository;
import com.example.apiferreteria.repositories.VentaRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleVentaService {
    @Autowired
    private DetalleVentaRepository repository;
    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private ProductoRepository productoRepository;
    private Float t;
    public DetalleVenta[] create(DetalleVentaDto[] detalleVentaDtos){
        return getDv(detalleVentaDtos);
    }
    public DetalleVenta[] getAllByFolio(String folio){
        return repository.findByFolio_v(folio);
    }
    public void delete(Integer id){
        Venta venta=ventaRepository.getReferenceById(repository.findById(id).get().getFolio_v().getFolio());
        DetalleVenta detalleVenta=repository.getReferenceById(id);
        t= venta.getTotal();
        t-=(detalleVenta.getPrecio()*detalleVenta.getCantidad());
        venta.setTotal(t);
        ventaRepository.save(venta);
        repository.deleteById(id);
    }

    private DetalleVenta[] getDv(DetalleVentaDto[] dto){
        Venta venta=ventaRepository.getReferenceById(dto[0].getFolio_v());
        t=venta.getTotal();
        for(byte i=0;i<dto.length;i++){
            DetalleVenta detalleVenta=new DetalleVenta();
            detalleVenta.setFolio_v((Venta) Hibernate.unproxy(venta));
            detalleVenta.setClave_producto(productoRepository.findById(dto[i].getClave_producto()).get());
            detalleVenta.setCantidad(dto[i].getCantidad());
            detalleVenta.setPrecio(dto[i].getPrecio());
            repository.save(detalleVenta);
            t+=(detalleVenta.getCantidad() * detalleVenta.getPrecio());
            venta.setTotal(t);
            ventaRepository.save(venta);
        }
        return repository.findByFolio_v(dto[0].getFolio_v());
    }
}
