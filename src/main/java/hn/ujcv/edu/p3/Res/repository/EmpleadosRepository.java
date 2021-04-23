package hn.ujcv.edu.p3.Res.repository;
import hn.ujcv.edu.p3.Res.entity.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmpleadosRepository extends JpaRepository<Empleados, Long> {
    Optional<Empleados> findByNombre(String nombre);
}//