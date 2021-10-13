package apap.tugas.sielekthor.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PembelianController {

    @GetMapping("/pembelian")
    public String viewPembelian(Model model) {
        return "daftar_pembelian";
    }

    @GetMapping("/pembelian/tambah")
    public String formTambahPembelian(Model model) {
        return "form_tambah_pembelian";
    }
    @PostMapping("/pembelian/tambah")
    public String submitTambahPembelian(Model model) {
        return "form_tambah_pembelian";
    }
}
