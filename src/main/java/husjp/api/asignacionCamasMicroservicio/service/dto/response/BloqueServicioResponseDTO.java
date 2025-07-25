package husjp.api.asignacionCamasMicroservicio.service.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BloqueServicioResponseDTO {

    private Integer id;
    private String nombre;
    private List<ServicioResDTO> servicios;
}
