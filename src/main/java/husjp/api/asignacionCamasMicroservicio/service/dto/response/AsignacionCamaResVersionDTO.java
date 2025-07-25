package husjp.api.asignacionCamasMicroservicio.service.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AsignacionCamaResVersionDTO {

    private String id;
    private EstadoSolicitudCamaResDTO estado;
    private LocalDateTime fechaInicial;
    private SolicitudCamaResVersionDTO solicitudCama;
}
