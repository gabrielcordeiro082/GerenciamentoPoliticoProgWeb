package br.edu.cesmac.nolapi.service;

import br.edu.cesmac.nolapi.domain.Candidato;
import br.edu.cesmac.nolapi.repository.CandidatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatosService {

	@Autowired
	private CandidatosRepository candidatosRespository;

	public Candidato salvar(Candidato candidato) {
		Candidato candidatoCriado = candidatosRespository.save(candidato);
		return candidatoCriado;
	}

	public Candidato atualizar(Candidato candidato) {
		Candidato candidatoAtualizado = candidatosRespository.save(candidato);
		return candidatoAtualizado;
	}

	public void deletarPorId(Long id) throws Exception {
		Candidato candidatoExclusao = candidatosRespository.findById(id)
				.orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));

		candidatosRespository.deleteById(id);
	}

	public Candidato buscarPorId(Long id) throws Exception {
		return candidatosRespository.findById(id)
				.orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
	}

	public List<Candidato> listar() {
		return candidatosRespository.findAll();
	}

}
