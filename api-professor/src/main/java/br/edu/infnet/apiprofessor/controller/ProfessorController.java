package br.edu.infnet.apiprofessor.controller;

import br.edu.infnet.apiprofessor.model.domain.Professor;
import br.edu.infnet.apiprofessor.model.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping(value = "/listar")
    public List<Professor> obterLista() {
        return professorService.obterLista();
    }

    @GetMapping(value = "/{idUser}/listar")
    public List<Professor> obterLista(@PathVariable Integer idUser) {
        return professorService.obterLista(idUser);
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Professor professor) {
        professorService.incluir(professor);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        professorService.excluir(id);
    }

    @GetMapping(value = "/qtde")
    public Long obterQtde() {
        return professorService.obterQtde();
    }

    @GetMapping(value = "/{id}/obter")
    public Professor obterPorId(@PathVariable Integer id) {
        return professorService.obterPorId(id);
    }
}


