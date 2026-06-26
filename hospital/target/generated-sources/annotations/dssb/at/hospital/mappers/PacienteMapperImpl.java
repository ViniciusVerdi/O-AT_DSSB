package dssb.at.hospital.mappers;

import dssb.at.hospital.dtos.requests.PacienteRequestDTO;
import dssb.at.hospital.dtos.responses.PacienteResponseDTO;
import dssb.at.hospital.entities.Paciente;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-25T23:12:42-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
@Component
public class PacienteMapperImpl implements PacienteMapper {

    @Override
    public Paciente toEntity(PacienteRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        Paciente paciente = new Paciente();

        paciente.setNome( requestDTO.getNome() );
        paciente.setCpf( requestDTO.getCpf() );
        paciente.setDataNascimento( requestDTO.getDataNascimento() );
        paciente.setTelefone( requestDTO.getTelefone() );

        return paciente;
    }

    @Override
    public PacienteResponseDTO toResponse(Paciente entity) {
        if ( entity == null ) {
            return null;
        }

        PacienteResponseDTO pacienteResponseDTO = new PacienteResponseDTO();

        pacienteResponseDTO.setId( entity.getId() );
        pacienteResponseDTO.setNome( entity.getNome() );
        pacienteResponseDTO.setCpf( entity.getCpf() );
        pacienteResponseDTO.setDataNascimento( entity.getDataNascimento() );
        pacienteResponseDTO.setTelefone( entity.getTelefone() );

        return pacienteResponseDTO;
    }
}
