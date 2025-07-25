package husjp.api.asignacionCamasMicroservicio.controllers;

import husjp.api.asignacionCamasMicroservicio.service.TitulosFormacionAcademicaService;
import husjp.api.asignacionCamasMicroservicio.service.dto.response.TitulosFormacionAcacemicaResDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SecurityRequirement(name = "Bearer Authentication")
@AllArgsConstructor
@RestController
@RequestMapping("/titulosFormacionAcademica")
public class TitulosFormacionAcademicaController {

     private TitulosFormacionAcademicaService titulosFormacionAcademicaService;

     @GetMapping("/especialidad")
     public ResponseEntity<List<TitulosFormacionAcacemicaResDTO>> obtenerTitulosDeEspecialidades() {
        return ResponseEntity.ok(titulosFormacionAcademicaService.findAllByEspecialidad());
     }
}
