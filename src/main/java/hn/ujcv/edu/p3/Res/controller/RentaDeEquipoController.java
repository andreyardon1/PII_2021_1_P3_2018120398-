package hn.ujcv.edu.p3.Res.controller;
import hn.ujcv.edu.p3.Res.entity.RentaDeEquipo;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;
import hn.ujcv.edu.p3.Res.service.RentaDeEquipoService;
import hn.ujcv.edu.p3.Res.utils.Constants;

import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rentaDeEquipo")
public class RentaDeEquipoController {
    @Autowired
    private RentaDeEquipoService service;

    @PostMapping("/addRentaDeEquipo")
    public ResponseEntity<Any> addRentaDeEquipo(@RequestBody RentaDeEquipo rentaDeEquipo){
        try{
            service.saveRentaDeEquipo(rentaDeEquipo);
            HttpHeaders responseHeader  = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_RENTA_DE_EQUIPO + rentaDeEquipo.getId());
            return new ResponseEntity(responseHeader, responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @PostMapping("/addRentasDeEquipos")
    public ResponseEntity<Any> addRentasDeEquipos(@RequestBody List<RentaDeEquipo> rentaDeEquipos){
        try{
            return new ResponseEntity(service.saveRentaDeEquipo(rentaDeEquipos), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @GetMapping("")
    public ResponseEntity<List<RentaDeEquipo>>findAllRentaDeEquipo(){
        try {
            return new ResponseEntity(service.getRentaDeEquipo(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @GetMapping("/id/{id}")
    public ResponseEntity<RentaDeEquipo>findRentaDeEquipoById(@PathVariable long id){
        try {
            return new ResponseEntity(service.getRentaDeEquipoById(id), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @GetMapping("/idDelPropietarioDelEquipo/{idDelPropietarioDelEquipo}")
    public ResponseEntity<RentaDeEquipo>findRentaDeEquipoByIdDelPropietarioDelEquipo(@PathVariable int idDelPropietarioDelEquipo){
        try {
            return new ResponseEntity(service.getRentaDeEquipoByIdDelPropietarioDelEquipo(idDelPropietarioDelEquipo), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @PutMapping("")
    public ResponseEntity<Any>updateRentaDeEquipo(@RequestBody RentaDeEquipo rentaDeEquipo){
        try {
            service.updateRentaDeEquipo(rentaDeEquipo);
            return new ResponseEntity(rentaDeEquipo, HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @DeleteMapping("/delete{id}")
    public ResponseEntity<Any>deleteBuffet(@PathVariable long id){
        try {
            service.deleteRentaDeEquipo(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
}//
