package pl.agatadziubala.ui;

import com.vaadin.data.Binder;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import pl.agatadziubala.domain.Todo;

public class TodoItemLayout extends HorizontalLayout {

    private  TextField name;
    private  CheckBox done;

    public TodoItemLayout(Todo todo) {
        name = new TextField();
        done = new CheckBox();

        addComponents(name, done);

        Binder<Todo> binder = new Binder<>(Todo.class);
        binder.bindInstanceFields(this);
        binder.setBean(todo);
    }
}
