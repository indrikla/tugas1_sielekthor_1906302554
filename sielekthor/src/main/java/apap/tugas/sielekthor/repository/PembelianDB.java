package apap.tugas.sielekthor.repository;
import apap.tugas.sielekthor.model.PembelianModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PembelianDB extends JpaRepository<PembelianModel, Long> {
//    Optional<PembelianModel> findByNoBioskop(Long noBioskop);
//    List<PembelianModel> findAllByOrderByNamaBioskop();
}

