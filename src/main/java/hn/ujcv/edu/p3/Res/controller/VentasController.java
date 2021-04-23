package hn.ujcv.edu.p3.Res.controller;
import hn.ujcv.edu.p3.Res.entity.Ventas;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;
import hn.ujcv.edu.p3.Res.service.VentasService;
import hn.ujcv.edu.p3.Res.utils.Constants;

import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ventas")
public class VentasController {
    @Autowired
    private VentasService service;

    @PostMapping("/addVenta")
    public ResponseEntity<Any> addVenta(@RequestBody Ventas venta){
        try{
            service.saveVentas(venta);
            HttpHeaders responseHeader  = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_VENTAS + venta.getId());
            return new ResponseEntity(venta, responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @PostMapping("/addVentas")
    public ResponseEntity<Any> addVentas(@RequestBody List<Ventas> ventas){
        try{
            return new ResponseEntity(service.saveVentas(ventas), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @GetMapping("")
    public ResponseEntity<List<Ventas>>findAllVentas(){
        try {
            return new ResponseEntity(service.getVentas(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @GetMapping("/id/{id}")
    public ResponseEntity<Ventas>findVentasById(@PathVariable long id){
        try {
            return new ResponseEntity(service.getVentasById(id), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @GetMapping("/idCliente/{idCliente}")
    public ResponseEntity<Ventas>findVentasByIdCliente(@PathVariable int idCliente){
        try {
            return new ResponseEntity(service.getVentasByIdCliente(idCliente), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @PutMapping("")
    public ResponseEntity<Any>updateVenta(@RequestBody Ventas ventas){
        try {
            service.updateVentas(ventas);
            return new ResponseEntity(ventas, HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @DeleteMapping("/delete{id}")
    public ResponseEntity<Any>deleteVenta(@PathVariable long id){
        try {
            service.deleteVentas(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
}//
