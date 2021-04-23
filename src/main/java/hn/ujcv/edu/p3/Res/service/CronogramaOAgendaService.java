package hn.ujcv.edu.p3.Res.service;

import hn.ujcv.edu.p3.Res.entity.CronogramaOAgenda;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;
import hn.ujcv.edu.p3.Res.repository.CronogramaOAgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CronogramaOAgendaService implements ICronogramaOAgendaService{

    @Autowired
    private CronogramaOAgendaRepository repository;

    @Override
    public CronogramaOAgenda saveCronogramaOAgenda(CronogramaOAgenda cronogramaOAgenda) throws BusinessException {
        try{
            return repository.save(cronogramaOAgenda);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public List<CronogramaOAgenda> saveCronogramaOAgenda(List<CronogramaOAgenda> cronogramaOAgenda) throws BusinessException {
        try{
            return repository.saveAll(cronogramaOAgenda);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public List<CronogramaOAgenda> getCronogramaOAgenda() throws BusinessException {
        try{
            return repository.findAll();
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public CronogramaOAgenda getCronogramaOAgendaById(long id) throws BusinessException, NotFoundException {
        Optional<CronogramaOAgenda> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(opt.isPresent()){
            throw new NotFoundException("No se encontró el cronograma o agenda "+id);
        }
        return opt.get();
    }//

    @Override
    public CronogramaOAgenda getCronogramaOAgendaByLugar(String lugar) throws BusinessException, NotFoundException {
        Optional<CronogramaOAgenda> opt = null;
        try{
            opt = repository.findByLugar(lugar);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(opt.isPresent()){
            throw new NotFoundException("No se encontró el cronograma o agenda "+lugar);
        }
        return opt.get();
    }//

    @Override
    public void deleteCronogramaOAgenda(long id) throws BusinessException, NotFoundException {
        Optional<CronogramaOAgenda> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el cronograma  o agenda "+id);
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
    public CronogramaOAgenda updateCronogramaOAgenda(CronogramaOAgenda cronogramaOAgenda) throws BusinessException, NotFoundException {
        Optional<CronogramaOAgenda> opt = null;
        try{
            opt = repository.findById(cronogramaOAgenda.getId());
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el cronograma o agenda "+cronogramaOAgenda.getId());
        }
        else{
            try {
                CronogramaOAgenda existingCronogramaOAgenda = new CronogramaOAgenda();
                existingCronogramaOAgenda.setId(cronogramaOAgenda.getId());
                existingCronogramaOAgenda.setLugar(cronogramaOAgenda.getLugar());
                existingCronogramaOAgenda.setFecha(cronogramaOAgenda.getFecha());
                existingCronogramaOAgenda.setCitas(cronogramaOAgenda.getCitas());
                existingCronogramaOAgenda.setProveedores(cronogramaOAgenda.getProveedores());
                existingCronogramaOAgenda.setPagos(cronogramaOAgenda.getPagos());
                existingCronogramaOAgenda.setReuniones(cronogramaOAgenda.getReuniones());
                existingCronogramaOAgenda.setOcupaciones(cronogramaOAgenda.getOcupaciones());
                existingCronogramaOAgenda.setAsignaciones(cronogramaOAgenda.getAsignaciones());

                return repository.save(existingCronogramaOAgenda);
            }catch (Exception e){
                throw new BusinessException(e.getMessage());
            }
        }
    }//
}//
