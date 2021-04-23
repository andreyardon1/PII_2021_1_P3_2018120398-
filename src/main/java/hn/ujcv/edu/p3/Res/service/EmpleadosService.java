package hn.ujcv.edu.p3.Res.service;

import hn.ujcv.edu.p3.Res.entity.Empleados;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;
import hn.ujcv.edu.p3.Res.repository.BuffetRepository;
import hn.ujcv.edu.p3.Res.repository.EmpleadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadosService implements IEmpleadosService{

    @Autowired
    private EmpleadosRepository repository;

    @Override
    public Empleados saveEmpleados(Empleados empleados) throws BusinessException {
        try{
            return repository.save(empleados);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public List<Empleados> saveEmpleados(List<Empleados> empleados) throws BusinessException {
        try{
            return repository.saveAll(empleados);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public List<Empleados> getEmpleados() throws BusinessException {
        try{
            return repository.findAll();
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public Empleados getEmpleadosById(long id) throws BusinessException, NotFoundException {
        Optional<Empleados> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(opt.isPresent()){
            throw new NotFoundException("No se encontró el empleado "+id);
        }
        return opt.get();
    }//

    @Override
    public Empleados getEmpleadosByNombre(String nombre) throws BusinessException, NotFoundException {
        Optional<Empleados> opt = null;
        try{
            opt = repository.findByNombre(nombre);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(opt.isPresent()){
            throw new NotFoundException("No se encontró el empleado "+nombre);
        }
        return opt.get();
    }//

    @Override
    public void deleteEmpleados(long id) throws BusinessException, NotFoundException {
        Optional<Empleados> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el empleado "+id);
        }
        else{
            try {
                repository.deleteById(id);
            }catch (Exception e){
                throw new BusinessException(e.getMessage());
            }
        }
    }//

    @Override
    public Empleados updateEmpleados(Empleados empleados) throws BusinessException, NotFoundException {
        Optional<Empleados> opt = null;
        try{
            opt = repository.findById(empleados.getId());
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el empleado "+empleados.getId());
        }
        else{
            try {
                Empleados existingEmpleados = new Empleados();
                existingEmpleados.setId(empleados.getId());
                existingEmpleados.setNombre(empleados.getNombre());
                existingEmpleados.setEdad(empleados.getEdad());
                existingEmpleados.setDni(empleados.getDni());
                existingEmpleados.setNumeroEmpleado(empleados.getNumeroEmpleado());
                existingEmpleados.setAcronimoDelDepartamento(empleados.getAcronimoDelDepartamento());
                existingEmpleados.setCodigoDeCarga(empleados.getCodigoDeCarga());
                existingEmpleados.setGenero(empleados.getGenero());
                existingEmpleados.setFechaDeRegistro(empleados.getFechaDeRegistro());

                return repository.save(existingEmpleados);
            }catch (Exception e){
                throw new BusinessException(e.getMessage());
            }
        }
    }//
}//
