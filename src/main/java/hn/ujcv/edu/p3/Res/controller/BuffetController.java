package hn.ujcv.edu.p3.Res.controller;
import hn.ujcv.edu.p3.Res.entity.Buffet;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;
import hn.ujcv.edu.p3.Res.service.BuffetService;
import hn.ujcv.edu.p3.Res.utils.Constants;

import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/buffet")
public class BuffetController {
    @Autowired
    private BuffetService service;

    @PostMapping("/addBuffet")
    public ResponseEntity<Any> addBuffet(@RequestBody Buffet buffet){
        try{
            service.saveBuffet(buffet);
            HttpHeaders responseHeader  = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_BUFFET + buffet.getId());
            return new ResponseEntity(buffet, responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @PostMapping("/addBuffets")
    public ResponseEntity<Any> addBuffets(@RequestBody List<Buffet> buffet){
        try{
            return new ResponseEntity(service.saveBuffet(buffet), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @GetMapping("")
    public ResponseEntity<List<Buffet>>findAllBuffets(){
        try {
            return new ResponseEntity(service.getBuffet(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @GetMapping("/id/{id}")
    public ResponseEntity<Buffet>findBuffetById(@PathVariable long id){
        try {
            return new ResponseEntity(service.getBuffetById(id), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @GetMapping("/menu/{menu}")
    public ResponseEntity<Buffet>findBuffetByMenu(@PathVariable String menu){
        try {
            return new ResponseEntity(service.getBuffetByMenu(menu), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @PutMapping("")
    public ResponseEntity<Any>updateBuffet(@RequestBody Buffet buffet){
        try {
            service.updateBuffet(buffet);
            return new ResponseEntity(buffet, HttpStatus.OK);
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
            service.deleteBuffet(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
}//
