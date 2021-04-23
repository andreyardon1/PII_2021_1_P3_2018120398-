package hn.ujcv.edu.p3.Res.repository;
import hn.ujcv.edu.p3.Res.entity.CronogramaOAgenda;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CronogramaOAgendaRepository extends JpaRepository<CronogramaOAgenda, Long> {
    Optional<CronogramaOAgenda> findByLugar(String lugar);
}//
