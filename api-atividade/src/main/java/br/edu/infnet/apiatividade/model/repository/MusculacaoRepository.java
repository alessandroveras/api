package br.edu.infnet.apiatividade.model.repository;

import br.edu.infnet.apiatividade.model.domain.Musculacao;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusculacaoRepository extends CrudRepository<Musculacao, Integer> {

    @Query("from Musculacao m where m.usuario.id = :userid")
    List<Musculacao> obterLista(Integer userid, Sort by);
}