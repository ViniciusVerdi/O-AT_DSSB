package dssb.at.hospital.mappers;

import dssb.at.hospital.dtos.requests.ConsultaRequestDTO;
import dssb.at.hospital.dtos.responses.ConsultaResponseDTO;
import dssb.at.hospital.entities.Consulta;
import dssb.at.hospital.entities.Medico;
import dssb.at.hospital.entities.Paciente;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-25T23:12:42-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
@Component
public class ConsultaMapperImpl implements ConsultaMapper {

    @Override
    public Consulta toEntity(ConsultaRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        Consulta consulta = new Consulta();

        consulta.setPaciente( consultaRequestDTOToPaciente( requestDTO ) );
        consulta.setMedico( consultaRequestDTOToMedico( requestDTO ) );
        consulta.setDataConsulta( requestDTO.getDataConsulta() );
        consulta.setObservacoes( requestDTO.getObservacoes() );

        return consulta;
    }

    @Override
    public ConsultaResponseDTO toResponse(Consulta entity) {
        if ( entity == null ) {
            return null;
        }

        ConsultaResponseDTO consultaResponseDTO = new ConsultaResponseDTO();

        consultaResponseDTO.setIdPaciente( entityPacienteId( entity ) );
        consultaResponseDTO.setIdMedico( entityMedicoId( entity ) );
        consultaResponseDTO.setId( entity.getId() );
        consultaResponseDTO.setDataConsulta( entity.getDataConsulta() );
        consultaResponseDTO.setObservacoes( entity.getObservacoes() );

        return consultaResponseDTO;
    }

    protected Paciente consultaRequestDTOToPaciente(ConsultaRequestDTO consultaRequestDTO) {
        if ( consultaRequestDTO == null ) {
            return null;
        }

        Paciente paciente = new Paciente();

        paciente.setId( consultaRequestDTO.getIdPaciente() );

        return paciente;
    }

    protected Medico consultaRequestDTOToMedico(ConsultaRequestDTO consultaRequestDTO) {
        if ( consultaRequestDTO == null ) {
            return null;
        }

        Medico medico = new Medico();

        medico.setId( consultaRequestDTO.getIdMedico() );

        return medico;
    }

    private UUID entityPacienteId(Consulta consulta) {
        Paciente paciente = consulta.getPaciente();
        if ( paciente == null ) {
            return null;
        }
        return paciente.getId();
    }

    private UUID entityMedicoId(Consulta consulta) {
        Medico medico = consulta.getMedico();
        if ( medico == null ) {
            return null;
        }
        return medico.getId();
    }
}
