package hn.ujcv.edu.p3.Res.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombreDeUsuario;
    private int idDeUsuario;
    private String correo;
    private String numeroDeTelefono;
    private String direccion;
    private String genero;
    private String contraseña;
}//
