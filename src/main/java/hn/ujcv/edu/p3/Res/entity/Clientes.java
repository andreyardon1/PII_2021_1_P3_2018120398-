package hn.ujcv.edu.p3.Res.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombrecompleto;
    private int dni;
    private String paisregion;
    private String pueblo;
    private String telefono;
    private int edad;
    private String genero;
}//
