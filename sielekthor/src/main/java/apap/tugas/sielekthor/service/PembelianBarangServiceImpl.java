package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.MemberModel;
import apap.tugas.sielekthor.model.PembelianBarangModel;
import apap.tugas.sielekthor.model.PembelianModel;
import apap.tugas.sielekthor.repository.MemberDB;
import apap.tugas.sielekthor.repository.PembelianBarangDB;
import apap.tugas.sielekthor.repository.PembelianDB;
import apap.tugas.sielekthor.repository.TipeDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PembelianBarangServiceImpl implements PembelianBarangService {

    @Autowired
    PembelianBarangDB pembelianBarangDB;

    @Autowired
    PembelianDB pembelianDB;

    @Autowired
    MemberDB memberDB;

    @Override
    public void addPembelianBarang(PembelianBarangModel pb) {
        pembelianBarangDB.save(pb);
    }

    @Override
    public void deletePembelianBarang(PembelianBarangModel pb) {
        pembelianBarangDB.delete(pb);
    }

    @Override
    public void updatePembelianBarang(PembelianBarangModel pb) {
        pembelianBarangDB.save(pb);
    }

//    @Override
//    public PembelianBarangModel findByIdBarang(Long idBarang) {
//        Optional<PembelianBarangModel> x = pembelianBarangDB.findByIdBarang(idBarang);
//        if (x.isPresent()) {
//            return x.get();
//        }
//        return null;
//    }

    @Override
    public PembelianBarangModel findByIdPembelianBarang(Long idPembelianBarang) {
        Optional<PembelianBarangModel> x = pembelianBarangDB.findByIdPembelianBarang(idPembelianBarang);
        if (x.isPresent()) {
            return x.get();
        }
        return null;
    }

//    @Override
//    public PembelianBarangModel findByIdPembelian(Long idPembelian) {
//        Optional<PembelianBarangModel> x = pembelianBarangDB.findByIdPembelian(idPembelian);
//        if (x.isPresent()) {
//            return x.get();
//        }
//        return null;
//    }

    @Override
    public List<PembelianBarangModel> getPembelianBarangList() {
        return pembelianBarangDB.findAll();
    }
}