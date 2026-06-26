package dssb.at.hospital.controllers;

import dssb.at.hospital.dtos.requests.MedicoRequestDTO;
import dssb.at.hospital.dtos.responses.MedicoRankingDTO;
import dssb.at.hospital.dtos.responses.MedicoResponseDTO;
import dssb.at.hospital.services.MedicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    private final MedicoService medicoService;
    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<MedicoResponseDTO> adicionarMedico(@RequestBody MedicoRequestDTO medicoRequestDTO) {
        MedicoResponseDTO response = medicoService.adicionarMedico(medicoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/todos")
    public ResponseEntity<List<MedicoResponseDTO>> obterTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(medicoService.obterTodos());
    }

    @GetMapping("/ranking")
    public ResponseEntity<List<MedicoRankingDTO>> getRanking() {
        return ResponseEntity.status(HttpStatus.OK).body(medicoService.rankingMaisConsultasMedicos());
    }

}
