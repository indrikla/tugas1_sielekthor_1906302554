package apap.tugas.sielekthor.repository;
import apap.tugas.sielekthor.model.BarangModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BarangDB extends JpaRepository<BarangModel, Long> {
    Optional<BarangModel> findByIdBarang(Long idBarang);
//    List<BarangModel> findAllBarang();
}
