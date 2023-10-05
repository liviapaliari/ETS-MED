package br.bosch.ETSMed.Model.Medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

// O Repository que controla o banco, é como se fosse o JPAUtil no Hibernate
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

    Page<Medico> findAllByAtivoTrue(Pageable pageable);
    @Query(
            """
            SELECT m FROM Medico m
            WHERE
            m.ativo = true AND
            m.especialidade = :especialidade AND
            m.id NOT IN(
                SELECT c.medico.id FROM Consulta c
                WHERE c.data = :data
                )
            ORDER BY RAND() LIMIT 1
            """
    )
    Medico escolherMedicoAleatorioLivreNaData(Especialidade especialidade, LocalDateTime data);
}