package husjp.api.asignacionCamasMicroservicio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "solicitud_cama")
public class SolicitudCama {

    @Id
    @Column(name = "id_solicitud_cama")
    private String id;
    @Column(name = "fecha_inicial", nullable = false)
    private LocalDateTime fechaInicial;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingreso_id", foreignKey = @ForeignKey(name = "fk_solicitudCama_ingreso"), nullable = false)
    private Ingreso ingreso;
    @ManyToOne
    @JoinColumn(name = "estado_solicitud_cama_id", foreignKey = @ForeignKey(name = "fk_solicitudCama_estadoSolicitudCama"), nullable = false)
    private EstadoSolicitudCama estado;
    @Column(name = "motivo_cancelacion")
    private String motivoCancelacion;

}
