package br.edu.infnet.apiproduto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apiproduto.model.domain.Bebida;
import br.edu.infnet.apiproduto.model.service.BebidaService;

@RestController
@RequestMapping("/api/produto")
public class BebidaController {
	
	@Autowired
	private BebidaService bebidaService;
	
	@GetMapping(value = "/{idUser}/listar/bebida")
	public List<Bebida> obterLista(@PathVariable Integer idUser) {
		return bebidaService.obterLista(idUser);
	}

	@GetMapping(value = "/listar/bebida")
	public List<Bebida> obterLista() {
		return bebidaService.obterLista();
	}

	@PostMapping(value = "/incluir/bebida")
	public void inserir(@RequestBody Bebida bebida) {
		bebidaService.incluir(bebida);
	}

	@GetMapping(value = "/{id}/bebida")
	public Bebida obterPorId(@PathVariable Integer id) {
		return bebidaService.obterPorId(id);
	}
	
	@GetMapping(value = "/qtde/bebida")
	public Long obterQtde() {
		return bebidaService.obterQtde();
	}
	
}