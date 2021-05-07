package br.edu.cesmac.nolapi.resources;

import java.net.URI;
import java.util.List;

import br.edu.cesmac.nolapi.service.PartidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.cesmac.nolapi.domain.Partido;

@RestController
@RequestMapping("/partidos")
public class PartidosResources {

	@Autowired
	private PartidosService partidosService;

	@GetMapping
	public List<Partido> listar() {
		return partidosService.listar();
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@Validated @RequestBody Partido partido) {
		partidosService.salvar(partido);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(partido.getIdPartido()).toUri();

		return ResponseEntity.created(uri).build();		
	}

	@PutMapping
	public void atualizar(@RequestBody Partido partido) {
		partidosService.atualizar(partido);
	}

	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable("id") Long idPartido) throws Exception {
		partidosService.deletarPorId(idPartido);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Partido> buscarPorId(@PathVariable("id") Long idPartido) throws Exception {
		Partido partido = partidosService.buscarPorId(idPartido);
		return ResponseEntity.ok(partido);
	}

	@GetMapping (params = "nome")
	public List<Partido> pesquisarPorNome (@RequestParam String nome) {
		return partidosService.perquisarPorNome(nome) ;
	}

}
