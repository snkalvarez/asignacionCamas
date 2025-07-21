package husjp.api.asignacionCamasMicroservicio.controllers;

import husjp.api.asignacionCamasMicroservicio.service.DiagnosticoService;
import husjp.api.asignacionCamasMicroservicio.service.dto.response.DiagnosticoResDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name = "Bearer Authentication")
@AllArgsConstructor
@RestController
@RequestMapping("/diagnostico")
public class DiagnosticoController {

    private DiagnosticoService diagnosticoService;

    @GetMapping("{idOrName}")
    public ResponseEntity<List<DiagnosticoResDTO>> getDiagnosticoByIdOrName(@PathVariable String idOrName) {
        return ResponseEntity.ok(diagnosticoService.findByIdOrNombre(idOrName));
    }
}
