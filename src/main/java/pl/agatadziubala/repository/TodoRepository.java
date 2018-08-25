package pl.agatadziubala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.agatadziubala.domain.Todo;

import javax.transaction.Transactional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Transactional
    void deleteByDone(boolean done);
}
