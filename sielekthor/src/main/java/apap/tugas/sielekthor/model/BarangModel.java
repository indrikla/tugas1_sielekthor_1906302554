package apap.tugas.sielekthor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalTime;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "barang")
public class BarangModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idBarang;

    @NotNull
    @Size(max=255)
    @Column(name = "kode_barang", nullable = false)
    private String kodeBarang;

    @NotNull
    @Size(max=255)
    @Column(name = "nama_barang", nullable = false)
    private String namaBarang;

    @NotNull
    @Size(max=255)
    @Column(name = "merk_barang", nullable = false)
    private String merkBarang;

    @NotNull
    @Size(max=255)
    @Column(name = "deskripsi_barang", nullable = false)
    private String deskripsiBarang;

    @NotNull
    @Column(name = "stok", nullable = false)
    private Integer stok;

    @NotNull
    @Column(name = "jumlah_garansi", nullable = false)
    private Integer jumlahGaransi;

    @NotNull
    @Column(name = "harga_barang", nullable = false)
    private Integer hargaBarang;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_tipe", referencedColumnName = "id", nullable = false)
    private TipeModel tipe;
}
