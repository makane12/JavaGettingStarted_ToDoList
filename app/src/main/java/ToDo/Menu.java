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

    public static void processMenuChoice(String input) {
        switch (input) {
            case "1":
//                Display ToDo List
                System.out.println(input + " was returned - DISPLAY");
                try {
                    Display.displayToDoList();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                CallMainMenu.returnToMainMenu();
                break;
            case "2":
//                Add a ToDo List
                System.out.println(input + " was returned - ADD");
                try {
                    Add.addToDoList();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                CallMainMenu.returnToMainMenu();
                break;
            case "3":
//                Edit ToDo List
                System.out.println(input + " was returned - EDIT");
                try {
                    Edit.editToDoList();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                CallMainMenu.returnToMainMenu();
                break;
            case "4":
//                Delete ToDo List
                System.out.println(input + " was returned - DELETE");
                try {
                    Delete.deleteToDoList();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                CallMainMenu.returnToMainMenu();
                break;
            case "5":
//                Exit
                System.out.println(input + " was returned - closing application.");
                System.exit(0);
                break;
            case "Exit":
//                Exit
                System.out.println(input + " was returned - exiting application.");
                System.exit(0);
                break;
            case "exit":
//                exit
                System.out.println(input + " was returned - shutting down application.");
                System.exit(0);
                break;
            case "menu":
//                Return to Main Menu ToDo List
                System.out.println(input + " was returned - RETURN TO MAIN MENU");
                CallMainMenu.returnToMainMenu();
                break;
            case "Menu":
//                Return to Main Menu ToDo List
                System.out.println(input + " was returned - Return to Main Menu");
                CallMainMenu.returnToMainMenu();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + input);
        }
    }
}