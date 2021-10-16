package apap.tugas.sielekthor.controller;
import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.model.PembelianBarangModel;
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

import java.util.ArrayList;
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
    public String formTambahBarang(Model model) {
        List<TipeModel> listTipe = tipeService.getTipeList();
        model.addAttribute("listTipe", listTipe);
        model.addAttribute("barang", new BarangModel());
        return "tambah_barang";
    }

    @PostMapping("/barang/tambah")
    public String submitTambaBarang(@ModelAttribute BarangModel barang, Model model) {
        barangService.addBarang(barang);
        model.addAttribute("kodeBarang", barang.getKodeBarang());
        return "tambah_barang_sukses";
    }

    @GetMapping("/barang/ubah/{idBarang}")
    public String formUbahBarang(@PathVariable Long idBarang, Model model) {
        BarangModel barang = barangService.findByIdBarang(idBarang);
        model.addAttribute("tipe", barang.getTipe());
        model.addAttribute("barang", barang);
        return "ubah_barang";
    }
    @PostMapping("/barang/ubah")
    public String submitUbahBarang(@ModelAttribute BarangModel barang, Model model) {
        barangService.updateBarang(barang);
        model.addAttribute("kodeBarang", barang.getKodeBarang());
        return "ubah_barang_sukses";
    }

    @GetMapping("/barang/hapus/{idBarang}")
    public String hapusBarang(@PathVariable Long idBarang, Model model) {
        BarangModel barang = barangService.findByIdBarang(idBarang);
        barangService.deleteBarang(barang);
//        model.addAttribute("tipe", barang.getTipe());
//        model.addAttribute("barang", barang);
        return "barang";
    }

    @GetMapping("/barang/{idBarang}")
    public String viewDetailBarang(@PathVariable Long idBarang, Model model) {
        BarangModel barang = barangService.findByIdBarang(idBarang);
        model.addAttribute("barang", barang);
        return "detail_barang";
    }

    @GetMapping("/barang/cari")
    public String cariBarangForm(Model model) {
        List<TipeModel> listTipe = tipeService.getTipeList();
        model.addAttribute("listTipe", listTipe);
        return "cari_barang";
    }

    @GetMapping("/barang/cari/tipe")
    public String cariBarangResult(@RequestParam(value = "idTipe") Long idTipe,
                                      @RequestParam(value = "stok") Boolean stok,
                                      Model model) {
        List<TipeModel> listTipe = tipeService.getTipeList();
        model.addAttribute("listTipe", listTipe);

        List<BarangModel> returnedList = new ArrayList<>();
        List<BarangModel> listBarang = barangService.getBarangList();
        for (BarangModel bm : listBarang) {
            if (bm.getTipe().getIdTipe().equals(idTipe)) {

                if (stok) {
                    if (bm.getStok() > 0) {
                        returnedList.add(bm);
                    }

                }  else {
                    if (bm.getStok() == 0) {
                        returnedList.add(bm);
                    }
                }
            }
        }
        model.addAttribute("listBarang", returnedList);
        return "cari_barang_sukses";
    }

}
