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
@Table(name = "lanzamiento")
public class Lanzamientos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String producto;
    private int precio;
    private Date fecha;
    private String lugar;
    private String hora;
}//