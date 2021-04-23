package hn.ujcv.edu.p3.Res.controller;
import hn.ujcv.edu.p3.Res.entity.Compras;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;
import hn.ujcv.edu.p3.Res.service.ComprasService;
import hn.ujcv.edu.p3.Res.utils.Constants;

import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/compras")
public class ComprasController {
    @Autowired
    private ComprasService service;

    @PostMapping("/addCompra")
    public ResponseEntity<Any> addCompra(@RequestBody Compras compra){
        try{
            service.saveCompras(compra);
            HttpHeaders responseHeader  = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_COMPRAS + compra.getId());
            return new ResponseEntity(compra, responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @PostMapping("/addCompras")
    public ResponseEntity<Any> addCompras(@RequestBody List<Compras> compras){
        try{
            return new ResponseEntity(service.saveCompras(compras), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @GetMapping("")
    public ResponseEntity<List<Compras>>findAllCompras(){
        try {
            return new ResponseEntity(service.getCompras(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @GetMapping("/id/{id}")
    public ResponseEntity<Compras>findCompraById(@PathVariable long id){
        try {
            return new ResponseEntity(service.getComprasById(id), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @GetMapping("/idDeUsuario/{idDeUsuario}")
    public ResponseEntity<Compras>findComprasByIdDeUsuario(@PathVariable int idDeUsuario){
        try {
            return new ResponseEntity(service.getComprasByIdDeUsuario(idDeUsuario), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @PutMapping("")
    public ResponseEntity<Any>updateCompra(@RequestBody Compras compra){
        try {
            service.updateCompras(compra);
            return new ResponseEntity(compra, HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @DeleteMapping("/delete{id}")
    public ResponseEntity<Any>deleteCompra(@PathVariable long id){
        try {
            service.deleteCompras(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
}//
