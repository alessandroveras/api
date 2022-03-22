package br.edu.infnet.apiprofessor.model.repository;

import br.edu.infnet.apiprofessor.model.domain.Professor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Integer> {


    @Query("from Professor s where s.usuario.id = :userid")
    List<Professor> obterLista(Integer userid, Sort by);
}