package dssb.at.hospital.repositories;

import dssb.at.hospital.entities.Medico;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@TestPropertySource(properties = "spring.sql.init.mode=never")
public class MedicoRepositoryTest {

    private final MedicoRepository repository;

    @Autowired
    public MedicoRepositoryTest(MedicoRepository repository) {
        this.repository = repository;
    }

    @Test
    void deveBuscarUmMedicoPorId() {
        Medico medico = new Medico("Dr. Roberto Santos", "CRM123456", "Cardiologista");

        Medico medicoSalvo = this.repository.save(medico);

        Optional<Medico> medicoRetornado = this.repository.findById(medicoSalvo.getId());

        assertTrue(medicoRetornado.isPresent());
        assertEquals("Dr. Roberto Santos", medicoRetornado.get().getNome());
    }
}