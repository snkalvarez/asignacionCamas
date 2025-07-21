package husjp.api.asignacionCamasMicroservicio.controllers;

import husjp.api.asignacionCamasMicroservicio.service.MedidasAislamientoService;
import husjp.api.asignacionCamasMicroservicio.service.dto.response.MedidasAislamientoResDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SecurityRequirement(name = "Bearer Authentication")
@AllArgsConstructor
@RestController
@RequestMapping("/medidasAislamiento")
public class MedidasAislamientoController {

    private MedidasAislamientoService medidasAislamientoService;

    @GetMapping
    public ResponseEntity<List<MedidasAislamientoResDTO>> getMedidasAislamiento() {
        return ResponseEntity.ok(medidasAislamientoService.findAll());
    }
}
