package br.edu.infnet.apiatividade.controller;

import br.edu.infnet.apiatividade.model.domain.Aerobico;
import br.edu.infnet.apiatividade.model.service.AerobicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atividade")
public class AerobicoController {

    @Autowired
    private AerobicoService aerobicoService;

    @GetMapping(value = "/{idUser}/listar/aerobico")
    public List<Aerobico> obterLista(@PathVariable Integer idUser) {
        return aerobicoService.obterLista(idUser);
    }

    @GetMapping(value = "/listar/aerobico")
    public List<Aerobico> obterLista() {
        return aerobicoService.obterLista();
    }

    @PostMapping(value = "/incluir/aerobico")
    public void inserir(@RequestBody Aerobico aerobico) {
        aerobicoService.incluir(aerobico);
    }

    @GetMapping(value = "/{id}/aerobico")
    public Aerobico obterPorId(@PathVariable Integer id) {
        return aerobicoService.obterPorId(id);
    }

    @GetMapping(value = "/qtde/aerobico")
    public Long obterQtde() {
        return aerobicoService.obterQtde();
    }

}