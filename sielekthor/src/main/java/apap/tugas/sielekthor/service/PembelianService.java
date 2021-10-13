package apap.tugas.sielekthor.service;
import apap.tugas.sielekthor.model.MemberModel;
import apap.tugas.sielekthor.model.PembelianModel;
import apap.tugas.sielekthor.model.TipeModel;

import java.util.List;

public interface PembelianService {
    void addPembelian(PembelianModel pembelian);
    void deletePembelian(PembelianModel pembelian);
    void updatePembelian(PembelianModel pembelian);
    List<PembelianModel> getPembelianList();
    PembelianModel findPembelianByMemberPembayaran(MemberModel member, String pembayaran);
}
