package husjp.api.asignacionCamasMicroservicio.controllers;

import husjp.api.asignacionCamasMicroservicio.service.CamaService;
import husjp.api.asignacionCamasMicroservicio.service.dto.response.CamaSimpleResDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name = "Bearer Authentication")
@AllArgsConstructor
@RestController
@RequestMapping("/cama")
public class CamaController {

    private CamaService camaService;

    @GetMapping("/{idServicio}")
    public ResponseEntity<List<CamaSimpleResDTO>> findAllByServicioId(@PathVariable Integer idServicio) {
        return ResponseEntity.ok( camaService.findAllByServicioId(idServicio));
    }
}
