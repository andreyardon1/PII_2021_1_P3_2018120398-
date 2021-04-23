package hn.ujcv.edu.p3.Res.service;

import hn.ujcv.edu.p3.Res.entity.Eventos;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;

import java.util.List;

public interface IEventosService {
    Eventos saveEventos(Eventos eventos) throws BusinessException;
    List<Eventos> saveEventos(List<Eventos> eventos) throws BusinessException;
    List<Eventos> getEventos() throws BusinessException;
    Eventos getEventosById(long id) throws BusinessException, NotFoundException;
    Eventos getEventosByNombreEventos(String nombreEventos) throws BusinessException, NotFoundException;
    void deleteEventos(long id) throws BusinessException, NotFoundException;
    Eventos updateEventos(Eventos eventos) throws BusinessException, NotFoundException;
}//
