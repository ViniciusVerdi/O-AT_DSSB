package dssb.at.hospital.dtos.responses;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class PacienteResponseDTO {
    private UUID id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
}
