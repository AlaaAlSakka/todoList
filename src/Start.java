

import java.util.Scanner;
public class Start {

    public static void main(String[] args) {
        new Start().myMethod();
    }

    public void myMethod () {
        TaskList taskList =new TaskList();


        Scanner input = new Scanner(System.in);
        String choice = null;

        do {
            //Splash screen with options
            System.out.println("----------------------------------------\nPlease Choose an option");
            System.out.println("");
            System.out.println("(1) Add a task ");
            System.out.println("(2) Remove a task ");
            System.out.println("(3) Update a task ");
            System.out.println("(4) List all tasks ");
            System.out.println("(5) List all done tasks ");
            System.out.println("(0) Exit ");
            choice = input.nextLine();
            switch (choice) {
                case "1":
                    //System.out.println("Add a task ");
                    //choice = input.nextLine();
                    taskList.addTask();
                    break;
                case "2":
                    System.out.println("Remove a task");
                    //choice = input.nextLine();
                    taskList.RemoveTask();
                    break;
                case "3":
                    System.out.println("Update a task");
                    choice = input.nextLine();
                    break;
                case "4":
                    System.out.println("List all tasks");
                    //choice = input.nextLine();
                    taskList.listTasks();
                    break;
                case "5":
                    System.out.println("List all done tasks ");
                    choice = input.nextLine();
                    //  taskList.doneTask();
                    break;





            }
        }
        while (Integer.parseInt(choice) > 0);

        System.out.println("Exit");
    }
}
