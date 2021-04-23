package hn.ujcv.edu.p3.Res.service;

import hn.ujcv.edu.p3.Res.entity.Eventos;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;
import hn.ujcv.edu.p3.Res.repository.EventosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventosService implements IEventosService{

    @Autowired
    private EventosRepository repository;

    @Override
    public Eventos saveEventos(Eventos eventos) throws BusinessException {
        try{
            return repository.save(eventos);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public List<Eventos> saveEventos(List<Eventos> eventos) throws BusinessException {
        try{
            return repository.saveAll(eventos);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public List<Eventos> getEventos() throws BusinessException {
        try{
            return repository.findAll();
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public Eventos getEventosById(long id) throws BusinessException, NotFoundException {
        Optional<Eventos> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(opt.isPresent()){
            throw new NotFoundException("No se encontró el evento "+id);
        }
        return opt.get();
    }//

    @Override
    public Eventos getEventosByNombreEventos(String nombreEventos) throws BusinessException, NotFoundException {
        Optional<Eventos> opt = null;
        try{
            opt = repository.findByNombreEvento(nombreEventos);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(opt.isPresent()){
            throw new NotFoundException("No se encontró el evento "+nombreEventos);
        }
        return opt.get();
    }//

    @Override
    public void deleteEventos(long id) throws BusinessException, NotFoundException {
        Optional<Eventos> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el evento "+id);
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
    public Eventos updateEventos(Eventos eventos) throws BusinessException, NotFoundException {
        Optional<Eventos> opt = null;
        try{
            opt = repository.findById(eventos.getId());
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el evento "+eventos.getId());
        }
        else{
            try {
                Eventos existingEventos = new Eventos();
                existingEventos.setId(eventos.getId());
                existingEventos.setNombreEvento(eventos.getNombreEvento());
                existingEventos.setCategoria(eventos.getCategoria());
                existingEventos.setValor(eventos.getValor());
                existingEventos.setFecha(eventos.getFecha());
                existingEventos.setLugar(eventos.getLugar());
                existingEventos.setHoraDelEvento(eventos.getHoraDelEvento());

                return repository.save(existingEventos);
            }catch (Exception e){
                throw new BusinessException(e.getMessage());
            }
        }
    }//
}//
