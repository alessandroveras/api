package br.edu.infnet.apiatividade.model.repository;

import java.util.List;

import br.edu.infnet.apiatividade.model.domain.Atividade;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadeRepository extends CrudRepository<Atividade, Integer> {

	@Query("from Atividade p where p.usuario.id = :userid")
	List<Atividade> obterLista(Integer userid, Sort by);
}