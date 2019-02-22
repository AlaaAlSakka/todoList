

import java.util.Scanner;
public class Start
{

    public static void main(String[] args)
    {
        new Start().myMethod();
    }

    public void myMethod ()
    {
        TaskList taskList =new TaskList();
        //TaskList doneList = new TaskList();
        Task task= new Task();



        Scanner input = new Scanner(System.in);
        String choice = null;

        do
            {
            //Splash screen with options
            System.out.println("----------------------------------------\nPlease Choose an option");
            System.out.println("");
            System.out.println("(1) Add a task ");
            System.out.println("(2) Remove a task ");
            System.out.println("(3) Update a task as done ");
            System.out.println("(4) List all tasks ");
            System.out.println("(5) List all done tasks ");
            System.out.println("(6) List all tasks according to due date ");
            System.out.println("(7) List all tasks according to title ");
            System.out.println("(0) Exit ");
            choice = input.nextLine();
            switch (choice) {
                case "0":
                    //Generally used to indicate successful termination.
                    System.exit(0);
                    break;
                case "1":
                    //choice = input.nextLine();
                    taskList.addTask();
                    break;
                case "2":
                    System.out.println("Remove a task");
                    //choice = input.nextLine();
                    taskList.RemoveTask();
                    break;
                case "3":
                    System.out.println("Update a task as done");
                    //choice = input.nextLine();
                    taskList.markasDone();
                    break;
                case "4":
                    System.out.println("List for all tasks");
                    //choice = input.nextLine();
                    taskList.listTasks();
                    break;
                case "5":
                    System.out.println("List for all done tasks ");
                    //choice = input.nextLine();
                    taskList.listDoneTasks();
                    break;
                case "6":
                    System.out.println("List for all tasks according to due date ");
                    //choice = input.nextLine();
                    taskList.listbyDate();
                    break;
                case "7":
                    System.out.println("List for all tasks according to title ");
                    //choice = input.nextLine();
                    taskList.listbyTitle();
                    break;

                default:
                    System.out.println("Please enter a valid choice.");
                    break;


            }
        }

        while (true);

    }
}
