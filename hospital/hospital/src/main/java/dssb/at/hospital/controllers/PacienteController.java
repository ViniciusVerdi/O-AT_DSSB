package dssb.at.hospital.controllers;

import dssb.at.hospital.dtos.requests.PacienteRequestDTO;
import dssb.at.hospital.dtos.responses.PacienteResponseDTO;
import dssb.at.hospital.services.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<PacienteResponseDTO> adicionarPaciente (@RequestBody PacienteRequestDTO dto){
        PacienteResponseDTO response = pacienteService.adicionarPaciente(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> adicionarPaciente (@PathVariable UUID id){
        PacienteResponseDTO response = pacienteService.buscarPacientePorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<PacienteResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.obterTodos());
    }
    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        pacienteService.apagarPaciente(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
}
