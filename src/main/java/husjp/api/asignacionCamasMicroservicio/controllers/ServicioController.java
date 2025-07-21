package husjp.api.asignacionCamasMicroservicio.controllers;

import husjp.api.asignacionCamasMicroservicio.service.ServicioService;
import husjp.api.asignacionCamasMicroservicio.service.dto.response.ServicioResDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecurityRequirement(name = "Bearer Authentication")
@AllArgsConstructor
@RestController
@RequestMapping("/servicio")
public class ServicioController {

    private ServicioService servicioService;

    @GetMapping("/{idBloqueServicio}")
    public ResponseEntity<List<ServicioResDTO>> findAllByBloqueServicioId(@PathVariable Integer idBloqueServicio) {
        return ResponseEntity.ok( servicioService.findAllByBloqueServicioId(idBloqueServicio));
    }
}
