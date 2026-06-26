package dssb.at.hospital.mappers;

import dssb.at.hospital.dtos.requests.ConsultaRequestDTO;
import dssb.at.hospital.dtos.responses.ConsultaResponseDTO;
import dssb.at.hospital.entities.Consulta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ConsultaMapper {
    
    @Mapping(target = "paciente.id", source = "idPaciente")
    @Mapping(target = "medico.id", source = "idMedico")
    @Mapping(target = "id", ignore = true)
    Consulta toEntity(ConsultaRequestDTO requestDTO);

    @Mapping(target = "idPaciente", source = "paciente.id")
    @Mapping(target = "idMedico", source = "medico.id")
    ConsultaResponseDTO toResponse(Consulta entity);

}
