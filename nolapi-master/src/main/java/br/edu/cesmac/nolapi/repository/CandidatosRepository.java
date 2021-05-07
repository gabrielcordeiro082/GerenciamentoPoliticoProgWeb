package br.edu.cesmac.nolapi.repository;

import br.edu.cesmac.nolapi.domain.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatosRepository extends JpaRepository<Candidato, Long> {

}
