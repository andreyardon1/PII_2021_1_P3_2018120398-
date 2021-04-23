package hn.ujcv.edu.p3.Res.service;

import hn.ujcv.edu.p3.Res.entity.Usuarios;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;
import hn.ujcv.edu.p3.Res.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService implements IUsuariosService{

    @Autowired
    private UsuariosRepository repository;

    @Override
    public Usuarios saveUsuarios(Usuarios usuarios) throws BusinessException {
        try{
            return repository.save(usuarios);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public List<Usuarios> saveUsuarios(List<Usuarios> usuarios) throws BusinessException {
        try{
            return repository.saveAll(usuarios);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public List<Usuarios> getUsuarios() throws BusinessException {
        try{
            return repository.findAll();
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }//

    @Override
    public Usuarios getUsuariosById(long id) throws BusinessException, NotFoundException {
        Optional<Usuarios> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(opt.isPresent()){
            throw new NotFoundException("No se encontró el usuario "+id);
        }
        return opt.get();
    }//

    @Override
    public Usuarios getUsuariosByNombreDeUsuario(String nombreDeUsuario)  throws BusinessException, NotFoundException {
        Optional<Usuarios> opt = null;
        try{
            opt = repository.findByNombreDeUsuario(nombreDeUsuario);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(opt.isPresent()){
            throw new NotFoundException("No se encontró el usuario "+nombreDeUsuario);
        }
        return opt.get();
    }//

    @Override
    public void deleteUsuarios(long id) throws BusinessException, NotFoundException {
        Optional<Usuarios> opt = null;
        try{
            opt = repository.findById(id);
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el usuario "+id);
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
    public Usuarios updateUsuarios(Usuarios usuarios) throws BusinessException, NotFoundException {
        Optional<Usuarios> opt = null;
        try{
            opt = repository.findById(usuarios.getId());
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }

        if(!opt.isPresent()){
            throw new NotFoundException("No se encontró el usuario "+usuarios.getId());
        }
        else{
            try {
                Usuarios existingUsuarios = new Usuarios();
                existingUsuarios.setId(usuarios.getId());
                existingUsuarios.setNombreDeUsuario(usuarios.getNombreDeUsuario());
                existingUsuarios.setIdDeUsuario(usuarios.getIdDeUsuario());
                existingUsuarios.setCorreo(usuarios.getCorreo());
                existingUsuarios.setNumeroDeTelefono(usuarios.getNumeroDeTelefono());
                existingUsuarios.setDireccion(usuarios.getDireccion());
                existingUsuarios.setGenero(usuarios.getGenero());
                existingUsuarios.setContraseña(usuarios.getContraseña());

                return repository.save(existingUsuarios);
            }catch (Exception e){
                throw new BusinessException(e.getMessage());
            }
        }
    }//
}//
