package ToDo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONObjectMapper {
    public static void main(String[] args) throws IOException {

        //read json file data to String
        byte[] jsonData = Files.readAllBytes(Paths.get("melissa.txt"));

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //convert json string to object
        ToDoList toDoList = objectMapper.readValue(jsonData, ToDoList.class);

        //convert Object to json string
        ToDoList list1 = createList();
        //configure Object mapper for pretty print
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        //writing to console, can write to any output stream such as a file
        StringWriter stringToDoList = new StringWriter();
        objectMapper.writeValue(stringToDoList, list1);
        System.out.println("ToDoList JSON is\n" + stringToDoList);
    }

    private static ToDoList createList() {
        ToDoList list = new ToDoList();
        list.setListTitle("NewListTest");
        list.setFirstName("Melissa");
        list.setLastName("Kane");
        list.setTask1("Remote old siding");
        list.setTask2("Sheeting and Ty-vek");
        list.setTask3("New siding");

        return list;
    }
}
