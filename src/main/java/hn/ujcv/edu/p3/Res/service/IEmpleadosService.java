package hn.ujcv.edu.p3.Res.service;

import hn.ujcv.edu.p3.Res.entity.Empleados;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;

import java.util.List;

public interface IEmpleadosService {
    Empleados saveEmpleados(Empleados empleados) throws BusinessException;
    List<Empleados> saveEmpleados(List<Empleados> empleados) throws BusinessException;
    List<Empleados> getEmpleados() throws BusinessException;
    Empleados getEmpleadosById(long id) throws BusinessException, NotFoundException;
    Empleados getEmpleadosByNombre(String nombre) throws BusinessException, NotFoundException;
    void deleteEmpleados(long id) throws BusinessException, NotFoundException;
    Empleados updateEmpleados(Empleados empleados) throws BusinessException, NotFoundException;
}//
