package hn.ujcv.edu.p3.Res.service;
import hn.ujcv.edu.p3.Res.entity.Buffet;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;

import java.util.List;

public interface IBuffetService {
    Buffet saveBuffet(Buffet buffet) throws BusinessException;
    List<Buffet> saveBuffet(List<Buffet> buffet) throws BusinessException;
    List<Buffet> getBuffet() throws BusinessException;
    Buffet getBuffetById(long id) throws BusinessException, NotFoundException;
    Buffet getBuffetByMenu(String menu) throws BusinessException, NotFoundException;
    void deleteBuffet(long id) throws BusinessException, NotFoundException;
    Buffet updateBuffet(Buffet buffet) throws BusinessException, NotFoundException;
}//
