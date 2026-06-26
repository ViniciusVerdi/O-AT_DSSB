package dssb.at.hospital.dtos.requests;

import lombok.Data;

@Data
public class MedicoRequestDTO {
    private String nome;
    private String crm;
    private String especialidade;
}
