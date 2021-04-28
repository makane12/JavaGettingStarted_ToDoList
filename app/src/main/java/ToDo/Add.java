package ToDo;

//import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Add {

    public static void addToDoList() throws FileNotFoundException {
        PrintStream original = System.out;
        String fileName = getFileName();
        String data = getListText();
        String listTitle = fileName + ".txt";

        displayFileTitleLocation(listTitle);
        createFolderSaveFile(listTitle);
        addListTextToFile(data, listTitle);

        System.setOut(original);
    }

    private static void createFolderSaveFile(String listTitle) throws FileNotFoundException {
        try {
            Files.createDirectories(Paths.get("C:\\ToDoList_SavedFiles\\"));
        } catch (IOException e) {
            System.out.println("Unable to create folder C:\\ToDoList_SavedFiles\\.");
            e.printStackTrace();
        }

        PrintStream out = new PrintStream(
                new FileOutputStream("C:\\ToDoList_SavedFiles\\" + listTitle));
        System.setOut(out);
    }

    private static void addListTextToFile(String data, String listTitle) throws FileNotFoundException {
        PrintStream writeToFile = new PrintStream("C:\\ToDoList_SavedFiles\\" + listTitle);
        writeToFile.append(data);
    }

    private static void displayFileTitleLocation(String listTitle) {
        System.out.println("ToDo List File:  " + listTitle + "  saved at  C:\\ToDoList_SavedFiles\\");
    }

    private static String getListText() {
        System.out.println("Enter To Do List Text. Text should be entered on a single line. When done, press Enter.");
        Scanner ln = new Scanner(System.in);
        String data;
        data = ln.nextLine();
        return data;
    }

    private static String getFileName() {
        Scanner ss = new Scanner(System.in);
        System.out.println("Enter name for new ToDo List, then press Enter.");
        String fileName;
        fileName = ss.nextLine();
        return fileName;
    }

    public static void createFirstList() {
        ArrayList<ToDoItem> firstList = new ArrayList<ToDoItem>() {
            {
                new ToDoItem("task1", LocalDate.of(2021, 01, 01), false, false);
            }

            {
                new ToDoItem("task2", LocalDate.of(2021, 02, 02), false, false);
            }

            {
                new ToDoItem("task3", LocalDate.of(2021, 03, 03), false, false);
            }
        };

        writeListToFile(firstList);


    }

    private static void writeListToFile(ArrayList<ToDoItem> taskList) {
        ObjectMapper obj = new ObjectMapper();
        String json = null;
        try {
            json = obj.writeValueAsString(taskList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        FileWriter file = null;
        try {
            file = new FileWriter("C:\\ToDoList_SavedFiles\\firstlist.json");
            file.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}