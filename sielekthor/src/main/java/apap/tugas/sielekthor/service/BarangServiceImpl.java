package apap.tugas.sielekthor.service;
import apap.tugas.sielekthor.model.*;
import apap.tugas.sielekthor.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BarangServiceImpl implements BarangService {

    @Autowired
    BarangDB barangDB;

    @Autowired
    TipeDB tipeDB;

    @Override
    public void addBarang(BarangModel barang) {
        barangDB.save(barang);
    }

    @Override
    public void deleteBarang(BarangModel barang) {
        barangDB.delete(barang);
    }

    @Override
    public void updateBarang(BarangModel barang) {
        barangDB.save(barang);
    }

    @Override
    public List<BarangModel> getBarangList() {
        return barangDB.findAll();
    }
}