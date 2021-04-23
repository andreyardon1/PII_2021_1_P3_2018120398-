package hn.ujcv.edu.p3.Res.service;

import hn.ujcv.edu.p3.Res.entity.CronogramaOAgenda;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;

import java.util.List;

public interface ICronogramaOAgendaService {
    CronogramaOAgenda saveCronogramaOAgenda(CronogramaOAgenda cronogramaOAgenda) throws BusinessException;
    List<CronogramaOAgenda> saveCronogramaOAgenda(List<CronogramaOAgenda> cronogramaOAgenda) throws BusinessException;
    List<CronogramaOAgenda> getCronogramaOAgenda() throws BusinessException;
    CronogramaOAgenda getCronogramaOAgendaById(long id) throws BusinessException, NotFoundException;
    CronogramaOAgenda getCronogramaOAgendaByLugar(String lugar) throws BusinessException, NotFoundException;
    void deleteCronogramaOAgenda(long id) throws BusinessException, NotFoundException;
    CronogramaOAgenda updateCronogramaOAgenda(CronogramaOAgenda cronogramaOAgenda) throws BusinessException, NotFoundException;
}//
