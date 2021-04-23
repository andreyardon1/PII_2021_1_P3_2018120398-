package hn.ujcv.edu.p3.Res.controller;
import hn.ujcv.edu.p3.Res.entity.Lanzamientos;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;
import hn.ujcv.edu.p3.Res.service.LanzamientosService;
import hn.ujcv.edu.p3.Res.utils.Constants;

import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lanzamientos")
public class LanzamientosController {
    @Autowired
    private LanzamientosService service;

    @PostMapping("/addLanzamiento")
    public ResponseEntity<Any> addLanzamiento(@RequestBody Lanzamientos lanzamiento){
        try{
            service.saveLanzamientos(lanzamiento);
            HttpHeaders responseHeader  = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_LANZAMIENTOS + lanzamiento.getId());
            return new ResponseEntity(lanzamiento, responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @PostMapping("/addLanzamientos")
    public ResponseEntity<Any> addLanzamientos(@RequestBody List<Lanzamientos> lanzamientos){
        try{
            return new ResponseEntity(service.saveLanzamientos(lanzamientos), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @GetMapping("")
    public ResponseEntity<List<Lanzamientos>>findAllLanzamientos(){
        try {
            return new ResponseEntity(service.getLanzamientos(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @GetMapping("/id/{id}")
    public ResponseEntity<Lanzamientos>findLanzamientosById(@PathVariable long id){
        try {
            return new ResponseEntity(service.getLanzamientosById(id), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @GetMapping("/nombre{nombre}")
    public ResponseEntity<Lanzamientos>findLanzamientosByNombre(@PathVariable String nombre){
        try {
            return new ResponseEntity(service.getLanzamientosByNombre(nombre), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @PutMapping("")
    public ResponseEntity<Any>updateLanzamiento(@RequestBody Lanzamientos lanzamientos){
        try {
            service.updateLanzamientos(lanzamientos);
            return new ResponseEntity(lanzamientos, HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @DeleteMapping("/delete{id}")
    public ResponseEntity<Any>deleteLanzamiento(@PathVariable long id){
        try {
            service.deleteLanzamientos(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
}//
