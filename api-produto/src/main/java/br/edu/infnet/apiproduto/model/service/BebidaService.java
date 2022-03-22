package br.edu.infnet.apiproduto.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.apiproduto.model.domain.Bebida;
import br.edu.infnet.apiproduto.model.repository.BebidaRepository;

@Service
public class BebidaService {
	
	@Autowired
	private BebidaRepository bebidaRepository;

	public List<Bebida> obterLista() {		
		return (List<Bebida>) bebidaRepository.findAll();
	}
	
	public List<Bebida> obterLista(Integer idUser) {		
		return (List<Bebida>) bebidaRepository.obterLista(idUser, Sort.by(Sort.Direction.ASC, "descricao"));
	}

	public void incluir(Bebida bebida) {
		bebidaRepository.save(bebida);
	}

	public Bebida obterPorId(Integer id) {
		return bebidaRepository.findById(id).orElse(null);
	}

	public Long obterQtde() {
		return bebidaRepository.count();
	}
}