package pl.agatadziubala.ui;

import com.vaadin.data.Binder;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import pl.agatadziubala.domain.Todo;
import pl.agatadziubala.repository.TodoRepository;

public class TodoItemLayout extends HorizontalLayout {

    private  TextField name;
    private  CheckBox done;


    TodoRepository todoRepository;

    public TodoItemLayout(Todo todo, TodoRepository todoRepository) {
        setWidth("100%");
        setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);

        name = new TextField();
        done = new CheckBox();
        this.todoRepository = todoRepository;

        addComponents(name, done);

        done.addValueChangeListener(event -> {
            boolean value = event.getValue();
            todo.setDone(value);
            todoRepository.save(todo);
        });

        Binder<Todo> binder = new Binder<>(Todo.class);
        binder.bindInstanceFields(this);
        binder.setBean(todo);

    }
}
