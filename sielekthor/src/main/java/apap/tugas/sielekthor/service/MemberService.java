package apap.tugas.sielekthor.service;
import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.model.MemberModel;

import java.util.List;
public interface MemberService {
    void addMember(MemberModel member);
//    void deleteBarang(BarangModel barang);
    void updateMember(MemberModel member);
    List<MemberModel> getMemberList();
}
