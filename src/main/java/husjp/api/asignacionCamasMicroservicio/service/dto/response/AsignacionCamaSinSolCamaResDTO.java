package husjp.api.asignacionCamasMicroservicio.service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AsignacionCamaSinSolCamaResDTO {

    private String id;
    private EstadoSolicitudCamaResDTO estado;
    private LocalDateTime fechaInicial;
    private VersionSolicitudAsignacionSinAsigCamaResDTO versionSolicitudAsignacion;
}
