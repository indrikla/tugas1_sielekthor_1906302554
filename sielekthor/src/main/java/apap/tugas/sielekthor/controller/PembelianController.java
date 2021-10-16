package apap.tugas.sielekthor.controller;
import apap.tugas.sielekthor.model.*;
import apap.tugas.sielekthor.service.*;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public String invoiceGenerator(String namaMember, String namaAdmin,
                                   LocalDateTime tanggalpem, Boolean metodePembayaran)  {
//        Angka sesuai karakter pertama nama mamber
        char karakterPertamaMember = namaMember.charAt(0);
        int angkaKarakterPertama = ((int) Character.toUpperCase(karakterPertamaMember) - 64) % 11;

//        Huruf Abjad terakhir nama admin
        char karakterTerakhirAdmin = Character.toUpperCase(namaAdmin.charAt(namaAdmin.length() - 1));

//        Tanggal pembelian bentuk dd mm
        LocalDateTime tanggalPembelian = tanggalpem;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        String text = tanggalPembelian.format(formatter);
        LocalDate parsedDate = LocalDate.parse(text, formatter);
        String tanggal = text.substring(8);
        String bulan = text.substring(5,7);
        String ddmm = tanggal + bulan;

//        Pembayaran
        String pembayaran = (metodePembayaran ? "02" : "01");

//        tanggal pembelian ditambah bulan pembelian di kali dengan 5
        int tanggalInt = Integer.parseInt(tanggal);
        int bulanInt = Integer.parseInt(bulan);
        int aritmatikaTanggal = (tanggalInt + bulanInt) * 5;

        String aritmatikaTanggalStr = Integer.toString(aritmatikaTanggal).length() == 2 ? '0' + Integer.toString(aritmatikaTanggal) : Integer.toString(aritmatikaTanggal);

//        Random char
        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'a');
        char b = (char)(r.nextInt(26) + 'a');
        char b1 = Character.toUpperCase(b);
        char c1 = Character.toUpperCase(c);
        String gabung = "" + c1 + b1;

        String invoiceResult = "" + angkaKarakterPertama + karakterTerakhirAdmin
                + ddmm + pembayaran + aritmatikaTanggalStr + gabung;

        return invoiceResult;
    }

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
        List<MemberModel> listMember = memberService.getMemberList();
        model.addAttribute("listMember", listMember);
        List<BarangModel> listBarang = barangService.getBarangList();
        model.addAttribute("listBarang", listBarang);
        model.addAttribute("pb", new PembelianBarangModel());
        model.addAttribute("pembelian", new PembelianModel());

        return "tambah_pembelian_barang";
    }
    @PostMapping("/pembelian/tambah")
    public String submitTambahPembelian(
            @ModelAttribute PembelianBarangModel pb,
            @ModelAttribute PembelianModel p,
            Model model) {

        p.setMember(memberService.findByIdMember(p.getMember().getIdMember()));
        p.setTanggalPembelian(LocalDateTime.now());

        System.out.println(p.getMember().getNamaMember());
        System.out.println(p.getNamaAdmin());
        System.out.println(p.getTanggalPembelian());
        System.out.println(p.isCash());

        String invoice = invoiceGenerator(p.getMember().getNamaMember(), p.getNamaAdmin(), p.getTanggalPembelian(), p.isCash());
        p.setNoInvoice(invoice);
        System.out.println(p.getNoInvoice());

        BarangModel b = barangService.findByIdBarang(pb.getBarang().getIdBarang());
        pb.setBarang(b);
        pb.setQuantity(pb.getQuantity());
        LocalDate today =  LocalDate.now();
        int jumlahGaransi = b.getJumlahGaransi();
        pb.setTanggalGaransi(today.plusDays(jumlahGaransi));
        System.out.println(pb.getTanggalGaransi());
        int totalHargaPembelian = b.getHargaBarang();
        p.setTotal(totalHargaPembelian * pb.getQuantity());
        pembelianService.addPembelian(p);
        pb.setIdPembelianBarang(p.getIdPembelian());
        pembelianBarangService.addPembelianBarang(pb);
        model.addAttribute("idPembelianBarang", pb.getIdPembelianBarang());
        return "tambah_pembelian_barang_sukses";
    }
}
