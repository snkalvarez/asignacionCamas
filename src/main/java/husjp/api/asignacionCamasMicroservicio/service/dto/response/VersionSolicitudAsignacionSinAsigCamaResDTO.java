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
public class VersionSolicitudAsignacionSinAsigCamaResDTO {

    private String id;
    private CamaResDTO cama;
    private UsuarioResDTO usuario;
    private String observacion;
    private String enfermeroOrigen;
    private String enfermeroDestino;
    private String extension;
    private String motivo_cancelacion;
    private LocalDateTime fechaCreacion;
    private ServicioResDTO servicio;
}
