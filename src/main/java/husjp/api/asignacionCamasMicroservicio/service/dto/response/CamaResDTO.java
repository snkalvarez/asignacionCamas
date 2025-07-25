package husjp.api.asignacionCamasMicroservicio.service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CamaResDTO {

    private Integer id;
    private String nombre;
    private String codigo;
    private ServicioResDTO servicio;
    private SubSeccionesServicioResDTO subseccion;
    private CamaEstadoResDTO camaEstado;
}
