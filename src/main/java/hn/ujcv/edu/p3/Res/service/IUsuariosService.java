package hn.ujcv.edu.p3.Res.service;
import hn.ujcv.edu.p3.Res.entity.Usuarios;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;

import java.util.List;

public interface IUsuariosService {
    Usuarios saveUsuarios(Usuarios usuarios) throws BusinessException;
    List<Usuarios> saveUsuarios(List<Usuarios> usuarios) throws BusinessException;
    List<Usuarios> getUsuarios() throws BusinessException;
    Usuarios getUsuariosById(long id) throws BusinessException, NotFoundException;
    Usuarios getUsuariosByNombreDeUsuario(String nombreDeUsuario) throws BusinessException, NotFoundException;
    void deleteUsuarios(long id) throws BusinessException, NotFoundException;
    Usuarios updateUsuarios(Usuarios usuarios) throws BusinessException, NotFoundException;
}//