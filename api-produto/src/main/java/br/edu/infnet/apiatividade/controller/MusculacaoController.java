package br.edu.infnet.apiatividade.controller;

import br.edu.infnet.apiatividade.model.domain.Musculacao;
import br.edu.infnet.apiatividade.model.service.MusculacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atividade")
public class MusculacaoController {

    @Autowired
    private MusculacaoService musculacaoService;

    @GetMapping(value = "/{idUser}/listar/musculacao")
    public List<Musculacao> obterLista(@PathVariable Integer idUser) {
        return musculacaoService.obterLista(idUser);
    }

    @GetMapping(value = "/listar/musculacao")
    public List<Musculacao> obterLista() {
        return musculacaoService.obterLista();
    }

    @PostMapping(value = "/incluir/musculacao")
    public void inserir(@RequestBody Musculacao musculacao) {
        musculacaoService.incluir(musculacao);
    }

    @GetMapping(value = "/{id}/musculacao")
    public Musculacao obterPorId(@PathVariable Integer id) {
        return musculacaoService.obterPorId(id);
    }

    @GetMapping(value = "/qtde/musculacao")
    public Long obterQtde() {
        return musculacaoService.obterQtde();
    }

}