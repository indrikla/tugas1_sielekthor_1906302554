package apap.tugas.sielekthor.controller;
import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.model.MemberModel;
import apap.tugas.sielekthor.model.PembelianModel;
import apap.tugas.sielekthor.service.BarangService;
import apap.tugas.sielekthor.service.MemberService;
import apap.tugas.sielekthor.service.PembelianService;
import apap.tugas.sielekthor.service.TipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberController {

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

    public String invoiceEditor(String invoiceLast, String namaMemberBaru) {
        char karakterPertamaMember = namaMemberBaru.charAt(0);
        int angkaKarakterPertama = ((int) Character.toUpperCase(karakterPertamaMember) - 64) % 11;

        return "" + angkaKarakterPertama + invoiceLast.substring(1);
    }

    @GetMapping("/member")
    public String viewMember(Model model) {
        List<MemberModel> listMember = memberService.getMemberList();
        model.addAttribute("listMember", listMember);
        return "daftar_member";
    }

    @GetMapping("/member/tambah")
    public String formTambahMember(Model model) {
        MemberModel member = new MemberModel();
        model.addAttribute("member", member);
        return "tambah_member";
    }

    @PostMapping("/member/tambah")
    public String submitTambahMember(@ModelAttribute MemberModel member, Model model) {
        memberService.addMember(member);
        model.addAttribute("idMember", member.getIdMember());
        return "tambah_member_sukses";
    }

    @GetMapping("/member/ubah/{idMember}")
    public String formUbahMember(@PathVariable Long idMember, Model model) {
        MemberModel member = memberService.findByIdMember(idMember);
        model.addAttribute("member", member);
        return "ubah_member";
    }

    @PostMapping("/member/ubah")
    public String submitUbahMember(@ModelAttribute MemberModel member,
                                   Model model) {
        List<String> invoice = new ArrayList<>();
        List<String> invoiceLama = new ArrayList<>();
        List<PembelianModel> listPembelian = memberService.findByIdMember(member.getIdMember()).getListPembelian();
        for (PembelianModel pm : listPembelian) {
            invoiceLama.add(pm.getNoInvoice());
            invoice.add(invoiceEditor(pm.getNoInvoice(), member.getNamaMember()));
            pm.setNoInvoice(invoiceEditor(pm.getNoInvoice(), member.getNamaMember()));
        }
        memberService.updateMember(member);
        model.addAttribute("member", member);
        model.addAttribute("invoices", invoice);
        model.addAttribute("invoicesLama", invoiceLama);
        return "ubah_member_sukses";
    }

    @GetMapping("/cari/member/paling-banyak")
    public String cariMember(Model model) {
        List<MemberModel> listMember = memberService.getMemberList();
        List<Integer> jumlahPembelian = new ArrayList<>();
        for (MemberModel m :  listMember) {
            jumlahPembelian.add(m.getListPembelian().size());
        }
        model.addAttribute("listMember", listMember);
        model.addAttribute("jumlahPembelian", jumlahPembelian);
        return "top_member";
    }


}
