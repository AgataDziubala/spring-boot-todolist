package pl.agatadziubala.ui;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import pl.agatadziubala.domain.Todo;
import pl.agatadziubala.repository.TodoRepository;

import java.util.List;

@SpringComponent
public class TodoLayout extends VerticalLayout {

    @Autowired
    private TodoRepository todoRepository;

    private List<Todo> todos;

    public void updateTodoList() {
        setTodos(todoRepository.findAll());
    }

    public void addTask(Todo todo) {
        todoRepository.save(todo);
        updateTodoList();
    }

    private void setTodos(List<Todo> todos) {
        this.todos = todos;
        removeAllComponents();
        todos.forEach(todo -> addComponent(new TodoItemLayout(todo, todoRepository)));
    }

    public void deleteCompleted() {
        todoRepository.deleteByDone(true);
        updateTodoList();
    }
}
