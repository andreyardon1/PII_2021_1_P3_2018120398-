package hn.ujcv.edu.p3.Res.service;

import hn.ujcv.edu.p3.Res.entity.Clientes;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;
import hn.ujcv.edu.p3.Res.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesService implements IClientesService{

    @Autowired
    private ClientesRepository repository;

    @Override
    public Clientes saveClientes(Clientes clientes) throws BusinessException {
        try{
            return repository.save(clientes);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public List<Clientes> saveClientes(List<Clientes> clientes) throws BusinessException {
        try{
            return repository.saveAll(clientes);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public List<Clientes> getClientes() throws BusinessException {
        try{
            return repository.findAll();
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public Clientes getClientesById(long id) throws BusinessException, NotFoundException {
        Optional<Clientes> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(opt.isPresent()){
            throw new NotFoundException("No se encontró el cliente "+id);
        }
        return opt.get();
    }//

    @Override
    public Clientes getClientesBynombrecompleto(String nombreCompleto) throws BusinessException, NotFoundException {
        Optional<Clientes> opt = null;
        try{
            opt = repository.findBynombrecompleto(nombreCompleto);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(opt.isPresent()){
            throw new NotFoundException("No se encontró el cliente "+nombreCompleto);
        }
        return opt.get();
    }//

    @Override
    public void deleteClientes(long id) throws BusinessException, NotFoundException {
        Optional<Clientes> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el cliente "+id);
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
    public Clientes updateClientes(Clientes clientes) throws BusinessException, NotFoundException {
        Optional<Clientes> opt = null;
        try{
            opt = repository.findById(clientes.getId());
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el cliente "+clientes.getId());
        }
        else{
            try {
                Clientes existingClientes = new Clientes();
                existingClientes.setId(clientes.getId());
                existingClientes.setNombrecompleto(clientes.getNombrecompleto());
                existingClientes.setDni(clientes.getDni());
                existingClientes.setPaisregion(clientes.getPaisregion());
                existingClientes.setPueblo(clientes.getPueblo());
                existingClientes.setTelefono(clientes.getTelefono());
                existingClientes.setEdad(clientes.getEdad());
                existingClientes.setGenero(clientes.getGenero());

                return repository.save(existingClientes);
            }catch (Exception e){
                throw new BusinessException(e.getMessage());
            }
        }
    }//
}//
