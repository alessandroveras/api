package br.edu.infnet.apiprofessor.model.service;

import br.edu.infnet.apiprofessor.model.domain.Professor;
import br.edu.infnet.apiprofessor.model.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> obterLista() {
        return (List<Professor>) professorRepository.findAll();
    }

    public List<Professor> obterLista(Integer idUser) {
        return professorRepository.obterLista(idUser, Sort.by(Sort.Direction.ASC, "nome"));
    }

    public void incluir(Professor professor) {
        professorRepository.save(professor);
    }

    public void excluir(Integer id) {
        professorRepository.deleteById(id);
    }

    public Long obterQtde() {
        return professorRepository.count();
    }

    public Professor obterPorId(@PathVariable Integer id) {
        return professorRepository.findById(id).orElse(null);
    }
}