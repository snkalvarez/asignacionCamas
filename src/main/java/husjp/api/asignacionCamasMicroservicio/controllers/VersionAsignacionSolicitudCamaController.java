package husjp.api.asignacionCamasMicroservicio.controllers;

import husjp.api.asignacionCamasMicroservicio.service.VersionAsignacionSolicitudCamaService;
import husjp.api.asignacionCamasMicroservicio.service.dto.request.VersionAsignacionCamaReqDTO;
import husjp.api.asignacionCamasMicroservicio.service.dto.request.VersionAsignacionCamaEditDTO;
import husjp.api.asignacionCamasMicroservicio.service.dto.response.VersionAsignacionCamaResDTO;
import husjp.api.asignacionCamasMicroservicio.service.dto.response.VersionAsignacionSolicitudCamaResDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@SecurityRequirement(name = "Bearer Authentication")
@AllArgsConstructor
@RestController
@RequestMapping("/asignacionVersionSolicitudCama")
public class VersionAsignacionSolicitudCamaController {

    private VersionAsignacionSolicitudCamaService versionAsignacionSolicitudCamaService;

    @PostMapping
    public ResponseEntity<VersionAsignacionCamaResDTO> guardarVersionAsignacionCama(Principal principal, @RequestBody VersionAsignacionCamaReqDTO versionAsignacionCamaReqDTO){
        return ResponseEntity.ok(versionAsignacionSolicitudCamaService.guardarVersionAsignacionCama(versionAsignacionCamaReqDTO, principal.getName()));
    }

    @GetMapping("/active/{idBloqueServicio}")
    public ResponseEntity<List<VersionAsignacionSolicitudCamaResDTO>> getAllVersionAsignacionCamaActivasEnEsperaPorIdBloque(@PathVariable Integer idBloqueServicio){
        return ResponseEntity.ok(versionAsignacionSolicitudCamaService.getVersionAsignacionSolicitudCamaByBloque(idBloqueServicio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VersionAsignacionSolicitudCamaResDTO> editarVersionAsignacion(@PathVariable("id")String idVersionAsignacion, @RequestBody VersionAsignacionCamaEditDTO versionAsignacionCamaEditDTO, Principal principal){
        VersionAsignacionSolicitudCamaResDTO responseDTO = versionAsignacionSolicitudCamaService.editarAsignacion(idVersionAsignacion, versionAsignacionCamaEditDTO, principal.getName());
        return ResponseEntity.ok(responseDTO);
    }


}
