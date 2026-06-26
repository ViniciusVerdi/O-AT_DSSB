package dssb.at.hospital.controllers;

import dssb.at.hospital.dtos.requests.ConsultaRequestDTO;
import dssb.at.hospital.dtos.responses.ConsultaResponseDTO;
import dssb.at.hospital.services.ConsultaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    private final ConsultaService consultaService;
    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }
    @PostMapping("/adicionar")
    public ResponseEntity<ConsultaResponseDTO> adicionarConsulta(@RequestBody ConsultaRequestDTO consultaRequestDTO) {
        ConsultaResponseDTO response = consultaService.adicionarConsulta(consultaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
