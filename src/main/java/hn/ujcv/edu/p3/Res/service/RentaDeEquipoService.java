package hn.ujcv.edu.p3.Res.service;

import hn.ujcv.edu.p3.Res.entity.RentaDeEquipo;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;
import hn.ujcv.edu.p3.Res.repository.RentaDeEquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RentaDeEquipoService implements IRentaDeEquipoService{

    @Autowired
    private RentaDeEquipoRepository repository;

    @Override
    public RentaDeEquipo saveRentaDeEquipo(RentaDeEquipo rentaDeEquipo) throws BusinessException {
        try{
            return repository.save(rentaDeEquipo);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public List<RentaDeEquipo> saveRentaDeEquipo(List<RentaDeEquipo> rentaDeEquipo) throws BusinessException {
        try{
            return repository.saveAll(rentaDeEquipo);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public List<RentaDeEquipo> getRentaDeEquipo() throws BusinessException {
        try{
            return repository.findAll();
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public RentaDeEquipo getRentaDeEquipoById(long id) throws BusinessException, NotFoundException {
        Optional<RentaDeEquipo> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(opt.isPresent()){
            throw new NotFoundException("No se encontró el renta de equipo "+id);
        }
        return opt.get();
    }//

    @Override
    public RentaDeEquipo getRentaDeEquipoByIdDelPropietarioDelEquipo(int idDelPropietarioDelEquipo) throws BusinessException, NotFoundException {
        Optional<RentaDeEquipo> opt = null;
        try{
            opt = repository.findByIdDelPropietarioDelEquipo(idDelPropietarioDelEquipo);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(opt.isPresent()){
            throw new NotFoundException("No se encontró el renta de equipo "+idDelPropietarioDelEquipo);
        }
        return opt.get();
    }//

    @Override
    public void deleteRentaDeEquipo(long id) throws BusinessException, NotFoundException {
        Optional<RentaDeEquipo> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el renta de equipo "+id);
        }
        else{
            try {
                repository.deleteById(id);
            }catch (Exception e){
                throw new BusinessException(e.getMessage());
            }
        }
    }//

    @Override
    public RentaDeEquipo updateRentaDeEquipo(RentaDeEquipo rentaDeEquipo) throws BusinessException, NotFoundException {
        Optional<RentaDeEquipo> opt = null;
        try{
            opt = repository.findById(rentaDeEquipo.getId());
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el renta de equipo "+rentaDeEquipo.getId());
        }
        else{
            try {
                RentaDeEquipo existingRentaDeEquipo = new RentaDeEquipo();
                existingRentaDeEquipo.setId(rentaDeEquipo.getId());
                existingRentaDeEquipo.setIdDelPropietarioDelEquipo(rentaDeEquipo.getIdDelPropietarioDelEquipo());
                existingRentaDeEquipo.setNombreDelEquipo(rentaDeEquipo.getNombreDelEquipo());
                existingRentaDeEquipo.setTipoDeEquipo(rentaDeEquipo.getTipoDeEquipo());
                existingRentaDeEquipo.setFechaDeAlquiler(rentaDeEquipo.getFechaDeAlquiler());
                existingRentaDeEquipo.setContrato(rentaDeEquipo.getContrato());
                existingRentaDeEquipo.setDireccion(rentaDeEquipo.getDireccion());
                existingRentaDeEquipo.setCondicionDeEquipo(rentaDeEquipo.getCondicionDeEquipo());

                return repository.save(rentaDeEquipo);
            }catch (Exception e){
                throw new BusinessException(e.getMessage());
            }
        }
    }//
}//
