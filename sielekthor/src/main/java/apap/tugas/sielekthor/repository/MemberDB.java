package apap.tugas.sielekthor.repository;
import apap.tugas.sielekthor.model.MemberModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberDB extends JpaRepository<MemberModel, Long> {
//    Optional<MemberModel> findByIdMember(Long id);
//    List<MemberModel> findAllMember();
}