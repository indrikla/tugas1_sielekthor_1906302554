package apap.tugas.sielekthor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Table(name = "barang")
public class BarangModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=16)
    @Column(nullable = false)
    private String kodeBarang;

    @NotNull
    @Size(max=30)
    @Column(nullable = false)
    private String nama;

    @NotNull
    @Size(max=30)
    @Column(nullable = false)
    private String merk;

    @NotNull
    @Size(max=100)
    @Column(nullable = false)
    private String deskripsiBarang;

    @NotNull
    @Column(nullable = false)
    private Integer stok;

    @NotNull
    @Column(nullable = false)
    private Integer jumlahGaransi;

//    @ManyToMany
//    @JoinTable(
//            name = "film_bioskop",
//            joinColumns = @JoinColumn(name = "no_bioskop"),
//            inverseJoinColumns = @JoinColumn(name = "no_film"))
//    List<FilmModel> listFilm;

}
