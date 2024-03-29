package apap.tugas.sielekthor.repository;
import apap.tugas.sielekthor.model.MemberModel;
import apap.tugas.sielekthor.model.PembelianModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PembelianDB extends JpaRepository<PembelianModel, Long> {
    Optional<PembelianModel> findByIdPembelian(Long idPembelian);
//    Optional<PembelianModel> findByMemberAndCash(MemberModel member, Boolean cash);
//    List<PembelianModel> findAllPembelian();
}

