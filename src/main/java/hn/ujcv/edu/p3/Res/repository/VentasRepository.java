package hn.ujcv.edu.p3.Res.repository;
import hn.ujcv.edu.p3.Res.entity.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VentasRepository extends JpaRepository<Ventas, Long> {
    Optional<Ventas> findByIdCliente(int idCliente);
}//