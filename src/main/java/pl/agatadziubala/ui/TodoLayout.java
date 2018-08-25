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

    public void updateTodoList() {
        setTodos(todoRepository.findAll());
    }

    public void addTask(Todo todo) {
        todoRepository.save(todo);
        updateTodoList();
    }

    public void setTodos(List<Todo> todos) {
        for (Todo todo : todos) {
            addComponent(new TodoItemLayout(todo));
        }
    }
}
