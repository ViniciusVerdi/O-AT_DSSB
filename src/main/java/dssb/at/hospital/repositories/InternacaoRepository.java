package dssb.at.hospital.repositories;

import dssb.at.hospital.entities.Internacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InternacaoRepository extends JpaRepository<Internacao, UUID> {
}
