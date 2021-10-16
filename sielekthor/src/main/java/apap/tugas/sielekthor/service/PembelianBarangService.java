package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.PembelianBarangModel;
import apap.tugas.sielekthor.model.PembelianModel;

import java.util.List;
import java.util.Optional;

public interface PembelianBarangService {
    void addPembelianBarang(PembelianBarangModel pb);
    void deletePembelianBarang(PembelianBarangModel pb);
    void updatePembelianBarang(PembelianBarangModel pb);
//    PembelianBarangModel findByIdBarang(Long idBarang);
    PembelianBarangModel findByIdPembelianBarang(Long idPembelianBarang);
//    PembelianBarangModel findByIdPembelian(Long idPembelian);
    List<PembelianBarangModel> getPembelianBarangList();
}
