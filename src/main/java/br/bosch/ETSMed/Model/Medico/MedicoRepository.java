package br.bosch.ETSMed.Model.Medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

// O Repository que controla o banco, é como se fosse o JPAUtil no Hibernate
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

    Page<Medico> findAllByAtivoTrue(Pageable pageable);
}