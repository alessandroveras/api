package br.edu.infnet.apipedido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apipedido.model.domain.Pedido;
import br.edu.infnet.apipedido.model.service.PedidoService;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;

	@GetMapping(value = "/listar")
	public List<Pedido> obterLista() {
		return pedidoService.obterLista();
	}

	@GetMapping(value = "/{idUser}/listar")
	public List<Pedido> obterLista(@PathVariable Integer idUser){
		return pedidoService.obterLista(idUser);
	}	

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Pedido pedido) {
		pedidoService.incluir(pedido);
	}

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		pedidoService.excluir(id);
	}
	
	@GetMapping(value = "/qtde")
	public Long obterQtde() {
		return pedidoService.obterQtde();
	}
	
	@GetMapping(value = "/{id}/obter")
	public Pedido obterPorId(@PathVariable Integer id) {
		return pedidoService.obterPorId(id);
	}
}