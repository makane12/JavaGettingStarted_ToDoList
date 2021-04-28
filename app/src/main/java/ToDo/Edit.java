package ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Edit {

    public static void editToDoList() throws FileNotFoundException {
        PrintStream original = System.out;
        String fileToOpen = getFileName();
        String titleEdit = fileToOpen + ".txt";

        showFileChosen(titleEdit);

        String newToDoText;
        newToDoText = enterNewToDoText(titleEdit);

        updateToDoText(newToDoText, titleEdit);
        displayFileTitleLocation(titleEdit);

        System.setOut(original);
    }

    private static String enterNewToDoText(String title) {
        System.out.println("\n");
        Scanner ss = new Scanner(System.in);
        System.out.println("Enter New Text for ToDoList. Text should be entered on a single line. When done, press Enter." + title);
        String newToDoText;
        newToDoText = ss.nextLine();
        return newToDoText;
    }

    private static void updateToDoText(String newToDoText, String title) throws FileNotFoundException {
        PrintStream writeToFile = new PrintStream("C:\\ToDoList_SavedFiles\\" + title);
        writeToFile.append(newToDoText);
    }

    private static void displayFileTitleLocation(String title) {
        System.out.println("Your new text was successfully saved at  C:\\ToDoList_SavedFiles\\" + title);
    }

    private static void showFileChosen(String title) throws FileNotFoundException {
        System.out.println("\n");
        System.out.println("Displaying Current ToDoList Text for " + title + ":");
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
        System.out.println("Enter name (prefix) of file to edit");
        String fileToOpen;
        fileToOpen = ss.nextLine();
        return fileToOpen;
    }
}
