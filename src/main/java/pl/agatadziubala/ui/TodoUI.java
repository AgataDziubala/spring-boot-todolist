package pl.agatadziubala.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import pl.agatadziubala.domain.Todo;
import pl.agatadziubala.repository.TodoRepository;

import java.util.List;

@Theme("valo")
@SpringUI(path = "")
public  class TodoUI extends UI {

    @Autowired
    TodoRepository todoRepository;

    @Override
    protected void init(VaadinRequest request) {
    }

    List<Todo> todos = todoRepository.findAll();

}