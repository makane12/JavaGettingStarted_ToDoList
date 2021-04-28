package ToDo;

public class ToDoList {
    private String listTitle;
    private String firstName;
    private String lastName;
    private String task1;
    private String task2;
    private String task3;

    public String getListTitle() { return listTitle; }
    public void setListTitle(String listTitle) { this.listTitle = listTitle; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void  setLastName(String lastName) { this.lastName = lastName; }

    public String getTask1() { return task1; }
    public void  setTask1(String task1) { this.task1 = task1; }

    public String getTask2() {return task2; }
    public void setTask2(String task2) { this.task2 = task2; }

    public String getTask3() { return task3; }
    public void setTask3(String task3) { this.task3 = task3; }

    @Override
    public String toString() {

        String sb;
        sb = "***** ToDoList Details *****\n" +
                "List Title = " + getListTitle() + "\n" +
                "First Name = " + getFirstName() + "\n" +
                "Last Name = " + getLastName() + "\n" +
                "ToDoItem 1 = " + getTask1() + "\n" +
                "ToDoItem 2 = " + getTask2() + "\n" +
                "ToDoItem 3 = " + getTask3() + "\n" +
                "**************************";
        return sb;

    }







}
