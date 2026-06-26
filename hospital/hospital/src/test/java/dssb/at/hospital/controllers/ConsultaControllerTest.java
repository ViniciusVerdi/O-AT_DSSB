package dssb.at.hospital.controllers;

import dssb.at.hospital.dtos.requests.ConsultaRequestDTO;
import dssb.at.hospital.dtos.responses.ConsultaResponseDTO;
import dssb.at.hospital.services.ConsultaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(ConsultaController.class)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
//teste
public class ConsultaControllerTest {

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    @MockitoBean
    private ConsultaService service;

    public ConsultaControllerTest(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }

    @Test
    void deveCriarUmaConsultaComSucesso() throws Exception {

        UUID idConsultaGerada = UUID.randomUUID();
        UUID idPaciente = UUID.randomUUID();
        UUID idMedico = UUID.randomUUID();
        LocalDateTime dataConsulta = LocalDateTime.now().plusDays(1);
        String observacao = "Consulta Cardiológica de Rotina";

        ConsultaRequestDTO requestDTO = new ConsultaRequestDTO(
                dataConsulta,
                observacao,
                idPaciente,
                idMedico
        );

        ConsultaResponseDTO responseDTO = new ConsultaResponseDTO(
                idConsultaGerada,
                dataConsulta,
                observacao,
                idPaciente,
                idMedico
        );

        when(this.service.adicionarConsulta(any(ConsultaRequestDTO.class))).thenReturn(responseDTO);

        String jsonString = this.objectMapper.writeValueAsString(requestDTO);

        MockHttpServletResponse response = this.mockMvc.perform(
                        post("/consultas/adicionar")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonString))
                .andDo(print())
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(201);
        assertThat(response.getContentAsString()).contains(idConsultaGerada.toString());
        assertThat(response.getContentAsString()).contains("Consulta Cardiológica de Rotina");
    }
}