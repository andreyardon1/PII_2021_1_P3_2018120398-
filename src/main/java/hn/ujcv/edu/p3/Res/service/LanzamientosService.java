package hn.ujcv.edu.p3.Res.service;

import hn.ujcv.edu.p3.Res.entity.Lanzamientos;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;
import hn.ujcv.edu.p3.Res.repository.LanzamientosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LanzamientosService implements ILanzamientosService{

    @Autowired
    private LanzamientosRepository repository;

    @Override
    public Lanzamientos saveLanzamientos(Lanzamientos lanzamientos) throws BusinessException {
        try{
            return repository.save(lanzamientos);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public List<Lanzamientos> saveLanzamientos(List<Lanzamientos> lanzamientos) throws BusinessException {
        try{
            return repository.saveAll(lanzamientos);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public List<Lanzamientos> getLanzamientos() throws BusinessException {
        try{
            return repository.findAll();
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public Lanzamientos getLanzamientosById(long id) throws BusinessException, NotFoundException {
        Optional<Lanzamientos> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(opt.isPresent()){
            throw new NotFoundException("No se encontró el lanzamiento "+id);
        }
        return opt.get();
    }//

    @Override
    public Lanzamientos getLanzamientosByNombre(String nombre) throws BusinessException, NotFoundException {
        Optional<Lanzamientos> opt = null;
        try{
            opt = repository.findByNombre(nombre);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(opt.isPresent()){
            throw new NotFoundException("No se encontró el lanzamiento "+nombre);
        }
        return opt.get();
    }//

    @Override
    public void deleteLanzamientos(long id) throws BusinessException, NotFoundException {
        Optional<Lanzamientos> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el lanzamiento "+id);
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
    public Lanzamientos updateLanzamientos(Lanzamientos lanzamientos) throws BusinessException, NotFoundException {
        Optional<Lanzamientos> opt = null;
        try{
            opt = repository.findById(lanzamientos.getId());
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el lanzamiento "+lanzamientos.getId());
        }
        else{
            try {
                Lanzamientos existingLanzamientos = new Lanzamientos();
                existingLanzamientos.setId(lanzamientos.getId());
                existingLanzamientos.setNombre(lanzamientos.getNombre());
                existingLanzamientos.setProducto(lanzamientos.getProducto());
                existingLanzamientos.setPrecio(lanzamientos.getPrecio());
                existingLanzamientos.setFecha(lanzamientos.getFecha());
                existingLanzamientos.setLugar(lanzamientos.getLugar());
                existingLanzamientos.setHora(lanzamientos.getHora());

                return repository.save(existingLanzamientos);
            }catch (Exception e){
                throw new BusinessException(e.getMessage());
            }
        }
    }//
}//
