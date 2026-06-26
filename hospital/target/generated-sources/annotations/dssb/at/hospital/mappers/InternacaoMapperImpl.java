package dssb.at.hospital.mappers;

import dssb.at.hospital.dtos.requests.InternacaoRequestDTO;
import dssb.at.hospital.dtos.responses.InternacaoResponseDTO;
import dssb.at.hospital.entities.Internacao;
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
public class InternacaoMapperImpl implements InternacaoMapper {

    @Override
    public Internacao toEntity(InternacaoRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        Internacao internacao = new Internacao();

        internacao.setPaciente( internacaoRequestDTOToPaciente( requestDTO ) );
        internacao.setDataEntrada( requestDTO.getDataEntrada() );
        internacao.setQuarto( requestDTO.getQuarto() );

        return internacao;
    }

    @Override
    public InternacaoResponseDTO toResponse(Internacao entity) {
        if ( entity == null ) {
            return null;
        }

        InternacaoResponseDTO internacaoResponseDTO = new InternacaoResponseDTO();

        internacaoResponseDTO.setIdPaciente( entityPacienteId( entity ) );
        internacaoResponseDTO.setId( entity.getId() );
        internacaoResponseDTO.setDataEntrada( entity.getDataEntrada() );
        internacaoResponseDTO.setDataAlta( entity.getDataAlta() );
        internacaoResponseDTO.setQuarto( entity.getQuarto() );

        return internacaoResponseDTO;
    }

    protected Paciente internacaoRequestDTOToPaciente(InternacaoRequestDTO internacaoRequestDTO) {
        if ( internacaoRequestDTO == null ) {
            return null;
        }

        Paciente paciente = new Paciente();

        paciente.setId( internacaoRequestDTO.getIdPaciente() );

        return paciente;
    }

    private UUID entityPacienteId(Internacao internacao) {
        Paciente paciente = internacao.getPaciente();
        if ( paciente == null ) {
            return null;
        }
        return paciente.getId();
    }
}
