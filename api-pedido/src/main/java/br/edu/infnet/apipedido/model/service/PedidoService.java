package br.edu.infnet.apipedido.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.apipedido.model.domain.Pedido;
import br.edu.infnet.apipedido.model.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	public List<Pedido> obterLista() {		
		return (List<Pedido>) pedidoRepository.findAll(Sort.by(Sort.Direction.ASC, "data"));
	}
	
	public List<Pedido> obterLista(Integer idUser){
		return pedidoRepository.findAll(idUser, Sort.by(Sort.Direction.ASC, "descricao"));
	}	

	public void incluir(Pedido pedido) {
		pedidoRepository.save(pedido);
	}
	
	public void excluir(Integer id) {
		pedidoRepository.deleteById(id);
	}
	
	public Long obterQtde() {
		return pedidoRepository.count();
	}
	
	public Pedido obterPorId(@PathVariable Integer id) {
		return pedidoRepository.findById(id).orElse(null);
	}
	
}