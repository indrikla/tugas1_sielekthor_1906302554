package apap.tugas.sielekthor.service;
import apap.tugas.sielekthor.model.BarangModel;

import java.util.List;

public interface BarangService {
    void addBarang(BarangModel barang);
    void deleteBarang(BarangModel barang);
    void updateBarang(BarangModel barang);
    List<BarangModel> getBarangList();
//    String checkError(BioskopModel bioskop);
//    BioskopModel getBioskopByNoBioskop(Long noBioskop);
}