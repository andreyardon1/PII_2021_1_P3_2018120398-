package hn.ujcv.edu.p3.Res.repository;
import hn.ujcv.edu.p3.Res.entity.Buffet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BuffetRepository extends JpaRepository<Buffet, Long> {
    Optional<Buffet> findByMenu(String menu);
}//
