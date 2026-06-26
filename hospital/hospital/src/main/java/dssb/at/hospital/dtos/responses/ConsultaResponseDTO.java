package dssb.at.hospital.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaResponseDTO {
    private UUID id;
    private LocalDateTime dataConsulta;
    private String observacoes;
    private UUID idPaciente;
    private UUID idMedico;
}
