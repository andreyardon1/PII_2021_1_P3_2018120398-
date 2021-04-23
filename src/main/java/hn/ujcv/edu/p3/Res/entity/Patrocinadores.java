package hn.ujcv.edu.p3.Res.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patrocinadores")
public class Patrocinadores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombreDelPatrocinador;
    private String direccion;
    private String correoElectronico;
    private int precio;
    private String actividad;
    private String lugarOSede;
}//