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
    private Long id;

    @NotNull
    @Size(max=13)
    @Column(nullable = false)
    private String noInvoice;

    @NotNull
    @Column(nullable = false)
    private boolean isCash;

    @NotNull
    @Size(max=30)
    @Column(nullable = false)
    private String namaAdmin;

    @NotNull
    @Column(nullable = false)
    private Integer total;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd:mm")
    private LocalTime tanggalPembelian;
}
