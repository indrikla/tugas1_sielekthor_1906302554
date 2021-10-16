package apap.tugas.sielekthor.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "pembelian")
public class PembelianModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idPembelian;

    @NotNull
    @Size(max=255)
    @Column(name = "no_invoice", nullable = false)
    private String noInvoice;

    @NotNull
    @Column(name = "is_cash", nullable = false)
    private boolean isCash;

    @NotNull
    @Size(max=255)
    @Column(name = "nama_admin", nullable = false)
    private String namaAdmin;

    @NotNull
    @Column(name = "total", nullable = false)
    private Integer total;

    @NotNull
    @Column(name = "tanggal_pembelian", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime tanggalPembelian;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_member", referencedColumnName = "id", nullable = false)
    private MemberModel member;

    public Long getIdPembelian() {
        return idPembelian;
    }

    public void setIdPembelian(Long idPembelian) {
        this.idPembelian = idPembelian;
    }

    public String getNoInvoice() {
        return noInvoice;
    }

    public void setNoInvoice(String noInvoice) {
        this.noInvoice = noInvoice;
    }

    public boolean isCash() {
        return isCash;
    }

    public void setCash(boolean cash) {
        isCash = cash;
    }

    public String getNamaAdmin() {
        return namaAdmin;
    }

    public void setNamaAdmin(String namaAdmin) {
        this.namaAdmin = namaAdmin;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public LocalDateTime getTanggalPembelian() {
        return tanggalPembelian;
    }

    public void setTanggalPembelian(LocalDateTime tanggalPembelian) {
        this.tanggalPembelian = tanggalPembelian;
    }

    public MemberModel getMember() {
        return member;
    }

    public void setMember(MemberModel member) {
        this.member = member;
    }
}
