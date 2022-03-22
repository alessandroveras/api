package br.edu.infnet.apisolicitante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apisolicitante.model.domain.Solicitante;
import br.edu.infnet.apisolicitante.model.service.SolicitanteService;

@RestController
@RequestMapping("/api/solicitante")
public class SolicitanteController {
	
	@Autowired
	private SolicitanteService solicitanteService;

	@GetMapping(value = "/listar")
	public List<Solicitante> obterLista() {
		return solicitanteService.obterLista();
	}

	@GetMapping(value = "/{idUser}/listar")
	public List<Solicitante> obterLista(@PathVariable Integer idUser){
		return solicitanteService.obterLista(idUser);
	}	

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Solicitante solicitante) {
		solicitanteService.incluir(solicitante);
	}

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		solicitanteService.excluir(id);
	}
	
	@GetMapping(value = "/qtde")
	public Long obterQtde() {
		return solicitanteService.obterQtde();
	}
	
	@GetMapping(value = "/{id}/obter")
	public Solicitante obterPorId(@PathVariable Integer id) {
		return solicitanteService.obterPorId(id);
	}
}


