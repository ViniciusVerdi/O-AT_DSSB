package dssb.at.hospital.mappers;

import dssb.at.hospital.dtos.requests.MedicoRequestDTO;
import dssb.at.hospital.dtos.responses.MedicoRankingDTO;
import dssb.at.hospital.dtos.responses.MedicoResponseDTO;
import dssb.at.hospital.dtos.responses.QntdConsultasMedicos;
import dssb.at.hospital.entities.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicoMapper {
    Medico toEntity(MedicoRequestDTO requestDTO);
    MedicoResponseDTO toResponse(Medico entity);
    MedicoRankingDTO toRankingDTO(QntdConsultasMedicos rank);

}
