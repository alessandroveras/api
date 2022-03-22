package br.edu.infnet.apiatividade.model.repository;

import br.edu.infnet.apiatividade.model.domain.Aerobico;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AerobicoRepository extends CrudRepository<Aerobico, Integer> {

    @Query("from Aerobico a where a.usuario.id = :userid")
    List<Aerobico> obterLista(Integer userid, Sort by);
}