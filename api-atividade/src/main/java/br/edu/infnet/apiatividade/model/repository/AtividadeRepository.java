package br.edu.infnet.apiatividade.model.repository;

import br.edu.infnet.apiatividade.model.domain.Atividade;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtividadeRepository extends CrudRepository<Atividade, Integer> {

    @Query("from Atividade a where a.usuario.id = :userid")
    List<Atividade> obterLista(Integer userid, Sort by);
}