package husjp.api.asignacionCamasMicroservicio.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;
    @Column(unique = true)
    private String documento;
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "servicios_usuarios",
            joinColumns = @JoinColumn(name = "id_persona"),
            inverseJoinColumns = @JoinColumn(name = "id_servicio")
    )
    private Set<Servicio> servicios;

}

