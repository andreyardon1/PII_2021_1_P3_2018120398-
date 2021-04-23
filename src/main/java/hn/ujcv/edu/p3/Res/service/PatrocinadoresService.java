package hn.ujcv.edu.p3.Res.service;

import hn.ujcv.edu.p3.Res.entity.Patrocinadores;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;
import hn.ujcv.edu.p3.Res.repository.PatrocinadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatrocinadoresService implements IPatrocinadoresService{

    @Autowired
    private PatrocinadoresRepository repository;

    @Override
    public Patrocinadores savePatrocinadores(Patrocinadores patrocinadores) throws BusinessException {
        try{
            return repository.save(patrocinadores);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public List<Patrocinadores> savePatrocinadores(List<Patrocinadores> patrocinadores) throws BusinessException {
        try{
            return repository.saveAll(patrocinadores);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public List<Patrocinadores> getPatrocinadores() throws BusinessException {
        try{
            return repository.findAll();
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public Patrocinadores getPatrocinadoresById(long id) throws BusinessException, NotFoundException {
        Optional<Patrocinadores> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(opt.isPresent()){
            throw new NotFoundException("No se encontró el patrocinador "+id);
        }
        return opt.get();
    }//

    @Override
    public Patrocinadores getPatrocinadoresByNombreDelPatrocinador(String nombreDelPatrocinador) throws BusinessException, NotFoundException {
        Optional<Patrocinadores> opt = null;
        try{
            opt = repository.findByNombreDelPatrocinador(nombreDelPatrocinador);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(opt.isPresent()){
            throw new NotFoundException("No se encontró el patrocinador "+nombreDelPatrocinador);
        }
        return opt.get();
    }//

    @Override
    public void deletePatrocinadores(long id) throws BusinessException, NotFoundException {
        Optional<Patrocinadores> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el patrocinador "+id);
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
    public Patrocinadores updatePatrocinadores(Patrocinadores patrocinadores) throws BusinessException, NotFoundException {
        Optional<Patrocinadores> opt = null;
        try{
            opt = repository.findById(patrocinadores.getId());
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el patrocinador "+patrocinadores.getId());
        }
        else{
            try {
                Patrocinadores existingPatrocinadores = new Patrocinadores();
                existingPatrocinadores.setId(patrocinadores.getId());
                existingPatrocinadores.setNombreDelPatrocinador(patrocinadores.getNombreDelPatrocinador());
                existingPatrocinadores.setDireccion(patrocinadores.getDireccion());
                existingPatrocinadores.setCorreoElectronico(patrocinadores.getCorreoElectronico());
                existingPatrocinadores.setPrecio(patrocinadores.getPrecio());
                existingPatrocinadores.setActividad(patrocinadores.getActividad());
                existingPatrocinadores.setLugarOSede(patrocinadores.getLugarOSede());

                return repository.save(existingPatrocinadores);
            }catch (Exception e){
                throw new BusinessException(e.getMessage());
            }
        }
    }//
}//
