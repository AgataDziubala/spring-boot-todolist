package pl.agatadziubala.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import pl.agatadziubala.domain.Todo;

@Theme("valo")
@SpringUI(path = "")
public class TodoUI extends UI {

    private VerticalLayout rootLayout;

    @Autowired
    private TodoLayout todoLayout;

    @Override
    protected void init(VaadinRequest request) {
        setupLayout();
        addForm();
        addTodoList();
        addDeleteButton();
    }

    private void setupLayout() {
        rootLayout = new VerticalLayout();
        setContent(rootLayout);
    }

    private void addForm() {
        HorizontalLayout formLayout = new HorizontalLayout();

        TextField taskName = new TextField();
        Button saveButton = new Button();
        saveButton.setCaption("Save");

        formLayout.addComponents(taskName, saveButton);
        rootLayout.addComponent(formLayout);

        saveButton.addClickListener(clickEvent -> {
            todoLayout.addTask(new Todo(taskName.getValue()));
            taskName.clear();
            taskName.focus();

        });
        saveButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);
    }

    private void addTodoList() {
        rootLayout.addComponent(todoLayout);
    }

    private void addDeleteButton() {
        Button deleteButton = new Button();
        deleteButton.setCaption("Delete completed");
        rootLayout.addComponent(deleteButton);

        deleteButton.addClickListener(clickEvent -> todoLayout.deleteCompleted());
    }
}