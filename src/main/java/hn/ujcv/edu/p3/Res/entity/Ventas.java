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
@Table(name = "ventas")
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int idCliente;
    private String nombreDeEmpresa;
    private Date fechaDeVenta;
    private String tipoDeVenta;
    private String observaciones;
    private String condicion;
}//