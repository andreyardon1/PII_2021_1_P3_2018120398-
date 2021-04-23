package hn.ujcv.edu.p3.Res.repository;
import hn.ujcv.edu.p3.Res.entity.RentaDeEquipo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RentaDeEquipoRepository extends JpaRepository<RentaDeEquipo, Long> {
    Optional<RentaDeEquipo> findByIdDelPropietarioDelEquipo(int idDelPropietarioDelEquipo);
}//