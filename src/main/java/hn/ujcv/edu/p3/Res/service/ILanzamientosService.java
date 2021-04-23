package hn.ujcv.edu.p3.Res.service;
import hn.ujcv.edu.p3.Res.entity.Lanzamientos;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;

import java.util.List;

public interface ILanzamientosService {
    Lanzamientos saveLanzamientos(Lanzamientos lanzamientos) throws BusinessException;
    List<Lanzamientos> saveLanzamientos(List<Lanzamientos> lanzamientos) throws BusinessException;
    List<Lanzamientos> getLanzamientos() throws BusinessException;
    Lanzamientos getLanzamientosById(long id) throws BusinessException, NotFoundException;
    Lanzamientos getLanzamientosByNombre(String nombre) throws BusinessException, NotFoundException;
    void deleteLanzamientos(long id) throws BusinessException, NotFoundException;
    Lanzamientos updateLanzamientos(Lanzamientos lanzamientos) throws BusinessException, NotFoundException;
}//
