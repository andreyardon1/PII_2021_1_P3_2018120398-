package hn.ujcv.edu.p3.Res.service;

import hn.ujcv.edu.p3.Res.entity.RentaDeEquipo;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;

import java.util.List;

public interface IRentaDeEquipoService {
    RentaDeEquipo saveRentaDeEquipo(RentaDeEquipo rentaDeEquipo) throws BusinessException;
    List<RentaDeEquipo> saveRentaDeEquipo(List<RentaDeEquipo> rentaDeEquipos) throws BusinessException;
    List<RentaDeEquipo> getRentaDeEquipo() throws BusinessException;
    RentaDeEquipo getRentaDeEquipoById(long id) throws BusinessException, NotFoundException;
    RentaDeEquipo getRentaDeEquipoByIdDelPropietarioDelEquipo(int idDelPropietarioDelEquipo) throws BusinessException, NotFoundException;
    void deleteRentaDeEquipo(long id) throws BusinessException, NotFoundException;
    RentaDeEquipo updateRentaDeEquipo(RentaDeEquipo rentaDeEquipo) throws BusinessException, NotFoundException;
}//
