package dssb.at.hospital.dtos.requests;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PacienteRequestDTO {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
}
