package hn.ujcv.edu.p3.Res.repository;
import hn.ujcv.edu.p3.Res.entity.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EventosRepository extends JpaRepository<Eventos, Long> {
    Optional<Eventos> findByNombreEvento(String nombreEvento);
}//