package com.example.ferreteriaa.services;

import com.example.ferreteriaa.dto.MarcaDto;
import com.example.ferreteriaa.entities.Marca;
import com.example.ferreteriaa.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository repository;
    public List<Marca> getAllByStatus(){
        return repository.findAllByStatus();
    }
    public Marca create(MarcaDto marcaDto){
        String[] result=repository.findNombresByStatus().toArray(new String[0]);
        for(int i=0;i<result.length;i++){
            if (marcaDto.getNombre().equals(result[i])) {
                throw new ResponseStatusException(HttpStatus.FOUND,String.format("Marca %s already exists",result[i]));
            }
        }
        Marca marca=new Marca();
        return getMarca(marcaDto,marca);
    }
    public Marca update(Integer id,MarcaDto marcaDto){
        if(repository.findById(id).isPresent()){
            Marca marca=repository.getReferenceById(id);
            return getMarca(marcaDto,marca);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Marca %s doesn´t exist",id));
        }
    }
    public Marca delete(Integer id){
        if(repository.findById(id).isPresent()){
            Marca marca=repository.getReferenceById(id);
            marca.setStatus((byte) 0);
            return repository.save(marca);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Marca %s doesn't exists",id));
        }
    }
    private Marca getMarca(MarcaDto marcaDto, Marca marca){
        marca.setNombre(marcaDto.getNombre());
        marca.setStatus(marcaDto.getStatus());
        return repository.save(marca);
    }
}
