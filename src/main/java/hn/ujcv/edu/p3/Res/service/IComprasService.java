package hn.ujcv.edu.p3.Res.service;
import hn.ujcv.edu.p3.Res.entity.Clientes;
import hn.ujcv.edu.p3.Res.entity.Compras;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;

import java.util.List;

public interface IComprasService {
    Compras saveCompras(Compras clientes) throws BusinessException;
    List<Compras> saveCompras(List<Compras> compras) throws BusinessException;
    List<Compras> getCompras() throws BusinessException;
    Compras getComprasById(long id) throws BusinessException, NotFoundException;
    Compras getComprasByIdDeUsuario(int idDeUsuario) throws BusinessException, NotFoundException;
    void deleteCompras(long id) throws BusinessException, NotFoundException;
    Compras updateCompras(Compras compras) throws BusinessException, NotFoundException;
}//