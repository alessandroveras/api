package br.edu.infnet.apiaula.controller;

import br.edu.infnet.apiaula.model.domain.Aula;
import br.edu.infnet.apiaula.model.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aula")
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @GetMapping(value = "/listar")
    public List<Aula> obterLista() {
        return aulaService.obterLista();
    }

    @GetMapping(value = "/{idUser}/listar")
    public List<Aula> obterLista(@PathVariable Integer idUser) {
        return aulaService.obterLista(idUser);
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Aula aula) {
        aulaService.incluir(aula);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        aulaService.excluir(id);
    }

    @GetMapping(value = "/qtde")
    public Long obterQtde() {
        return aulaService.obterQtde();
    }

    @GetMapping(value = "/{id}/obter")
    public Aula obterPorId(@PathVariable Integer id) {
        return aulaService.obterPorId(id);
    }
}