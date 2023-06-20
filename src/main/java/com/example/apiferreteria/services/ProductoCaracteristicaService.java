package com.example.apiferreteria.services;

import com.example.apiferreteria.dto.ProductoCaracteristicaDto;
import com.example.apiferreteria.embeddable.ProductoCaracteristicaPk;
import com.example.apiferreteria.entities.Producto;
import com.example.apiferreteria.entities.ProductoCaracteristica;
import com.example.apiferreteria.repositories.CaracteristicaRepository;
import com.example.apiferreteria.repositories.ProductoCaracteristicaRepository;
import com.example.apiferreteria.repositories.ProductoRepository;
import com.example.apiferreteria.repositories.UnidadMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoCaracteristicaService {
    @Autowired
    private ProductoCaracteristicaRepository repository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CaracteristicaRepository caracteristicaRepository;
    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;


    public List<ProductoCaracteristica> getAll() {
        return repository.findAll();
    }

    public ProductoCaracteristica[] create(ProductoCaracteristicaDto[] dto) {
        ProductoCaracteristica pc = new ProductoCaracteristica();
        /*Producto producto=productoRepository.getReferenceById(dto[0].getClave_producto());
        producto.setStatus((byte) 2);
        productoRepository.save(producto);*/
        return getProductoCaracteristica(dto, pc);
    }

    public void delete(ProductoCaracteristicaDto dto) {
        ProductoCaracteristicaPk pc = new ProductoCaracteristicaPk();
        pc.setClave_producto(productoRepository.findById(dto.getClave_producto()).get());
        pc.setId_caracteristica(caracteristicaRepository.findById(dto.getId_caracteristica()).get());
        repository.deleteById(pc);
    }

    public ProductoCaracteristica[] getAllByClave(String clave) {
        return repository.findByClave_producto(clave);
    }

    private ProductoCaracteristica[] getProductoCaracteristica(ProductoCaracteristicaDto[] dto, ProductoCaracteristica pc) {
        /*for (byte i = 0; i < dto.length; i++) {
            ProductoCaracteristica[] prod = repository.findByClave_producto(dto[0].getClave_producto());

            if(Arrays.stream(prod).findAny().isEmpty()){
                pc.setClave_producto(productoRepository.findById(dto[i].getClave_producto()).get());
                pc.setId_caracteristica(caracteristicaRepository.findById(dto[i].getId_caracteristica()).get());
                pc.setId_unidad_medida(unidadMedidaRepository.findById(dto[i].getId_unidad_medida()).get());
                pc.setMedida(dto[i].getMedida());
            }else {
                if(dto[i].getClave_producto().equals(prod[i].getClave_producto())){
                }else{
                    pc.setClave_producto(productoRepository.findById(dto[i].getClave_producto()).get());
                    pc.setId_caracteristica(caracteristicaRepository.findById(dto[i].getId_caracteristica()).get());
                    pc.setId_unidad_medida(unidadMedidaRepository.findById(dto[i].getId_unidad_medida()).get());
                    pc.setMedida(dto[i].getMedida());
                }
            }

            pc.setClave_producto(productoRepository.findById(dto[i].getClave_producto()).get());
            pc.setId_caracteristica(caracteristicaRepository.findById(dto[i].getId_caracteristica()).get());
            pc.setId_unidad_medida(unidadMedidaRepository.findById(dto[i].getId_unidad_medida()).get());
            pc.setMedida(dto[i].getMedida());
            repository.save(pc);
        }*/
        ProductoCaracteristica[] prod = repository.findByClave_producto(dto[0].getClave_producto());
        if (Arrays.stream(prod).findAny().isEmpty()) {
            for (byte i = 0; i < dto.length; i++) {
                pc.setClave_producto(productoRepository.findById(dto[i].getClave_producto()).get());
                pc.setId_caracteristica(caracteristicaRepository.findById(dto[i].getId_caracteristica()).get());
                pc.setId_unidad_medida(unidadMedidaRepository.findById(dto[i].getId_unidad_medida()).get());
                pc.setMedida(dto[i].getMedida());
                repository.save(pc);
            }
        } else {
            for (byte i = 0; i < dto.length; i++) {
                if (dto[i].getClave_producto().equals(prod[i].getClave_producto())) {
                } else {
                    pc.setClave_producto(productoRepository.findById(dto[i].getClave_producto()).get());
                    pc.setId_caracteristica(caracteristicaRepository.findById(dto[i].getId_caracteristica()).get());
                    pc.setId_unidad_medida(unidadMedidaRepository.findById(dto[i].getId_unidad_medida()).get());
                    pc.setMedida(dto[i].getMedida());
                }
                repository.save(pc);
            }
        }
        return repository.findByClave_producto(dto[0].getClave_producto());
    }
}
