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
@Table(name = "cronogramaOAgenda")
public class CronogramaOAgenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String lugar;
    private Date fecha;
    private String citas;
    private String proveedores;
    private String pagos;
    private String reuniones;
    private String ocupaciones;
    private String asignaciones;
}//