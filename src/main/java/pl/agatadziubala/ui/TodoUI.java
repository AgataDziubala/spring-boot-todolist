package pl.agatadziubala.ui;

import com.vaadin.event.ShortcutAction;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.Position;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;
import pl.agatadziubala.domain.Todo;

//@Theme("valo")
@SpringUI(path = "")
public class TodoUI extends UI {

    private VerticalLayout rootLayout;

    @Autowired
    private TodoLayout todoLayout;

    @Override
    protected void init(VaadinRequest request) {
        setupLayout();
        addHeader();
        addForm();
        addTodoList();
        addDeleteButton();
    }

    private void setupLayout() {
        rootLayout = new VerticalLayout();
        //rootLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(rootLayout);
    }

    private void addForm() {
        HorizontalLayout formLayout = new HorizontalLayout();
        formLayout.setWidth("80%");

        TextField taskName = new TextField();
        Button saveButton = new Button();
        saveButton.setCaption("Save");
        saveButton.addStyleName(ValoTheme.BUTTON_PRIMARY);

        formLayout.addComponentsAndExpand(taskName);
        formLayout.addComponents(saveButton);
        rootLayout.addComponent(formLayout);

        saveButton.addClickListener(clickEvent -> {
            try {
                todoLayout.addTask(new Todo(taskName.getValue()));
            } catch (Exception e) {
                Notification.show("Field can't be empty").setStyleName(ValoTheme.NOTIFICATION_WARNING);
            }
            if (!taskName.getValue().isEmpty()) {
                Notification.show("Task saved!").setPosition(Position.BOTTOM_CENTER);
            }
            taskName.clear();
            taskName.focus();
        });
        saveButton.setClickShortcut(ShortcutAction.KeyCode.ENTER);
    }

    private void addHeader() {
        Label headerName = new Label("Task list");
        headerName.addStyleName(ValoTheme.LABEL_H1);
        Label headerCommand = new Label("Define your task:");
        headerCommand.addStyleName(ValoTheme.LABEL_H2);
        rootLayout.addComponent(headerName);
        rootLayout.setComponentAlignment(headerName, Alignment.MIDDLE_CENTER);
        rootLayout.addComponent(headerCommand);
        rootLayout.setComponentAlignment(headerCommand, Alignment.MIDDLE_LEFT);
    }

    private void addTodoList() {
        rootLayout.addComponent(todoLayout);
    }

    private void addDeleteButton() {
        HorizontalLayout deleteLayout = new HorizontalLayout();

        Button deleteButton = new Button();
        deleteButton.setCaption("Delete completed");
        deleteLayout.addComponent(deleteButton);
        rootLayout.addComponent(deleteButton);

        deleteButton.addClickListener(clickEvent -> {
            todoLayout.deleteCompleted();
            Notification.show("Task deleted").setPosition(Position.BOTTOM_CENTER);
        });

    }
}