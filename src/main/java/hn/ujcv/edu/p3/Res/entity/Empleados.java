package hn.ujcv.edu.p3.Res.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private int edad;
    private int dni;
    private int numeroEmpleado;
    private String acronimoDelDepartamento;
    private int codigoDeCarga;
    private String genero;
    private Date fechaDeRegistro;
}//