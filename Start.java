

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
            System.out.println("(4) Edit a task ");
            System.out.println("(5) Show tasks ");
            System.out.println("(6) Show done tasks ");
            System.out.println("(7) Show tasks according to due date ");
            System.out.println("(8) Show tasks according to title ");
            System.out.println("(9) Show tasks according to a selected project ");
            System.out.println("(0) Exit ");
            choice = input.nextLine();
            switch (choice) {
                case "0":
                    //Generally used to indicate successful termination.
                    System.exit(0);
                    break;
                case "1":
                    taskList.addTask();
                    break;
                case "2":
                    System.out.println("Remove a task");
                    taskList.RemoveTask();
                    break;
                case "3":
                    System.out.println("Update a task as done");
                    taskList.markasDone();
                    break;

                case "4":
                    System.out.println("Edit a task ");
                    taskList.editTask();
                    break;
                case "5":
                    System.out.println("List for all tasks");
                    taskList.listTasks();
                    break;
                case "6":
                    System.out.println("List for all done tasks ");
                    taskList.listDoneTasks();
                    break;
                case "7":
                    System.out.println("List for all tasks according to due date ");
                    taskList.listbyDate();
                    break;
                case "8":
                    System.out.println("List for all tasks according to title ");
                    taskList.listbyTitle();
                    break;
                case "9":
                    System.out.println("Enter a project name to see all the tasks for it ");
                    taskList.showProjectTasks();
                    break;





                default:
                    System.out.println("Please enter a valid choice.");
                    break;


            }
        }

        while (true);

    }
}
