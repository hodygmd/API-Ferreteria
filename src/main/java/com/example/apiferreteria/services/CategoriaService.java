package com.example.ferreteriaa.services;

import com.example.ferreteriaa.dto.CategoriaDto;
import com.example.ferreteriaa.entities.Categoria;
import com.example.ferreteriaa.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;
    public List<Categoria> getAllByStatus(){
        return repository.findAllByStatus();
    }
    public Categoria create(CategoriaDto categoriaDto){
        /*String[] result= repository.findNombresByStatus().toArray(new String[0]);
        for(int i=0;i<result.length;i++){
            if (categoriaDto.getDescripcion().equals(result[i])) {
                throw new ResponseStatusException(HttpStatus.FOUND,String.format("Categoria %s already exists",result[i]));
            }
        }*/
        Categoria categoria=new Categoria();
        return getCategoria(categoriaDto,categoria);
    }
    public Categoria update(Integer id,CategoriaDto categoriaDto){
        if(repository.findById(id).isPresent()){
            Categoria categoria=repository.getReferenceById(id);
            return getCategoria(categoriaDto,categoria);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Categoria %s doesn´t exist",id));
        }
    }
    public Categoria delete(Integer id){
        if(repository.findById(id).isPresent()){
            Categoria categoria=repository.getReferenceById(id);
            categoria.setStatus((byte) 0);
            return repository.save(categoria);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Categoria %s doesn't exists",id));
        }
    }
    private Categoria getCategoria(CategoriaDto categoriaDto, Categoria categoria) {
        categoria.setDescripcion(categoriaDto.getDescripcion());
        categoria.setStatus(categoriaDto.getStatus());
        return repository.save(categoria);
    }
}
