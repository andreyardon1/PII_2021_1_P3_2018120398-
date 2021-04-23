package hn.ujcv.edu.p3.Res.controller;
import hn.ujcv.edu.p3.Res.entity.Usuarios;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;
import hn.ujcv.edu.p3.Res.service.BuffetService;
import hn.ujcv.edu.p3.Res.service.UsuariosService;
import hn.ujcv.edu.p3.Res.utils.Constants;

import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuariosController {
    @Autowired
    private UsuariosService service;

    @PostMapping("/addBuffet")
    public ResponseEntity<Any> addBuffet(@RequestBody Usuarios usuario){
        try{
            service.saveUsuarios(usuario);
            HttpHeaders responseHeader  = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_USUARIOS + usuario.getId());
            return new ResponseEntity(usuario, responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @PostMapping("/addBuffets")
    public ResponseEntity<Any> addBuffets(@RequestBody List<Usuarios> usuarios){
        try{
            return new ResponseEntity(service.saveUsuarios(usuarios), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @GetMapping("")
    public ResponseEntity<List<Usuarios>>findAllUsuarios(){
        try {
            return new ResponseEntity(service.getUsuarios(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @GetMapping("/id/{id}")
    public ResponseEntity<Usuarios>findUsuariosById(@PathVariable long id){
        try {
            return new ResponseEntity(service.getUsuariosById(id), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @GetMapping("/nombreDeUsuario/{nombreDeUsuario}")
    public ResponseEntity<Usuarios>findUsuariosByNombreDeUsuario(@PathVariable String nombreDeUsuario){
        try {
            return new ResponseEntity(service.getUsuariosByNombreDeUsuario(nombreDeUsuario), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @PutMapping("")
    public ResponseEntity<Any>updateUsuarios(@RequestBody Usuarios usuarios){
        try {
            service.updateUsuarios(usuarios);
            return new ResponseEntity(usuarios, HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @DeleteMapping("/delete{id}")
    public ResponseEntity<Any>deleteUsuario(@PathVariable long id){
        try {
            service.deleteUsuarios(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
}//
