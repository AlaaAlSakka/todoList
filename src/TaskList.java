import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TaskList {

    public  ArrayList<Task> taskList;
    public static ArrayList<Task> doneList = new ArrayList<>();

    public TaskList()
    {
        taskList = new ArrayList<>();
    }

    public void addTask () {
        Task task = new Task();
        Scanner scanner = new Scanner(System.in);
        System.out.println( "Enter the task you want to add" );
        task.title = scanner.nextLine();
        System.out.println( "Enter the due date of this task");
        task.dueDate =scanner.nextLine();
        taskList.add (task);



    }


    public void RemoveTask(){
        String t;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextLine();
        Iterator <Task> it= taskList.iterator();
        while (it.hasNext()){
            Task r =it.next();
            if (t.equals(r.title))
                taskList.remove(r);



        }



    }

    public void listTasks(){
        System.out.println("Tasks are: ");

        for (Task task: taskList){
            System.out.println("\t\t\t" + task.title);
        }

    }

}
