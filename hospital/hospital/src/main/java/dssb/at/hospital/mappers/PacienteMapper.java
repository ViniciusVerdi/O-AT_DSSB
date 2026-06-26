package dssb.at.hospital.mappers;

import dssb.at.hospital.dtos.requests.PacienteRequestDTO;
import dssb.at.hospital.dtos.responses.PacienteResponseDTO;
import dssb.at.hospital.entities.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PacienteMapper {
    Paciente toEntity(PacienteRequestDTO requestDTO);
    PacienteResponseDTO toResponse(Paciente entity);
}
