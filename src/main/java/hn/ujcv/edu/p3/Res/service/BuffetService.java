package hn.ujcv.edu.p3.Res.service;

import hn.ujcv.edu.p3.Res.entity.Buffet;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;
import hn.ujcv.edu.p3.Res.repository.BuffetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuffetService implements IBuffetService{

    @Autowired
    private BuffetRepository repository;

    @Override
    public Buffet saveBuffet(Buffet buffet) throws BusinessException {
        try{
            return repository.save(buffet);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public List<Buffet> saveBuffet(List<Buffet> buffet) throws BusinessException {
        try{
            return repository.saveAll(buffet);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public List<Buffet> getBuffet() throws BusinessException {
        try{
            return repository.findAll();
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public Buffet getBuffetById(long id) throws BusinessException, NotFoundException {
        Optional<Buffet> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(opt.isPresent()){
            throw new NotFoundException("No se encontró el buffet "+id);
        }
        return opt.get();
    }//

    @Override
    public Buffet getBuffetByMenu(String menu) throws BusinessException, NotFoundException {
        Optional<Buffet> opt = null;
        try{
            opt = repository.findByMenu(menu);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(opt.isPresent()){
            throw new NotFoundException("No se encontró el buffet "+menu);
        }
        return opt.get();
    }//

    @Override
    public void deleteBuffet(long id) throws BusinessException, NotFoundException {
        Optional<Buffet> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el buffet "+id);
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
    public Buffet updateBuffet(Buffet buffet) throws BusinessException, NotFoundException {
        Optional<Buffet> opt = null;
        try{
            opt = repository.findById(buffet.getId());
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el buffet "+buffet.getId());
        }
        else{
            try {
                Buffet existingBuffet = new Buffet();
                existingBuffet.setId(buffet.getId());
                existingBuffet.setMenu(buffet.getMenu());
                existingBuffet.setPrecios(buffet.getPrecios());
                existingBuffet.setLugar(buffet.getLugar());
                existingBuffet.setFecha(buffet.getFecha());
                existingBuffet.setHora(buffet.getHora());
                existingBuffet.setRefrescos(buffet.getRefrescos());
                return repository.save(existingBuffet);
            }catch (Exception e){
                throw new BusinessException(e.getMessage());
            }
        }
    }//
}//
