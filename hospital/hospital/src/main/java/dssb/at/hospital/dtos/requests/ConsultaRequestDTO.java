package dssb.at.hospital.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaRequestDTO {
    private LocalDateTime dataConsulta;
    private String observacoes;
    private UUID idPaciente;
    private UUID idMedico;
}
