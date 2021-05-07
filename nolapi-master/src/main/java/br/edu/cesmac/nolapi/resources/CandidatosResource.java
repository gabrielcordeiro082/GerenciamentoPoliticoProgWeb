package br.edu.cesmac.nolapi.resources;

import br.edu.cesmac.nolapi.domain.Candidato;
import br.edu.cesmac.nolapi.service.CandidatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/candidatos")
public class CandidatosResource {

	@Autowired
	private CandidatosService candidatosService;

	@GetMapping
	public List<Candidato> listar() {
		return candidatosService.listar();
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@Validated @RequestBody Candidato candidato) {
		candidatosService.salvar(candidato);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(candidato.getIdCandidato()).toUri();

		return ResponseEntity.created(uri).build();		
	}

	@PutMapping
	public void atualizar(@RequestBody Candidato candidato) {
		candidatosService.atualizar(candidato);
	}

	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable("id") Long idCandidato) throws Exception {
		candidatosService.deletarPorId(idCandidato);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Candidato> buscarPorId(@PathVariable("id") Long idCandidato) throws Exception {
		return ResponseEntity.ok(candidatosService.buscarPorId(idCandidato));
	}

	/*
	@GetMapping(value = "/{id}")
	public ResponseEntity<Candidato> buscarPorId(@PathVariable("id") Long idCandidato) throws Exception {
		Candidato candidato = candidatosService.buscarPorId(idCandidato);
		return ResponseEntity.ok(candidato);
	}

	 */

}
