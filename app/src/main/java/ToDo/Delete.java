package ToDo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Delete {

    public static void deleteToDoList() throws IOException {
        Scanner ss = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Enter name (prefix) of file to be deleted.");
        String name = ss.nextLine();
        String titleDelete = name + ".txt";
        Path fileToDeletePath = Paths.get("C:\\ToDoList_SavedFiles\\" + titleDelete);

        try {
            Files.delete(fileToDeletePath);
            System.out.println("The file " + titleDelete + " has been Deleted successfully.");
        } catch (IOException e) {
            System.out.println("File name not found or cannot be deleted at this time. Please try again later. Returning to Main Menu.");
        }
    }
}