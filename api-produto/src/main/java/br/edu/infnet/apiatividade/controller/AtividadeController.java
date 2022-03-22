package br.edu.infnet.apiatividade.controller;

import br.edu.infnet.apiatividade.model.domain.Atividade;
import br.edu.infnet.apiatividade.model.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atividade")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @GetMapping(value = "/{idUser}/listar")
    public List<Atividade> obterLista(@PathVariable Integer idUser) {
        return atividadeService.obterLista(idUser);
    }

    @GetMapping(value = "/listar")
    public List<Atividade> obterLista() {
        return atividadeService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void inserir(@RequestBody Atividade atividade) {
        atividadeService.incluir(atividade);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        atividadeService.excluir(id);
    }

    @GetMapping(value = "/{id}")
    public Atividade obterPorId(@PathVariable Integer id) {
        return atividadeService.obterPorId(id);
    }

    @GetMapping(value = "/qtde")
    public Long obterQtde() {
        return atividadeService.obterQtde();
    }
}