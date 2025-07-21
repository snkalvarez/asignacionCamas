package husjp.api.asignacionCamasMicroservicio.controllers;

import husjp.api.asignacionCamasMicroservicio.service.SolicitudCamaService;
import husjp.api.asignacionCamasMicroservicio.service.dto.response.SolicitudCamaResDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SecurityRequirement(name = "Bearer Authentication")
@AllArgsConstructor
@RestController
@RequestMapping("/solicitudCama")
public class SolicitudCamaController {

    private SolicitudCamaService solicitudCamaService;

    @PutMapping("/cancelar/{idSolicitudCama}")
    public ResponseEntity<SolicitudCamaResDTO> cancelarSolicitudMotigo(@PathVariable String idSolicitudCama, @RequestParam(name = "motivo", required = true) String motivo){
        return ResponseEntity.ok(solicitudCamaService.updateMotivoCancelacion(motivo, idSolicitudCama));
    }
}
