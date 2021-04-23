package hn.ujcv.edu.p3.Res.service;
import hn.ujcv.edu.p3.Res.entity.Patrocinadores;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;

import java.util.List;

public interface IPatrocinadoresService {
    Patrocinadores savePatrocinadores(Patrocinadores patrocinadores) throws BusinessException;
    List<Patrocinadores> savePatrocinadores(List<Patrocinadores> patrocinadores) throws BusinessException;
    List<Patrocinadores> getPatrocinadores() throws BusinessException;
    Patrocinadores getPatrocinadoresById(long id) throws BusinessException, NotFoundException;
    Patrocinadores getPatrocinadoresByNombreDelPatrocinador(String nombreDelPatrocinador) throws BusinessException, NotFoundException;
    void deletePatrocinadores(long id) throws BusinessException, NotFoundException;
    Patrocinadores updatePatrocinadores(Patrocinadores patrocinadores) throws BusinessException, NotFoundException;
}//
