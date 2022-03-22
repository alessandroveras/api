package br.edu.infnet.apiaula.model.service;

import br.edu.infnet.apiaula.model.domain.Aula;
import br.edu.infnet.apiaula.model.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class AulaService {

    @Autowired
    private AulaRepository aulaRepository;

    public List<Aula> obterLista() {
        return (List<Aula>) aulaRepository.findAll(Sort.by(Sort.Direction.ASC, "data"));
    }

    public List<Aula> obterLista(Integer idUser) {
        return aulaRepository.findAll(idUser, Sort.by(Sort.Direction.ASC, "duracao"));
    }

    public void incluir(Aula aula) {
        aulaRepository.save(aula);
    }

    public void excluir(Integer id) {
        aulaRepository.deleteById(id);
    }

    public Long obterQtde() {
        return aulaRepository.count();
    }

    public Aula obterPorId(@PathVariable Integer id) {
        return aulaRepository.findById(id).orElse(null);
    }

}