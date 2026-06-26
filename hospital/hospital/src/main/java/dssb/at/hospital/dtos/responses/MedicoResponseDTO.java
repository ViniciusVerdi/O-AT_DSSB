package dssb.at.hospital.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoResponseDTO {
    private UUID id;
    private String nome;
    private String crm;
    private String especialidade;
}
