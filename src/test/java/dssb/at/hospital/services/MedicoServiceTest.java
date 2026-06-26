package dssb.at.hospital.services;

import dssb.at.hospital.dtos.responses.MedicoResponseDTO;
import dssb.at.hospital.entities.Medico;
import dssb.at.hospital.mappers.MedicoMapper;
import dssb.at.hospital.repositories.MedicoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MedicoServiceTest {

    @Mock
    private MedicoRepository repository;

    @Mock
    private MedicoMapper mapper;

    @InjectMocks
    private MedicoService service;

    @Test
    void deveListarTodosOsMedicos() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        Medico m1 = new Medico("Dr. Roberto", "CRM123", "Cardiologista");
        m1.setId(id1);
        Medico m2 = new Medico("Dra. Ana", "CRM456", "Ortopedista");
        m2.setId(id2);

        MedicoResponseDTO dto1 = new MedicoResponseDTO(id1, "Dr. Roberto", "CRM123", "Cardiologista");
        MedicoResponseDTO dto2 = new MedicoResponseDTO(id2, "Dra. Ana", "CRM456", "Ortopedista");

        when(this.repository.findAll()).thenReturn(List.of(m1, m2));

        when(this.mapper.toResponse(m1)).thenReturn(dto1);
        when(this.mapper.toResponse(m2)).thenReturn(dto2);

        List<MedicoResponseDTO> medicos = this.service.obterTodos();

        assertEquals(2, medicos.size());

        assertEquals("Dr. Roberto", medicos.get(0).getNome());
        assertEquals("CRM123", medicos.get(0).getCrm());

        assertEquals("Dra. Ana", medicos.get(1).getNome());
        assertEquals("Ortopedista", medicos.get(1).getEspecialidade());

    }
}