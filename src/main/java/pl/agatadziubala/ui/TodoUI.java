package pl.agatadziubala.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import pl.agatadziubala.domain.Todo;
import pl.agatadziubala.repository.TodoRepository;

@Theme("valo")
@SpringUI(path = "")
public  class TodoUI extends UI {

    @Autowired
    TodoRepository todoRepository;

    @Override
    protected void init(VaadinRequest request) {
        final TextField nameField = new TextField();
        nameField.setCaption("Name of task");

        final Button saveButton = new Button("",  clickEvent -> {
            todoRepository.save(new Todo(nameField.getValue()));

        });

        saveButton.setIcon(FontAwesome.PLUS);
        saveButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        setContent(new VerticalLayout(nameField, saveButton));
    }



//    List<Todo> todos = todoRepository.findAll();

}