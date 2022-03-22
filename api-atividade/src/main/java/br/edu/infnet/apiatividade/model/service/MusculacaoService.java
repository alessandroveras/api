package br.edu.infnet.apiatividade.model.service;

import br.edu.infnet.apiatividade.model.domain.Musculacao;
import br.edu.infnet.apiatividade.model.repository.MusculacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusculacaoService {

    @Autowired
    private MusculacaoRepository musculacaoRepository;

    public List<Musculacao> obterLista() {
        return (List<Musculacao>) musculacaoRepository.findAll();
    }

    public List<Musculacao> obterLista(Integer idUser) {
        return (List<Musculacao>) musculacaoRepository.obterLista(idUser, Sort.by(Sort.Direction.ASC, "grupamentoMuscular"));
    }

    public void incluir(Musculacao musculacao) {
        musculacaoRepository.save(musculacao);
    }

    public Musculacao obterPorId(Integer id) {
        return musculacaoRepository.findById(id).orElse(null);
    }

    public Long obterQtde() {
        return musculacaoRepository.count();
    }
}