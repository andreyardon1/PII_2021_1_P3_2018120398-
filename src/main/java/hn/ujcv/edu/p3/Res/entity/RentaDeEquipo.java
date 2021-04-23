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
@Table(name = "rentaDeEquipo")
public class RentaDeEquipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int idDelPropietarioDelEquipo;
    private String nombreDelEquipo;
    private String tipoDeEquipo;
    private Date fechaDeAlquiler;
    private String contrato;
    private String direccion;
    private String condicionDeEquipo;
}//
