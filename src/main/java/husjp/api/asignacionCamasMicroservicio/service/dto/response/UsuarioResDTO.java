package husjp.api.asignacionCamasMicroservicio.service.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResDTO {

    private Integer idPersona;
    private String documento;
    private String nombreCompleto;
}
