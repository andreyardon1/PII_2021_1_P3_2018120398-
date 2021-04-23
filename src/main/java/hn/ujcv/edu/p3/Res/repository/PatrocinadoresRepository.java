package hn.ujcv.edu.p3.Res.repository;
import hn.ujcv.edu.p3.Res.entity.Patrocinadores;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PatrocinadoresRepository extends JpaRepository<Patrocinadores, Long> {
    Optional<Patrocinadores> findByNombreDelPatrocinador(String nombreDelPatrocinador);
}//