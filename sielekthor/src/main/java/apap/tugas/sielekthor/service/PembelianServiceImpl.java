package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.MemberModel;
import apap.tugas.sielekthor.model.PembelianModel;
import apap.tugas.sielekthor.repository.MemberDB;
import apap.tugas.sielekthor.repository.PembelianDB;
import apap.tugas.sielekthor.repository.TipeDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PembelianServiceImpl implements PembelianService {

    @Autowired
    PembelianDB pembelianDB;

    @Autowired
    MemberDB memberDB;

    @Override
    public void addPembelian(PembelianModel pembelian) {
        pembelianDB.save(pembelian);
    }

    @Override
    public void deletePembelian(PembelianModel pembelian) {
        pembelianDB.delete(pembelian);
    }

    @Override
    public void updatePembelian(PembelianModel pembelian) {
        pembelianDB.save(pembelian);
    }

    @Override
    public List<PembelianModel> getPembelianList() {
        return pembelianDB.findAll();
    }

    @Override
    public PembelianModel findByIdPembelian(Long idPembelian) {
        Optional<PembelianModel> x = pembelianDB.findByIdPembelian(idPembelian);
        if (x.isPresent()) {
            return x.get();
        }
        return null;
    }


}