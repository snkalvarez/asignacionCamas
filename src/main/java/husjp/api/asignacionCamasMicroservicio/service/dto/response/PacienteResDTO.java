package husjp.api.asignacionCamasMicroservicio.service.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PacienteResDTO {

    private Integer idPersona;
    private String documento;
    private String nombreCompleto;
    private String genero;
    private LocalDate fechaNacimiento;

}
