package com.example.apiferreteria.services;

import com.example.apiferreteria.dto.EmpleadoDto;
import com.example.apiferreteria.entities.Empleado;
import com.example.apiferreteria.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository repository;
    public List<Empleado> getAllByStatus(){
        return repository.findAllByStatus();
    }
    public Empleado create(EmpleadoDto empleadoDto){
        String[] result= repository.findNombresByStatus().toArray(new String[0]);
        for(int i=0;i<result.length;i++){
            if (empleadoDto.getNombre().equals(result[i])) {
                throw new ResponseStatusException(HttpStatus.FOUND,String.format("Empleado %s already exists",result[i]));
            }
        }
        Empleado empleado=new Empleado();
        return getEmpleado(empleadoDto,empleado);
    }
    public Empleado update(String clave,EmpleadoDto empleadoDto){
        if(repository.findById(clave).isPresent()){
            Empleado empleado=repository.getReferenceById(clave);
            return getEmpleado(empleadoDto,empleado);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Empleado %s doesn´t exist",clave));
        }
    }
    public Empleado delete(String clave){
        if(repository.findById(clave).isPresent()){
            Empleado empleado=repository.getReferenceById(clave);
            empleado.setStatus((byte) 0);
            return repository.save(empleado);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Empleado %s doesn't exists",clave));
        }
    }
    private Empleado getEmpleado(EmpleadoDto empleadoDto,Empleado empleado) {
        empleado.setClave(empleadoDto.getClave());
        empleado.setNombre(empleadoDto.getNombre());
        empleado.setStatus(empleadoDto.getStatus());
        return repository.save(empleado);
    }
}
