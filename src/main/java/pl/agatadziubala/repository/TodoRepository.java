package pl.agatadziubala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.agatadziubala.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
