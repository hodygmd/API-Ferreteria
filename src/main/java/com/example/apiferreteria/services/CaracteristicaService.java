package com.example.apiferreteria.services;

import com.example.apiferreteria.dto.CaracteristicaDto;
import com.example.apiferreteria.entities.Caracteristica;
import com.example.apiferreteria.repositories.CaracteristicaRepository;
import com.example.apiferreteria.repositories.UnidadMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CaracteristicaService {
    @Autowired
    private CaracteristicaRepository repository;
    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;
    public List<Caracteristica> getAllByStatus(){
        return repository.findAllByStatus();
    }
    public Caracteristica create(CaracteristicaDto caracteristicaDto){
        String[] result= repository.findNombresByStatus().toArray(new String[0]);
        for(int i=0;i<result.length;i++){
            if (caracteristicaDto.getDescripcion().equals(result[i])) {
                throw new ResponseStatusException(HttpStatus.FOUND,String.format("Unidad %s already exists",result[i]));
            }
        }
        Caracteristica caracteristica=new Caracteristica();
        return getCategoria(caracteristicaDto,caracteristica);
    }
    public Caracteristica update(Integer id,CaracteristicaDto caracteristicaDto){
        if(repository.findById(id).isPresent()){
            Caracteristica caracteristica=repository.getReferenceById(id);
            return getCategoria(caracteristicaDto,caracteristica);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Unidad %s doesn´t exist",id));
        }
    }
    public Caracteristica delete(Integer id){
        if(repository.findById(id).isPresent()){
            Caracteristica caracteristica=repository.getReferenceById(id);
            caracteristica.setStatus((byte) 0);
            return repository.save(caracteristica);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Unidad %s doesn't exists",id));
        }
    }
    private Caracteristica getCategoria(CaracteristicaDto caracteristicaDto,Caracteristica caracteristica) {
        caracteristica.setDescripcion(caracteristicaDto.getDescripcion());

        caracteristica.setStatus(caracteristicaDto.getStatus());
        return repository.save(caracteristica);
    }
}
