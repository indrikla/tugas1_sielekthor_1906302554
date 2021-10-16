package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.model.MemberModel;
import apap.tugas.sielekthor.repository.BarangDB;
import apap.tugas.sielekthor.repository.MemberDB;
import apap.tugas.sielekthor.repository.TipeDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberDB memberDB;

    @Override
    public void addMember(MemberModel member) {
        memberDB.save(member);
    }

    @Override
    public void updateMember(MemberModel member) {
        memberDB.save(member);
    }

    @Override
    public List<MemberModel> getMemberList() {
        return memberDB.findAll();
    }

    @Override
    public MemberModel findByIdMember(Long idMember) {
        Optional<MemberModel> x = memberDB.findByIdMember(idMember);
        if (x.isPresent()) {
            return x.get();
        }
        return null;
    }
}