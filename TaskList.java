import java.time.format.DateTimeParseException;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.*;




public class TaskList implements Serializable {

    public static ArrayList<Task> taskList;
    public ArrayList<Task> doneList = new ArrayList<>();
    Task done = new Task();
    private static final String filepath = "//Users//alaa/Desktop//todoList//file";
    private static final long serialVersionUID = 1L;

    private FileHandler fileHandler = new FileHandler();

     public TaskList() throws Exception {
         taskList = load(); //new ArrayList<>();
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
        LocalDate date = checkingDF();
        task.setDueDate(date);
        task.setStatus(isDone);
        taskList.add(task);
    }


    public LocalDate checkingDF() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String date = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                LocalDate parse = LocalDate.parse(date, formatter);

                if (LocalDate.now().compareTo(parse) <= 0) {
                    return parse;
                } else if (LocalDate.now().compareTo(parse) > 0)
                    System.out.println("This date is an old date please enter a new date dd/MM/yyyy");

            } catch (DateTimeParseException exc) {
                System.out.printf("Enter the right format for the data dd/MM/yyyy ");
            }
        }
    }


    public void removeTask() {
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
                LocalDate date = checkingDF();
                r.setDueDate(date);
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
        boolean finds = false;
        while (it.hasNext())
        {
            Task r = it.next();
            if (p.equals(r.getProject())) {
                System.out.println(r);
                finds = true;
            }
        }
        if (!finds) {
            System.out.println("There is no project with this name");

        }
    }


    public void save()
    {
       fileHandler.saveArrayList(taskList);
    }

    public ArrayList<Task> load() throws Exception
    {
        ArrayList<Task> test = fileHandler.loadFromFile();

        for (Task task : test)
        {
            System.out.println(task);
        }
        return test;
    }
}




