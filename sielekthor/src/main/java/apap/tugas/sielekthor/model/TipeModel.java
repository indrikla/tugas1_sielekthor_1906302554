package apap.tugas.sielekthor.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "tipe")
public class TipeModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idTipe;

    @NotNull
    @Size(max=255)
    @Column(name = "nama", nullable = false)
    private String namaTipe;

    @NotNull
    @Size(max=255)
    @Column(name = "deskripsiTipe", nullable = false)
    private String deskripsiTipe;

    @OneToMany(mappedBy = "tipe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BarangModel> listBarang;
}
