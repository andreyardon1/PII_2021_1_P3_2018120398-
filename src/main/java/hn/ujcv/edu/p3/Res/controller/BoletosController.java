package hn.ujcv.edu.p3.Res.controller;
import hn.ujcv.edu.p3.Res.entity.Boletos;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;
import hn.ujcv.edu.p3.Res.service.BoletosService;
import hn.ujcv.edu.p3.Res.utils.Constants;

import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/boletos")
public class BoletosController {
    @Autowired
    private BoletosService service;

    @PostMapping("/addBoleto")
    public ResponseEntity<Any> addBoleto(@RequestBody Boletos boleto){
        try{
                service.saveBoleto(boleto);
                HttpHeaders responseHeader  = new HttpHeaders();
                responseHeader.set("location", Constants.URL_BASE_BOLETOS + boleto.getId());
                return new ResponseEntity(boleto, responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @PostMapping("/addBoletos")
    public ResponseEntity<Any> addBoletos(@RequestBody List<Boletos> boletos){
       try{
            return new ResponseEntity(service.saveBoletos(boletos), HttpStatus.CREATED);
       } catch (Exception e){
           return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }//
    @GetMapping("")
    public ResponseEntity<List<Boletos>>findAllBoletos(){
        try {
            return new ResponseEntity(service.getBoletos(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @GetMapping("/id/{id}")
    public ResponseEntity<Boletos>findBoletoById(@PathVariable long id){
        try {
            return new ResponseEntity(service.getBoletoById(id), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @GetMapping("/idDeUsuario/{idDeUsuario}")
    public ResponseEntity<Boletos>findBoletoByIdDeUsuario(@PathVariable int idDeUsuario){
        try {
            return new ResponseEntity(service.getBoletoByIdDeUsuario(idDeUsuario), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @PutMapping("")
    public ResponseEntity<Any>updateBoleto(@RequestBody Boletos boleto){
        try {
            service.updateBoleto(boleto);
            return new ResponseEntity(boleto, HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @DeleteMapping("/delete{id}")
    public ResponseEntity<Any>deleteBoleto(@PathVariable long id){
        try {
            service.deleteBoleto(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
}//
