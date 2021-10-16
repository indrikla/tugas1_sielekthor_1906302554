package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.PembelianModel;
import apap.tugas.sielekthor.model.TipeModel;
import apap.tugas.sielekthor.repository.MemberDB;
import apap.tugas.sielekthor.repository.TipeDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional
public class TipeServiceImpl implements TipeService {

    @Autowired
    TipeDB tipeDB;

    @Override
    public List<TipeModel> getTipeList() {
        return tipeDB.findAll();
    }

    @Override
    public TipeModel findByNamaTipe(String namaTipe) {
        Optional<TipeModel> x = tipeDB.findByNamaTipe(namaTipe);
        if (x.isPresent()) {
            return x.get();
        }
        return null;
    }
}