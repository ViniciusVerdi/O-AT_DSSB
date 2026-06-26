package dssb.at.hospital.dtos.responses;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class InternacaoResponseDTO {
    private UUID id;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataAlta;
    private int quarto;
    private UUID idPaciente;
}
