package husjp.api.asignacionCamasMicroservicio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ingreso")
public class Ingreso {

    @Id
    private String id;
    @Column(name = "fecha_ingreso")
    private LocalDateTime fechaIngreso;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id", foreignKey = @ForeignKey(name = "FK_ingreso_paciente"))
    private Paciente paciente;
}
