import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class TaskList
{

    public ArrayList<Task> taskList;
    public ArrayList<Task> doneList = new ArrayList<>();
    Task done = new Task();

    public TaskList()
    {
        taskList = new ArrayList<>();
    }

    public void addTask()
    {
        Task task = new Task();
        String isDone = "notDone";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the project name  ");
        task.setProject(scanner.nextLine());
        System.out.println("Enter the task you want to add");
        task.setTitle(scanner.nextLine());
        System.out.println("Enter the due date of this task in this format dd/MM/yyyy  ");
        String date = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        task.setDueDate(localDate);
        task.setStatus(isDone);




        taskList.add(task);
    }


    public void RemoveTask()
    {
        String t;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextLine();
        Iterator<Task> it = taskList.iterator();
        while (it.hasNext())
        {
            Task r = it.next();
            if (t.equals(r.getTitle()))
            {
                taskList.remove(r);
            }
        }
    }


    public void markasDone()
    {
        String t;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextLine();
        Iterator<Task> it = taskList.iterator();
        while (it.hasNext())
        {
            Task r = it.next();
            if (t.equals(r.getTitle()))
            {
                doneList.add(r);
                done.status();
                String isDone= "Done";
                r.setStatus(isDone);
                //it.remove();
                System.out.println(r.getTitle() + " is done");
                return;
            }
        }

    }


    public void listTasks()
    {
        System.out.println("Tasks are: ");
        for (Task task : taskList)
        {
            System.out.println(task);
        }

    }


    public void listDoneTasks()
    {
        System.out.println("Done tasks are: ");
        for (Task task : doneList) {
            System.out.println("\t\t\t" + task.getTitle());
        }

    }

    public void listbyDate()
    {
        ArrayList dateList = (ArrayList) taskList.clone();
        Collections.sort(dateList);
        for (Object task : dateList)
        {
            System.out.println(task);
        }

    }

    public void listbyTitle()
    {

        taskList.stream()
                .map(x -> x.getTitle())
                .sorted((s1, s2) -> s1.compareToIgnoreCase(s2)  )
                .forEach(details -> System.out.println(details));


    }
}




 /*   public void editTask (Task t)
    {
        System.out.println("Enter new title");
        Scanner scnr =  new Scanner(System.in);
        t.setTitle(scnr.nextLine());
        System.out.println("Enter new title");
         //t.setDueDate(scnr.nextLine());
    }
        String t;
        String t2;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextLine();
        Iterator<Task> it = taskList.iterator();
        while (it.hasNext())
        {
            Task r = it.next();
            if (t.equals(r.getTitle()))
            {
                System.out.println("Enter the new title ") ;
                t2 = scanner.nextLine();




             */


