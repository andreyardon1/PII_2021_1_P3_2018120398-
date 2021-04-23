package hn.ujcv.edu.p3.Res.repository;
import hn.ujcv.edu.p3.Res.entity.Compras;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ComprasRepository extends JpaRepository<Compras, Long> {
    Optional<Compras> findByIdDeUsuario(int idDeUsuario);
}//