package ToDo;

import java.time.LocalDate;

public class ToDoItem {
    String name;
    LocalDate dueDate;
    Boolean isCompleted;
    Boolean isStarted;

    public ToDoItem() {}

    public ToDoItem(String name, LocalDate dueDate, Boolean isCompleted, Boolean isStarted) {
        this.name = name;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
        this.isStarted = isStarted;
    }
}
