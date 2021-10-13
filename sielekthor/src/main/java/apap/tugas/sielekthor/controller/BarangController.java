package apap.tugas.sielekthor.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BarangController {

    @GetMapping("/barang")
    public String viewBarang(Model model) {
        return "daftar_barang";
    }

    @GetMapping("/barang/tambah")
    public String viewTambahBarang(Model model) {
        return "tambah_barang";
    }

}
