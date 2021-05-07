package br.edu.cesmac.nolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.cesmac.nolapi.domain.Partido;

import java.util.List;

public interface PartidosRepository extends JpaRepository<Partido, Long> {

}

