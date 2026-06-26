package dssb.at.hospital.mappers;

import dssb.at.hospital.dtos.requests.MedicoRequestDTO;
import dssb.at.hospital.dtos.responses.MedicoRankingDTO;
import dssb.at.hospital.dtos.responses.MedicoResponseDTO;
import dssb.at.hospital.dtos.responses.QntdConsultasMedicos;
import dssb.at.hospital.entities.Medico;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-25T23:12:42-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
@Component
public class MedicoMapperImpl implements MedicoMapper {

    @Override
    public Medico toEntity(MedicoRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        Medico medico = new Medico();

        medico.setNome( requestDTO.getNome() );
        medico.setCrm( requestDTO.getCrm() );
        medico.setEspecialidade( requestDTO.getEspecialidade() );

        return medico;
    }

    @Override
    public MedicoResponseDTO toResponse(Medico entity) {
        if ( entity == null ) {
            return null;
        }

        MedicoResponseDTO medicoResponseDTO = new MedicoResponseDTO();

        medicoResponseDTO.setId( entity.getId() );
        medicoResponseDTO.setNome( entity.getNome() );
        medicoResponseDTO.setCrm( entity.getCrm() );
        medicoResponseDTO.setEspecialidade( entity.getEspecialidade() );

        return medicoResponseDTO;
    }

    @Override
    public MedicoRankingDTO toRankingDTO(QntdConsultasMedicos rank) {
        if ( rank == null ) {
            return null;
        }

        MedicoRankingDTO medicoRankingDTO = new MedicoRankingDTO();

        medicoRankingDTO.setId( rank.getId() );
        medicoRankingDTO.setNome( rank.getNome() );
        medicoRankingDTO.setEspecialidade( rank.getEspecialidade() );
        medicoRankingDTO.setTotalConsultas( rank.getTotalConsultas() );

        return medicoRankingDTO;
    }
}
