package dssb.at.hospital.mappers;

import dssb.at.hospital.dtos.requests.InternacaoRequestDTO;
import dssb.at.hospital.dtos.responses.InternacaoResponseDTO;
import dssb.at.hospital.entities.Internacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InternacaoMapper {
    @Mapping(target = "paciente.id", source = "idPaciente")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataAlta", ignore = true)
    Internacao toEntity(InternacaoRequestDTO requestDTO);

    @Mapping(target = "idPaciente", source = "paciente.id")
    InternacaoResponseDTO toResponse(Internacao entity);
}
