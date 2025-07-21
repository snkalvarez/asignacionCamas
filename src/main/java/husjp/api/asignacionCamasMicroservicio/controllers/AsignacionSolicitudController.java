package husjp.api.asignacionCamasMicroservicio.controllers;

import husjp.api.asignacionCamasMicroservicio.service.AsignacionSolicitudCamaService;
import husjp.api.asignacionCamasMicroservicio.service.dto.request.AsignacionCamaReqDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SecurityRequirement(name = "Bearer Authentication")
@AllArgsConstructor
@RestController
@RequestMapping("/asignacionSolicitudCama")
public class AsignacionSolicitudController {

    private AsignacionSolicitudCamaService asignacionSolicitudCamaService;

    @PutMapping("/{id}/estadoFinalizado")
    public ResponseEntity<AsignacionCamaReqDTO> editarEstadoFinalizado(@PathVariable  String id){
        AsignacionCamaReqDTO asignacionCamaReqDTO = asignacionSolicitudCamaService.cambiarEstadoFinalizada(id);
        return  ResponseEntity.ok(asignacionCamaReqDTO);
    }

    @Operation(summary = "Cencela la asignacion de cama y setea el motivo de la cancelacion a la ultima version de la asignacion de cama")
    @PutMapping("/{id}/cancelar/motivo/{idVersionAsignacionCama}")
    public ResponseEntity<AsignacionCamaReqDTO> cancelarAsignacionMotivoVersinoAsignacionCama(@PathVariable String id, @PathVariable String idVersionAsignacionCama, @RequestParam(name = "motivo", required = true) String motivo){
        return ResponseEntity.ok(asignacionSolicitudCamaService.cancelarAsignacionSolicitudMotivoVersinoAsignacionCama(id, idVersionAsignacionCama, motivo));
    }

}