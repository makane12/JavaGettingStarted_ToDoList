package ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Display {
    public static void displayToDoList() {
        String fileToOpen = getFileName();
        String titleDisplay  = fileToOpen + ".txt";

        System.out.println("\n");
        System.out.println("Displaying ToDoList for " + titleDisplay + ":");
        try {
            showFileChosen(titleDisplay);
        } catch (Exception e) {
            System.out.println("File name not found. Returning to Main Menu.");
            CallMainMenu.returnToMainMenu();
        }
    }

    private static void showFileChosen(String title) throws FileNotFoundException {
        File file = new File("C:\\ToDoList_SavedFiles\\" + title);
        Scanner sc = new Scanner(file);
        StringBuffer sb = new StringBuffer();
        while (sc.hasNext()) {
            sb.append(" ").append(sc.nextLine());
        }
        System.out.println(sb);
    }

    private static String getFileName() {
        Scanner ss = new Scanner(System.in);
        System.out.println("Enter name (prefix) of file to display, then press Enter.");
        String fileToOpen;
        fileToOpen = ss.nextLine();
        return fileToOpen;
    }
}