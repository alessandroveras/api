package br.edu.infnet.apiatividade.model.service;

import br.edu.infnet.apiatividade.model.domain.Atividade;
import br.edu.infnet.apiatividade.model.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public List<Atividade> obterLista() {
        return (List<Atividade>) atividadeRepository.findAll();
    }

    public List<Atividade> obterLista(Integer idUser) {
        return atividadeRepository.obterLista(idUser, Sort.by(Sort.Direction.ASC, "descricao"));
    }

    public void excluir(Integer id) {
        atividadeRepository.deleteById(id);
    }

    public Atividade obterPorId(Integer id) {
        return atividadeRepository.findById(id).orElse(null);
    }

    public Long obterQtde() {
        return atividadeRepository.count();
    }

    public void incluir(Atividade atividade) {
        atividadeRepository.save(atividade);
    }
}