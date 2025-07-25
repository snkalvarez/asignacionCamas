package husjp.api.asignacionCamasMicroservicio.service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudCamaResDTO {

    private String id;
    private EstadoSolicitudCamaResDTO estado;
    private String fechaInicial;
    private IngresoResDTO ingreso;
    private String motivoCancelacion;
    private List<VersionSolicitudResDTO> versionSolicitud;

}
