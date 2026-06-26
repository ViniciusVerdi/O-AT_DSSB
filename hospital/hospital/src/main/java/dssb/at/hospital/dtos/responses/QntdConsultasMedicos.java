package dssb.at.hospital.dtos.responses;

import java.util.UUID;

public interface QntdConsultasMedicos {
    UUID getId();
    String getNome();
    String getEspecialidade();
    Long getTotalConsultas();
}
