package hn.ujcv.edu.p3.Res.service;
import hn.ujcv.edu.p3.Res.entity.Ventas;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;

import java.util.List;

public interface IVentasService {
    Ventas saveVentas(Ventas ventas) throws BusinessException;
    List<Ventas> saveVentas(List<Ventas> ventas) throws BusinessException;
    List<Ventas> getVentas() throws BusinessException;
    Ventas getVentasById(long id) throws BusinessException, NotFoundException;
    Ventas getVentasByIdCliente(int idCliente) throws BusinessException, NotFoundException;
    void deleteVentas(long id) throws BusinessException, NotFoundException;
    Ventas updateVentas(Ventas ventas) throws BusinessException, NotFoundException;
}//
