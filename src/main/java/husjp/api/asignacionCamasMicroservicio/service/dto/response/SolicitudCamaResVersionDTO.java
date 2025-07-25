package husjp.api.asignacionCamasMicroservicio.service.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolicitudCamaResVersionDTO {
    private String id;
    private EstadoSolicitudCamaResDTO estado;
    private String fechaInicial;
    private IngresoResDTO ingreso;
    private String motivoCancelacion;
    private VersionSolicitudSinSolAsigResDTO versionSolicitud;
    
}
