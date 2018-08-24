package pl.agatadziubala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.agatadziubala.domain.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
