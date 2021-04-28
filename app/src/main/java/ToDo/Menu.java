package ToDo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public static String mainScreenDisplay() {
        Scanner s = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("****  MAIN MENU  ****");
//        System.out.println("\n");
        System.out.println("1. Display a ToDo List");
        System.out.println("2. Add ToDo List");
        System.out.println("3. Edit ToDo List");
        System.out.println("4. Delete ToDo List");
        System.out.println("5. Exit");
        System.out.println("\n");
        System.out.println("Select Option");
        String u;
        u = s.nextLine();
        return u;
    }

    public static boolean processMenuChoice(String input) {
        boolean returnCode = true;
        switch (input) {
            case "1":
//                Display ToDo List
                System.out.println(input + " was returned - DISPLAY");
                try {
                    Display.displayToDoList();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "2":
//                Add a ToDo List
                System.out.println(input + " was returned - ADD");
                try {
                    Add.createFirstList();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "3":
//                Edit ToDo List
                System.out.println(input + " was returned - EDIT");
                try {
                    Edit.editToDoList();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case "4":
//                Delete ToDo List
                System.out.println(input + " was returned - DELETE");
                try {
                    Delete.deleteToDoList();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "5":
            case "Exit":
            case "exit":
//                Exit
                System.out.println(input + " was returned - closing application.");
                returnCode = false;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + input);
        }
        return returnCode;
    }
}
