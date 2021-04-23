package hn.ujcv.edu.p3.Res.service;

import hn.ujcv.edu.p3.Res.entity.Ventas;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;
import hn.ujcv.edu.p3.Res.repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VentasService implements IVentasService{

    @Autowired
    private VentasRepository repository;

    @Override
    public Ventas saveVentas(Ventas ventas) throws BusinessException {
        try{
            return repository.save(ventas);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public List<Ventas> saveVentas(List<Ventas> ventas) throws BusinessException {
        try{
            return repository.saveAll(ventas);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public List<Ventas> getVentas() throws BusinessException {
        try{
            return repository.findAll();
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public Ventas getVentasById(long id) throws BusinessException, NotFoundException {
        Optional<Ventas> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(opt.isPresent()){
            throw new NotFoundException("No se encontró la venta "+id);
        }
        return opt.get();
    }//

    @Override
    public Ventas getVentasByIdCliente(int idCliente)throws BusinessException, NotFoundException {
        Optional<Ventas> opt = null;
        try{
            opt = repository.findByIdCliente(idCliente);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(opt.isPresent()){
            throw new NotFoundException("No se encontró la venta "+idCliente);
        }
        return opt.get();
    }//

    @Override
    public void deleteVentas(long id) throws BusinessException, NotFoundException {
        Optional<Ventas> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(!opt.isPresent()){
            throw new NotFoundException("No se encontró la ventas "+id);
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
    public Ventas updateVentas(Ventas ventas) throws BusinessException, NotFoundException {
        Optional<Ventas> opt = null;
        try{
            opt = repository.findById(ventas.getId());
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(!opt.isPresent()){
            throw new NotFoundException("No se encontró la venta "+ventas.getId());
        }
        else{
            try {
                Ventas existingVentas = new Ventas();
                existingVentas.setId(ventas.getId());
                existingVentas.setIdCliente(ventas.getIdCliente());
                existingVentas.setNombreDeEmpresa(ventas.getNombreDeEmpresa());
                existingVentas.setFechaDeVenta(ventas.getFechaDeVenta());
                existingVentas.setTipoDeVenta(ventas.getTipoDeVenta());
                existingVentas.setObservaciones(ventas.getObservaciones());
                existingVentas.setCondicion(ventas.getCondicion());

                return repository.save(existingVentas);
            }catch (Exception e){
                throw new BusinessException(e.getMessage());
            }
        }
    }//
}//
