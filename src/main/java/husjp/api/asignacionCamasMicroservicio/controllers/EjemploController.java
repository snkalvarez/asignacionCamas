package husjp.api.asignacionCamasMicroservicio.controllers;

import husjp.api.asignacionCamasMicroservicio.service.EjemploService;
import husjp.api.asignacionCamasMicroservicio.service.dto.EjemploDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@SecurityRequirement(name = "Bearer Authentication")
@AllArgsConstructor
@RestController
@RequestMapping("/ejemplo")
public class EjemploController {

    private EjemploService ejemploService;

    @Operation(summary = "Obtiene el ejemplo")
    @GetMapping()
    public ResponseEntity<List<EjemploDTO>> getAllEjemplo(){
        return ResponseEntity.ok(ejemploService.getAllEjemplo());
    }
    @GetMapping("/fecha")
    public ResponseEntity<LocalDateTime> getFecha() {
        LocalDateTime fecha = LocalDateTime.now();
        return ResponseEntity.ok(fecha);
    }
}
