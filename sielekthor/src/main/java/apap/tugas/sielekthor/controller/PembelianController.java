package apap.tugas.sielekthor.controller;
import apap.tugas.sielekthor.model.*;
import apap.tugas.sielekthor.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PembelianController {

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

    @Qualifier("pembelianBarangServiceImpl")
    @Autowired
    private PembelianBarangService pembelianBarangService;

    @GetMapping("/pembelian")
    public String viewPembelian(Model model) {
        List<PembelianModel> listPembelian = pembelianService.getPembelianList();
        List<PembelianBarangModel> listPembelianBarang = pembelianBarangService.getPembelianBarangList();
        model.addAttribute("listPembelian", listPembelian);
        model.addAttribute("listPembelianBarang", listPembelianBarang);
        return "daftar_pembelian";
    }

    @GetMapping("/pembelian/{idPembelian}")
    public String viewDetailPembelian(@PathVariable Long idPembelian, Model model) {
        List<PembelianBarangModel> listPembelianBarangModel = pembelianBarangService.getPembelianBarangList();
        List<PembelianBarangModel> returnedPBList = new ArrayList<>();

        for (PembelianBarangModel pb : listPembelianBarangModel) {
            if (pb.getPembelian().getIdPembelian().equals(idPembelian)) {
                returnedPBList.add(pb);
            }
        }
        PembelianModel x = pembelianService.findByIdPembelian(idPembelian);
        List<PembelianBarangModel> listPembelianBarang = pembelianBarangService.getPembelianBarangList();
        model.addAttribute("pembelian", x);
        model.addAttribute("listPembelianBarang", returnedPBList);
        return "detail_pembelian";
    }

    @GetMapping("/filter-pembelian")
    public String cariPembelianForm(Model model) {
        List<MemberModel> listMember = memberService.getMemberList();
        model.addAttribute("listMember", listMember);
        return "cari_pembelian";
    }

    @GetMapping("/filter-pembelian/cari/pembelian")
    public String cariPembelianResult(@RequestParam(value = "idMember") Long idMember,
                                @RequestParam(value = "tipePembayaran") Boolean isCicilan,
                                Model model) {
        List<MemberModel> listMember = memberService.getMemberList();
        model.addAttribute("listMember", listMember);
        List<PembelianModel> returnedList = new ArrayList<>();
        List<PembelianModel> listPembelian = pembelianService.getPembelianList();
        for (PembelianModel pm : listPembelian) {
            if(pm.getMember().getIdMember().equals(idMember)) {
                if(isCicilan) {
                    if (pm.isCash()) {
                        returnedList.add(pm);
                    }
                } else {
                    if (!pm.isCash()) {
                        returnedList.add(pm);
                    }
                }
            }
        }
        model.addAttribute("listPembelian", returnedList);
        return "cari_pembelian_sukses";
    }

    @GetMapping("/pembelian/tambah")
    public String formTambahPembelian(Model model) {
        return "tambah_pembelian";
    }
    @PostMapping("/pembelian/tambah")
    public String submitTambahPembelian(Model model) {
        return "tambah_pembelian";
    }
}
