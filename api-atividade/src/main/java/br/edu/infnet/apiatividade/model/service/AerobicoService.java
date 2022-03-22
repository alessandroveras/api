package br.edu.infnet.apiatividade.model.service;

import br.edu.infnet.apiatividade.model.domain.Aerobico;
import br.edu.infnet.apiatividade.model.repository.AerobicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AerobicoService {

    @Autowired
    private AerobicoRepository aerobicoRepository;

    public List<Aerobico> obterLista() {
        return (List<Aerobico>) aerobicoRepository.findAll();
    }

    public List<Aerobico> obterLista(Integer idUser) {
        return (List<Aerobico>) aerobicoRepository.obterLista(idUser, Sort.by(Sort.Direction.ASC, "equipamento"));
    }

    public void incluir(Aerobico aerobico) {
        aerobicoRepository.save(aerobico);
    }

    public Aerobico obterPorId(Integer id) {
        return aerobicoRepository.findById(id).orElse(null);
    }

    public Long obterQtde() {
        return aerobicoRepository.count();
    }
}