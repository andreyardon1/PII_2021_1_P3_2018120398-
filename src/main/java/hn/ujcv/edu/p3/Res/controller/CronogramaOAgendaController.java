package hn.ujcv.edu.p3.Res.controller;
import hn.ujcv.edu.p3.Res.entity.CronogramaOAgenda;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;
import hn.ujcv.edu.p3.Res.service.CronogramaOAgendaService;
import hn.ujcv.edu.p3.Res.utils.Constants;

import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cronogramaOAgenda")
public class CronogramaOAgendaController {
    @Autowired
    private CronogramaOAgendaService service;

    @PostMapping("/addCronogramaOAgenda")
    public ResponseEntity<Any> addCronogramaOAgenda(@RequestBody CronogramaOAgenda cronogramaOAgenda){
        try{
            service.saveCronogramaOAgenda(cronogramaOAgenda);
            HttpHeaders responseHeader  = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_CRONOGRAMA_O_AGENDA + cronogramaOAgenda.getId());
            return new ResponseEntity(cronogramaOAgenda, responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @PostMapping("/addCronogramasOAgendas")
    public ResponseEntity<Any> addCronogramasOAgendas(@RequestBody List<CronogramaOAgenda> cronogramaOAgenda){
        try{
            return new ResponseEntity(service.saveCronogramaOAgenda(cronogramaOAgenda), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @GetMapping("")
    public ResponseEntity<List<CronogramaOAgenda>>findAllCronogramaOAgenda(){
        try {
            return new ResponseEntity(service.getCronogramaOAgenda(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @GetMapping("/id/{id}")
    public ResponseEntity<CronogramaOAgenda>findCronogramaOAgendaById(@PathVariable long id){
        try {
            return new ResponseEntity(service.getCronogramaOAgendaById(id), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @GetMapping("/lugar/{lugar}")
    public ResponseEntity<CronogramaOAgenda>findCronogramaOAgendaByLugar(@PathVariable String lugar){
        try {
            return new ResponseEntity(service.getCronogramaOAgendaByLugar(lugar), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @PutMapping("")
    public ResponseEntity<Any>updateCronogramaOAgenda(@RequestBody CronogramaOAgenda cronogramaOAgenda){
        try {
            service.updateCronogramaOAgenda(cronogramaOAgenda);
            return new ResponseEntity(cronogramaOAgenda, HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @DeleteMapping("/delete{id}")
    public ResponseEntity<Any>deleteCronogramaOAgenda(@PathVariable long id){
        try {
            service.deleteCronogramaOAgenda(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
}//
