package hn.ujcv.edu.p3.Res.repository;
import hn.ujcv.edu.p3.Res.entity.Boletos;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BoletosRepository extends JpaRepository<Boletos, Long> {
    Optional<Boletos> findByIdDeUsuario(int idDeUsuario);
}//
