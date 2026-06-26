package dssb.at.hospital.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Internacao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @Column(name = "data_entrada", nullable = false)
    private LocalDateTime dataEntrada;

    @Column(name = "data_alta")
    private LocalDateTime dataAlta;

    @Column(name = "numero_quarto", nullable = false)
    private int quarto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    public Internacao() {
    }

    public Internacao(LocalDateTime dataEntrada, LocalDateTime dataAlta, int quarto, Paciente paciente) {
        this.dataEntrada = dataEntrada;
        this.dataAlta = dataAlta;
        this.quarto = quarto;
        this.paciente = paciente;
    }
}
