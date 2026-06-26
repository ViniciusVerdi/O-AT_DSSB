package dssb.at.hospital.repositories;

import dssb.at.hospital.dtos.responses.QntdConsultasMedicos;
import dssb.at.hospital.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MedicoRepository extends JpaRepository<Medico, UUID> {
    boolean existsByCrm(String crm);

    @Query("SELECT m.id AS id, m.nome AS nome, m.especialidade AS especialidade, COUNT(c.id) AS totalConsultas " +
            "FROM Medico m " +
            "LEFT JOIN Consulta c ON c.medico = m " +
            "GROUP BY m.id, m.nome, m.especialidade " +
            "ORDER BY totalConsultas DESC")
    List<QntdConsultasMedicos> findMedicosComContagemDeConsultas();

}
