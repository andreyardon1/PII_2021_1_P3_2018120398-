package hn.ujcv.edu.p3.Res.controller;
import hn.ujcv.edu.p3.Res.entity.Patrocinadores;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;
import hn.ujcv.edu.p3.Res.service.PatrocinadoresService;
import hn.ujcv.edu.p3.Res.utils.Constants;

import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patrocinadores")
public class PatrocinadoresController {
    @Autowired
    private PatrocinadoresService service;

    @PostMapping("/addPatrocinador")
    public ResponseEntity<Any> addPatrocinador(@RequestBody Patrocinadores patrocinador){
        try{
            service.savePatrocinadores(patrocinador);
            HttpHeaders responseHeader  = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_PATROCINADORES + patrocinador.getId());
            return new ResponseEntity(patrocinador, responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @PostMapping("/addPatrocinadores")
    public ResponseEntity<Any> addPatrocinadores(@RequestBody List<Patrocinadores> patrocinadores){
        try{
            return new ResponseEntity(service.savePatrocinadores(patrocinadores), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @GetMapping("")
    public ResponseEntity<List<Patrocinadores>>findAllPatrocinadores(){
        try {
            return new ResponseEntity(service.getPatrocinadores(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @GetMapping("/id/{id}")
    public ResponseEntity<Patrocinadores>findPatrocinadorById(@PathVariable long id){
        try {
            return new ResponseEntity(service.getPatrocinadoresById(id), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @GetMapping("/nombreDelPatrocinador/{nombreDelPatrocinador}")
    public ResponseEntity<Patrocinadores>findPatrocinadoresByNombreDelPatrocinador(@PathVariable String nombreDelPatrocinador){
        try {
            return new ResponseEntity(service.getPatrocinadoresByNombreDelPatrocinador(nombreDelPatrocinador), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @PutMapping("")
    public ResponseEntity<Any>updatePatrocinador(@RequestBody Patrocinadores patrocinador){
        try {
            service.updatePatrocinadores(patrocinador);
            return new ResponseEntity(patrocinador, HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @DeleteMapping("/delete{id}")
    public ResponseEntity<Any>deletePatrocinador(@PathVariable long id){
        try {
            service.deletePatrocinadores(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
}//
