package hn.ujcv.edu.p3.Res.controller;
import hn.ujcv.edu.p3.Res.entity.Empleados;
import hn.ujcv.edu.p3.Res.exceptions.BusinessException;
import hn.ujcv.edu.p3.Res.exceptions.NotFoundException;
import hn.ujcv.edu.p3.Res.service.EmpleadosService;
import hn.ujcv.edu.p3.Res.utils.Constants;

import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadosController {
    @Autowired
    private EmpleadosService service;

    @PostMapping("/addEmpleado")
    public ResponseEntity<Any> addEmpleado(@RequestBody Empleados empleado){
        try{
            service.saveEmpleados(empleado);
            HttpHeaders responseHeader  = new HttpHeaders();
            responseHeader.set("location", Constants.URL_BASE_EMPLEADOS + empleado.getId());
            return new ResponseEntity(empleado, responseHeader, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @PostMapping("/addEmpleados")
    public ResponseEntity<Any> addEmpleados(@RequestBody List<Empleados> empleados){
        try{
            return new ResponseEntity(service.saveEmpleados(empleados), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @GetMapping("")
    public ResponseEntity<List<Empleados>>findAllEmpleados(){
        try {
            return new ResponseEntity(service.getEmpleados(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }//
    @GetMapping("/id/{id}")
    public ResponseEntity<Empleados>findEmpleadoById(@PathVariable long id){
        try {
            return new ResponseEntity(service.getEmpleadosById(id), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Empleados>findEmpleadosByNombre(@PathVariable String nombre){
        try {
            return new ResponseEntity(service.getEmpleadosByNombre(nombre), HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @PutMapping("")
    public ResponseEntity<Any>updateEmpleado(@RequestBody Empleados empleado){
        try {
            service.updateEmpleados(empleado);
            return new ResponseEntity(empleado, HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
    @DeleteMapping("/delete{id}")
    public ResponseEntity<Any>deleteEmpleado(@PathVariable long id){
        try {
            service.deleteEmpleados(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (BusinessException e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch (NotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }//
}//
