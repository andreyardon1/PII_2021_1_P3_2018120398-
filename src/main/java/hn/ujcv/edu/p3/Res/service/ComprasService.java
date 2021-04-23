package hn.ujcv.edu.p3.Res.service;

import hn.ujcv.edu.p3.Res.entity.Compras;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;
import hn.ujcv.edu.p3.Res.repository.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComprasService implements IComprasService{

    @Autowired
    private ComprasRepository repository;

    @Override
    public Compras saveCompras(Compras compras) throws BusinessException {
        try{
            return repository.save(compras);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public List<Compras> saveCompras(List<Compras> compras) throws BusinessException {
        try{
            return repository.saveAll(compras);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public List<Compras> getCompras() throws BusinessException {
        try{
            return repository.findAll();
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public Compras getComprasById(long id) throws BusinessException, NotFoundException {
        Optional<Compras> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(opt.isPresent()){
            throw new NotFoundException("No se encontró la compra "+id);
        }
        return opt.get();
    }//

    @Override
    public Compras getComprasByIdDeUsuario(int idDeUsuario) throws BusinessException, NotFoundException {
        Optional<Compras> opt = null;
        try{
            opt = repository.findByIdDeUsuario(idDeUsuario);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(opt.isPresent()){
            throw new NotFoundException("No se encontró la compra "+idDeUsuario);
        }
        return opt.get();
    }//

    @Override
    public void deleteCompras(long id) throws BusinessException, NotFoundException {
        Optional<Compras> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el compra "+id);
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
    public Compras updateCompras(Compras compras) throws BusinessException, NotFoundException {
        Optional<Compras> opt = null;
        try{
            opt = repository.findById(compras.getId());
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el compra "+compras.getId());
        }
        else{
            try {
                Compras existingCompras = new Compras();
                existingCompras.setId(compras.getId());
                existingCompras.setIdDeUsuario(compras.getIdDeUsuario());
                existingCompras.setLugar(compras.getLugar());
                existingCompras.setFecha(compras.getFecha());
                existingCompras.setTipoDeCompras(compras.getTipoDeCompras());
                existingCompras.setLocall(compras.getLocall());
                existingCompras.setProducto(compras.getProducto());
                existingCompras.setPrecios(compras.getPrecios());

                return repository.save(existingCompras);
            }catch (Exception e){
                throw new BusinessException(e.getMessage());
            }
        }
    }//
}//
