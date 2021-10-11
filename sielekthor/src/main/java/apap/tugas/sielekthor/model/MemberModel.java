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
@Table(name = "member")
public class MemberModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=30)
    @Column(nullable = false)
    private String namaMember;

    @NotNull
    @Size(max=30)
    @Column(nullable = false)
    private String jenisKelamin;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd/mm/yy")
    private LocalTime tanggalLahir;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yy-mm-dd")
    private LocalTime tanggalPendaftaran;
}
