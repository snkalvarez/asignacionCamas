package husjp.api.asignacionCamasMicroservicio.service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AsignacionCamaResDTO {

    private String id;
    private EstadoSolicitudCamaResDTO estado;
    private LocalDateTime fechaInicial;
    private  LocalDateTime fechaFinal;
    private SolicitudCamaResDTO solicitudCama;

}
