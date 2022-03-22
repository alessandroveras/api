package br.edu.infnet.apiproduto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apiproduto.model.domain.Comida;
import br.edu.infnet.apiproduto.model.service.ComidaService;

@RestController
@RequestMapping("/api/produto")
public class ComidaController {
	
	@Autowired
	private ComidaService comidaService;
	
	@GetMapping(value = "/{idUser}/listar/comida")
	public List<Comida> obterLista(@PathVariable Integer idUser) {
		return comidaService.obterLista(idUser);
	}

	@GetMapping(value = "/listar/comida")
	public List<Comida> obterLista() {
		return comidaService.obterLista();
	}

	@PostMapping(value = "/incluir/comida")
	public void inserir(@RequestBody Comida comida) {
		comidaService.incluir(comida);
	}

	@GetMapping(value = "/{id}/comida")
	public Comida obterPorId(@PathVariable Integer id) {
		return comidaService.obterPorId(id);
	}
	
	@GetMapping(value = "/qtde/comida")
	public Long obterQtde() {
		return comidaService.obterQtde();
	}
	
}