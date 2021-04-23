package hn.ujcv.edu.p3.Res.service;

import hn.ujcv.edu.p3.Res.entity.Boletos;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;

import java.util.List;

public interface IBoletoService {
   Boletos saveBoleto(Boletos boleto) throws BusinessException;
   List<Boletos> saveBoletos(List<Boletos> boletos) throws BusinessException;
   List<Boletos> getBoletos() throws BusinessException;
   Boletos getBoletoById(long id) throws BusinessException, NotFoundException;
   Boletos getBoletoByIdDeUsuario(int idDeUsuario) throws BusinessException, NotFoundException;
   void deleteBoleto(long id) throws BusinessException, NotFoundException;
   Boletos updateBoleto(Boletos boleto) throws BusinessException, NotFoundException;
}//
