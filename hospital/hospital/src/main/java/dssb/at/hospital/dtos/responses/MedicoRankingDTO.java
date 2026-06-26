package dssb.at.hospital.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicoRankingDTO {
    private UUID id;
    private String nome;
    private String especialidade;
    private Long totalConsultas;
}
