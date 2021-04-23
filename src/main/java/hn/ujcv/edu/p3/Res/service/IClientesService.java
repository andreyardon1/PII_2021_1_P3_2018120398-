package hn.ujcv.edu.p3.Res.service;
import hn.ujcv.edu.p3.Res.entity.Clientes;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;

import java.util.List;

public interface IClientesService {
    Clientes saveClientes(Clientes clientes) throws BusinessException;
    List<Clientes> saveClientes(List<Clientes> clientes) throws BusinessException;
    List<Clientes> getClientes() throws BusinessException;
    Clientes getClientesById(long id) throws BusinessException, NotFoundException;
    Clientes getClientesBynombrecompleto(String nombrecompleto) throws BusinessException, NotFoundException;
    void deleteClientes(long id) throws BusinessException, NotFoundException;
    Clientes updateClientes(Clientes clientes) throws BusinessException, NotFoundException;
}//