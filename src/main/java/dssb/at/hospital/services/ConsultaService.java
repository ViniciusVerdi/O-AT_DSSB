package dssb.at.hospital.services;

import dssb.at.hospital.dtos.requests.ConsultaRequestDTO;
import dssb.at.hospital.dtos.responses.ConsultaResponseDTO;
import dssb.at.hospital.entities.Consulta;
import dssb.at.hospital.mappers.ConsultaMapper;
import dssb.at.hospital.repositories.ConsultaRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {
    private final ConsultaRepository consultaRepository;
    private final ConsultaMapper consultaMapper;

    public ConsultaService(ConsultaRepository consultaRepository, ConsultaMapper consultaMapper) {
        this.consultaRepository = consultaRepository;
        this.consultaMapper = consultaMapper;
    }

    public ConsultaResponseDTO adicionarConsulta (ConsultaRequestDTO dto) {
        Consulta consulta = consultaMapper.toEntity(dto);
        Consulta novaConsulta = consultaRepository.save(consulta);
        return consultaMapper.toResponse(novaConsulta);

    }
}
