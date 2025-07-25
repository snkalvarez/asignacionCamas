package husjp.api.asignacionCamasMicroservicio.service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VersionAsignacionCamaReqDTO {

    private AsignacionCamaReqDTO asignacionCama;
    private CamaReqDTO cama;
    private String observacion;
    private String enfermeroOrigen;
    private String enfermeroDestino;
    private String extension;
    private ServicioReqDTO servicio;

}
