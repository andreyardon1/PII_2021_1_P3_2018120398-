package hn.ujcv.edu.p3.Res.repository;
import hn.ujcv.edu.p3.Res.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    Optional<Usuarios> findByNombreDeUsuario(String nombreDeUsuario);
}//