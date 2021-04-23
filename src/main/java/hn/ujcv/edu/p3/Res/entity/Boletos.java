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
@Table(name = "boletos")
public class Boletos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int idDeUsuario;
    private double precio;
    private String correo;
    private int numeroDeEntrada;
    private Date fecha;
    private String telefono;
    private String entradaGeneral;
    private String horaDelEvento;
    private String vip;
}//