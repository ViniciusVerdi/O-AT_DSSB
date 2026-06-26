package dssb.at.hospital.services;

import dssb.at.hospital.dtos.requests.MedicoRequestDTO;
import dssb.at.hospital.dtos.responses.MedicoRankingDTO;
import dssb.at.hospital.dtos.responses.MedicoResponseDTO;
import dssb.at.hospital.entities.Medico;
import dssb.at.hospital.mappers.MedicoMapper;
import dssb.at.hospital.repositories.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoService {
    private final MedicoRepository medicoRepository;
    private final MedicoMapper medicoMapper;

    public MedicoService(MedicoRepository medicoRepository, MedicoMapper medicoMapper) {
        this.medicoRepository = medicoRepository;
        this.medicoMapper = medicoMapper;
    }
    public MedicoResponseDTO adicionarMedico(MedicoRequestDTO dto) {
        if(medicoRepository.existsByCrm(dto.getCrm())){
            throw new IllegalStateException("Erro: CRM já cadastrado no sistema!");
        };
        Medico medico = new Medico(dto.getNome(), dto.getCrm(), dto.getEspecialidade());
        Medico novoMedico = medicoRepository.save(medico);
        return medicoMapper.toResponse(novoMedico);
    }
    public List<MedicoResponseDTO> obterTodos() {
        return medicoRepository.findAll().stream()
                .map(medicoMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<MedicoRankingDTO> rankingMaisConsultasMedicos() {
        return medicoRepository.findMedicosComContagemDeConsultas().stream()
                .map(medicoMapper::toRankingDTO)
                .collect(Collectors.toList());
    }
}
