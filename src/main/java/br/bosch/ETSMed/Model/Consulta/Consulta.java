package br.bosch.ETSMed.Model.Consulta;

import br.bosch.ETSMed.Model.Medico.Medico;
import br.bosch.ETSMed.Model.Paciente.Paciente;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "Consultas")
@Entity(name = "Consulta")
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {
    @Id // Indica que é um ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que é o banco (entidade) que vai gerar os IDs
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id") // Referente ao nome da chave estrangeira criada no banco
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private LocalDateTime data;
}