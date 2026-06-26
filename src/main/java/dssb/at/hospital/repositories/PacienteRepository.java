package dssb.at.hospital.repositories;

import dssb.at.hospital.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PacienteRepository  extends JpaRepository<Paciente, UUID> {
    boolean existsByCpf(String cpf);
}
