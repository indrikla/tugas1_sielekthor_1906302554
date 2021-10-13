package apap.tugas.sielekthor.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name = "pembelian_barang")
public class PembelianBarangModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idPembelianBarang;

    @NotNull
    @Column(name = "tanggal_garansi", nullable = false)
    @DateTimeFormat(pattern = "YYYY-MM-dd")
    private LocalTime tanggalGaransi;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "id_barang", referencedColumnName = "id")
    private BarangModel barang;

    @ManyToOne
    @JoinColumn(name = "id_pembelian", referencedColumnName = "id")
    private PembelianModel pembelian;

}