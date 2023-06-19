package com.example.apiferreteria.services;

import com.example.apiferreteria.dto.ProductoCaracteristicaDto;
import com.example.apiferreteria.embeddable.ProductoCaracteristicaPk;
import com.example.apiferreteria.entities.ProductoCaracteristica;
import com.example.apiferreteria.repositories.CaracteristicaRepository;
import com.example.apiferreteria.repositories.ProductoCaracteristicaRepository;
import com.example.apiferreteria.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoCaracteristicaService {
    @Autowired
    private ProductoCaracteristicaRepository repository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CaracteristicaRepository caracteristicaRepository;
    public List<ProductoCaracteristica> getAll(){
        return repository.findAll();
    }
    public List<ProductoCaracteristica> create(ProductoCaracteristicaDto[] dto){
        ProductoCaracteristica pc=new ProductoCaracteristica();
        return getProductoCaracteristica(dto,pc);
    }
    public void delete(ProductoCaracteristicaDto dto){
        ProductoCaracteristicaPk pc=new ProductoCaracteristicaPk();
        pc.setClave_producto(productoRepository.findById(dto.getClave_producto()).get());
        pc.setId_caracteristica(caracteristicaRepository.findById(dto.getId_caracteristica()).get());
        repository.deleteById(pc);
    }
    public List<ProductoCaracteristica> getAllByClave(String clave){
        return repository.findByClave_producto(clave);
    }
    private List<ProductoCaracteristica> getProductoCaracteristica(ProductoCaracteristicaDto[] dto,ProductoCaracteristica pc){
        for(byte i=0;i<dto.length;i++){
            pc.setClave_producto(productoRepository.findById(dto[i].getClave_producto()).get());
            pc.setId_caracteristica(caracteristicaRepository.findById(dto[i].getId_caracteristica()).get());
            repository.save(pc);
        }
        return repository.findByClave_producto(dto[0].getClave_producto());
    }
}
