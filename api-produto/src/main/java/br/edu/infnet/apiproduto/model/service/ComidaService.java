package br.edu.infnet.apiproduto.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.apiproduto.model.domain.Comida;
import br.edu.infnet.apiproduto.model.repository.ComidaRepository;

@Service
public class ComidaService {
	
	@Autowired
	private ComidaRepository comidaRepository;

	public List<Comida> obterLista() {		
		return (List<Comida>) comidaRepository.findAll();
	}
	
	public List<Comida> obterLista(Integer idUser) {		
		return (List<Comida>) comidaRepository.obterLista(idUser, Sort.by(Sort.Direction.ASC, "descricao"));
	}

	public void incluir(Comida comida) {
		comidaRepository.save(comida);
	}

	public Comida obterPorId(Integer id) {
		return comidaRepository.findById(id).orElse(null);
	}

	public Long obterQtde() {
		return comidaRepository.count();
	}
}