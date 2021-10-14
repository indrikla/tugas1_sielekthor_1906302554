package apap.tugas.sielekthor.controller;
import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.model.TipeModel;
import apap.tugas.sielekthor.service.BarangService;
import apap.tugas.sielekthor.service.MemberService;
import apap.tugas.sielekthor.service.PembelianService;
import apap.tugas.sielekthor.service.TipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BarangController {

    @Qualifier("barangServiceImpl")
    @Autowired
    private BarangService barangService;

    @Qualifier("pembelianServiceImpl")
    @Autowired
    private PembelianService pembelianService;

    @Qualifier("tipeServiceImpl")
    @Autowired
    private TipeService tipeService;

    @Qualifier("memberServiceImpl")
    @Autowired
    private MemberService memberService;

    @GetMapping("/barang")
    public String viewBarang(Model model) {
        List<BarangModel> listBarang = barangService.getBarangList();
        model.addAttribute("listBarang", listBarang);
        for(BarangModel b : listBarang) {
            System.out.println(b);
            System.out.println(b.getNamaBarang());
        }
        return "daftar_barang";
    }

    @GetMapping("/barang/tambah")
    public String viewTambahBarang(Model model) {
        List<TipeModel> listTipe = tipeService.getTipeList();
        model.addAttribute("listTipe", listTipe);
        model.addAttribute("barang", new BarangModel());
        return "tambah_barang";
    }

    @PostMapping("/barang/tambah")
    public String submitTambaBarang(@ModelAttribute BarangModel barang, Model model) {
//        if (bioskop.getListFilm() == null) {
//            bioskop.setListFilm(new ArrayList<>());
//        }
        barangService.addBarang(barang);
        // model.addAttribute("idMember", barang.getIdMember());
        return "tambah_barang_sukses";
    }

}
