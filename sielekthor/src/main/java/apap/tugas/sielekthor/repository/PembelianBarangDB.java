package apap.tugas.sielekthor.repository;
import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.model.PembelianBarangModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface PembelianBarangDB extends JpaRepository<PembelianBarangModel, Long> {
//    Optional<PembelianBarangModel> findByIdBarang(Long idBarang);
    Optional<PembelianBarangModel> findByIdPembelianBarang(Long idPembelianBarang);
}
