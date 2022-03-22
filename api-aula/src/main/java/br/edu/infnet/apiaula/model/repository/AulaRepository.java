package br.edu.infnet.apiaula.model.repository;

import br.edu.infnet.apiaula.model.domain.Aula;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AulaRepository extends CrudRepository<Aula, Integer> {

    @Query("from Aula a where a.usuario.id = :userid")
    List<Aula> findAll(Integer userid, Sort by);

    List<Aula> findAll(Sort by);
}