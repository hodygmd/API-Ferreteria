package com.example.ferreteriaa.services;

import com.example.ferreteriaa.entities.ProductoCaracteristica;
import com.example.ferreteriaa.repositories.ProductoCaracteristicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoCaracteristicaService {
    @Autowired
    private ProductoCaracteristicaRepository repository;
    public List<ProductoCaracteristica> getAll(){
        return repository.findAll();
    }
}
