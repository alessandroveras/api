package br.edu.infnet.apisolicitante.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.apisolicitante.model.domain.Solicitante;
import br.edu.infnet.apisolicitante.model.repository.SolicitanteRepository;

@Service
public class SolicitanteService {
	
	@Autowired
	private SolicitanteRepository solicitanteRepository;

	public List<Solicitante> obterLista() {		
		return (List<Solicitante>) solicitanteRepository.findAll();
	}
	
	public List<Solicitante> obterLista(Integer idUser){
		return solicitanteRepository.obterLista(idUser, Sort.by(Sort.Direction.ASC, "nome"));
	}	

	public void incluir(Solicitante solicitante) {
		solicitanteRepository.save(solicitante);
	}
	
	public void excluir(Integer id) {
		solicitanteRepository.deleteById(id);
	}
	
	public Long obterQtde() {
		return solicitanteRepository.count();
	}
	
	public Solicitante obterPorId(@PathVariable Integer id) {
		return solicitanteRepository.findById(id).orElse(null);
	}
}