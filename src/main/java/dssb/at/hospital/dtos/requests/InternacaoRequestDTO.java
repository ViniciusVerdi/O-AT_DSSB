package dssb.at.hospital.dtos.requests;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class InternacaoRequestDTO {
    private LocalDateTime dataEntrada;
    private int quarto;
    private UUID idPaciente;
}
