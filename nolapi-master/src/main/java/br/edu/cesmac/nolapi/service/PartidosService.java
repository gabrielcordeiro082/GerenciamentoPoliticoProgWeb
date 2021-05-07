package br.edu.cesmac.nolapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.cesmac.nolapi.domain.Partido;
import br.edu.cesmac.nolapi.repository.PartidosRepository;

@Service
public class PartidosService {

	@Autowired
	private PartidosRepository partidosRepository;

	public Partido salvar(Partido partido) {
		Partido partidoCriado = partidosRepository.save(partido);
		return partidoCriado;
	}

	public Partido atualizar(Partido partido) {
		Partido partidoAtualizado = partidosRepository.save(partido);
		return partidoAtualizado;
	}

	public void deletarPorId(Long id) throws Exception {
		Partido partidoExclusao = partidosRepository.findById(id)
				.orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));

		partidosRepository.deleteById(id);
	}

	public Partido buscarPorId(Long id) throws Exception {
		return partidosRepository.findById(id)
				.orElseThrow(() -> new Exception("Nenhum registro encontrado com o ID"));
	}

	public List<Partido> listar() {
		return partidosRepository.findAll();
	}

}
