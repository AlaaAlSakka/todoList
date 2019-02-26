import java.time.format.DateTimeParseException;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;




public class TaskList {

    public ArrayList<Task> taskList;
    public ArrayList<Task> doneList = new ArrayList<>();
    Task done = new Task();

    public TaskList() {
        taskList = new ArrayList<>();
    }

    public void addTask() {
        Task task = new Task();
        String isDone = "notDone";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the project name  ");
        task.setProject(scanner.nextLine());
        System.out.println("Enter the task you want to add");
        task.setTitle(scanner.nextLine());
        System.out.println("Enter the due date of this task in this format: dd/MM/yyyy  ");



        String date = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//boolean df = false;

        //  while (df =false) {


            try {

                LocalDate parse = LocalDate.parse(date, formatter);
                task.setDueDate(parse);
            } catch (DateTimeParseException exc) {
                System.out.printf("Enter the right format for the data dd/MM/yyyy ");
            }




        task.setStatus(isDone);
        taskList.add(task);


/*
        String input = null;
        try {
            DateTimeFormatter f =
                    DateTimeFormatter.ofPattern("MMM d yyyy");
            LocalDate d = LocalDate.parse(input, f);
            System.out.printf("%s%n", d);
        }
        catch (DateTimeParseException exc) {
            System.out.printf("%s is not parsable!%n", input);
            throw exc;      // Rethrow the exception.
        }

      /*
      try {
            LocalDate parse = LocalDate.parse(date, formatter);
          //Fail ("Should have failed");
        } catch (DateTimeParseException ex) {
            // expected
        }

         */
    }


    public void RemoveTask() {
        String t;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextLine();
        Iterator<Task> it = taskList.iterator();
        while (it.hasNext()) {
            Task r = it.next();
            if (t.equals(r.getTitle())) {
                taskList.remove(r);
            }
        }
    }


    public void markasDone() {
        String t;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextLine();
        Iterator<Task> it = taskList.iterator();
        while (it.hasNext()) {
            Task r = it.next();
            if (t.equals(r.getTitle())) {
                doneList.add(r);
                done.status();
                String isDone = "Done";
                r.setStatus(isDone);
                //it.remove();
                System.out.println(r.getTitle() + " is done");
                return;
            }
        }

    }

    public void editTask() {
        String t;

        System.out.println("Which task do you want to edit?");
        Scanner scanner = new Scanner(System.in);
        Iterator<Task> it = taskList.iterator();
        t = scanner.nextLine();

        while (it.hasNext()) {
            Task r = it.next();
            if (t.equals(r.getTitle())) {
                taskList.remove(r);
                System.out.println("Enter the new title");
                Scanner scnr = new Scanner(System.in);
                String isDone = "notDone";
                r.setTitle(scanner.nextLine());
                System.out.println("Enter the due date of this task in this format: dd/MM/yyyy ");
                String date = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate localDate = LocalDate.parse(date, formatter);
                r.setDueDate(localDate);
                taskList.add(r);
            }
        }
    }

    public void listTasks() {
        System.out.println("Tasks are: ");
        for (Task task : taskList) {
            System.out.println(task);
        }

    }


    public void listDoneTasks() {
        System.out.println("Done tasks are: ");
        for (Task task : doneList) {
            System.out.println("\t\t\t" + task.getTitle());
        }

    }

    public void listbyDate() {
        ArrayList dateList = (ArrayList) taskList.clone();
        Collections.sort(dateList);
        for (Object task : dateList) {
            System.out.println(task);
        }

    }

    public void listbyTitle() {
        taskList.stream()
                .sorted(new TaskComparator())
                .forEach(x -> System.out.println(x.getTitle() + "-------- project: " + x.getProject() + "--------" + x.getDueDate() + "--------" + x.getStatus()));


    }


    public void showProjectTasks() {

        ArrayList projectList = (ArrayList) taskList.clone();
        String p;
        Scanner scanner = new Scanner(System.in);
        p = scanner.nextLine();
        Iterator<Task> it = projectList.iterator();
        while (it.hasNext()) {
            Task r = it.next();
            if (p.equals(r.getProject())) {
                {
                    System.out.println(r);
                }
            }
        }
    }


}



  /*  public void listbyProject(String projectName)
    {
        taskList.stream()
                .filter(x -> x.getProject().equalsIgnoreCase(projectName))
//                .sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
                .forEach(x -> System.out.println(x ));
        //System.out.println(getDetails);
    }

  public void listbyTitle()
    {
//        taskList.stream()
//                .map(x -> x.getTitle())
//                .sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
//                .forEach(x -> System.out.print(x);}
/*
        for (Object task : taskList)
        {
            System.out.println(task);
        }

    }
*/


