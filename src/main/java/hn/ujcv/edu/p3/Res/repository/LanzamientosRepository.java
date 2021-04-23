package hn.ujcv.edu.p3.Res.repository;
import hn.ujcv.edu.p3.Res.entity.Lanzamientos;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LanzamientosRepository extends JpaRepository<Lanzamientos, Long> {
    Optional<Lanzamientos> findByNombre(String nombre);
}//