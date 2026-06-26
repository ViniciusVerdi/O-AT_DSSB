package dssb.at.hospital.services;

import dssb.at.hospital.dtos.requests.PacienteRequestDTO;
import dssb.at.hospital.dtos.responses.PacienteResponseDTO;
import dssb.at.hospital.entities.Paciente;
import dssb.at.hospital.mappers.PacienteMapper;
import dssb.at.hospital.repositories.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;

    public PacienteService(PacienteRepository pacienteRepository, PacienteMapper pacienteMapper) {
        this.pacienteRepository = pacienteRepository;
        this.pacienteMapper = pacienteMapper;
    }

    public PacienteResponseDTO adicionarPaciente(PacienteRequestDTO dto) {
        if(pacienteRepository.existsByCpf(dto.getCpf())){
            throw new IllegalStateException("Erro: CPF já cadastrado no sistema!");
        };
        Paciente paciente = new Paciente(dto.getNome(), dto.getCpf(), dto.getDataNascimento(), dto.getTelefone());
        Paciente novoPaciente = pacienteRepository.save(paciente);
        return pacienteMapper.toResponse(novoPaciente);
    }

    public PacienteResponseDTO buscarPacientePorId(UUID id) {
        Paciente paciente = buscarPacientePorIdOrThrow(id);
        return pacienteMapper.toResponse(paciente);
    }

    public List<PacienteResponseDTO> obterTodos() {
        return pacienteRepository.findAll().stream()
                .map(pacienteMapper::toResponse)
                .collect(Collectors.toList());
    }
    public void apagarPaciente(UUID id) {
        Paciente paciente = buscarPacientePorIdOrThrow(id);
        pacienteRepository.deleteById(id);
    }

    private Paciente buscarPacientePorIdOrThrow(UUID id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Erro: Paciente não encontrado!"));
    }

}
